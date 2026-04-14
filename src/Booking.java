import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.List;

public class Booking {
    //V rámci jedné rezervace (booking) vždy přiřazujeme pokoj jednomu nebo více hostům
    // na časové období mezi dvěma daty (například pokoj číslo 3 na období od 15. 7.
    // do 24. 7. 2021). Pobyt je buď pracovní, nebo rekreační (type of vacation).

    private Integer bookingId;
    private List<Room> rooms = new ArrayList<>();
    private List<Guest> guests = new ArrayList<>();
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Boolean isPrivate;

    public Booking(Integer bookingId, List<Room> room, List<Guest> guests, LocalDate dateFrom, LocalDate dateTo, Boolean isPrivate) {
        this.bookingId = bookingId;
        this.rooms = room;
        this.guests = guests;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.isPrivate = isPrivate;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getBookingData(){
        String guestString = "";
        for (Guest itemGuests : guests) {
            if (guestString.equals("")) {
                guestString = itemGuests.getGuestData();
            }
            else {
                guestString = guestString + ", " + itemGuests.getGuestData();

            }
        }
        String roomString = "";
        for (Room itemRooms : rooms)  {
            if (roomString.equals("")) {
            roomString = Integer.toString(itemRooms.getRoomNumber());
        }
            else {
            roomString = guestString + ", " + itemRooms.getRoomNumber();

            }
        }
        Integer guestCount = guests.size();
        Integer roomCount = rooms.size();
        String guestText = "";
        String roomText = "";
        if (guestCount == 1) {
            guestText = "\npro hosta ";
        }
        else {
            guestText = "\npro hosty ";
        }
        if (roomCount == 1) {
            roomText = "\npokoje číslo ";
        }
        else {
            roomText = "\npokojů číslo ";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateFrom = getDateFrom().format(formatter);
        String dateTo = getDateTo().format(formatter);

        String textRow1 = "Rezervace číslo " + bookingId;
        String textRow2 = roomText + roomString;
        String textRow3 = guestText + guestString;
        String textRow4 = "\nv období od " + dateFrom + " do " + dateTo;

        Set<Integer> rowSize = new HashSet<>();
        rowSize.add(textRow1.length());
        rowSize.add(textRow2.length());
        rowSize.add(textRow3.length());
        rowSize.add(textRow4.length());

        Integer max = Collections.max(rowSize);
        String markRepeater = "=".repeat(max);

        String bookingData = markRepeater +
                        "\n" + textRow1 +
                        textRow2 +
                        textRow3 +
                        textRow4 +
                        "\n" + markRepeater;

        return bookingData;
    }
}
