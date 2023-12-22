package org.IIITD.RG.Project.Zootopia.Animals;

import java.util.ArrayList;

public class Mammals implements Animal_Interface{
    public static ArrayList<Mammals> mammalList= new ArrayList<>();
    private String Mammal_name;
    private String Mammal_description;
    private String Mammal_Sound;
    private static int Mammal_vc;

    public static int getMammal_vc() {
        return Mammal_vc;
    }

    public static void setMammal_vc(int mammal_vc) {
        Mammal_vc = mammal_vc;
    }

    public String getMammal_name() {
        return Mammal_name;
    }

    public void setMammal_name(String mammal_name) {
        Mammal_name = mammal_name;
    }

    public String getMammal_description() {
        return Mammal_description;
    }

    public void setMammal_description(String mammal_description) {
        Mammal_description = mammal_description;
    }

    public String getMammal_Sound() {
        return Mammal_Sound;
    }

    public void setMammal_Sound(String mammal_Sound) {
        Mammal_Sound = mammal_Sound;
    }

    public Mammals(String mammal_name, String mammal_description, String mammal_Sound) {
        Mammal_name = mammal_name;
        Mammal_description = mammal_description;
        Mammal_Sound = mammal_Sound;
    }

    @Override
    public String makeNoise() {
        return getMammal_Sound();
    }

    @Override
    public String readDescription() {
        return getMammal_description();
    }
}
