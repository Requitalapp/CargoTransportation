package CargoTransportation.Manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class ManageServiceImpl implements ManageService {
    private ManageRepository repository;

    @Autowired
    public ManageServiceImpl(ManageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public Manage findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }

    @Override
    public void save(Manage manage) {
        repository.save(manage);
    }
}
