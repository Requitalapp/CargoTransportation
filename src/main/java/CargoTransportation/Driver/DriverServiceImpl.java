package CargoTransportation.Driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    private DriverRepository repository;

    @Autowired
    public DriverServiceImpl(DriverRepository repository){
        this.repository = repository;
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }

    @Override
    public void save(Driver driver) {
        repository.save(driver);
    }

    @Override
    public Driver findById(int id) {
        return repository.findById(id).get();
    }

}
