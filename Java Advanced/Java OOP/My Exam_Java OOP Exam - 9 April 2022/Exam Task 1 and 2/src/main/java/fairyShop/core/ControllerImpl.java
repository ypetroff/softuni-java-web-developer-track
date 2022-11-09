package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;
import fairyShop.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Helper> helperRepository;
    private Repository<Present> presentRepository;
    private int countCraftedPresents;

    public ControllerImpl() {
        helperRepository = new HelperRepository();
        presentRepository = new PresentRepository();
        countCraftedPresents = 0;
    }

    @Override
    public String addHelper(String type, String helperName) {

        Helper helper;
        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }

        helperRepository.add(helper);

        return String.format(ConstantMessages.ADDED_HELPER, helper.getClass().getSimpleName(), helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {

        Helper helper = helperRepository.findByName(helperName);

        if (helper == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }

        helper.addInstrument(new InstrumentImpl(power));

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {

        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {

        List<Helper> almostReadyHelpers = helperRepository.getModels().stream()
                .filter(h -> h.getEnergy() > 50).collect(Collectors.toList());

        if (almostReadyHelpers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        long brokenInstruments = 0;
        Present currentPresent = presentRepository.findByName(presentName);
        Shop shop = new ShopImpl();
        for (Helper helper : almostReadyHelpers) {
            shop.craft(currentPresent, helper);
            brokenInstruments = helper.getInstruments().stream().filter(Instrument::isBroken).count();

            if (currentPresent.isDone()) {
                break;
            }
        }

        String presentStatus = currentPresent.isDone()
                ? "done"
                : "not done";

        if (presentStatus.equals("done")) {
            countCraftedPresents++;
        }

        StringBuilder sb = new StringBuilder(String.format(ConstantMessages.PRESENT_DONE, presentName, presentStatus));
        sb.append(String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments));
        return sb.toString();
    }

    @Override
    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d presents are done!", countCraftedPresents));
        sb.append(System.lineSeparator());
        sb.append("Helpers info:");
        sb.append(System.lineSeparator());
        List<String> helpersInfo = helperRepository.getModels().stream().map(Helper::toString).collect(Collectors.toList());
        sb.append(String.join(System.lineSeparator(), helpersInfo));
        return sb.toString();
    }
}
