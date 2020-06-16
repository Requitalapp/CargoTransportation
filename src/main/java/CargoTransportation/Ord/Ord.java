package CargoTransportation.Ord;

import CargoTransportation.Cargo.Cargo;
import CargoTransportation.Client.Client;
import CargoTransportation.Driver.Driver;
import CargoTransportation.Manage.Manage;
import CargoTransportation.Route.Route;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ord")
public class Ord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordid;
    @ManyToOne
    @JoinColumn(name = "manageid")
    private Manage manage;
    @ManyToOne
    @JoinColumn(name = "routeid")
    private Route route;
    @ManyToOne
    @JoinColumn(name = "cargoid")
    private Cargo cargo;
    @ManyToOne
    @JoinColumn(name = "driverid")
    private Driver driver;
    @ManyToOne
    @JoinColumn(name = "clientid")
    private Client client;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliverydate;
    private int activesign;


    protected Ord() {
    }

    public Ord(Date orderdate, Date deliverydate) {
        this.orderdate = orderdate;
        this.deliverydate = deliverydate;
        this.activesign = 1;
    }

    public int getActivesign() {
        return activesign;
    }

    public int getOrdid() {
        return ordid;
    }

    public Manage getManage() {
        return manage;
    }

    public Route getRoute() {
        return route;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Driver getDriver() {
        return driver;
    }

    public Client getClient() {
        return client;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setActivesign(int activesign) {
        this.activesign = activesign;
    }

    public void setManage(Manage manage) {
        this.manage = manage;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setOrdid(int ordid) {
        this.ordid = ordid;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }
}
