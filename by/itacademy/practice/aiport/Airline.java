package by.itacademy.practice.aiport;

public class Airline {
	
	private String destination;
	private int flightNumber;
	private String airlineType;
	private String departureTime;
	private String departureDay;
	
	public Airline() {
		destination = "MSQ";
		flightNumber = 0;
		airlineType = "";
		departureTime = "";
		departureDay = "";		
	}
	
	public Airline(String destination, int flightNumber, String aircraftType, String departureTime,
			String departureDay) {
		super();
		this.destination = destination;
		this.flightNumber = flightNumber;
		this.airlineType = aircraftType;
		this.departureTime = departureTime;
		this.departureDay = departureDay;		
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAircraftType() {
		return airlineType;
	}

	public void setAircraftType(String aircraftType) {
		this.airlineType = aircraftType;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDepartureDay() {
		return departureDay;
	}

	public void setDepartureDay(String departureDay) {
		this.departureDay = departureDay;
	}
	
	public String toString() {
		return destination + " " + flightNumber + " " + airlineType + " " + departureTime + " " + departureDay;
	}
	
	
	
	
}
