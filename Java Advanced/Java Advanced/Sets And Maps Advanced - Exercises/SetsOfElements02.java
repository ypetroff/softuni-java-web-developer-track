import java.util.*;

public class SetsOfElements02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] length = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = length[0];
        int m = length[1];
        Set<Integer> ns = new LinkedHashSet<>();
        Set<Integer> ms = new LinkedHashSet<>();

        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                ns.add(Integer.parseInt(scanner.nextLine()));
            } else {
                ms.add(Integer.parseInt(scanner.nextLine()));
            }
        }

        List<Integer> uniqueNums = getUnique(ns, ms);
        uniqueNums.forEach(num -> System.out.printf("%d ", num));
    }

    private static List<Integer> getUnique(Set<Integer> ns, Set<Integer> ms) {
        List<Integer> temp = new ArrayList<>();
        for (Integer n : ns) {
            for (Integer m : ms) {
                if(n.equals(m)) {
                   temp.add(n);
                }
            }
        }
return temp;
        }
    }
