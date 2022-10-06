package Google07;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Company> companies = new HashMap<>();
        Map<String, List<Pokemon>> pokemons = new HashMap<>();
        Map<String, List<Parents>> parents = new HashMap<>();
        Map<String, List<Children>> children = new HashMap<>();
        Map<String, Car> cars = new HashMap<>();


        String command;
        while(!(command = scanner.nextLine()).equals("End")) {
            String[] personInfo = command.split("\\s+");
            String name = personInfo[0];
            getData(name, companies, pokemons, parents, children, cars, personInfo);
        }

        command = scanner.nextLine();

        System.out.println(command);
        System.out.println("Company:");
        String finalCommand = command;
        companies.entrySet().stream().filter(p -> p.getKey().equals(finalCommand))
                .forEach(x -> System.out.printf("%s",x.getValue().toString()));
        System.out.println("Car:");
        cars.entrySet().stream().filter(p -> p.getKey().equals(finalCommand))
                .forEach(x -> System.out.printf("%s",x.getValue().toString()));
        System.out.println("Pokemon:");
        pokemons.entrySet().stream().filter(p -> p.getKey().equals(finalCommand))
                .forEach(x -> x.getValue().stream().map(Pokemon::toString).forEach(System.out::println));
        System.out.println("Parents:");
        parents.entrySet().stream().filter(p -> p.getKey().equals(finalCommand))
                .forEach(x -> x.getValue().stream().map(Parents::toString).forEach(System.out::println));
        System.out.println("Children:");
        children.entrySet().stream().filter(p -> p.getKey().equals(finalCommand))
                .forEach(x -> x.getValue().stream().map(Children::toString).forEach(System.out::println));
    }

    private static void getData(String name, Map<String, Company> companies, Map<String, List<Pokemon>> pokemons, Map<String, List<Parents>> parents, Map<String, List<Children>> children, Map<String, Car> cars, String[] personInfo) {

        switch (personInfo[1]) {
            case "company":
                Company company = new Company(personInfo[2], personInfo[3], Double.parseDouble(personInfo[4]));
                companies.put(name, company);
                break;
            case "pokemon":
                Pokemon pokemon = new Pokemon(personInfo[2], personInfo[3]);
                pokemons.putIfAbsent(name, new ArrayList<>());
                pokemons.get(name).add(pokemon);
                break;
            case "parents":
                Parents parent = new Parents(personInfo[2], personInfo[3]);
                parents.putIfAbsent(name, new ArrayList<>());
                parents.get(name).add(parent);
                break;
            case "children":
                Children child = new Children(personInfo[2], personInfo[3]);
                children.putIfAbsent(name, new ArrayList<>());
                children.get(name).add(child);
                break;
            case "car":
                Car car = new Car(personInfo[2], personInfo[3]);
                cars.put(name, car);
                break;
        }
    }
}
