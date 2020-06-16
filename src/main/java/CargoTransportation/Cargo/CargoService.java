package CargoTransportation.Cargo;

import java.util.List;

public interface CargoService {
    List findAll();
    Cargo findById(int id);
    void save(Cargo cargo);
    int delete(int id);
}

