package org.IIITD.RG.Project.Zootopia.Visitors;

import org.IIITD.RG.Project.Zootopia.Animals.Amphibians;
import org.IIITD.RG.Project.Zootopia.Animals.Mammals;
import org.IIITD.RG.Project.Zootopia.Animals.Reptiles;
import org.IIITD.RG.Project.Zootopia.Attractions.Attractions;

import java.util.ArrayList;
import java.util.Scanner;

import static org.IIITD.RG.Project.Zootopia.Animals.Amphibians.*;
import static org.IIITD.RG.Project.Zootopia.Animals.Mammals.*;
import static org.IIITD.RG.Project.Zootopia.Animals.Reptiles.*;
import static org.IIITD.RG.Project.Zootopia.Attractions.Attractions.attractionList;
import static org.IIITD.RG.Project.Zootopia.Feedback.Feedback.feedbackArrayList;

public class Premium_visitors extends Visitors_abstract {
    public static ArrayList<Premium_visitors> premiumVisitorsArrayList = new ArrayList<>();
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

    public Premium_visitors(String visitor_name, Integer visitor_age, String visitor_phno, Integer visitor_balance, String visitor_email, String visitor_password) {
        this.visitor_name = visitor_name;
        this.visitor_age = visitor_age;
        this.visitor_phno = visitor_phno;
        this.visitor_balance = visitor_balance;
        this.visitor_email = visitor_email;
        this.visitor_password = visitor_password;
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
        }
    }

    @Override
    public void buyTickets() {

    }

    @Override
    public void visitAnimal() {
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
                    setMammal_vc(getMammal_vc()+1);
                    System.out.println(sound);
                    break;
                }
                else if(name.equals(mammals.getMammal_name()) && choose ==2){
                    String des= mammals.getMammal_description();
                    setMammal_vc(getMammal_vc()+1);
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
                    setAmphi_vc(getAmphi_vc()+1);
                    System.out.println(sound);
                    break;
                }
                else if(name.equals(amphibians.getAmphi_name()) && choose ==2){
                    String des= amphibians.getAmphi_description();
                    setAmphi_vc(getAmphi_vc()+1);
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
        for (Attractions attractions : attractionList) {
            if (id == attractions.getAttraction_ID() && attractions.getAttraction_status().equals("OPEN")) {
                System.out.println("Thank you for visiting " + attractions.getAttraction_name() + " ! Hope you enjoyed! ");
                break;
            }
            else if(id == attractions.getAttraction_ID() && attractions.getAttraction_status().equals("CLOSED")){
                System.out.println("Sorry, attraction is closed right now. ");
        }
    }}

    @Override
    public void giveFeedback() {
        Scanner inp= new Scanner(System.in);
        System.out.println("Please enter your feedback: ");
        String feedback= inp.nextLine();
        feedbackArrayList.add(feedback);
        System.out.println("Thank you for your valuable feedback! ");
    }
}
