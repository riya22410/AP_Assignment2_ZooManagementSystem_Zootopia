package org.IIITD.RG.Project.Zootopia.Admin;
import org.IIITD.RG.Project.Zootopia.Animals.Amphibians;
import org.IIITD.RG.Project.Zootopia.Animals.Mammals;
import org.IIITD.RG.Project.Zootopia.Animals.Reptiles;
import org.IIITD.RG.Project.Zootopia.Attractions.Attractions;
import org.IIITD.RG.Project.Zootopia.Offers.Deals;
import org.IIITD.RG.Project.Zootopia.Offers.Discount;
import org.w3c.dom.DOMStringList;

import java.util.Map;
import java.util.Scanner;

import static org.IIITD.RG.Project.Zootopia.Animals.Amphibians.amphiList;
import static org.IIITD.RG.Project.Zootopia.Animals.Amphibians.getAmphi_vc;
import static org.IIITD.RG.Project.Zootopia.Animals.Mammals.getMammal_vc;
import static org.IIITD.RG.Project.Zootopia.Animals.Mammals.mammalList;
import static org.IIITD.RG.Project.Zootopia.Animals.Reptiles.getReptile_vc;
import static org.IIITD.RG.Project.Zootopia.Animals.Reptiles.reptileList;
import static org.IIITD.RG.Project.Zootopia.Attractions.Attractions.attractionList;
import static org.IIITD.RG.Project.Zootopia.Feedback.Feedback.feedbackArrayList;
import static org.IIITD.RG.Project.Zootopia.Offers.Deals.dealsArrayList;
import static org.IIITD.RG.Project.Zootopia.Offers.Discount.discountArrayList;


public class Admin {
    private static final String ADMIN_USERNAME= "admin";
    private static final String ADMIN_PASSWORD= "admin123";
    private static int Total_Revenue;

    public static int getTotal_Revenue() {
        return Total_Revenue;
    }

    public static void setTotal_Revenue(int total_Revenue) {
        Total_Revenue = total_Revenue;
    }

    public void totalRevenueGenerated(){
        System.out.println("Total revenue generated: "+Admin.getTotal_Revenue());
    }
    public void getMostPopularAttraction(){
        int max=0;
        String name="";
        for (Attractions attractions : attractionList) {
            if (attractions.getAttraction_usercount() > max) {
                max = attractions.getAttraction_usercount();
                name = attractions.getAttraction_name();
            }
        }
        System.out.println("Most popular attraction is: "+ name);
    }
    public void getVisitorCount(){
        int num_att=0;
        int num_an=0;
        for (Attractions attractions : attractionList) {
            num_att += attractions.getAttraction_usercount();
        }
        num_an+=getAmphi_vc();
        num_an+=getMammal_vc();
        num_an+=getReptile_vc();
        int tot= num_att+num_an;
        System.out.println("Total number of visitors: "+tot);
        System.out.println("Total visitors for animals: "+ num_an);
        System.out.println("Total visitors for attractions: "+num_att);
    }

    public void addAttraction(){
        Scanner inp= new Scanner(System.in);
        Scanner inp2= new Scanner(System.in);
        System.out.println("Enter name of Attraction: ");
        String name=inp.nextLine();
        System.out.println("Enter price of Attraction: ");
        int price= inp2.nextInt();
        System.out.println("Enter description of Attraction: ");
        String description= inp.nextLine();
        Attractions a1= new Attractions(name, price, description);
        attractionList.add(a1);
        System.out.println("Attraction added successfully!");
    }
    public void viewAttraction(){
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
    }

