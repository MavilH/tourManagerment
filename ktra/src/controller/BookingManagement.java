
package controller;

import fileIO.HandleFile;
import java.util.ArrayList;
import java.util.List;
import models.CustomerBooking;
import runtime.Menu;
import utilities.Inputter;
import models.Hotel;
import models.Tour;


public class BookingManagement {
    List<CustomerBooking> bookingList;
    private List<CustomerBooking> load(){
        try{
            HandleFile file = new HandleFile();
            return file.readBookingFromFile();
        }catch (Exception ex){
            return null;
        }      
    }
    public BookingManagement() {
        bookingList = load();
        if(bookingList == null){
            bookingList = new ArrayList<>();
        }
    }
  
    
    public void bookTourAndHotel(TourManagement tm, HotelManagement hm){
        Hotel h;
        String nBookingID;
        do {            
            nBookingID = Inputter.inputNonBlankStr("Enter Booking ID: ");
            boolean check = isExistID(nBookingID);
            if(check == true){
                System.out.printf("ID is exist. Pls Re-");
            }else{
                break;
            }
        } while (true);
        
        System.out.println("TOUR AVAILABLE:");
        tm.showTour();
        String tourID = Inputter.inputNonBlankStr("Enter Tour ID you choose: ");
        boolean check = tm.isExistID(tourID);
        if(check == false){
            System.out.println("This ID doesn't exist");
        }else{
            System.out.println("Booking tour successfully, pls choose your hotel");
            Tour t = tm.searchTourByid(tourID);
            
            hm.showAvailableHotel(t.getDestination());
            String hotelID = Inputter.inputNonBlankStr("Enter Hotel ID you choose: ");
            boolean checkHotel = hm.isExistID(hotelID);
            while(true){
                if(checkHotel == false){
                    System.out.printf("This ID doesn't exist, Pls re-Enter: ");
                    hotelID = Inputter.inputNonBlankStr("Enter Hotel ID you choose: ");
                }else{
                    System.out.println("Booking hotel successfully");
                    h = hm.searchHotelByID(hotelID);
                    int a = h.getAvailableRooms();
                    h.setAvailableRooms(a - 1);
                    hm.update(h);
                    break;
                }
            }
            CustomerBooking c = new CustomerBooking(nBookingID, tourID, hotelID);
            bookingList.add(c);
            
        }
        
    }
    public boolean isExistID(String id){
        for (CustomerBooking booking : bookingList) {
            if(booking.getBookingID().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }
    public CustomerBooking searchBookingByID(String id){
        for (CustomerBooking customerBooking : bookingList) {
            if(customerBooking.getBookingID().equalsIgnoreCase(id)){
                return customerBooking;
            }
        }
        return null;
    }
    
    public void cancelBooking(TourManagement tm, HotelManagement hm){
        for (CustomerBooking customerBooking : bookingList) {
            System.out.println(customerBooking.toString());
        }
        String nBookingID = Inputter.inputNonBlankStr("Input BookingID you want to cancel: ");
        CustomerBooking c = searchBookingByID(nBookingID);
        if(c == null){
            System.out.println("This BookingID doesn't exist");
        }else{
            bookingList.remove(c);
            Hotel h = hm.searchHotelByID(c.getHotelID());
            int a = h.getAvailableRooms();
            h.setAvailableRooms(a + 1);
            hm.update(h);
            System.out.println("Remove successfully");
        }    
    }
    public void updateBooking(TourManagement tm, HotelManagement hm){
        String nBookingID = Inputter.inputNonBlankStr("Enter Booking ID: ");

        CustomerBooking c = searchBookingByID(nBookingID);
        if(c == null){
            System.out.println("Tour ID doesn't exist!!");
        }else{
            System.out.println("TOUR AVAILABLE:");
            tm.showTour();
            String tourID = Inputter.inputNonBlankStr("Enter Tour ID you choose: ");
            boolean check = tm.isExistID(tourID);
            if(check == false){
                System.out.println("This ID doesn't exist");
            }else{
                System.out.println("Booking tour successfully, pls choose your hotel");
                Tour t = tm.searchTourByid(tourID);

                hm.showAvailableHotel(t.getDestination());
                String hotelID = Inputter.inputNonBlankStr("Enter Hotel ID you choose: ");
                boolean checkHotel = hm.isExistID(hotelID);
                while(true){
                    if(!checkHotel){
                        System.out.printf("This ID doesn't exist, Pls re-Enter: ");
                        hotelID = Inputter.inputNonBlankStr("Enter Hotel ID you choose: ");
                    }else{
                        System.out.println("Booking hotel successfully");
                        Hotel h = hm.searchHotelByID(hotelID);
                        int a = h.getAvailableRooms();
                        h.setAvailableRooms(a);
                        hm.update(h);
                        break;
                    }
                }
                CustomerBooking tmpC = new CustomerBooking(nBookingID, tourID, hotelID);
                int index = bookingList.indexOf(tmpC);
                bookingList.set(index, tmpC);
                System.out.println("Updating successfully");
            } 
        }
    }
    public List<CustomerBooking> getBookingList(){
        return bookingList;
    }
}
