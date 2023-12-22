package org.IIITD.RG.Project.Zootopia.Visitors;

import org.IIITD.RG.Project.Zootopia.Admin.Admin;
import org.IIITD.RG.Project.Zootopia.Animals.Amphibians;
import org.IIITD.RG.Project.Zootopia.Animals.Mammals;
import org.IIITD.RG.Project.Zootopia.Animals.Reptiles;
import org.IIITD.RG.Project.Zootopia.Attractions.Attractions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import static org.IIITD.RG.Project.Zootopia.Animals.Amphibians.*;
import static org.IIITD.RG.Project.Zootopia.Animals.Mammals.*;
import static org.IIITD.RG.Project.Zootopia.Animals.Reptiles.*;
import static org.IIITD.RG.Project.Zootopia.Attractions.Attractions.attractionList;
import static org.IIITD.RG.Project.Zootopia.Feedback.Feedback.feedbackArrayList;
import static org.IIITD.RG.Project.Zootopia.Offers.Deals.dealsArrayList;
import static org.IIITD.RG.Project.Zootopia.Offers.Discount.discountArrayList;
import static org.IIITD.RG.Project.Zootopia.Visitors.Premium_visitors.premiumVisitorsArrayList;


//login; recharge; *************************************************************************************************
public class Basic_visitors extends Visitors_abstract{
    public static ArrayList<Basic_visitors> basicVisitorsArrayList = new ArrayList<>();
    public HashMap<Integer, Integer> ticketStore= new HashMap<>();
    private String visitor_name;
    private Integer visitor_age;
    private String visitor_phno;
    private Integer visitor_balance;
    private String visitor_email;
    private String visitor_password;

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public Integer getVisitor_age() {
        return visitor_age;
    }

    public void setVisitor_age(Integer visitor_age) {
        this.visitor_age = visitor_age;
    }

    public String getVisitor_phno() {
        return visitor_phno;
    }

    public void setVisitor_phno(String visitor_phno) {
        this.visitor_phno = visitor_phno;
    }

    public Integer getVisitor_balance() {
        return visitor_balance;
    }

    public void setVisitor_balance(Integer visitor_balance) {
        this.visitor_balance = visitor_balance;
    }

    public String getVisitor_email() {
        return visitor_email;
    }

    public void setVisitor_email(String visitor_email) {
        this.visitor_email = visitor_email;
    }

    public String getVisitor_password() {
        return visitor_password;
    }

    public void setVisitor_password(String visitor_password) {
        this.visitor_password = visitor_password;
    }

    public Basic_visitors(String visitor_name, Integer visitor_age, String visitor_phno, Integer visitor_balance, String visitor_email, String visitor_password) {
        this.visitor_name = visitor_name;
        this.visitor_age = visitor_age;
        this.visitor_phno = visitor_phno;
        this.visitor_balance = visitor_balance;
        this.visitor_email = visitor_email;
        this.visitor_password = visitor_password;
    }
    public static void registerVisitor(){
        Scanner inp= new Scanner(System.in);
        Scanner inp2= new Scanner(System.in);
        System.out.println("Enter name of visitor: ");
        String name= inp.nextLine();
        System.out.println("Enter age of visitor: ");
        int age= inp2.nextInt();
        System.out.println("Enter phone no. of visitor: ");
        String phno= inp.nextLine();
        System.out.println("Enter balance of visitor: ");
        int balance= inp2.nextInt();
        System.out.println("Enter email of visitor: ");
        String email= inp.nextLine();
        System.out.println("Enter password of email of visitor: ");
        String pass= inp.nextLine();
        Basic_visitors b1= new Basic_visitors(name, age, phno, balance, email, pass);
        basicVisitorsArrayList.add(b1);
        for (org.IIITD.RG.Project.Zootopia.Offers.Discount discount : discountArrayList) {
            if (discount.getLowerage() <= age && discount.getUpperage() >= age) {
                System.out.println("Discount of " + discount.getPercentagediscount() +"available! Enter discount code: "+ discount.getDiscountCouponCode()+" to avail discount. ");
                String discode= inp.nextLine();
                if(discode.equals(discount.getDiscountCouponCode())){
                    int val = (int) ((20 * discount.getPercentagediscount()) / 100.0);
                    if(b1.getVisitor_balance()>=20-val){
                        b1.setVisitor_balance(b1.getVisitor_balance()-(20-val));
                        Admin.setTotal_Revenue(Admin.getTotal_Revenue()+(20-val));
                        System.out.println(discount.getDiscountCouponCode() + " successfully applied! ");
                        System.out.println("Balance: " + b1.getVisitor_balance());
                        System.out.println("Member registered successfully! ");
                        break;
                    }
                    else{
                        System.out.println("Balance insufficient! Please recharge! ");
                    }
                }
                else{
                    System.out.println("Incorrect discount code entered. Payment will proceed without discount. ");
                    if(b1.getVisitor_balance()>=20){
                        b1.setVisitor_balance(b1.getVisitor_balance()-(20));
                        Admin.setTotal_Revenue(Admin.getTotal_Revenue()+20);
                        System.out.println("Balance: " + b1.getVisitor_balance());
                        System.out.println("Member registered successfully! ");
                        break;
                    }
                    else{
                        System.out.println("Balance insufficient! Please recharge! ");
                    }
                }
            }
            else{
                if(b1.getVisitor_balance()>=20){
                    b1.setVisitor_balance(b1.getVisitor_balance()-(20));
                    Admin.setTotal_Revenue(Admin.getTotal_Revenue()+20);
                    System.out.println("Balance: " + b1.getVisitor_balance());
                    System.out.println("Member registered successfully! ");
                    break;
                }
                else{
                    System.out.println("Balance insufficient! Please recharge! ");
                }
            }
        }
    }

