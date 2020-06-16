package CargoTransportation.Vehicle;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleid;
    private String licenseplate;
    private String model;
    private int fuelconsumption;
    private int carrying;
    private int wagonvolume;
    private int activesign;

    protected Vehicle() {
    }

    public Vehicle(String licenseplate, String model, Integer fuelconsumption, Integer carrying, Integer wagonvolume) {
        this.licenseplate = licenseplate;
        this.model = model;
        this.fuelconsumption = fuelconsumption;
        this.carrying = carrying;
        this.wagonvolume = wagonvolume;
        this.activesign = 1;
    }

    public int getVehicleid() {
        return vehicleid;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public String getModel() {
        return model;
    }

    public int getFuelconsumption() {
        return fuelconsumption;
    }

    public int getCarrying() {
        return carrying;
    }

    public int getWagonvolume() {
        return wagonvolume;
    }

    public int getActivesign() {
        return activesign;
    }

    @Override
    public String toString() {
        return String.format("Model: " + model + "; " + "Fuelconsumption: " + fuelconsumption + "; Carrying: " + carrying +
                "; Wagonvolume: " + wagonvolume);
    }

    public void setActivesign(int activesign) {
        this.activesign = activesign;
    }

    public void setVehicleid(int vehicleid) {
        this.vehicleid = vehicleid;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    public void setFuelconsumption(int fuelconsumption) {
        this.fuelconsumption = fuelconsumption;
    }

    public void setWagonvolume(int wagonvolume) {
        this.wagonvolume = wagonvolume;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
