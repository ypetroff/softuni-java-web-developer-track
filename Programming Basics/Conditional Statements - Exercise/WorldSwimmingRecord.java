import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double worldRecord = Double.parseDouble(scanner.nextLine());
        double totalDistanceMeters = Double.parseDouble(scanner.nextLine());
        double OneMeterDistance = Double.parseDouble(scanner.nextLine());
        double resistance = 12.5;
        double contenderTime = totalDistanceMeters * OneMeterDistance;
        // if (totalDistanceMeters > 15) {
        double distanceResistance1 = totalDistanceMeters / 15;
        double distanceResistance = Math.floor(distanceResistance1);
        double addedTime = distanceResistance * resistance;
        //double addedTime = Math.floor(addedTime1);
        double finalTime = contenderTime + addedTime;
        if (finalTime >= worldRecord) {
            double attemptedRecord = finalTime - worldRecord;
            System.out.printf("No, he failed! He was %.2f seconds slower.", attemptedRecord);
        }else {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", finalTime);
        }
        //} else  if (contenderTime >= worldRecord){
           // double attemptedRecord = contenderTime - worldRecord;
           // System.out.printf("No, he failed! He was %.2f seconds slower.", attemptedRecord);
        //}else {
            //double newRecord = worldRecord - contenderTime;
          //  System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.",contenderTime);
        }

    }
//}
