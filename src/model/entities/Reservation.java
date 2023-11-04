package model.entities;

import model.exceptions.DomainException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class Reservation {
    private final DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    public Reservation(){

    }

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) throws DomainException{
        if(!checkout.isAfter(checkin)){
            throw new DomainException("teste, teste");
        }

        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public long duration(){
       Duration d1 = Duration.between(getCheckin().atStartOfDay(), getCheckout().atStartOfDay());
       return d1.toDays();
    }

    public void updateDates(LocalDate checkin, LocalDate checkout){
        LocalDate now = LocalDate.now();
        if (checkin.isBefore(now) || checkout.isBefore(now)){
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
        }
        if(!checkout.isAfter(checkin)){
            throw new DomainException("Error in reservation: check-out date must be after check-in date");
        }
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString(){
        return "Room "
                + getRoomNumber()
                + ", check-in: "
                + fmt1.format(getCheckin())
                + ", check-in: "
                + fmt1.format(getCheckout())
                + ", "
                + duration()
                + " nights";
    }
}