    public void modifyAttraction(){
        Scanner inp= new Scanner(System.in);
        System.out.println("Enter Attraction ID: ");
        int ID= inp.nextInt();
        int status=0;
        for (Attractions value : attractionList) {
            if (ID == value.getAttraction_ID()) {
                status = 1;
                break;
            }
        }
        if(status==0){
            System.out.println("ID not found!");
        }
        else{Scanner inp1= new Scanner(System.in);
        Scanner inp2= new Scanner(System.in);
        Scanner inp3= new Scanner(System.in);
        System.out.println("Enter modified Attraction name, if any: ");
        String name= inp2.nextLine();
        System.out.println("Enter modified Attraction price, if any: ");
        int price= inp1.nextInt();
        System.out.println("Enter modified Attraction status (OPEN/CLOSED): ");
        String stat= inp2.nextLine();
        System.out.println("Enter modified Attraction description, if any: ");
        String des= inp3.nextLine();
            for (Attractions attractions : attractionList) {
                if (ID == attractions.getAttraction_ID()) {
                    attractions.setAttraction_name(name);
                    attractions.setAttraction_price(price);
                    attractions.setAttraction_status(stat);
                    attractions.setAttraction_description(des);
                    break;
                }
            }
        System.out.println("Information updated successfully!");}
    }

    public void removeAttraction(){
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
        Scanner inp= new Scanner(System.in);
        System.out.println("Enter ID of attraction to be removed`: ");
        int stat=0;
        int ID= inp.nextInt();
        for(int i=0; i<attractionList.size(); i++){
            if(ID==attractionList.get(i).getAttraction_ID()){
                stat=1;
                attractionList.remove(attractionList.get(i));
                break;
            }
        }
        if(stat==0){
            System.out.println("ID not found!");
        }
        else{
            System.out.println("Attraction removed successfully!");
        }
    }

    public void addAnimal(){
        Scanner inp= new Scanner(System.in);
        System.out.println("Enter type of animal to be added (M/R/A): ");
        String type= inp.nextLine();
        System.out.println("Enter name of animal to be added: ");
        String name= inp.nextLine();
        System.out.println("Enter sound made by the animal: ");
        String sound= inp.nextLine();
        System.out.println("Enter description of animal: ");
        String des= inp.nextLine();
        switch (type) {
            case "M" -> {
                Mammals m1 = new Mammals(name, des, sound);
                mammalList.add(m1);
                System.out.println("Animal added successfully!");
            }
            case "A" -> {
                Amphibians a1 = new Amphibians(name, des, sound);
                amphiList.add(a1);
                System.out.println("Animal added successfully!");
            }
            case "R" -> {
                Reptiles r1 = new Reptiles(name, des, sound);
                reptileList.add(r1);
                System.out.println("Animal added successfully!");
            }
            default -> System.out.println("Error- Enter correct animal type!");
        }
    }
    public void viewAnimal(){
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
    }

