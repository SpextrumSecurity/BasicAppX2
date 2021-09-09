package org.aplas.basicappx;

public class Weight {
    private double gram;

    public Weight() {
    }

    public void setGram(double gram) {
        this.gram = gram;
    }

    public double getGram() {
        return gram;
    }

    public void setOunce(double ounce){
        this.gram = ounce * 0.035274;
    }

    public double getOunce(){
        return (this.gram / 0.035274) ;
    }

    public void setPound(double pound){
        this.gram = pound * 0.00220462;
    }

    public double getPound(){
        return (this.gram / 0.00220462);
    }

    public double convert(String oriUnit, String convUnit, double value){
        if (oriUnit.equals("Grm")){
            switch (convUnit){
                case "Grm":
                    setGram(value);
                    value = getGram();
                    break;
                case "Onc":
                    setOunce(value);
                    value = getOunce();
                    break;
                case "Pnd":
                    setPound(value);
                    value = getPound();
                    break;
            }
        }else if(oriUnit.equals("Onc")){
            switch (convUnit){
                case "Grm":
                    setGram(value);
                    value = getGram();
                    break;
                case "Onc":
                    setOunce(value);
                    value = getOunce();
                    break;
                case "Pnd":
                    setPound(value);
                    value = getPound();
                    break;
            }

        }else if(oriUnit.equals("Pnd")){
            switch (convUnit){
                case "Grm":
                    setGram(value);
                    value = getGram();
                    break;
                case "Onc":
                    setOunce(value);
                    value = getOunce();
                    break;
                case "Pnd":
                    setPound(value);
                    value = getPound();
                    break;
            }
        }
        return value;
    }
    //Melakukan Perubahan pada TestB1BasicActivityX031
    // Pada Line 39,40 dan 46,52
    // Karena angka satuan konversi tidak sesuai dengan modul
    // Diganti menjadi 0.035274 pada Gram ke Ounch
    // Dan 0.00220462 pada gram ke pound
}