package org.IIITD.RG.Project.Zootopia.Offers;

import java.util.ArrayList;

public class Deals {
    public static ArrayList<Deals> dealsArrayList= new ArrayList<>();
    private int num;
    private int percentage;
    private String DealName;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getDealName() {
        return DealName;
    }

    public void setDealName(String dealName) {
        DealName = dealName;
    }

    public Deals(int num, int percentage, String dealName) {
        this.num = num;
        this.percentage = percentage;
        DealName = dealName;
    }

}

