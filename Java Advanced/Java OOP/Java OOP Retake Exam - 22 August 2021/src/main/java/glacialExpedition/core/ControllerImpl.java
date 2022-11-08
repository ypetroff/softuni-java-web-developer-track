package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private final static int MINIMUM_ENERGY_TO_PARTICIPATE_IN_EXPEDITION = 50;

   private final Repository<Explorer> explorerRepository;
   private final Repository<State> stateRepository;
   private int exploredStatesCount;

    public ControllerImpl() {
        explorerRepository = new ExplorerRepository();
        stateRepository = new StateRepository();
        exploredStatesCount = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type) {
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }

        explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {

        State state = new StateImpl(stateName);
        Collections.addAll(state.getExhibits(), exhibits);
        stateRepository.add(state);

        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {

        Explorer toBeRetired = explorerRepository.byName(explorerName);

        if(toBeRetired == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        explorerRepository.remove(toBeRetired);
        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorersEligibleForMission = explorerRepository.getCollection().stream()
                .filter(e -> e.getEnergy() > MINIMUM_ENERGY_TO_PARTICIPATE_IN_EXPEDITION).collect(Collectors.toList());

        if(explorersEligibleForMission.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        Mission mission = new MissionImpl();
        mission.explore(stateRepository.byName(stateName), explorersEligibleForMission);
        long retired = explorersEligibleForMission.stream().filter(e -> !e.canSearch()).count();
        exploredStatesCount++;
        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retired);
    }

    @Override
    public String finalResult() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, exploredStatesCount));
        sb.append(System.lineSeparator());
        sb.append(ConstantMessages.FINAL_EXPLORER_INFO);
        explorerRepository.getCollection().stream().map(Explorer::toString).forEach(sb::append);
        return sb.toString().trim();
    }
}
