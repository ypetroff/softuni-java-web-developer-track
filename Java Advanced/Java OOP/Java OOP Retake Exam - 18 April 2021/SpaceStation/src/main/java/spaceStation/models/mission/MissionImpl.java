package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.BaseAstronaut;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;

import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {

    @Override /** This is the most critical part of the code **/
    public void explore(Planet planet, Collection<Astronaut> astronauts)  {

        /**Dimo's solution -> https://softuni.bg/trainings/resources/video/67260/video-06-december-2021-dimo-georgiev-java-oop-october-2021/3486**/
        Collection<String> planetItems = planet.getItems();

        for (Astronaut astronaut : astronauts) {
            while(astronaut.canBreath() && planetItems.iterator().hasNext()) {
                astronaut.breath();
                String currentItem = planetItems.iterator().next();
                astronaut.getBag().getItems().add(currentItem);
                planetItems.remove(currentItem);
            }
        }


    }
        }


            //TODO complete the logic -> how to add item to the astronaut's bag
            /**
             •	The astronauts start going out in open space one by one. They can't go, if they don't have any oxygen left.
             •	An astronaut lands on a planet and starts collecting its items one by one.
             •	He finds an item and he takes a breath.
             •	He adds the item to his backpack and respectively the item must be removed from the planet.
             •	Astronauts can't keep collecting items if their oxygen becomes 0.
             •	If it becomes 0, the next astronaut starts exploring.
             **/

            /**My Solution **/
             /*  List<String> planetItems = (List<String>) planet.getItems();


        for (Astronaut a : astronauts) {
                while (a.canBreath() && !planetItems.isEmpty()) {
                    a.breath();
                    List<String> astronautItems = (List<String>) a.getBag().getItems();
                    String item = planetItems.get(0);
                    astronautItems.add(item);
                    planetItems.remove(item);
                    if (a instanceof BaseAstronaut) {
                        Bag bag = new Backpack();

                        ((Backpack) bag).setItems(astronautItems);

                        ((BaseAstronaut) a).setBag(bag);
                    }
                    ((PlanetImpl) planet).setItems(planetItems);
                }
        }*/

