import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Plane {
        String model;
        String brand;
        String serialNumber;
        int seatCapacity;

        public Plane(String model, String brand, String serialNumber, int seatCapacity) {
            this.model = model;
            this.brand = brand;
            this.serialNumber = serialNumber;
            this.seatCapacity = seatCapacity;
        }

        @Override
        public String toString() {
            return brand + " " + model + " (" + serialNumber + ", Koltuk: " + seatCapacity + ")";
        }
    }

    static class Location {
        String country;
        String city;
        String airport;
        boolean isActive;

        public Location(String country, String city, String airport, boolean isActive) {
            this.country = country;
            this.city = city;
            this.airport = airport;
            this.isActive = isActive;
        }

        @Override
        public String toString() {
            return city + " - " + airport;
        }
    }

    static class Flight {
        Location from;
        Location to;
        String time;
        Plane plane;
        double price;
        int reservedSeats = 0;

        public Flight(Location from, Location to, String time, Plane plane, double price) {
            this.from = from;
            this.to = to;
            this.time = time;
            this.plane = plane;
            this.price = price;
        }

        public boolean isFull() {
            return reservedSeats >= plane.seatCapacity;
        }

        public int getAvailableSeats() {
            return plane.seatCapacity - reservedSeats;
        }

        public void reserveSeats(int count) {
            reservedSeats += count;
        }

        @Override
        public String toString() {
            return from + " -> " + to + " | Saat: " + time + " | Uçak: " + plane +
                    " | Fiyat: " + price + "₺ | Boş Koltuk: " + getAvailableSeats();
        }
    }

    static class Reservation {
        Flight flight;
        String firstName;
        String lastName;
        int age;
        String email;
        int seatCount;

        public Reservation(Flight flight, String firstName, String lastName, int age, String email, int seatCount) {
            this.flight = flight;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.email = email;
            this.seatCount = seatCount;
        }

        @Override
        public String toString() {
            return "Yolcu: " + firstName + " " + lastName + " (" + age + " yaşında)\n" +
                    "E-mail: " + email + "\n" +
                    "Uçuş: " + flight.from + " -> " + flight.to + " | Saat: " + flight.time +
                    " | Fiyat (Toplam): " + (flight.price * seatCount) + "₺" +
                    " | Rezervasyon Koltuk Sayısı: " + seatCount;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Plane> planes = new ArrayList<>();
        List<Location> locations = new ArrayList<>();
        List<Flight> flights = new ArrayList<>();
        List<Reservation> reservations = new ArrayList<>();

        // Uçaklar
        planes.add(new Plane("737", "Boeing", "SN001", 5));
        planes.add(new Plane("A320", "Airbus", "SN002", 4));
        planes.add(new Plane("777", "Boeing", "SN003", 6));
        planes.add(new Plane("A380", "Airbus", "SN004", 8));

        // Lokasyonlar
        Location istanbul = new Location("Türkiye", "İstanbul", "IST", true);
        Location berlin = new Location("Almanya", "Berlin", "BER", true);
        Location london = new Location("İngiltere", "Londra", "LHR", true);
        Location paris = new Location("Fransa", "Paris", "CDG", true);
        Location newyork = new Location("ABD", "New York", "JFK", true);
        Location rome = new Location("İtalya", "Roma", "FCO", true);

        locations.add(istanbul);
        locations.add(berlin);
        locations.add(london);
        locations.add(paris);
        locations.add(newyork);
        locations.add(rome);

        // Uçuşlar
        flights.add(new Flight(istanbul, berlin, "08:00", planes.get(0), 1200));
        flights.add(new Flight(berlin, istanbul, "14:30", planes.get(1), 1250));
        flights.add(new Flight(london, paris, "09:15", planes.get(2), 950));
        flights.add(new Flight(paris, london, "13:50", planes.get(0), 1000));
        flights.add(new Flight(newyork, istanbul, "22:00", planes.get(3), 5000));
        flights.add(new Flight(istanbul, newyork, "10:00", planes.get(2), 4800));
        flights.add(new Flight(rome, paris, "11:30", planes.get(1), 1100));
        flights.add(new Flight(paris, rome, "16:30", planes.get(0), 1050));

        // Uçuşları listele
        System.out.println("✈️ Mevcut Uçuşlar:");
        for (int i = 0; i < flights.size(); i++) {
            System.out.println((i + 1) + ". " + flights.get(i));
        }

        // Uçuş seçimi
        System.out.print("\nLütfen bir uçuş seçin (1-" + flights.size() + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // buffer temizle

        if (choice < 1 || choice > flights.size()) {
            System.out.println("❌ Geçersiz seçim!");
            return;
        }

        Flight selectedFlight = flights.get(choice - 1);

        if (selectedFlight.isFull()) {
            System.out.println("❌ Bu uçuşta boş koltuk kalmamış.");
            return;
        }

        // Kaç koltuk rezervasyon yapılacak?
        System.out.print("Kaç koltuk rezerve etmek istiyorsunuz? (Boş koltuk: " + selectedFlight.getAvailableSeats() + "): ");
        int seatCount = scanner.nextInt();
        scanner.nextLine(); // buffer temizle

        if (seatCount < 1) {
            System.out.println("❌ Geçersiz koltuk sayısı!");
            return;
        }

        if (seatCount > selectedFlight.getAvailableSeats()) {
            System.out.println("❌ Yeterli boş koltuk yok!");
            return;
        }

        // Kullanıcı bilgileri
        System.out.print("Adınız: ");
        String firstName = scanner.nextLine();
        System.out.print("Soyadınız: ");
        String lastName = scanner.nextLine();
        System.out.print("Yaşınız: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // buffer temizle

        System.out.print("E-posta adresiniz: ");
        String email = scanner.nextLine();

        // E-mail doğrulama
        if (!email.contains("@")) {
            System.out.println("❌ Geçersiz e-posta adresi! '@' içermeli.");
            return;
        }

        // Rezervasyon işlemi
        selectedFlight.reserveSeats(seatCount);
        Reservation reservation = new Reservation(selectedFlight, firstName, lastName, age, email, seatCount);
        reservations.add(reservation);

        // Rezervasyon çıktısı
        System.out.println("\n✅ Rezervasyon Başarılı!");
        System.out.println(reservation);
    }
}
