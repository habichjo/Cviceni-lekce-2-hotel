import java.util.ArrayList;
import java.util.List;


public class BookingManager {
    private List<Booking> booking = new ArrayList<>();

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

   public String getBooking(Integer bookingId) {
        String actualBooking = "";
        for (Booking itemBooking : booking) {

            if (itemBooking.getBookingId() == bookingId) {
                actualBooking = itemBooking.getBookingData();
            }
        }

       if (actualBooking.equals("")) {
           actualBooking = "Booking " + bookingId + " not found in booking list.";
       }

       return actualBooking;
   }

    public String getBookings() {
        String bookingList = "";
        for (Booking itemBooking : booking) {

            if (bookingList.equals("")) {
                bookingList = itemBooking.getBookingData();
            }
            else {
                bookingList = bookingList + "\n" + itemBooking.getBookingData();
            }
        }

        return bookingList;
    }


}


