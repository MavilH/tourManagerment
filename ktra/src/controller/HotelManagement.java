
package controller;

import fileIO.HandleFile;
import java.util.ArrayList;
import java.util.List;
import models.Hotel;
import utilities.Inputter;

public class HotelManagement {
    List<Hotel>  hotelList;
    
    private List<Hotel> load(){
        try{
            HandleFile file = new HandleFile();
            return file.readHotelFromFile();
        }catch (Exception ex){
            return null;
        }      
    }
    public HotelManagement() {
        hotelList = load();
        if(hotelList == null){
            hotelList = new ArrayList<>();
        }
    }
    
    public void addNewHotel(){
        String nHotelID;
        do {            
            nHotelID = Inputter.inputNonBlankStr("Enter Hotel ID: ");
            boolean check = isExistID(nHotelID);
            if(check == true){
                System.out.printf("ID is exist. Pls Re-");
            }else{
                break;
            }
        } while (true);
        String nName = Inputter.inputNonBlankStr("Enter Hotel Name: ");
        String nLocation = Inputter.inputNonBlankStr("Enter Hotel Location: ");
        int aR = Inputter.inputInt("Enter Hotel Available rooms: ", 0, ">=");
        String nAmentities = Inputter.inputNonBlankStr("Enter Hotel Amentities: ");
        double nPricing = Inputter.inputDouble("Enter Pricing: ", 0, ">=");
        Hotel h = new Hotel(nHotelID, nName, nLocation, aR, nAmentities, nPricing);
        hotelList.add(h);
        System.out.println("Adding successfully");
    }
    public boolean isExistID(String id){
        for (Hotel tour : hotelList) {
            if(tour.getHotelID().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }
   
    public Hotel searchHotelByID(String id){
        for (Hotel hotel : hotelList) {
            if(hotel.getHotelID().equalsIgnoreCase(id)){
                return hotel;
            }
        }
        return null;
    }
    public List<Hotel> searchHotelByLocation(){
        String lo = Inputter.inputNonBlankStr("Enter location you want to search: ");
        List<Hotel> tmpList = new ArrayList<>();
        for (Hotel hotel : hotelList) {
            if(hotel.getLocation().equalsIgnoreCase(lo)){
                tmpList.add(hotel);
            }
        }
        return tmpList;
    }
    public List<Hotel> searchHotelByAmentities(){
        String ame = Inputter.inputNonBlankStr("Enter ametities you want to search: ");
        List<Hotel> tmpList = new ArrayList<>();
        for (Hotel hotel : hotelList) {
            if(hotel.getAmentities().equalsIgnoreCase(ame)){
                tmpList.add(hotel);
            }
        }
        return tmpList;
    }
    public List<Hotel> searchHotelByPricing(){
        double pri = Inputter.inputADouble("Enter price you want to search", "Error");
        List<Hotel> tmpList = new ArrayList<>();
        for (Hotel hotel : hotelList) {
            if(hotel.getPricing() == pri){
                tmpList.add(hotel);
            }
        }
        return tmpList;
    }
    
    public void updateRoomAvailability(){
        String id = Inputter.inputNonBlankStr("Enter hotel id you want to update: ");
        Hotel h = searchHotelByID(id);
        if(h == null){
            System.out.println("This ID doesn's exist!!");
        }else{
            int aR = Inputter.inputInt("Enter Hotel Available rooms: ", 0, ">=");
            
            for (Hotel hotel : hotelList) {
                if(hotel.getHotelID().equalsIgnoreCase(id)){
                    hotel.setAvailableRooms(aR);
                }
            }
            System.out.println("Updating successfully");

        }
    }
    public void updateAmentities( ){
        String id = Inputter.inputNonBlankStr("Enter hotel id you want to update: ");
        Hotel h = searchHotelByID(id);
        if(h == null){
            System.out.println("This ID doesn's exist!!");
        }else{
            String nAmentities = Inputter.inputNonBlankStr("Enter Hotel Amentities: ");
            for (Hotel hotel : hotelList) {
                if(hotel.getHotelID().equalsIgnoreCase(id)){
                    hotel.setAmentities(nAmentities);
                }
            }
            System.out.println("Updating successfully");
        }
    }
    public void updatePricing(){
        String id = Inputter.inputNonBlankStr("Enter hotel id you want to update: ");
        Hotel h = searchHotelByID(id);
        if(h == null){
            System.out.println("This ID doesn's exist!!");
        }else{
            double nPricing = Inputter.inputDouble("Enter Pricing: ", 0, ">=");
            for (Hotel hotel : hotelList) {
                if(hotel.getHotelID().equalsIgnoreCase(id)){
                    hotel.setPricing(nPricing);
                }
            }
            System.out.println("Updating successfully");
        }
    }
    public void update(Hotel h){
        int index = hotelList.indexOf(h);
        hotelList.set(index, h);
        
    }
    
    public Hotel deleteHotel(){
        String id = Inputter.inputNonBlankStr("Enter hotel id you want to delete: ");
        Hotel h = searchHotelByID(id);
        if(h == null){
            System.out.println("ID doestn't exist!!");
            return null;
        }else{
            System.out.println("Do you want to delete this hotel?");
            System.out.println(h.toString());
            System.out.println("1. OK!!");
            System.out.println("2. NO!!");
            int i;
            while (true) {
                i = Inputter.inputAnInteger("Enter your choice: ", "Pls enter integer number!");
                if (i == 1 || i == 2) {
                    break;
                }
            }
            if (i == 1) {
                hotelList.remove(h);
                System.out.println("Remove successfull");
            }
            return h;
        }
    }
    
    public void showAvailableHotel(String location){
        for (Hotel hotel : hotelList) {
            if(hotel.getAvailableRooms() != 0 && hotel.getLocation().equalsIgnoreCase(location) ){
                System.out.println(hotel.toString());
            }
        }
    }
    public List<Hotel> getHotelList(){
        return hotelList;
    }
}
