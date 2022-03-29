package by.itacademy.practice.aiport;

import java.util.ArrayList;
import java.util.List;

public class Airport {
	private String airportName;
	private List<Airline> airlines = new ArrayList<>();

	public Airport(String airportName) {
		this.airportName = airportName;
	}

	public void addAirline(Airline airline) {
		airlines.add(airline);
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public void printList() {
		for (Airline airline : airlines) {
			System.out.println(airline.toString());
		}
	}

	public List<String> listOfDestinations(Airport airport) {
		List<String> destinations = new ArrayList<>();
		boolean isNew = false;
		for (int i = 0; i < airlines.size(); i++) {
			if (i == 0) {
				destinations.add(airlines.get(i).getDestination());
			} else {
				for (int j = 0; j < i; j++) {
					if (!airlines.get(j).getDestination().equals(airlines.get(i).getDestination())) {
						isNew = true;
					} else {
						isNew = false;
						break;
					}
				}
				if (isNew) {
					destinations.add(airlines.get(i).getDestination());
				}
			}
		}
		return destinations;
	}

	public void printFligthsOfChoosedDestination(String dest) {
		for (int i = 0; i < airlines.size(); i++) {
			if (dest.equals(airlines.get(i).getDestination())) {
				System.out.println(airlines.get(i));
			}
		}
	}

	public void printStringList(List<String> lists) {
		for (String list : lists) {
			System.out.println(list);
		}
	}

	public List<String> listOfDepartureDays(Airport airport) {
		String[] weekDays = new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
				"Sunday" };
		List<String> departureDays = new ArrayList<>();
		boolean isNew = false;
		for (int i = 0; i < weekDays.length; i++) {
			for (int j = 0; j < airlines.size(); j++) {
				if (airlines.get(j).getDepartureDay().equals(weekDays[i])) {
					isNew = true;
				} else {
					isNew = false;
				}
				if (isNew) {
					departureDays.add(airlines.get(j).getDepartureDay());
					break;
				}
			}
		}
		return departureDays;
	}

	public void printFligthsOfChoosedDepartureDay(String day) {
		for (int i = 0; i < airlines.size(); i++) {
			if (day.equals(airlines.get(i).getDepartureDay())) {
				System.out.println(airlines.get(i));
			}
		}
	}

	public void printFligthsOfChoosedDepartureTime(String day, String time) {
		if (time.length() != 5) {
			throw new RuntimeException("Время введено неверено.");
		}
		int hour = Integer.parseInt(time.substring(0,2));
		int min = Integer.parseInt(time.substring(3,5));
		boolean isFlight = false;
		for (int i = 0; i < airlines.size(); i++) {
			if (day.equals(airlines.get(i).getDepartureDay())) {
				int airHour = Integer.parseInt(airlines.get(i).getDepartureTime().substring(0, 2));
				int airMin = Integer.parseInt(airlines.get(i).getDepartureTime().substring(3, 5));
				if (airHour > hour) {
					System.out.println(airlines.get(i));
					isFlight = true;
				} else if (airHour == hour && airMin >= min) {
					System.out.println(airlines.get(i));
					isFlight = true;
				}
			}
		}
		if (!isFlight) {
			System.out.println("Таких рейсов нет.\n");
		}
	}


	
	

}
