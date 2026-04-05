import java.math.BigDecimal;

public class Room {
    // Hosty vždy ubytováváme na pokojích (room). Pokoj je identifikován svým číslem.
    // O každém pokoji chceme evidovat, kolik lůžek tam je (neřeš přistýlky apod.),
    // zda má pokoj balkón a zda má výhled na moře.

    // Dále chceme znát také cenu pokoje za jednu noc (předpokládej, že je cena pevně
    // daná bez ohledu na sezónu a počet ubytovaných).

    private Integer roomNumber;
    private Integer numberOfBeds;
    private BigDecimal pricePerNight;
    private Boolean hasBalcony;
    private Boolean hasSeaView;

    public Room(Integer roomNumber, Integer numberOfBeds, BigDecimal pricePerNight, Boolean hasBalcony, Boolean hasSeaView) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = pricePerNight;
        this.hasBalcony = hasBalcony;
        this.hasSeaView = hasSeaView;
    }

    public Room(Integer roomNumber, Integer numberOfBeds) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = new BigDecimal(1000); // 70 % of rooms has the same parameters and price
        this.hasBalcony = true;  // 70 % of rooms has balcony
        this.hasSeaView = true;  // 80 % of rooms has sea view
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Boolean getHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(Boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public Boolean getHasSeaView() {
        return hasSeaView;
    }

    public void setHasSeaView(Boolean hasSeaView) {
        this.hasSeaView = hasSeaView;
    }
}
