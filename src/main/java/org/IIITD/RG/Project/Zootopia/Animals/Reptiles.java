package org.IIITD.RG.Project.Zootopia.Animals;

import java.util.ArrayList;

public class Reptiles implements Animal_Interface{
    public static ArrayList<Reptiles> reptileList= new ArrayList<>();
    private String Reptile_name;
    private String Reptile_description;
    private String Reptile_Sound;
    private static int Reptile_vc;

    public static int getReptile_vc() {
        return Reptile_vc;
    }

    public static void setReptile_vc(int reptile_vc) {
        Reptile_vc = reptile_vc;
    }

    public String getReptile_name() {
        return Reptile_name;
    }

    public void setReptile_name(String reptile_name) {
        Reptile_name = reptile_name;
    }

    public String getReptile_description() {
        return Reptile_description;
    }

    public void setReptile_description(String reptile_description) {
        Reptile_description = reptile_description;
    }

    public String getReptile_Sound() {
        return Reptile_Sound;
    }

    public void setReptile_Sound(String reptile_Sound) {
        Reptile_Sound = reptile_Sound;
    }

    public Reptiles(String reptile_name, String reptile_description, String reptile_Sound) {
        Reptile_name = reptile_name;
        Reptile_description = reptile_description;
        Reptile_Sound = reptile_Sound;
    }

    @Override
    public String makeNoise() {
        return getReptile_Sound();
    }

    @Override
    public String readDescription() {
        return getReptile_description();
    }
}
