package CargoTransportation.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {
    private RouteRepository repository;

    @Autowired
    public RouteServiceImpl(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public Route findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }

    @Override
    public void save(Route route) {
        repository.save(route);
    }
}
