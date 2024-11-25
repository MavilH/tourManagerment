
package models;

import java.util.List;
import java.util.Objects;


public class Hotel {
    private String hotelID;
    private String name;
    private String location;
    private int availableRooms;
    private String amentities;
    private double pricing;

    public Hotel(String hotelID, String name, String location, int availableRooms, String amentities, double pricing) {
        this.hotelID = hotelID;
        this.name = name;
        this.location = location;
        this.availableRooms = availableRooms;
        this.amentities = amentities;
        this.pricing = pricing;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public String getAmentities() {
        return amentities;
    }

    public void setAmentities(String amentities) {
        this.amentities = amentities;
    }

    public double getPricing() {
        return pricing;
    }

    public void setPricing(double pricing) {
        this.pricing = pricing;
    }

    @Override
    public String toString() {
        return String.format("%s_%s_%s_%d_%s_%.2f", hotelID, name, location, availableRooms, amentities, pricing);
    }
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hotel other = (Hotel) obj;
        if (!Objects.equals(this.hotelID, other.hotelID)) {
            return false;
        }
        return true;
    }
    
    
}
