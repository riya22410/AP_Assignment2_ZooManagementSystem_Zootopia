package org.IIITD.RG.Project.Zootopia.Animals;

import java.util.ArrayList;

public class Amphibians implements Animal_Interface{
    public static ArrayList<Amphibians> amphiList= new ArrayList<>();
    private String Amphi_name;
    private String Amphi_description;
    private String Amphi_Sound;
    private static int Amphi_vc;

    public static int getAmphi_vc() {
        return Amphi_vc;
    }

    public static void setAmphi_vc(int amphi_vc) {
        Amphi_vc = amphi_vc;
    }

    public String getAmphi_name() {
        return Amphi_name;
    }

    public void setAmphi_name(String amphi_name) {
        Amphi_name = amphi_name;
    }

    public String getAmphi_description() {
        return Amphi_description;
    }

    public void setAmphi_description(String amphi_description) {
        Amphi_description = amphi_description;
    }

    public String getAmphi_Sound() {
        return Amphi_Sound;
    }

    public void setAmphi_Sound(String amphi_Sound) {
        Amphi_Sound = amphi_Sound;
    }

    public Amphibians(String amphi_name, String amphi_description, String amphi_Sound) {
        Amphi_name = amphi_name;
        Amphi_description = amphi_description;
        Amphi_Sound = amphi_Sound;
    }

    @Override
    public String makeNoise() {
        return getAmphi_Sound();
    }

    @Override
    public String readDescription() {
        return getAmphi_description();
    }
}
