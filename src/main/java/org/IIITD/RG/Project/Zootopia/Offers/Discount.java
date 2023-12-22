package org.IIITD.RG.Project.Zootopia.Offers;

import java.util.ArrayList;

public class Discount {
    public static ArrayList<Discount> discountArrayList= new ArrayList<>();
    private int lowerage;
    private int upperage;
    private int percentagediscount;
    private String discountCouponCode;

    public int getLowerage() {
        return lowerage;
    }

    public void setLowerage(int lowerage) {
        this.lowerage = lowerage;
    }

    public int getUpperage() {
        return upperage;
    }

    public void setUpperage(int upperage) {
        this.upperage = upperage;
    }

    public int getPercentagediscount() {
        return percentagediscount;
    }

    public void setPercentagediscount(int percentagediscount) {
        this.percentagediscount = percentagediscount;
    }

    public String getDiscountCouponCode() {
        return discountCouponCode;
    }

    public void setDiscountCouponCode(String discountCouponCode) {
        this.discountCouponCode = discountCouponCode;
    }

    public Discount(int lowerage, int upperage, int percentagediscount, String discountCouponCode) {
        this.lowerage = lowerage;
        this.upperage = upperage;
        this.percentagediscount = percentagediscount;
        this.discountCouponCode = discountCouponCode;
    }

}
