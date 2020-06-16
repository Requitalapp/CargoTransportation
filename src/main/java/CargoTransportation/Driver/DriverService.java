package CargoTransportation.Driver;

import java.util.List;

public interface DriverService {
    public Driver findById(int id);
    List findAll();
    public void save(Driver driver);
    public int delete(int id);
}
