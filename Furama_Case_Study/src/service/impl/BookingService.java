package service.impl;

import model.Booking;
import repository.IBookingRepository;
import repository.impl.BookingRepository;
import service.IBookingService;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingService implements IBookingService {
    private static IBookingRepository bookingRepository = new BookingRepository();
    private static Scanner scanner = new Scanner(System.in);


//    public Booking(String bookingCode, String bookingDay, String startDay, String endDay, String customerCode, String serviceCode) {

    @Override
    public void addNewBooking() {

        System.out.println("Please enter booking code to add:");
        String bookingCode = scanner.nextLine();

        System.out.println("Please enter booking day to add:");
        String bookingDay = scanner.nextLine();

        System.out.println("Please enter the start day: ");
        String startDay = scanner.nextLine();

        System.out.println("Please enter the end day: ");
        String endDay = scanner.nextLine();

        System.out.println("Please enter the customer code: ");
        String customerCode = scanner.nextLine();

        System.out.println("Please enter the service code: ");
        String serviceCode = scanner.nextLine();

//    public Booking(String bookingCode, String bookingDay, String startDay, String endDay, String customerCode, String serviceCode) {

        Booking newBooking = new Booking(bookingCode,bookingDay,startDay,endDay,customerCode,serviceCode);
        bookingRepository.addNewBooking(newBooking);
        System.out.println("Success. Finish add new booking");

    }

    @Override
    public void displayListBooking() {
        Set<Booking> bookingSet = bookingRepository.getAll();
        for (Booking booking:bookingSet) {
            System.out.println(booking);
        }
    }

    @Override
    public void createNewContract() {

    }

    @Override
    public void displayListContract() {

    }

    @Override
    public void editContract() {

    }
}
