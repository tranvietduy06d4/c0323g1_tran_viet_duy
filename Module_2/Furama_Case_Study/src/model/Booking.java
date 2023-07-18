package model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Booking implements Comparable<Booking> {

    private String bookingCode;
    private String bookingDay;
    private String startDay;
    private String endDay;
    private String customerCode;
    private String serviceCode;

    public Booking() {
    }

    public Booking(String bookingCode, String bookingDay, String startDay, String endDay, String customerCode, String serviceCode) {
        this.bookingCode = bookingCode;
        this.bookingDay = bookingDay;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerCode = customerCode;
        this.serviceCode = serviceCode;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(String bookingDay) {
        this.bookingDay = bookingDay;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public String toString() {
        return "- Booking " +
                "bookingCode= " + bookingCode + '\'' +
                ", bookingDay= " + bookingDay + '\'' +
                ", startDay= " + startDay + '\'' +
                ", endDay= " + endDay + '\'' +
                ", customerCode= " + customerCode + '\'' +
                ", serviceCode= " + serviceCode + '\'' ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingCode, booking.bookingCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingCode);
    }

    @Override
    public int compareTo(Booking o) {
        if(this.equals(o)) {
            return 0;
        } else {
            LocalDate localDate = LocalDate.parse(o.bookingDay);
            LocalDate localDate1 = LocalDate.parse(this.bookingDay);
            return localDate.isBefore(localDate1) ? 1:-1;
        }
    }
}
