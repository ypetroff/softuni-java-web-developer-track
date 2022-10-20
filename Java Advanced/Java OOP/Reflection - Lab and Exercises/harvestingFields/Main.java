package harvestingFields;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> clazz = RichSoilLand.class;

		String command;
		while (!(command = scanner.nextLine()).equalsIgnoreCase("harvest")) {

					PrinterImpl printer = new PrinterImpl(clazz, command);
					printer.print();

		}

	}
}
