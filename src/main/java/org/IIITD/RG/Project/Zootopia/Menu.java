package org.IIITD.RG.Project.Zootopia;
import org.IIITD.RG.Project.Zootopia.Admin.Admin;
import org.IIITD.RG.Project.Zootopia.Animals.Amphibians;
import org.IIITD.RG.Project.Zootopia.Animals.Mammals;
import org.IIITD.RG.Project.Zootopia.Animals.Reptiles;
import org.IIITD.RG.Project.Zootopia.Offers.Deals;
import org.IIITD.RG.Project.Zootopia.Offers.Discount;
import org.IIITD.RG.Project.Zootopia.Visitors.Basic_visitors;
import org.IIITD.RG.Project.Zootopia.Visitors.Premium_visitors;
import org.IIITD.RG.Project.Zootopia.Visitors.Visitors_abstract;

import java.util.*;

import static org.IIITD.RG.Project.Zootopia.Animals.Amphibians.amphiList;
import static org.IIITD.RG.Project.Zootopia.Animals.Mammals.mammalList;
import static org.IIITD.RG.Project.Zootopia.Animals.Reptiles.reptileList;
import static org.IIITD.RG.Project.Zootopia.Offers.Deals.dealsArrayList;
import static org.IIITD.RG.Project.Zootopia.Offers.Discount.discountArrayList;

