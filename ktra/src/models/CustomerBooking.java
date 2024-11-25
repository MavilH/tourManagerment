
package models;

import java.util.Objects;


public class CustomerBooking {
    String bookingID;
    String tourID;
    String hotelID;

    public CustomerBooking(String bookingID, String tourID, String hotelID) {
        this.bookingID = bookingID;
        this.tourID = tourID;
        this.hotelID = hotelID;
    }

    public String getTourID() {
        return tourID;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
    
    @Override
    public String toString() {
        return String.format("%s_%s_%s", bookingID,tourID, hotelID);
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
        final CustomerBooking other = (CustomerBooking) obj;
        if (!Objects.equals(this.bookingID, other.bookingID)) {
            return false;
        }
        return true;
    }
    
}
