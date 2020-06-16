package CargoTransportation.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository repository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository repository){
        this.repository = repository;
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public Vehicle findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }

    @Override
    public void save(Vehicle vehicle) {
        repository.save(vehicle);
    }
}
