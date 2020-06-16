package CargoTransportation.Driver;

import CargoTransportation.Vehicle.Vehicle;

import javax.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverid;
    @ManyToOne
    @JoinColumn(name = "vehicleid")
    private Vehicle vehicle;
    private String fullname;
    private String license;
    private String phonenumber;
    private int activesign;


    protected Driver() {
    }

    public Driver(String fullname, String license, String phonenumber) {
        this.fullname = fullname;
        this.license = license;
        this.phonenumber = phonenumber;
        this.activesign = 1;
    }

    public int getActivesign() {
        return activesign;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getDriverid() {
        return driverid;
    }

    public String getFullname() {
        return fullname;
    }

    public String getLicense() {
        return license;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setActivesign(int activesign) {
        this.activesign = activesign;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
    }

    @Override
    public String toString() {
        return String.format(fullname + "; " + phonenumber + "; " + vehicle);
    }
}
