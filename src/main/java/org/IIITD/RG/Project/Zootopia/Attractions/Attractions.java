package org.IIITD.RG.Project.Zootopia.Attractions;
import java.util.*;
public class Attractions {
        private static int ID_generator = 0;
        public static ArrayList<Attractions> attractionList = new ArrayList<>();
        int attraction_ID;
        private String Attraction_name;
        private int Attraction_price;
        private int Attraction_usercount;
        private String Attraction_status;
        private String Attraction_description;
    public String getAttraction_name() {
        return Attraction_name;
    }
    public void setAttraction_name(String attraction_name) {
        Attraction_name = attraction_name;
    }
    public int getAttraction_price() {
        return Attraction_price;
    }
    public void setAttraction_price(int attraction_price) {
        Attraction_price = attraction_price;
    }
    public int getAttraction_usercount() {
        return Attraction_usercount;
    }
    public void setAttraction_usercount(int attraction_usercount) {
        Attraction_usercount = attraction_usercount;
    }
    public int getAttraction_ID() {
        return attraction_ID;
    }
    public String getAttraction_status() {
        return Attraction_status;
    }
    public void setAttraction_status(String attraction_status) {
        Attraction_status = attraction_status;
    }

    public String getAttraction_description() {
        return Attraction_description;
    }

    public void setAttraction_description(String attraction_description) {
        Attraction_description = attraction_description;
    }

    public Attractions(String name, int price, String description){
            this.setAttraction_name(name);
            this.setAttraction_price(price);
            this.setAttraction_description(description);
            this.setAttraction_usercount(0);
            this.setAttraction_status("OPEN"); //assuming on adding a new attraction, it is initially in the working state i.e. open.
            this.attraction_ID = ++ID_generator;
            //check timing for scheduling
        }
    }

