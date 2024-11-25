
package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Tour {
    private String tourID;
    private String name;
    private String destination;
    private String duration;
    private String description;
    private double price;
    private String inclusions;
    private String exclusions;

    

    public Tour(String tourID, String name, String destination, String duration, String description, double price, String inclusions, String exclusions){
        this.tourID = tourID;
        this.name = name;
        this.destination = destination;
        this.duration = duration;
        this.description = description;
        this.price = price;
        this.inclusions = inclusions;
        this.exclusions = exclusions;

    }
    
    public String getTourID() {
        return tourID;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInclusions() {
        return inclusions;
    }

    public void setInclusions(String inclusions) {
        this.inclusions = inclusions;
    }

    public String getExclusions() {
        return exclusions;
    }

    public void setExclusions(String exclusions) {
        this.exclusions = exclusions;
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
        final Tour other = (Tour) obj;
        if (!Objects.equals(this.tourID, other.tourID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s_%s_%s_%s_%s_%.2f_%s_%s", tourID, name, destination, duration, description, price, inclusions, exclusions);
    }
    
}
