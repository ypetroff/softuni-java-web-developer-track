import java.util.*;

public class CompanyUsers08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        Map<String, List<String>> company = new HashMap<>();

        while(!"End".equals(input = scanner.nextLine())) {

            String[] newData = input.split(" -> ");
            String companyName = newData[0];
            String employeeID = newData[1];

            company.putIfAbsent(companyName, new ArrayList<>());
            if(!company.get(companyName).contains(employeeID)) {
                company.get(companyName).add(employeeID);
            }
        }

        company.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(x -> {
                    System.out.printf("%s%n", x.getKey());

//                    x.getValue().stream()
//                            .sorted(String::compareTo)
//                                    .forEach(p -> System.out.printf("-- %s%n", x.getValue().get(Map.Entry::getValue)));
                    x.getValue().iterator()
                            .forEachRemaining( p -> System.out.printf("-- %s%n", p));
                });

    }
}
