package CargoTransportation.Cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CargoServiceImpl implements CargoService {
    private CargoRepository repository;

    @Autowired
    public CargoServiceImpl(CargoRepository repository){
        this.repository = repository;
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public Cargo findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }

    @Override
    public void save(Cargo cargo) {
        repository.save(cargo);
    }
}
