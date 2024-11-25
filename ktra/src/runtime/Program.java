
package runtime;

import controller.BookingManagement;
import controller.HotelManagement;
import controller.TourManagement;
import fileIO.HandleFile;
import java.util.List;
import jdk.internal.org.objectweb.asm.Handle;
import utilities.Inputter;
import models.Tour;
import models.Hotel;
import models.CustomerBooking;



public class Program {

    
    public static void main(String[] args) {
        String[] options = {"Create New Tour",
            "View and update existing tours", "Delete Tour",
            "Add new hotel", "Update and manage hotels",
            "Remove hotel", "Customer booking", "View and manage bookings",
            "Generate reports", "Data Management", "Exit"};
        TourManagement tm = new TourManagement();
        HotelManagement hm = new HotelManagement();
        BookingManagement bk = new BookingManagement();
        int choice = 0;
         do {
            System.out.println("\nCompany Employee Management Program");
            choice = Menu.getChoice(options); // show Menu options
            switch (choice) {
                case 1: {
                    tm.createNewTour();
//                    tm.showTour();
                    break;
                }
                case 2: {
                    String[] newOptions = {"Searching", "Update", "Exit"};
                    int newChoice = 0;
                    newChoice = Menu.getChoice(newOptions);
                    switch(newChoice){
                        case 1:{
                             String[] nO1 = {"Search By Destination", "Search By Duration"
                             , "Search By Price", "Exit"};
                             int nc1 = Menu.getChoice(nO1);
                             switch(nc1){
                                 case 1:{
                                     List<Tour> tmpTourList = tm.searchByDestination();
                                     for (Tour tour : tmpTourList) {
                                         System.out.println(tour.toString());
                                     }
                                     break;
                                 }
                                 case 2:{
                                     List<Tour> tmpTourList = tm.searchByDuration();
                                     for (Tour tour : tmpTourList) {
                                         System.out.println(tour.toString());
                                     }
                                     break;
                                 }
                                 case 3: {
                                     List<Tour> tmpTourList = tm.searchByPrice();
                                     for (Tour tour : tmpTourList) {
                                         System.out.println(tour.toString());
                                     }
                                     break;
                                 }
                                 case 4:{
                                     break;
                                 } 
                             }
                             break;
                        }
                        case 2:{
                            String[] no2 = {"Update full", "Update pricing", 
                            "Update Inclusiones", "Update Exclusion", "Exit"};
                            int nc2 = Menu.getChoice(no2);
                            switch(nc2){
                                case 1:{
                                    tm.updateModifyTour();
                                    break;
                                }
                                case 2:{
                                    tm.updatePrice();
                                    break;
                                }
                                case 3:{
                                    tm.updateInclusions();
                                    break;
                                }
                                case 4:{
                                    tm.updateExclusions();
                                    break;
                                }
                                case 5:{
                                    break;
                                }
                            }
                            break;
                        }
                        case 3:{
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    tm.deleteTour();
                    break;
                }
                case 4:{
                    hm.addNewHotel();
                    break;
                }
                case 5:{
                    String[] newOptions = {"Searching", "Update", "exit"};
                    int newChoice = 0;
                    newChoice = Menu.getChoice(newOptions);
                    switch(newChoice){
                        case 1:{
                             String[] nO1 = {"Search By location", "Search By pricing"
                             , "Search By amentities", "exit"};
                             int nc1 = Menu.getChoice(nO1);
                             switch(nc1){
                                 case 1:{
                                     List<Hotel> tmpList = hm.searchHotelByLocation();
                                     for (Hotel hotel : tmpList) {
                                         System.out.println(hotel.toString());
                                     }
                                     break;
                                 }
                                 case 2:{
                                     List<Hotel> tmpList = hm.searchHotelByPricing();
                                     for (Hotel hotel : tmpList) {
                                         System.out.println(hotel.toString());
                                     }
                                     break;
                                     
                                 }
                                 case 3: {
                                     List<Hotel> tmpList = hm.searchHotelByAmentities();
                                     for (Hotel hotel : tmpList) {
                                         System.out.println(hotel.toString());
                                     }
                                     break;
                                 }
                                 case 4: {
                                     break;
                                 }
                                 
                             }
                             break;
                        }
                        case 2:{
                            String[] no2 = {"Update room availability", "Update pricing", 
                            "Update amenitities", "exit"};
                            int nc2 = Menu.getChoice(no2);
                            switch(nc2){
                                case 1:{
                                   hm.updateRoomAvailability();
                                    break;
                                }
                                case 2:{
                                    hm.updatePricing();
                                    break;
                                }
                                case 3:{
                                    hm.updateAmentities();
                                    break;
                                }
                               
                                case 4:{
                                    break;
                                }
                            }
                            break;
                        }
                        case 3:{
                            break;
                        }
                    }
                    break;
                }
                case 6:{
                    hm.deleteHotel();
                    break;
                }
                case 7:{
                    bk.bookTourAndHotel(tm, hm);
                    break;
                }
                case 8:{
                    bk.cancelBooking(tm, hm);
                    break;
                }
                case 9:{
                    System.out.println("Ấy chết quên làm case này rùi :<>");
                    break;
                }
                case 10:{
                    HandleFile.writeToFile(tm.getTourList(), hm.getHotelList(), bk.getBookingList());
                    System.out.println("Saving successfully");
                    break;
                }
            }
        } while (choice > 0 && choice < options.length);
    }
    
    
    
    
     
}