    public static Visitors_abstract visitorLogin(){
        Scanner inp= new Scanner(System.in);
        System.out.println("Enter your email ID: ");
        String email= inp.nextLine();
        System.out.println("Enter password: ");
        String pass= inp.nextLine();
        for (Basic_visitors basicVisitors : basicVisitorsArrayList) {
            if (email.equals(basicVisitors.getVisitor_email())) {
                if (pass.equals(basicVisitors.getVisitor_password())) {
                    return basicVisitors;
                }
            }
        }
        for (Premium_visitors premiumVisitors : premiumVisitorsArrayList) {
            if (email.equals(premiumVisitors.getVisitor_email())) {
                if (pass.equals(premiumVisitors.getVisitor_password())) {
                    return premiumVisitors;
                }
            }
        }
        System.out.println("No member found. Register first. ");
        return null;
    }

    @Override
    public void exploreZoo() {
        Scanner inp= new Scanner(System.in);
        System.out.println("What do you want to explore? Press 1 for attractions; 2 for animals: ");
        int chosen= inp.nextInt();
        if(chosen==1){
            System.out.println("+--------------------------------------------------------------------------------------+");
            System.out.println("| Attraction ID |   Attraction name    |   Attraction price |   Attraction status  |");
            System.out.println("+---------------------------------------------------------------------------------------+");

            for (Attractions attractions : attractionList) {
                Integer attractionID = attractions.getAttraction_ID();
                String attractionName = attractions.getAttraction_name();
                Integer attractionPrice = attractions.getAttraction_price();
                String attractionStatus = attractions.getAttraction_status();

                String formattedOutput = String.format("| %-13d| %-20s| %-22d| %-15s", attractionID, attractionName, attractionPrice, attractionStatus);
                System.out.println(formattedOutput);
            }

            System.out.println("+---------------------------------------------------------------------------------------+");
            System.out.println("Which attraction do you want to visit? Enter attraction ID. ");
            int ID= inp.nextInt();
            for (Attractions attractions : attractionList) {
                if (ID == attractions.getAttraction_ID()) {
                    String ans= attractions.getAttraction_description();
                    System.out.println(ans);
                    break;
                }
            }
        }
        else if(chosen==2){
            Scanner inp3= new Scanner(System.in);
            System.out.println("Enter type of animal whom you want to explore(M/R/A): ");
            String type= inp3.nextLine();
            switch (type) {
                case "M" -> {
                    System.out.println("+------------------------------------------------------------+");
                    System.out.println("| Animal Type      |   Animal Name       |");
                    System.out.println("+------------------------------------------------------------+");
                    for (Mammals mammals : mammalList) {
                        String mname = mammals.getMammal_name();
                        String mtype = "Mammal";

                        String formattedOutput = String.format("| %-18s| %-22s|", mtype, mname);
                        System.out.println(formattedOutput);
                    }
                    System.out.println("+------------------------------------------------------------+");
                }
                case "R" -> {
                    System.out.println("+------------------------------------------------------------+");
                    System.out.println("| Animal Type          |   Animal Name             |");
                    System.out.println("+------------------------------------------------------------+");
                    for (Reptiles reptiles : reptileList) {
                        String rname = reptiles.getReptile_name();
                        String rtype = "Reptile";

                        String formattedOutput = String.format("| %-18s| %-22s|", rtype, rname);
                        System.out.println(formattedOutput);
                    }
                    System.out.println("+------------------------------------------------------------+");
                }
                case "A" -> {
                    System.out.println("+------------------------------------------------------------+");
                    System.out.println("| Animal Type          |   Animal Name             |");
                    System.out.println("+------------------------------------------------------------+");
                    for (Amphibians amphibians : amphiList) {
                        String aname = amphibians.getAmphi_name();
                        String atype = "Amphibian";

                        String formattedOutput = String.format("| %-18s| %-22s|", atype, aname);
                        System.out.println(formattedOutput);
                    }
                    System.out.println("+------------------------------------------------------------+");
                }
                default -> System.out.println("No such type exists!");
            }
            Scanner inp2= new Scanner(System.in);
            System.out.println("Enter name of animal whom you want to explore: ");
            String name= inp2.nextLine();
            if(type.equals("M")){
                for (Mammals mammals : mammalList) {
                    if (name.equals(mammals.getMammal_name())) {
                        String des= mammals.getMammal_description();
                        System.out.println(des);
                        break;
                    }

                }
            }
            else if(type.equals("R")){
                for (Reptiles reptiles : reptileList) {
                    if (name.equals(reptiles.getReptile_name())) {
                        String des= reptiles.getReptile_description();
                        System.out.println(des);
                        break;
                    }

                }
            }
            else{
                for (Amphibians amphibians : amphiList) {
                    if (name.equals(amphibians.getAmphi_name())) {
                        String des= amphibians.getAmphi_description();
                        System.out.println(des);
                        break;
                    }
                }
            }
            System.out.println("Buy your ticket now!");
        }
        }
    @Override
    public void buyTickets() {
        HashMap<Integer, Integer> tempTicketStore= new HashMap<>();
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("| Attraction ID |   Attraction name    |   Attraction price |   Attraction status  |");
        System.out.println("+---------------------------------------------------------------------------------------+");

        for (Attractions attractions : attractionList) {
            Integer attractionID = attractions.getAttraction_ID();
            String attractionName = attractions.getAttraction_name();
            Integer attractionPrice = attractions.getAttraction_price();
            String attractionStatus = attractions.getAttraction_status();

            String formattedOutput = String.format("| %-13d| %-20s| %-22d| %-15s", attractionID, attractionName, attractionPrice, attractionStatus);
            System.out.println(formattedOutput);
        }
        Scanner inp= new Scanner(System.in);
        Scanner inp2= new Scanner(System.in);
        System.out.println("Enter number of tickets you want to buy: ");
        int num= inp2.nextInt();
        for(int i=0; i<num;i++){
            System.out.println("Enter Attraction ID for which you want to buy ticket(s) ?");
            int id= inp2.nextInt();
//            this.ticketStore.put(id, 1);
//            tempTicketStore.put(id,1);
            if (tempTicketStore.containsKey(id)) {
                int currentValue = tempTicketStore.get(id);
                tempTicketStore.put(id, currentValue + 1);
                int cv2= this.ticketStore.get(id);
                this.ticketStore.put(id,cv2+1 );
            }
            else if(!tempTicketStore.containsKey(id) && this.ticketStore.containsKey(id)){
                tempTicketStore.put(id,1);
                int cv2= this.ticketStore.get(id);
                this.ticketStore.put(id,cv2+1 );
            }
            else if(!tempTicketStore.containsKey(id) && !this.ticketStore.containsKey(id)){
                tempTicketStore.put(id,1);
                this.ticketStore.put(id,1);
            }
        }
        int val=0;
        int age= this.getVisitor_age();
        for (org.IIITD.RG.Project.Zootopia.Offers.Discount discount : discountArrayList) {
            if (discount.getLowerage() <= age && discount.getUpperage() >= age) {
                System.out.println("Discount of " + discount.getPercentagediscount() +"available! Enter discount code: "+ discount.getDiscountCouponCode()+" to avail discount. ");
                String discode= inp.nextLine();
                if(discode.equals(discount.getDiscountCouponCode())){
                    val = discount.getPercentagediscount();
                    break;
                }
                else{
                    System.out.println("Incorrect discount code entered! Payment will proceed without discount. \n");
                }
            }
            else{
                System.out.println("No discount applicable. \n");
            }
        }
        int total_price=0;
        //discount
        for (Attractions attractions : attractionList) {
                if (tempTicketStore.containsKey(attractions.getAttraction_ID())) {
                    int price = attractions.getAttraction_price();
                    price = (int) (price - (price * val) / 100.0);
                    total_price+=price;
                }
        }

        //deal
        for (org.IIITD.RG.Project.Zootopia.Offers.Deals deals : dealsArrayList) {
            if (num == deals.getNum()) {
                int perc = deals.getPercentage();
                total_price = total_price - ((total_price * perc) / 100);
                System.out.println("Deal " + deals.getDealName() + " applied successfully! ");
            }
        }

        //final ticket purchase
        if(this.getVisitor_balance()>=total_price){
            this.setVisitor_balance(this.getVisitor_balance() - total_price);
            Admin.setTotal_Revenue(total_price+Admin.getTotal_Revenue());
            tempTicketStore.clear();
            System.out.println("Ticket(s) purchased successfully! ");
            System.out.println("Balance remaining: " + this.getVisitor_balance());
        }
        else{
            System.out.println("Insufficient balance! Please recharge! ");
        }
    }

