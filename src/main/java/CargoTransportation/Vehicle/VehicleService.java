package CargoTransportation.Vehicle;

import java.util.List;

public interface VehicleService {
    List findAll();
    Vehicle findById(int id);
    void save(Vehicle vehicle);
    int delete(int id);
}

