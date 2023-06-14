package repository.impl;

import model.Booking;
import repository.IBookingRepository;

import java.util.Set;
import java.util.TreeSet;

public class BookingRepository implements IBookingRepository {
//    public Booking(String bookingCode, String bookingDay, String startDay, String endDay, String customerCode, String serviceCode) {

    private static Set<Booking> bookingSet = new TreeSet<>();
    static {
        bookingSet.add(new Booking("BO-0001","2023-05-06","2023-05-07","2023-05-08","KH-0001","SVVL-0001"));
        bookingSet.add(new Booking("BO-0002","2023-05-07","2023-05-08","2023-05-12","KH-0002","SVHO-0001"));
        bookingSet.add(new Booking("BO-0003","2023-05-07","2023-05-09","2023-05-14","KH-0003","SVRO-0001"));
    }


    @Override
    public Set<Booking> getAll() {
        return bookingSet;
    }

    @Override
    public void addNewBooking(Booking booking) {
        bookingSet.add(booking);
    }
}
