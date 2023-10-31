package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number:");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy):");
        LocalDate checkin = LocalDate.parse(sc.next(), fmt1);
        System.out.print("Check-in date (dd/MM/yyyy):");
        LocalDate checkout = LocalDate.parse(sc.next(), fmt1);

        if(!checkout.isAfter(checkin)){ //se checkout nao for depois de checkin
            System.out.print("Error in reservation: check-out date must be after check-in date");
        }else{
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy):");
            checkin = LocalDate.parse(sc.next(), fmt1);
            System.out.print("Check-in date (dd/MM/yyyy):");
            checkout = LocalDate.parse(sc.next(), fmt1);

            LocalDate now = LocalDate.now();
            if (checkin.isBefore(now) || checkout.isBefore(now)){
                System.out.print("Error in reservation: Reservation dates for update must be future dates");
            }else if(!checkout.isAfter(checkin)){
                System.out.print("Error in reservation: check-out date must be after check-in date");
            }else{
                reservation.updateDates(checkin, checkout);
                System.out.println("Reservation: " + reservation);
            }
        }

        sc.close();




    }
}