    public void viewDiscounts() {
        System.out.println("+------------------------------------------------------------+");
        System.out.println("| Discount name      |   Offer      |");
        System.out.println("+------------------------------------------------------------+");
        for (org.IIITD.RG.Project.Zootopia.Offers.Discount discount : discountArrayList) {
            String name = discount.getDiscountCouponCode();
            int perc = discount.getPercentagediscount();
            String formattedOutput = String.format("| %-18s| %-22s|", name, perc);
            System.out.println(formattedOutput);
        }
        System.out.println("+------------------------------------------------------------+");
    }

    public void buyMembership() { //used to purchase premium membership
        Scanner inp= new Scanner(System.in);
        System.out.println("You currently have a basic membership, do you want to purchase premium membership? (Y/N):" );
        String response= inp.nextLine();
        if(response.equals("Y")){
            int flag=0;
            System.out.println("Enter your phone number: ");
            String phno= inp.nextLine();
            //payment
            int age= this.getVisitor_age();
            for (org.IIITD.RG.Project.Zootopia.Offers.Discount discount : discountArrayList) {
                if (discount.getLowerage() <= age && discount.getUpperage() >= age) {
                    System.out.println("Discount of " + discount.getPercentagediscount() +"available! Enter discount code: "+ discount.getDiscountCouponCode()+" to avail discount. ");
                    String discode= inp.nextLine();
                    if(discode.equals(discount.getDiscountCouponCode())){
                        int val = (int) ((50 * discount.getPercentagediscount()) / 100.0);
                        if(this.getVisitor_balance()>=50-val){
                            this.setVisitor_balance(this.getVisitor_balance()-(50-val));
                            Admin.setTotal_Revenue(Admin.getTotal_Revenue()+(50-val));
                            System.out.println(discount.getDiscountCouponCode() + " successfully applied! ");
                            System.out.println("Balance: " + this.getVisitor_balance());
                            System.out.println("Congratulations! You are now a premium member! ");
                            System.out.println("Please log out and login again to avail benefits. ");
                            flag=1;
                            break;
                        }
                        else{
                            System.out.println("Balance insufficient! Please recharge! ");
                            break;
                        }
                    }
                    else{
                        System.out.println("Incorrect discount code entered. Payment will proceed without discount. ");
                        if(this.getVisitor_balance()>=50){
                            this.setVisitor_balance(this.getVisitor_balance()-(50));
                            Admin.setTotal_Revenue(Admin.getTotal_Revenue()+50);
                            System.out.println("Balance: " + this.getVisitor_balance());
                            System.out.println("Congratulations! You are now a premium member ");
                            System.out.println("Please log out and login again to avail benefits. ");
                            flag=1;
                            break;
                        }
                        else{
                            System.out.println("Balance insufficient! Please recharge! ");
                            break;
                        }
                    }
                }
                else{
                    if(this.getVisitor_balance()>=50){
                        this.setVisitor_balance(this.getVisitor_balance()-(50));
                        Admin.setTotal_Revenue(50+Admin.getTotal_Revenue());
                        System.out.println("Balance: " + this.getVisitor_balance());
                        System.out.println("Congratulations! You are now a premium member ");
                        System.out.println("Please log out and login again to avail benefits. ");
                        flag=1;
                        break;
                    }
                    else{
                        System.out.println("Balance insufficient! Please recharge! ");
                    }
                }
            }
            if(flag==1){
                for(int i=0; i<basicVisitorsArrayList.size(); i++){
                    if(phno.equals(basicVisitorsArrayList.get(i).getVisitor_phno())){
                        String name= basicVisitorsArrayList.get(i).getVisitor_name();
                        int age2= basicVisitorsArrayList.get(i).getVisitor_age();
                        String ph= basicVisitorsArrayList.get(i).getVisitor_phno();
                        String em= basicVisitorsArrayList.get(i).getVisitor_email();
                        String pass= basicVisitorsArrayList.get(i).getVisitor_password();
                        int balance= basicVisitorsArrayList.get(i).getVisitor_balance();
                        Premium_visitors p1= new Premium_visitors(name, age2, ph, balance, em, pass);
                        premiumVisitorsArrayList.add(p1);
                        basicVisitorsArrayList.remove(basicVisitorsArrayList.get(i));
                        break;
                    }
                }
            }
            else{
                System.out.println("Switch to premium membership unsuccessful. \n");
            }
        }
    }

