package org.aplas.basicappx;

public class Temperature {
    private double celcius;

    public Temperature() {

    }

    public void setCelcius(double celcius) {
        this.celcius = celcius;
    }

    public double getCelcius() {
        return celcius;
    }

    public void setFahrenheit(double fahrenheit) {
        this.celcius = (fahrenheit - 32) * 5 / 9;
    }

    public double getFahrenheit() {
        return (this.celcius * 9 / 5) + 32;
    }

    public void setKelvins(double kelvin) {
        this.celcius = kelvin - 273.15;
    }

    public double getKelvins() {
        return this.celcius + 273.15;
    }

    public double convert(String oriUnit, String convUnit, double value) {
        if (oriUnit.equals("°C")) {
            switch (convUnit) {
                case "°C":
                    setCelcius(value);
                    value = getCelcius();
                    break;
                case "°F":
                    setCelcius(value);
                    value = getFahrenheit();
                    break;
                case "K":
                    setCelcius(value);
                    value = getKelvins();
                    break;
            }
        } else if (oriUnit.equals("°F")) {
            switch (convUnit) {
                case "°C":
                    setFahrenheit(value);
                    value = getCelcius();
                    break;
                case "°F":
                    setFahrenheit(value);
                    value = getFahrenheit();
                    break;
                case "K":
                    setFahrenheit(value);
                    value = getKelvins();
                    break;
            }
        } else if (oriUnit.equals("K")) {
            switch (convUnit) {
                case "°C":
                    setKelvins(value);
                    value = getCelcius();
                    break;
                case "°F":
                    setKelvins(value);
                    value = getFahrenheit();
                    break;
                case "K":
                    setKelvins(value);
                    value = getKelvins();
                    break;
            }
        }
        return value;
    }
}
