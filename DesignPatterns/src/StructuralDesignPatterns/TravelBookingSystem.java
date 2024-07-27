package StructuralDesignPatterns;

import java.util.Scanner;

class FlightBooking {
    public void bookFlight(String flightDetails) {
        System.out.println("Booking flight: " + flightDetails);
        // Simulate flight booking
        System.out.println("Flight booked successfully.");
    }
}

class HotelReservation {
    public void bookHotel(String hotelDetails) {
        System.out.println("Booking hotel: " + hotelDetails);
        // Simulate hotel booking
        System.out.println("Hotel booked successfully.");
    }
}

class CarRental {
    public void rentCar(String carDetails) {
        System.out.println("Renting car: " + carDetails);
        // Simulate car rental
        System.out.println("Car rented successfully.");
    }
}

class ItineraryManagement {
    public void generateItinerary(String flightDetails, String hotelDetails, String carDetails) {
        System.out.println("\nGenerating itinerary...");
        System.out.println("Flight: " + flightDetails);
        System.out.println("Hotel: " + hotelDetails);
        System.out.println("Car: " + carDetails);
        System.out.println("Itinerary generated successfully.");
    }
}

class TravelBookingFacade {
    private final FlightBooking flightBooking;
    private final HotelReservation hotelReservation;
    private final CarRental carRental;
    private final ItineraryManagement itineraryManagement;

    public TravelBookingFacade() {
        this.flightBooking = new FlightBooking();
        this.hotelReservation = new HotelReservation();
        this.carRental = new CarRental();
        this.itineraryManagement = new ItineraryManagement();
    }

    public void bookTravel(String flightDetails, String hotelDetails, String carDetails) {
        flightBooking.bookFlight(flightDetails);
        hotelReservation.bookHotel(hotelDetails);
        carRental.rentCar(carDetails);
        itineraryManagement.generateItinerary(flightDetails, hotelDetails, carDetails);
    }
}

public class TravelBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelBookingFacade travelBookingFacade = new TravelBookingFacade();

        while (true) {
            System.out.println("\nTravel Booking System:");
            System.out.println("1. Book Travel");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter flight details: ");
                        String flightDetails = scanner.nextLine();

                        System.out.print("Enter hotel details: ");
                        String hotelDetails = scanner.nextLine();

                        System.out.print("Enter car rental details: ");
                        String carDetails = scanner.nextLine();

                        travelBookingFacade.bookTravel(flightDetails, hotelDetails, carDetails);
                        break;

                    case 2:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
