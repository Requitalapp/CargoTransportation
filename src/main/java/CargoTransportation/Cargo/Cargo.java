package CargoTransportation.Cargo;
import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cargoid;
    private String cargotype;
    private int cargocost;
    private int volume;
    private int weight;
    private int activesign;

    protected Cargo(){}

    public Cargo(String cargotype, Integer cargocost, Integer volume, Integer weight){
        this.cargotype = cargotype;
        this.cargocost = cargocost;
        this.volume = volume;
        this.weight = weight;
        this.activesign = 1;
    }

    public int getCargoid(){
        return cargoid;
    }
    public String getCargotype(){
        return cargotype;
    }
    public int getCargocost(){
        return cargocost;
    }
    public int getVolume(){
        return volume;
    }
    public int getWeight(){
        return weight;
    }
    public int getActivesign(){
        return activesign;
    }

    public void setActivesign   (int activesign) {
        this.activesign = activesign;
    }
    public void setCargoid(int cargoid  ) {
        this.cargoid = cargoid;
    }
    public void setCargocost(int cargocost) {
        this.cargocost = cargocost;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public void setWeight   (int weight) {
        this.weight = weight;
    }
    public void setCargotype(String cargotype) {
        this.cargotype = cargotype;
    }

    @Override
    public String toString(){
        return String.format("Volume: " + volume + "; " + "Weight: " + weight);
    }
}
