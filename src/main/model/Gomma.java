package main.model;

import java.util.Objects;

public class Gomma {
    private Integer idGomma;
    private String model;
    private String manufacturer;
    private double price;
    private double width;
    private double height;
    private double diameter;
    private double weight;
    private String speed;
    private String typeVehicle;
    private String season;
    private int quantity;

    public Gomma(Integer idGomma,String model, String manufacturer, double price, double width, double height, double diameter, double weight, String speed, String season,String typeVehicle,int quantity) {
        this.idGomma=idGomma;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.width = width;
        this.height = height;
        this.diameter = diameter;
        this.weight = weight;
        this.speed = speed;
        this.typeVehicle = typeVehicle;
        this.season = season;
        this.quantity=quantity;

    }

    public Integer getIdGomma()
    {
        return idGomma;
    }

    public void setIdGomma(Integer idGomma)
    {
        this.idGomma = idGomma;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gomma gomma = (Gomma) o;
        return Double.compare(gomma.price, price) == 0 &&
                Objects.equals(idGomma, gomma.idGomma) &&
                Objects.equals(model, gomma.model) &&
                Objects.equals(manufacturer, gomma.manufacturer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idGomma, model, manufacturer, price, width, height, diameter, weight, speed, typeVehicle, season,quantity);
    }

    @Override
    public String toString() {
        return "GOMMA: \nModel: " + model +
                "\nManufacturer: " +manufacturer +
                "\nPrice: "+price+
                "\n width:" + width +
                "\n height:" + height +
                "\n diameter:" + diameter +
                "\n weight:" + weight +
                "\n speed:'" + speed + '\'' +
                "\n TypeVehicle:'" + typeVehicle + '\'' +
                "\n season:'" + season + '\'' +
                "\n quantity:'" + quantity + '\'' +
                "\n";

    }
}
