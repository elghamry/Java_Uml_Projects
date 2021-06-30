package com.EgyptianPyramids;

public class Pyramid {
    private String Pharaoh,Ancient_name,Modern_name,Site,Base1,Base2,Slope ,Volume;
    String Height;

    public String getSite() {
        return Site;
    }

    public Pyramid(String pharaoh, String ancient_name, String modern_name, String site, String base1, String base2, String height, String slope, String volume) {
        Pharaoh = pharaoh;
        Ancient_name = ancient_name;
        Modern_name = modern_name;
        Site = site;
        Base1 = base1;
        Base2 = base2;
        Height = height;
        Slope = slope;
        Volume = volume;
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "Pharaoh='" + Pharaoh + '\'' +
                ", Ancient_name='" + Ancient_name + '\'' +
                ", Modern_name='" + Modern_name + '\'' +
                ", Site='" + Site + '\'' +
                ", Base1='" + Base1 + '\'' +
                ", Base2='" + Base2 + '\'' +
                ", Height='" + Height + '\'' +
                ", Slope='" + Slope + '\'' +
                ", Volume='" + Volume + '\'' +
                '}'+"\n";
    }

    public void setSite(String site) {
        Site = site;
    }

    public void setPharaoh(String pharaoh) {
        Pharaoh = pharaoh;
    }

    public void setAncient_name(String ancient_name) {
        Ancient_name = ancient_name;
    }

    public void setModern_name(String modern_name) {
        Modern_name = modern_name;
    }

    public void setBase1(String base1) {
        Base1 = base1;
    }

    public void setBase2(String base2) {
        Base2 = base2;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public void setSlope(String slope) {
        Slope = slope;
    }

    public void setVolume(String volume) {
        Volume = volume;
    }

    public String getPharaoh() {
        return Pharaoh;
    }

    public String getAncient_name() {
        return Ancient_name;
    }

    public String getModern_name() {
        return Modern_name;
    }

    public String getBase1() {
        return Base1;
    }

    public String getBase2() {
        return Base2;
    }

    public String getHeight() {
        return Height;
    }

    public String getSlope() {
        return Slope;
    }

    public String getVolume() {
        return Volume;
    }
}