    public void viewSpecialDeals() {
        System.out.println("+------------------------------------------------------------+");
        System.out.println("| Deal name      |   Offer      |");
        System.out.println("+------------------------------------------------------------+");
        for (org.IIITD.RG.Project.Zootopia.Offers.Deals deals : dealsArrayList) {
            String name = deals.getDealName();
            int perc = deals.getPercentage();
            String formattedOutput = String.format("| %-18s| %-22s|", name, perc);
            System.out.println(formattedOutput);
        }
        System.out.println("+------------------------------------------------------------+");
    }
    @Override
    public void visitAnimal() {
        //assuming no ticket is required for visiting animals
        Scanner inp= new Scanner(System.in);
        System.out.println("Enter type of animal whom you want to visit(M/R/A): ");
        String type= inp.nextLine();
        switch (type) {
            case "M" -> {
                System.out.println("+------------------------------------------------------------+");
                System.out.println("| Animal Type      |   Animal Name       |");
                System.out.println("+------------------------------------------------------------+");
                for (Mammals mammals : mammalList) {
                    String mname = mammals.getMammal_name();
                    String mtype = "Mammal";

                    String formattedOutput = String.format("| %-18s| %-22s|", mtype, mname);
                    System.out.println(formattedOutput);
                }
                System.out.println("+------------------------------------------------------------+");
            }
            case "R" -> {
                System.out.println("+------------------------------------------------------------+");
                System.out.println("| Animal Type          |   Animal Name             |");
                System.out.println("+------------------------------------------------------------+");
                for (Reptiles reptiles : reptileList) {
                    String rname = reptiles.getReptile_name();
                    String rtype = "Reptile";

                    String formattedOutput = String.format("| %-18s| %-22s|", rtype, rname);
                    System.out.println(formattedOutput);
                }
                System.out.println("+------------------------------------------------------------+");
            }
            case "A" -> {
                System.out.println("+------------------------------------------------------------+");
                System.out.println("| Animal Type          |   Animal Name             |");
                System.out.println("+------------------------------------------------------------+");
                for (Amphibians amphibians : amphiList) {
                    String aname = amphibians.getAmphi_name();
                    String atype = "Amphibian";

                    String formattedOutput = String.format("| %-18s| %-22s|", atype, aname);
                    System.out.println(formattedOutput);
                }
                System.out.println("+------------------------------------------------------------+");
            }
            default -> System.out.println("No such type exists!");
        }
        Scanner inp2= new Scanner(System.in);
        Scanner inp3= new Scanner(System.in);
        System.out.println("Enter name of animal whom you want to visit: ");
        String name= inp2.nextLine();
        System.out.println("Enter 1 for feeding the animal; enter 2 for reading about the animal: ");
        int choose= inp3.nextInt();
            if(type.equals("M")){
                for (Mammals mammals : mammalList) {
                    if (name.equals(mammals.getMammal_name()) && choose==1) {
                        String sound= mammals.getMammal_Sound();
                        setAmphi_vc(getAmphi_vc()+1);
                        System.out.println(sound);
                        break;
                    }
                    else if(name.equals(mammals.getMammal_name()) && choose ==2){
                        setAmphi_vc(getAmphi_vc()+1);
                        String des= mammals.getMammal_description();
                        System.out.println(des);
                        break;
                    }
                }
            }
            else if(type.equals("R")){
                for (Reptiles reptiles : reptileList) {
                    if (name.equals(reptiles.getReptile_name()) && choose ==1 ) {
                        String sound= reptiles.getReptile_Sound();
                        setReptile_vc(getReptile_vc()+1);
                        System.out.println(sound);
                        break;
                    }
                    else if(name.equals(reptiles.getReptile_name()) && choose ==2){
                        String des= reptiles.getReptile_description();
                        setReptile_vc(getReptile_vc()+1);
                        System.out.println(des);
                        break;
                    }

                }
            }
            else{
                for (Amphibians amphibians : amphiList) {
                    if (name.equals(amphibians.getAmphi_name()) && choose ==1 ) {
                        String sound= amphibians.getAmphi_Sound();
                        setMammal_vc(getMammal_vc()+1);
                        System.out.println(sound);
                        break;
                    }
                    else if(name.equals(amphibians.getAmphi_name()) && choose ==2){
                        String des= amphibians.getAmphi_description();
                        setMammal_vc(getMammal_vc()+1);
                        System.out.println(des);
                        break;
                    }
                }
            }
    }