    public void modifyAnimal(){
        Scanner inp= new Scanner(System.in);
        System.out.println("Enter type of animal whom you want to modify (M/R/A): ");
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
                System.out.println("Enter name of animal whom you want to modify: ");
                String dname= inp.nextLine();
                System.out.println("Enter new description: ");
                String newdes= inp.nextLine();
                for(int i=0; i<mammalList.size();i++){
                    if(dname.equals(mammalList.get(i).getMammal_name())){
                        mammalList.get(i).setMammal_description(newdes);
                        System.out.println("Description modified successfully! ");
                        break;
                    }
                }
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
                System.out.println("Enter name of animal whom you want to modify: ");
                String dname= inp.nextLine();
                System.out.println("Enter new description: ");
                String newdes= inp.nextLine();
                for(int i=0; i<reptileList.size();i++){
                    if(dname.equals(reptileList.get(i).getReptile_name())){
                        reptileList.get(i).setReptile_description(newdes);
                        System.out.println("Description modified successfully! ");
                        break;
                    }
                }
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
                System.out.println("Enter name of animal whom you want to modify: ");
                String dname= inp.nextLine();
                System.out.println("Enter new description: ");
                String newdes= inp.nextLine();
                for(int i=0; i<amphiList.size();i++){
                    if(dname.equals(amphiList.get(i).getAmphi_name())){
                        amphiList.get(i).setAmphi_description(newdes);
                        System.out.println("Description modified successfully! ");
                        break;
                    }
                }
            }
            default -> System.out.println("No such type exists!");
        }
    }

    public void removeAnimal(){
        Scanner inp= new Scanner(System.in);
        System.out.println("Enter type of animal which you want to remove(M/R/A): ");
        String type= inp.nextLine();
        switch (type) {
            case "M" -> {
                System.out.println("+------------------------------------------------------------+");
                System.out.println("| Animal Type          |   Animal Name             |");
                System.out.println("+------------------------------------------------------------+");
                for (Mammals mammals : mammalList) {
                    String mname = mammals.getMammal_name();
                    String mtype = "Mammal";

                    String formattedOutput = String.format("| %-18s| %-22s|", mtype, mname);
                    System.out.println(formattedOutput);
                }
                System.out.println("+------------------------------------------------------------+");
                Scanner inp2= new Scanner(System.in);
                System.out.println("Enter name of animal who you want to remove: ");
                String name= inp2.nextLine();
                for(int i=0; i<mammalList.size(); i++){
                    if(name.equals(mammalList.get(i).getMammal_name()) && mammalList.size()>2){
                        mammalList.remove(mammalList.get(i));
                        System.out.println("Animal removed successfully! ");
                        break;
                    }
                    else if(name.equals(mammalList.get(i).getMammal_name()) && mammalList.size()<=2){
                        System.out.println("Cannot remove animal as min count = 2");
                    }
                }
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
                Scanner inp2= new Scanner(System.in);
                System.out.println("Enter name of animal who you want to remove: ");
                String name= inp2.nextLine();
                for(int i=0; i<reptileList.size(); i++){
                    if(name.equals(reptileList.get(i).getReptile_name()) && reptileList.size()>2){
                        reptileList.remove(reptileList.get(i));
                        System.out.println("Animal removed successfully! ");
                        break;
                    }
                    else if(name.equals(reptileList.get(i).getReptile_name()) && reptileList.size()<=2){
                        System.out.println("Cannot remove animal as min count = 2");
                    }
            }}
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
                Scanner inp2= new Scanner(System.in);
                System.out.println("Enter name of animal who you want to remove: ");
                String name= inp2.nextLine();
                for(int i=0; i<amphiList.size(); i++){
                    if(name.equals(amphiList.get(i).getAmphi_name()) && amphiList.size()>2){
                        amphiList.remove(amphiList.get(i));
                        System.out.println("Animal removed successfully!");
                        break;
                    }
                    else if(name.equals(amphiList.get(i).getAmphi_name()) && amphiList.size()<=2){
                        System.out.println("Cannot remove animal as min count = 2");
                    }
            }}
            default -> System.out.println("No such type exists!");
        }

    }
    public void viewFeedback(){
        System.out.println("+-------------------------------+");
        System.out.println("|   Feedback   | ");
        System.out.println("+-------------------------------+");

        for (String Feedback : feedbackArrayList) {
            String formattedOutput = String.format("|%-22s|", Feedback);
            System.out.println(formattedOutput);
        }
        System.out.println("+-------------------------------+");
    }

    public void addDiscount(){
        Scanner sc= new Scanner(System.in);
        Scanner sc2= new Scanner(System.in);
        System.out.println("Enter discount coupon code name: ");
        String dname= sc.nextLine();
        System.out.println("Enter percentage of discount given to user: ");
        int dperc= sc2.nextInt();
        System.out.println("Enter lower limit of age: ");
        int dlage= sc2.nextInt();
        System.out.println("Enter upper limit of age: ");
        int duage= sc2.nextInt();
        Discount d1= new Discount(dlage, duage, dperc, dname);
        discountArrayList.add(d1);
        System.out.println("New discount added! ");
    }

    public void addDeal(){
        Scanner sc= new Scanner(System.in);
        Scanner sc2= new Scanner(System.in);
        System.out.println("Enter deal name: ");
        String dname= sc.nextLine();
        System.out.println("Enter percentage of deal given to user: ");
        int dperc= sc2.nextInt();
        System.out.println("Enter number of tickets to be purchased to avail offer: ");
        int dcount= sc2.nextInt();
        Deals d1= new Deals(dcount, dperc, dname);
        dealsArrayList.add(d1);
    }

    public void removeDiscount(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter discount coupon code name to be removed: ");
        String dname= sc.nextLine();
        int flag=0;
        for(int i=0; i< discountArrayList.size(); i++){
            if(dname.equals(discountArrayList.get(i).getDiscountCouponCode())){
                discountArrayList.remove(discountArrayList.get(i));
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.println("No such discount found! ");
        }
        else{
            System.out.println("Discount removed successfully! ");
        }
    }

    public void removeDeal(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter deal name to be removed: ");
        String dname= sc.nextLine();
        int flag=0;
        for(int i=0; i<dealsArrayList.size();i++){
            if(dname.equals(dealsArrayList.get(i).getDealName())){
                dealsArrayList.remove(dealsArrayList.get(i));
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.println("No such deal found! ");
        }
        else{
            System.out.println("Deal removed successfully! ");
        }
    }

    public void modifyDiscount(){
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

        Scanner inp= new Scanner(System.in);
        Scanner inp2= new Scanner(System.in);
        System.out.println("Enter discount coupon code name: ");
        String dname= inp.nextLine();
        System.out.println("Enter new percentage discount: ");
        int dperc= inp2.nextInt();
        int flag=0;
        for(int i=0; i< discountArrayList.size();i++){
            if(dname.equals(discountArrayList.get(i).getDiscountCouponCode())){
                discountArrayList.get(i).setPercentagediscount(dperc);
                flag=1;
                System.out.println("Discount updated successfully! ");
                break;
            }
        }
        if(flag==0){
            System.out.println("No such discount exists. ");
        }
    }

    public void modifyDeals(){
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
        Scanner inp= new Scanner(System.in);
        Scanner inp2= new Scanner(System.in);
        System.out.println("Enter deal name: ");
        String dname= inp.nextLine();
        System.out.println("Enter new percentage deal: ");
        int dperc= inp2.nextInt();
        int flag=0;
        for(int i=0; i<dealsArrayList.size();i++){
            if(dname.equals(dealsArrayList.get(i).getDealName())){
                dealsArrayList.get(i).setPercentage(dperc);
                flag=1;
                System.out.println("Deal updated successfully! ");
                break;
            }
        }
        if(flag==0){
            System.out.println("No such deal exists. ");
        }
    }

    public void Attractions_menu(){
        Scanner inp= new Scanner(System.in);
        System.out.println("1. Add Attraction");
        System.out.println("2. View Attraction");
        System.out.println("3. Modify Attraction");
        System.out.println("4. Remove Attraction");
        System.out.println("Enter your choice: ");
        int choice = inp.nextInt();
        switch (choice) {
            case 1 -> this.addAttraction();
            case 2 -> this.viewAttraction();
            case 3 -> this.modifyAttraction();
            case 4 -> this.removeAttraction();
            default -> System.out.println("Invalid option selected");
        }
    }

    public void Animals_menu(){
        Scanner inp = new Scanner(System.in);
        System.out.println("1. Add Animal");
        System.out.println("2. View Animal");
        System.out.println("3. Modify Animal Description");
        System.out.println("4. Remove Animal");
        System.out.println("Enter your choice: ");
        int choice = inp.nextInt();
        switch (choice) {
            case 1 -> this.addAnimal();
            case 2 -> this.viewAnimal();
            case 3 -> this.modifyAnimal();
            case 4 -> this.removeAnimal();
            default -> System.out.println("Invalid choice entered");
        }
    }

    public void Discount_menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add Discount");
        System.out.println("2. Modify discount percentage");
        System.out.println("3. Remove Discount");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> this.addDiscount();
            case 2 -> this.modifyDiscount();
            case 3 -> this.removeDiscount();
            default -> System.out.println("Wrong option selected");
        }
    }

    public void Deals_menu(){
        Scanner inp = new Scanner(System.in);
        System.out.println("1. Add Deal");
        System.out.println("2. Modify deal percentage");
        System.out.println("3. Remove Deal");
        System.out.println();
        System.out.println("Enter your choice: ");
        int choice = inp.nextInt();
        switch (choice){
            case 1:
                this.addDeal();
                break;
            case 2:
                this.modifyDeals();
                break;
            case 3:
                this.removeDeal();
            default:
                System.out.println("Wrong option selected");
        }}
}









