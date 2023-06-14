package repository;

import model.Booking;

import java.util.List;
import java.util.Set;

public interface IBookingRepository {
    public Set<Booking> getAll();
    public void addNewBooking(Booking booking);

}
