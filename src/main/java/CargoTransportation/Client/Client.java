package CargoTransportation.Client;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientid;
    private String fullname;
    private String phonenumber;
    private String address;
    private int activesign;

    protected Client() {
    }

    public Client(String fullname, String phonenumber, String address) {
        this.fullname = fullname;
        this.phonenumber = phonenumber;
        this.address = address;
        this.activesign = 1;
    }

    public int getClientid() {
        return clientid;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public int getActivesign() {
        return activesign;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setAddress(String address) {
        this.activesign = activesign;
    }

    public void setActivesign(int activesign) {
        this.activesign = activesign;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    @Override
    public String toString() {
        return String.format(fullname + "; " + phonenumber + "; " + address);
    }
}

