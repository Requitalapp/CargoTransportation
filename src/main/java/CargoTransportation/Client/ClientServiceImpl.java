package CargoTransportation.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository repository){
        this.repository = repository;
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public Client findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(Client client) {
        repository.save(client);
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }
}
