package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String personId = scan.nextLine();
        List<Person> people = new ArrayList<>();
        Map<String, List<String>> parentAndChildren = new LinkedHashMap<>();
        String input;

        while (!"End".equals(input = scan.nextLine())) {
            if (input.contains(" - ")) {
                String[] data = input.split(" - ");
                String parentId = data[0];
                String childrenId = data[1];
                parentAndChildren.putIfAbsent(parentId, new ArrayList<>());
                parentAndChildren.get(parentId).add(childrenId);
            } else {
                String[] data = input.split("\\s+");
                String name = data[0] + " " + data[1];
                String birthDate = data[2];
                people.add(new Person(name, birthDate));
            }
        }
//        parentAndChildren.forEach((parentId, children) -> {
//            Person parent = findPerson(people, parentId);
//            children.stream().map(childId -> findPerson(people, childId)).forEach(parent::addChild);
//        });
//        Person forPerson = findPerson(people, personId);
//        System.out.println(getFamilyTreeFor(forPerson));
    }
}
