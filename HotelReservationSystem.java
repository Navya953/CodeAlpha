package com.web;
import java.util.*;

class Room {
    String category;
    double price;
    boolean booked;

    Room(String category, double price) {
        this.category = category;
        this.price = price;
        this.booked = false;
    }
}

class Hotel {
    Map<Integer, Room> rooms = new HashMap<>();

    public Hotel() {
        rooms.put(101, new Room("Standard", 2000));
        rooms.put(102, new Room("Standard", 2000));
        rooms.put(201, new Room("Deluxe", 3500));
        rooms.put(202, new Room("Deluxe", 3500));
        rooms.put(301, new Room("Suite", 5000));
    }

    public void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Map.Entry<Integer, Room> entry : rooms.entrySet()) {
            if (!entry.getValue().booked) {
                System.out.println("Room " + entry.getKey() + " (" + entry.getValue().category + ") - ₹" + entry.getValue().price);
            }
        }
    }

    public void bookRoom(int roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room != null && !room.booked) {
            room.booked = true;
            System.out.println("Room " + roomNumber + " booked successfully.");
        } else {
            System.out.println("Room not available.");
        }
    }

    public void cancelBooking(int roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room != null && room.booked) {
            room.booked = false;
            System.out.println("Booking for room " + roomNumber + " cancelled.");
        } else {
            System.out.println("No booking found for that room.");
        }
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. Show Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int bookRoom = sc.nextInt();
                    hotel.bookRoom(bookRoom);
                    break;
                case 3:
                    System.out.print("Enter room number to cancel: ");
                    int cancelRoom = sc.nextInt();
                    hotel.cancelBooking(cancelRoom);
                    break;
                case 4:
                    System.out.println("Thank you for using Hotel Reservation System.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}


