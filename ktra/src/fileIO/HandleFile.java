
package fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import models.CustomerBooking;
import models.Tour;
import models.Hotel;
import controller.TourManagement;
import controller.HotelManagement;
import controller.BookingManagement;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;





public class HandleFile {
    public static void writeToFile(List<Tour> tourList, List<Hotel> hotelList, List<CustomerBooking> bookingList){
        String tourURL = "src/fileIO/tour.txt";
        String hotelURL = "src/fileIO/hotel.txt";
        String bookingURL = "src/fileIO/booking.txt";
        try{
            PrintWriter pw = new PrintWriter(tourURL);
            for (Tour tour : tourList) {
                pw.println(tour.toString());
            }
            pw.flush();
            pw.close();
        }catch(Exception e){
            System.out.println("File Error");
        }
        try{
            PrintWriter pw = new PrintWriter(hotelURL);
            for (Hotel hotel : hotelList) {
                pw.println(hotel.toString());
            }
            pw.flush();
            pw.close();
        }catch(Exception e){
            System.out.println("File Error");
        }
        try{
            PrintWriter pw = new PrintWriter(bookingURL);
            for (CustomerBooking booking : bookingList) {
                pw.println(booking.toString());
            }
            pw.flush();
            pw.close();
        }catch(Exception e){
            System.out.println("File Error");
        }
    }
    
    public static List<Tour> readTourFromFile(){
        List<Tour> tourList = new ArrayList<>();
        String tourURL = "src/fileIO/tour.txt";
        File f = new File(tourURL);
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line = null;
            while(true){
                line = br.readLine();
                if(line == null){
                    break;
                }else{
                    //%s|%s|%s|%s|%s|%.2f|%s|%s|%s", tourID, name, destination, duration, description, price, inclusions, exclusions, location);
                    String tour[] = line.split("_");
                    
                    String tourID = tour[0];
                    String name = tour[1];
                    String destination = tour[2];
                    String duration = tour[3];
                    String description = tour[4];
                    double price = Double.parseDouble(tour[5]);
                    String inclusions = tour[6];
                    String exclusions = tour[7];
                    Tour t = new Tour(tourID, name, destination, duration, description, price, inclusions, exclusions);
                    tourList.add(t);
                }
            }
            return tourList;
        } catch (Exception e) {
            System.out.println("File Error");
        }
        return tourList;
     }
    
    public static List<Hotel> readHotelFromFile(){
        List<Hotel> hotelList = new ArrayList<>();
        String hotelURL = "src/fileIO/hotel.txt";
        File f = new File(hotelURL);
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line = null;
            while(true){
                line = br.readLine();
                if(line == null){
                    break;
                }else{
                    //return String.format("%s|%s|%s|%d|%s|%.2f", hotelID, name, location, availableRooms, amentities, pricing);
                    String hotel[] = line.split("_");
                    String hotelID = hotel[0];
                    String name = hotel[1];
                    String location = hotel[2];
                    int availableRooms = Integer.parseInt(hotel[3]);
                    String amentities = hotel[4];
                    double pricing = Double.parseDouble(hotel[5]);
                    Hotel h = new Hotel(hotelID, name, location, availableRooms, amentities, pricing);
                    hotelList.add(h);
                }
            }
            return hotelList;
        } catch (Exception e) {
            System.out.println("File Error");
        }
        return hotelList;
     }
    
     public static List<CustomerBooking> readBookingFromFile(){
        List<CustomerBooking> bookingList = new ArrayList<>();
        String bookingURL = "src/fileIO/booking.txt";
        File f = new File(bookingURL);
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line = null;
            while(true){
                line = br.readLine();
                if(line == null){
                    break;
                }else{
                    //rreturn String.format("%s|%s|%s", bookingID,tourID, hotelID);
                    String booking[] = line.split("_");
                    String bookingID = booking[0];
                    String tourID = booking[1];
                    String hotelID = booking[1];
                    CustomerBooking c = new CustomerBooking(bookingID, tourID, hotelID);
                    bookingList.add(c);
                }
            }
            return bookingList;
        } catch (Exception e) {
            System.out.println("File Error");
        }
        return null;
     }

   
}