public class Menu {
    public static void Mainhelp() {
        Admin a1= new Admin();
        Basic_visitors b1= null;
        Premium_visitors v1= null;

        //creating object for MINOR discount:
        int age1= 0;
        int age2=17;
        int per1= 10;
        String name1= "MINOR10";
        Discount d1= new Discount(age1, age2, per1, name1);

        //creating object for SENIORCITIZEN discount:
        int age3= 60;
        int age4= 150;
        int per2= 20;
        String name2= "SENIOR20";
        Discount d2= new Discount(age3, age4, per2, name2);
        //add object to array list
        discountArrayList.add(d1);
        discountArrayList.add(d2);

        // DEAL 1:
        int n1=2;
        int perc1= 15;
        String named1= "BUY 2 TICKETS, GET 15% OFF";
        Deals deal1= new Deals(n1, perc1, named1);

        // DEAL 2:
        int n2=3;
        int perc2= 30;
        String named2= "BUY 3 TICKETS, GET 30% OFF";
        Deals deal2= new Deals(n2, perc2, named2);

        //add object to array list
        dealsArrayList.add(deal1);
        dealsArrayList.add(deal2);

        //MAMMAL 1
        String mname1= "Elephant";
        String msound1= "Trrrrr";
        String mdes1= "Elephant is a mammal. It has a long trunk.";
        Mammals m1= new Mammals(mname1,mdes1, msound1 );
        mammalList.add(m1);

        // MAMMAL 2
        String mname2= "Lion";
        String msound2= "Roar";
        String mdes2= "Lion is a mammal. It is the king of the jungle. ";
        Mammals m2= new Mammals(mname2, mdes2, msound2);
        mammalList.add(m2);

        //REPTILE 1
        String rname1= "Snake";
        String rdes1= "Snake is a reptile. These snakes have scales on their body. ";
        String rsound1= "Hiss";
        Reptiles r1= new Reptiles(rname1, rdes1, rsound1);
        reptileList.add(r1);

        //REPTILE 2
        String rname2= "Crocodile";
        String rdes2= "Crocodile is a reptile. It has scales on its body. ";
        String rsound2= "Aaaa";
        Reptiles r2= new Reptiles(rname2, rdes2, rsound2);
        reptileList.add(r2);

        //AMPHIBIAN 1
        String aname1= "Wood frog";
        String ades1= "Wood frog is an amphibian. Wood frogs are very well adapted to inhabiting cool temperatures.";
        String asound1= "Crock crock";
        Amphibians am1= new Amphibians(aname1, ades1, asound1);
        amphiList.add(am1);

        //AMPHIBIAN 2
        String aname2= "Toad";
        String ades2= "Toad is an amphibian. It is frog's baby. ";
        String asound2= "Crock";
        Amphibians am2= new Amphibians(aname2, ades2, asound2);
        amphiList.add(am2);

        System.out.println("**** WELCOME TO ZOOTOPIA!! *****");
        while(true){
            System.out.println("+---------------------------+");
            System.out.println("1. Enter as admin");
            System.out.println("2. Register a new visitor");
            System.out.println("3. Login as a visitor");
            System.out.println("4. Exit");
            int check=0;
            Scanner en= new Scanner(System.in);
            System.out.println("Who do you want to enter as?");
            int inp= en.nextInt();
            switch (inp) {
                case 1 -> {
                    Scanner p = new Scanner(System.in);
                    System.out.println("Enter username: ");
                    String uname = p.nextLine();
                    System.out.println("Enter password: ");
                    String pass = p.nextLine();
                    if (uname.equals("admin") && pass.equals("admin123")) {
                        System.out.println("Logged in successfully!");
                        check = 1;
                    } else {
                        System.out.println("Incorrect credentials!");
                    }
                }
                case 2 -> Basic_visitors.registerVisitor();
                case 3 -> {
                    Visitors_abstract temp = Basic_visitors.visitorLogin();
                    if (temp == null) {
                        System.out.println("Try again. ");
                    } else if (temp.getClass().equals(Basic_visitors.class)) {
                        b1 = (Basic_visitors) temp;
                        v1= null;
                    } else {
                        v1 = (Premium_visitors) temp;
                        b1= null;
                    }
                }
                case 4 -> {
                }
            }
            if(inp==4){
                break;
            }
            if(inp==1 && check==1){
                while(true){
                    Scanner adm_inp = new Scanner(System.in);
                    System.out.println("1. Manage Animals");
                    System.out.println("2. Manage Attractions");
                    System.out.println("3. Set Discount");
                    System.out.println("4. Set Deal");
                    System.out.println("5. View Visitor Stats");
                    System.out.println("6. View Feedback");
                    System.out.println("7. Logout");
                    System.out.println("+-------------------------------------------------------------------------------+");
                    System.out.println("Enter your choice: ");
                    int choice= adm_inp.nextInt();
                    switch (choice) {
                        case 1 -> a1.Animals_menu();
                        case 2 -> a1.Attractions_menu();
                        case 3 -> a1.Discount_menu();
                        case 4 -> a1.Deals_menu();
                        case 5 -> {
                            a1.getMostPopularAttraction();
                            a1.getVisitorCount();
                            a1.totalRevenueGenerated();
                        }
                        case 6 -> a1.viewFeedback();
                        case 7 -> {
                        }
                    }
                    if(choice==7){
                        break;
                    }
                }
            }
            else if(inp==3 && b1!=null){
                while(true){
                    System.out.println("1. Explore the zoo");
                    System.out.println("2. Buy Membership");
                    System.out.println("3. View Discount");
                    System.out.println("4. View Special Deals");
                    System.out.println("5. Buy Ticket(s)");
                    System.out.println("6. Visit Attractions");
                    System.out.println("7. Visit Animals");
                    System.out.println("8. Leave Feedback");
                    System.out.println("9. Recharge account");
                    System.out.println("10. Logout");
                    System.out.println("+------------------------------------------------------------------------------+");
                    Scanner inp2= new Scanner(System.in);
                    System.out.println("Enter your choice: ");
                    int Basic_inp= inp2.nextInt();
                    switch (Basic_inp) {
                        case 1 -> b1.exploreZoo();
                        case 2 -> b1.buyMembership();
                        case 3 -> b1.viewDiscounts();
                        case 4 -> b1.viewSpecialDeals();
                        case 5 -> b1.buyTickets();
                        case 6 -> b1.visitAttraction();
                        case 7 -> b1.visitAnimal();
                        case 8 -> b1.giveFeedback();
                        case 9 -> b1.rechargeBalance();
                        case 10 -> {
                        }}
                        if(Basic_inp==10){
                            break;
                        }
                }
            }
            else if(inp==3 && v1!=null){
                while(true){
                    System.out.println("1. Explore the zoo");
                    System.out.println("2. Visit Attractions");
                    System.out.println("3. Visit Animals");
                    System.out.println("4. Leave Feedback");
                    System.out.println("5. Logout");
                    System.out.println("+---------------------------------------------------------------------------+");
                    Scanner inp2= new Scanner(System.in);
                    System.out.println("Enter your choice: ");
                    int prem_inp= inp2.nextInt();
                    switch (prem_inp) {
                        case 1 -> v1.exploreZoo();
                        case 2 -> v1.visitAttraction();
                        case 3 -> v1.visitAnimal();
                        case 4 -> v1.giveFeedback();
                        case 5 -> {
                        }}
                    if(prem_inp==5){
                        break;
                    }
                }
            }
        }
    }
    }
