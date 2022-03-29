package by.itacademy.practice.aiport;

import java.util.List;
import java.util.Scanner;

public class FlightSchedule {

	public static void main(String[] args) {
		Airport airport = new Airport("Minsk-MSQ");

		airport.addAirline(new Airline("Dubai-DXW", 2727, "Boeing 737-800", "05:20", "Wednesday"));
		airport.addAirline(new Airline("Venice-VCE", 1515, "Airbus A321", "12:55", "Friday"));
		airport.addAirline(new Airline("Oslo-TRF", 9750, "Boeing 737-800", "08:30", "Friday"));
		airport.addAirline(new Airline("Vena-VIE", 1484, "Airbus A321", "10:15", "Monday"));
		airport.addAirline(new Airline("Bari-BRI", 6191, "Boeing 737-800", "06:20", "Friday"));
		airport.addAirline(new Airline("Dubai-DXW", 2863, "Airbus A321", "22:15", "Saturday"));
		airport.addAirline(new Airline("Venice-VCE", 2185, "Airbus A321", "06:25", "Monday"));

		Scanner scInt = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);

		while (true) {
			System.out.print("Выберите пункт меню: \n" + "0. выйти\n" + "1. вывод списка всех рейсов\n"
					+ "2. вывод списка рейсов для заданного пункта назначения\n"
					+ "3. вывод списка рейсов для заданного дня недели\n"
					+ "4. вывод списка рейсов для заданного дня недели, время вылета для которых больше заданного\n>> ");
			int choice = scInt.nextInt();
			if (choice == 0) {
				break;
			}
			if (choice < 1 || choice > 4) {
				System.out.println("Выбран несуществующий пункт меню. Повторите выбор: ");
				continue;
			}
			System.out.println("----------------------------------------------");
			switch (choice) {
			case 1:
				airport.printList();
				System.out.println("----------------------------------------------");
				break;
			case 2:
				System.out.println("Выберите пункт назначения: ");
				List<String> destination = airport.listOfDestinations(airport);
				airport.printStringList(destination);
				System.out.print(">> ");
				String dest = scString.nextLine();
				System.out.println("Рейсы в " + dest + ":");
				airport.printFligthsOfChoosedDestination(dest);
				System.out.println("----------------------------------------------");

				while (true) {
					System.out.print("Выберите пункт меню: \n" + "0. назад\n"
							+ "1. вывод списка рейсов для другого пункта назначения\n>> ");
					int choice2 = scInt.nextInt();
					if (choice2 == 0) {
						System.out.println("----------------------------------------------");
						break;
					}
					if (choice2 > 1) {
						System.out.println("Выбран несуществующий пункт меню. Повторите выбор: ");
						continue;
					}
					System.out.println("----------------------------------------------");
					switch (choice2) {
					case 1:
						System.out.print("Выберите пункт назначения: >> ");
						dest = scString.nextLine();
						System.out.println("Рейсы в " + dest + ":");
						airport.printFligthsOfChoosedDestination(dest);
						System.out.println("----------------------------------------------");
					}
					continue;
				}
				break;
			case 3:
				System.out.println("Есть запланированные рейсы в следующие дни недели: ");
				List<String> days = airport.listOfDepartureDays(airport);
				airport.printStringList(days);
				System.out.print("Выберите день недели: >> ");
				String day = scString.nextLine();
				System.out.println("Доступные рейсы в " + day + ":");
				airport.printFligthsOfChoosedDepartureDay(day);
				System.out.println("----------------------------------------------");
				
				while (true) {
					System.out.print("Выберите пункт меню: \n" + "0. назад\n"
							+ "1. вывод списка рейсов для другого дня недели\n>> ");
					int choice2 = scInt.nextInt();
					if (choice2 == 0) {
						System.out.println("----------------------------------------------");
						break;
					}
					if (choice2 > 1) {
						System.out.println("Выбран несуществующий пункт меню. Повторите выбор: ");
						continue;
					}
					System.out.println("----------------------------------------------");
					switch (choice2) {
					case 1:
						System.out.print("Выберите день недели: >> ");
						day = scString.nextLine();
						System.out.println("Доступные рейсы в " + day + ":");
						airport.printFligthsOfChoosedDestination(day);
						System.out.println("----------------------------------------------");
					}
					continue;
				}
				break;
			case 4:
				System.out.println("Есть запланированные рейсы в следующие дни недели: ");
				airport.printStringList(airport.listOfDepartureDays(airport));
				System.out.print("Выберите день недели: >> ");
				day = scString.nextLine();
				System.out.print("Введите время отправления (не ранее, чем) в формате 00:00: >> ");
				String time = scString.nextLine();
				System.out.println("В " + day + " позже " + time + " есть следующие рейсы:");
				airport.printFligthsOfChoosedDepartureTime(day, time);
				System.out.println("----------------------------------------------");
				
				while (true) {
					System.out.print("Выберите пункт меню: \n" + "0. назад\n"
							+ "1. вывод списка рейсов для другого дня недели и времени\n>> ");
					int choice2 = scInt.nextInt();
					if (choice2 == 0) {
						System.out.println("----------------------------------------------");
						break;
					}
					if (choice2 > 1) {
						System.out.println("Выбран несуществующий пункт меню. Повторите выбор: ");
						continue;
					}
					System.out.println("----------------------------------------------");
					switch (choice2) {
					case 1:
						System.out.print("Выберите день недели: >> ");
						day = scString.nextLine();
						System.out.print("Введите время отправления (не ранее, чем) в формате 00:00: >> ");
						time = scString.nextLine();
						System.out.println("В " + day + " позже " + time + " есть следующие рейсы:");
						airport.printFligthsOfChoosedDepartureTime(day, time);
						System.out.println("----------------------------------------------");
					}
					continue;
				}
				break;
			}
		}
		scInt.close();
		scString.close();
	}

}
