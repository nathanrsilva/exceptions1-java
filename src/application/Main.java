package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number:");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy):");
            LocalDate checkin = LocalDate.parse(sc.next(), fmt1);
            System.out.print("Check-in date (dd/MM/yyyy):");
            LocalDate checkout = LocalDate.parse(sc.next(), fmt1);

            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy):");
            checkin = LocalDate.parse(sc.next(), fmt1);
            System.out.print("Check-in date (dd/MM/yyyy):");
            checkout = LocalDate.parse(sc.next(), fmt1);

            reservation.updateDates(checkin, checkout);
            System.out.println("Reservation: " + reservation);
        }catch(DomainException e){
            System.out.println(e.getMessage());
        }catch(RuntimeException e){
            System.out.println("Unexpected error");
        }

        sc.close();




    }
}
