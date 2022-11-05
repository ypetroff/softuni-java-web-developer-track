package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Astronaut> astronauts;
    private Repository<Planet> planets;
    private int exploredPlanets;

    public ControllerImpl() {
        this.astronauts = new AstronautRepository();
        this.planets = new PlanetRepository();

    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        this.astronauts.add(astronaut);

        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {

        PlanetImpl planet = new PlanetImpl(planetName);

        for (String item : items) {
            planet.getItems().add(item);
        }

        planets.add(planet);

        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronauts.findByName(astronautName);

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        astronauts.remove(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {

        List<Astronaut> eligibleForMission = this.astronauts.getModels().stream()
                .filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        if (eligibleForMission.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Planet planet = this.planets.findByName(planetName);

        Mission mission = new MissionImpl();
        mission.explore(planet, eligibleForMission);
        long deadAstronauts = eligibleForMission.stream().filter(a -> !a.canBreath()).count();
        exploredPlanets++;
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronauts);


    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder(
                String.format(ConstantMessages.REPORT_PLANET_EXPLORED, exploredPlanets)).append(System.lineSeparator())
                .append(ConstantMessages.REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        String astronautsInfo = astronauts.getModels().stream()
                .map(Astronaut::toString).collect(Collectors.joining(System.lineSeparator()));
        sb.append(astronautsInfo);

        return sb.toString().trim();
    }
}
