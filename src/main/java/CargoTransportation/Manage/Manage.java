package CargoTransportation.Manage;

import javax.persistence.*;

@Entity
@Table(name = "manage")
public class Manage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int manageid;
    private String fullname;
    private String phonenumber;
    public int activesign;

    protected Manage() {
    }

    public Manage(String fullname, String phonenumber) {
        this.fullname = fullname;
        this.phonenumber = phonenumber;
        this.activesign = 1;
    }

    public int getManageid() {
        return manageid;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhonenumber() {
        return phonenumber;
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

    public void setActivesign(int activesign) {
        this.activesign = activesign;
    }

    public void setManageid(int manageid) {
        this.manageid = manageid;
    }

    @Override
    public String toString() {
        return String.format(fullname + "; " + phonenumber);
    }
}
