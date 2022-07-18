import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());
        switch (city) {
            case "Sofia":
                if (sales >= 0 && sales <= 500) {
                    double commission = sales * .05;
                    System.out.printf("%.2f", commission);
                }else if (sales > 500 && sales <= 1000) {
                    double commission = sales * .07;
                    System.out.printf("%.2f", commission);
                }else if (sales > 1000 && sales <= 10000) {
                    double commission = sales * .08;
                    System.out.printf("%.2f", commission);
                }else if (sales > 10000) {
                    double commission = sales * .12;
                    System.out.printf("%.2f", commission);
                }else {
                    System.out.println("error");
                }
                break;
            case "Varna":
                //4.5%	7.5%	10%	13%
                if (sales >= 0 && sales <= 500) {
                    double commission = sales * .045;
                    System.out.printf("%.2f", commission);
                }else if (sales > 500 && sales <= 1000) {
                    double commission = sales * .075;
                    System.out.printf("%.2f", commission);
                }else if (sales > 1000 && sales <= 10000) {
                    double commission = sales * .1;
                    System.out.printf("%.2f", commission);
                }else if (sales > 10000) {
                    double commission = sales * .13;
                    System.out.printf("%.2f", commission);
                }else {
                    System.out.println("error");
                }
                break;
            case "Plovdiv":
                //5.5%	8%	12%	14.5%
                if (sales >= 0 && sales <= 500) {
                    double commission = sales * .055;
                    System.out.printf("%.2f", commission);
                }else if (sales > 500 && sales <= 1000) {
                    double commission = sales * .08;
                    System.out.printf("%.2f", commission);
                }else if (sales > 1000 && sales <= 10000) {
                    double commission = sales * .12;
                    System.out.printf("%.2f", commission);
                }else if (sales > 10000) {
                    double commission = sales * .145;
                    System.out.printf("%.2f", commission);
                }else {
                    System.out.println("error");
                }
                break;
            default:
                System.out.println("error");
        }
    }
}
