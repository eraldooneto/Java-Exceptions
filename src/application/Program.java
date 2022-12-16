package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int roomNumber = scan.nextInt();
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(scan.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(scan.next());
			
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);
	
			System.out.println();
<<<<<<< HEAD
	
=======
			
			
>>>>>>> c9e2a8a6b12509d2e3e3c17a34e9e2470128c526
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(scan.next());
	
			reservation.updateDates(checkIn, checkOut);
	
			System.out.println(reservation);
			
<<<<<<< HEAD
		} catch(ParseException e) {
			System.out.println("Invalid date format!");
			
		} catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
			
		} catch(RuntimeException e) {
			System.out.println("Unexpected error.");
		}
				
=======
			String error = reservation.updateDates(checkIn, checkOut); 
			

			if(error != null) {
				System.out.println("Reservation error: " + error);
				
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println(reservation);
			}	

		} 
			
>>>>>>> c9e2a8a6b12509d2e3e3c17a34e9e2470128c526
		 scan.close();
		
	}
		

}


