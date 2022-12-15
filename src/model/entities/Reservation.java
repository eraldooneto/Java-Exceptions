package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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

	public Date getCheckin() {
		return checkIn;
	}


	public Date getCheckout() {
		return checkOut;
	}

	public final long duration() {
		
		long differenceBetweenDates = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(differenceBetweenDates, TimeUnit.MILLISECONDS);
	}
	
	public final String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future.";
			
		} else if(!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date.";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Room ");
		sb.append(getRoomNumber());
		sb.append(", check-in: ");
		sb.append(sdf.format(checkIn));
		sb.append(", check-out: ");
		sb.append(sdf.format(checkOut));
		sb.append(", ");
		sb.append(duration());
		sb.append(" nights.");
		
		return sb.toString();
	
	}
	
}
