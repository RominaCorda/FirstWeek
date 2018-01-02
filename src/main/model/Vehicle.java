package main.model;

import java.util.Objects;

public class Vehicle {
    Integer idVehicle;
    String brand;
    String model;
    String power;

    public Vehicle(Integer idVehicle,String brand,String model,String power){
        this.idVehicle=idVehicle;
        this.brand=brand;
        this.model=model;
        this.power=power;
    }

    public Integer getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(idVehicle, vehicle.idVehicle) &&
                Objects.equals(brand, vehicle.brand) &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(power, vehicle.power);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idVehicle, brand, model, power);
    }
    @Override
    public String toString(){
        return "VEHICLE: \nBrand:" +brand+"\nModel: "+model+"\nPower: "+power;
    }
}
