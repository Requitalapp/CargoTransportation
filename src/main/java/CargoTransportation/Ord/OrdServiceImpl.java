package CargoTransportation.Ord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class OrdServiceImpl implements OrdService {
    private OrdRepository repository;

    @Autowired
    public OrdServiceImpl(OrdRepository repository) {
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
    public void save(Ord ord) {
        repository.save(ord);
    }

    @Override
    public Ord findById(int id) {
        return repository.findById(id).get();
    }

}
