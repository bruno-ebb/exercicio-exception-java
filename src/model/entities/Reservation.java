package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
	
	private static DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public Integer getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	public LocalDate getCheckIn() {
		return checkIn;
	}


	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long duration = ChronoUnit.DAYS.between(getCheckIn(), getCheckOut());
		return duration;
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
			+ roomNumber
			+ ", check-in: "
			+ dtf.format(checkIn)
			+ ", check-out: "
			+ dtf.format(checkOut)
			+ ", "
			+ duration()
			+ " nights.";
	}
	
}
