
package controller;


import fileIO.HandleFile;
import java.util.ArrayList;
import java.util.List;
import utilities.Inputter;
import models.Tour;


public class TourManagement {
   
    List<Tour> tourList = null;
    
     private List<Tour> load(){
        try{
            HandleFile file = new HandleFile();
            return file.readTourFromFile();
        }catch (Exception ex){
            return null;
        }      
    }
    public TourManagement() {
        tourList = load();
        if(tourList == null){
            tourList = new ArrayList<>();
        }
    }
    
    public void createNewTour(){
        String nTourID;
        do {            
            nTourID = Inputter.inputNonBlankStr("Enter Tour ID: ");
            boolean check = isExistID(nTourID);
            if(check == true){
                System.out.printf("ID is exist. Pls Re-");
            }else{
                break;
            }
        } while (true);
        String nName = Inputter.inputNonBlankStr("Enter Tour Name: ");
        String nDestination = Inputter.inputNonBlankStr("Enter Tour Destination: ");
        String nDuration = Inputter.inputNonBlankStr("Enter Tour Duration: ");
        String nDescription = Inputter.inputNonBlankStr("Enter Tour Description: ");
        double nPrice = Inputter.inputDouble("Enter Tour Price: ", 0, ">=");
        String nInclusions = Inputter.inputNonBlankStr("Enter Tour Inclusions: ");
        String nExclusions = Inputter.inputNonBlankStr("Enter Tour Exclusions: ");
        

        Tour nTour = new Tour(nTourID, nName, nDestination, nDuration, nDescription, nPrice, nInclusions, nExclusions);
        tourList.add(nTour);
        System.out.println("Creating successfully");
    }
    
    public List<Tour> searchByDestination(){
        String des = Inputter.inputNonBlankStr("Enter Destination you want to search: ");
        List<Tour> tmpList = new ArrayList<>();
        for (Tour tour : tourList) {
            if(tour.getDestination().equalsIgnoreCase(des)){
                tmpList.add(tour);
            }
        }
        return tmpList;
    }
    public List<Tour> searchByDuration(){
        String dur = Inputter.inputNonBlankStr("Enter Duration you want to search: ");
        List<Tour> tmpList = new ArrayList<>();
        for (Tour tour : tourList) {
            if(tour.getDuration().equalsIgnoreCase(dur)){
                tmpList.add(tour);
            }
        }
        return tmpList;
    }
    public List<Tour> searchByPrice(){
        double pri = Inputter.inputADouble("Enter price you want to search", "error");
        List<Tour> tmpList = new ArrayList<>();
        for (Tour tour : tourList) {
            if(tour.getPrice() == pri){
                tmpList.add(tour);
            }
        }
        return tmpList;
    }
    public Tour searchTourByid(String id){
        for (Tour tour : tourList) {
            if(tour.getTourID().equalsIgnoreCase(id)){
                return tour;
            }
        }
        return null;
    }
    
    public void updateModifyTour(){
        String id = Inputter.inputNonBlankStr("Enter Tour ID: ");
        Tour t = searchTourByid(id);
        if(t == null){
            System.out.println("Tour ID doesn't exist!!");
        }else{
            String nName = Inputter.inputNonBlankStr("Enter Tour Name: ");
            String nDestination = Inputter.inputNonBlankStr("Enter Tour Destination: ");
            String nDuration = Inputter.inputNonBlankStr("Enter Tour Duration: ");
            String nDescription = Inputter.inputNonBlankStr("Enter Tour Description: ");
            double nPrice = Inputter.inputDouble("Enter Tour Price: ", 0, ">=");
            String nInclusions = Inputter.inputNonBlankStr("Enter Tour Inclusions: ");
            String nExclusions = Inputter.inputNonBlankStr("Enter Tour Exclusions: ");
            Tour nTour = new Tour(id, nName, nDestination, nDuration, nDescription, nPrice, nInclusions, nExclusions);
            update(nTour);
            System.out.println("Updating successfully");
        }
    }
    public void updatePrice(){
        String id = Inputter.inputNonBlankStr("Enter tour id: ");
        Tour t = searchTourByid(id);
        if(t == null){
            System.out.println("Tour ID doesn't exist!!");
        }else{
            double nPrice = Inputter.inputDouble("Enter Tour Price: ", 0, ">=");
            for (Tour tour : tourList) {
                if(tour.getTourID().equalsIgnoreCase(id)){
                    tour.setPrice(nPrice);
                }
            }
            System.out.println("Updating successfully");
        }
    }
    public void updateInclusions(){
        String id = Inputter.inputNonBlankStr("Enter tour id: ");
        Tour t = searchTourByid(id);
        if(t == null){
            System.out.println("Tour ID doesn't exist!!");
        }else{
            String nInclusions = Inputter.inputNonBlankStr("Enter Tour Inclusions: ");
            for (Tour tour : tourList) {
                if(tour.getTourID().equalsIgnoreCase(id)){
                    tour.setInclusions(nInclusions);
                }
            }
            System.out.println("Updating successfully");
        }
    }
    public void updateExclusions(){
        String id = Inputter.inputNonBlankStr("Enter tour id: ");
        Tour t = searchTourByid(id);
        if(t == null){
            System.out.println("Tour ID doesn't exist!!");
        }else{
            String nExclusions = Inputter.inputNonBlankStr("Enter Tour Exclusions: ");
            for (Tour tour : tourList) {
                if(tour.getTourID().equalsIgnoreCase(id)){
                    tour.setExclusions(nExclusions);
                }
            }
            System.out.println("Updating successfully");
        }
    }
    public void update(Tour nTour){
        int index = tourList.indexOf(nTour);
        tourList.set(index, nTour);
    }
    public boolean isExistID(String id){
        for (Tour tour : tourList) {
            if(tour.getTourID().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }
    
    public Tour deleteTour(){
        String id = Inputter.inputNonBlankStr("Enter tour id: ");
        Tour t = searchTourByid(id);
        if (t == null) {
            System.out.println("ID doesn's exist!!");
            return null;
        } else {
            System.out.println("Do you want to delete this tour?");
            System.out.println(t.toString());
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
                tourList.remove(t);
                System.out.println("Remove successfull");
            }
            return t;
        }
    }
    
    public void showTour(){
        for (Tour tour : tourList) {
            System.out.println(tour.toString());;
        }
    }
    public List<Tour> getTourList(){
        return tourList;
    }
    
            
}
