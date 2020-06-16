package CargoTransportation.Ord;

import java.util.List;

public interface OrdService {
    public Ord findById(int id);

    List findAll();

    public void save(Ord ord);

    public int delete(int id);
}