    @Override
    public void visitAttraction() {
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("| Attraction ID |   Attraction name    |   Attraction price |   Attraction status  |");
        System.out.println("+---------------------------------------------------------------------------------------+");
        for (Attractions attractions : attractionList) {
            Integer attractionID = attractions.getAttraction_ID();
            String attractionName = attractions.getAttraction_name();
            Integer attractionPrice = attractions.getAttraction_price();
            String attractionStatus = attractions.getAttraction_status();
            String formattedOutput = String.format("| %-13d| %-20s| %-22d| %-15s", attractionID, attractionName, attractionPrice, attractionStatus);
            System.out.println(formattedOutput);
        }
        Scanner inp= new Scanner(System.in);
        System.out.println("Which attraction would you like to visit? Enter Attraction ID");
        int id= inp.nextInt();
        for(int i=0; i< this.ticketStore.size(); i++){
            if(this.ticketStore.containsKey(id)){
                for (Attractions attractions : attractionList) {
                    if (id == attractions.getAttraction_ID() && attractions.getAttraction_status().equals("OPEN")) {
                        //attraction visitor count
                        attractions.setAttraction_usercount(attractions.getAttraction_usercount()+1);
                        System.out.println("1 ticket used. ");
                        System.out.println("Thank you for visiting " + attractions.getAttraction_name() + " ! Hope you enjoyed! ");
                        int temp= this.ticketStore.get(id);
                        this.ticketStore.put(id,temp-1);
                        if(this.ticketStore.get(id)==0){
                            this.ticketStore.remove(id);
                        }
                        return;

                    }
                    else if(id == attractions.getAttraction_ID() && attractions.getAttraction_status().equals("CLOSED")){
                        System.out.println("Sorry, this attraction is closed right now. ");
                    }
                }
            }
            else{
                System.out.println("Sorry, ticket not available. Basic Members need to buy separate tickets for the attractions.");
            }
        }
    }

    public void rechargeBalance(){
        System.out.println("Current balance: "+this.getVisitor_balance());
        Scanner inp= new Scanner(System.in);
        System.out.println("Enter recharge amount: ");
        int recharge= inp.nextInt();
        this.setVisitor_balance(this.getVisitor_balance()+recharge);
        System.out.println("Balance updated! ");
    }

    @Override
    public void giveFeedback() {
        Scanner inp= new Scanner(System.in);
        System.out.println("Please enter your feedback: ");
        String feedback= inp.nextLine();
        feedbackArrayList.add(feedback);
        System.out.println("Thank you for your valuable feedback! ");
    }
}
