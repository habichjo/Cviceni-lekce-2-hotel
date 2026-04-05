import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Guest adelaMalikova = new Guest("Adéla", "Malíková", LocalDate.of(1993,3,13));
        Guest janDvoracek = new Guest("Jan", "Dvořáček", LocalDate.of(1995,5,5));
        janDvoracek.setDateOfBirth(LocalDate.of(1995,4,5));
        String printText = "První vytištění hosta: " + janDvoracek.getGuestData();
        Integer textLength = printText.length();
        System.out.println(printText);
        System.out.print("=".repeat(textLength) + "\n\n\n");

        Room room1 = new Room(1,1);
        Room room2 = new Room(2,1);
        Room room3 = new Room(3, 3, new BigDecimal(2400), false, true);

        // REZERVACE:
        // Pro Adélu rezervuj pokoj č. 1 od 19. do 26. 7. 2021.
        // Pro oba (společná rezervace) na pokoj č. 3 od 1. do 14. 9. 2021.

        List<Guest> guestList1 = new ArrayList<>();
        guestList1.add(adelaMalikova);
        List<Room> roomList1 = new ArrayList<>();
        roomList1.add(room1);
        Booking booking1 = new Booking(1, roomList1, guestList1, LocalDate.of(2021,7,19), LocalDate.of(2021,7,26));
        List<Guest> guestList2 = new ArrayList<>();
        guestList2.add(adelaMalikova);
        guestList2.add(janDvoracek);
        List<Room> roomList2 = new ArrayList<>();
        roomList2.add(room3);
        Booking booking2 = new Booking(2, roomList2, guestList2, LocalDate.of(2021,9,1), LocalDate.of(2021,9,14));

        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(booking1);
        bookingList.add(booking2);

        String spaceMaker = "-".repeat(15);
        System.out.print(spaceMaker + " VYTIŠTĚNÍ REZERVACÍ " + spaceMaker + "\n\n");

        for (Booking itemBooking : bookingList) {
            System.out.println("Rezervace číslo " + itemBooking.getBookingId());
            List<Room> roomList = itemBooking.getRoom();
            for (Room itemRoom : roomList) {
                System.out.println(" * pokoje číslo: " + itemRoom.getRoomNumber());
            }
            List<Guest> guestList = itemBooking.getGuests();
            System.out.println(" * pro hosty: ");
            for (Guest itemGuests : guestList) {
                System.out.println("      " + itemGuests.getGuestData());
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String dateFrom = itemBooking.getDateFrom().format(formatter);
            String dateTo = itemBooking.getDateFrom().format(formatter);
            System.out.println(" * v období: " + "\n      od " + dateFrom + "\n      do " + dateTo);

            System.out.println(spaceMaker);
        }

    }
}