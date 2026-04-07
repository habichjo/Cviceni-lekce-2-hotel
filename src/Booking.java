import jdk.jshell.execution.LoaderDelegate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    //V rámci jedné rezervace (booking) vždy přiřazujeme pokoj jednomu nebo více hostům
    // na časové období mezi dvěma daty (například pokoj číslo 3 na období od 15. 7.
    // do 24. 7. 2021). Pobyt je buď pracovní, nebo rekreační (type of vacation).

    private Integer bookingId;
    private List<Room> room = new ArrayList<>();
    private List<Guest> guests = new ArrayList<>();
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Boolean isPrivate;

    public Booking(Integer bookingId, List<Room> room, List<Guest> guests, LocalDate dateFrom, LocalDate dateTo, Boolean isPrivate) {
        this.bookingId = bookingId;
        this.room = room;
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

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
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
}
