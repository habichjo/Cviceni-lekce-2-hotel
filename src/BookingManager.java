import java.util.ArrayList;
import java.util.List;


public class BookingManager {
    private List<Booking> booking = new ArrayList<>();

    public void addBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public void clearBookings() {
        booking.clear();
    }

    public Integer getNumberOfWorkingBookings() {
        Integer numberOfWorkingBookings = 0;
        if (!booking.isEmpty()) {
            for (Booking itemBooking : booking) {
                if (!itemBooking.getPrivate()) {
                    numberOfWorkingBookings = numberOfWorkingBookings + 1;
                }
            }
        }
        return numberOfWorkingBookings;
    }

    public Integer getNumberOfBookings() {
        Integer numberOfBookings = booking.size();
        return numberOfBookings;
    }


    public String getBooking(Integer bookingId) {
        String actualBooking = "";
        for (Booking itemBooking : booking) {

            if (itemBooking.getBookingId() == bookingId) {
                actualBooking = itemBooking.getBookingData();
            }
        };

       if (actualBooking.equals("")) {
           actualBooking = "Booking " + bookingId + " not found in booking list.";
       }

       return actualBooking;
    }

    public String getBookings() {
        String bookingList = "";
        if (!booking.isEmpty()) {
            for (Booking itemBooking : booking) {

                if (bookingList.equals("")) {
                    bookingList = itemBooking.getBookingData();
                } else {
                    bookingList = bookingList + "\n" + itemBooking.getBookingData();
                }
            }
        }
        else
            bookingList = "Empty manager - there are no booking available.";

        return bookingList;
    }

    public Integer getGuestsCount() {
        Integer guestsCount = 0;

        if (!booking.isEmpty()) {
            for (Booking itemBooking : booking) {
                guestsCount = guestsCount + itemBooking.getGuestsCount();

            }
        }

        return guestsCount;
    }


}


