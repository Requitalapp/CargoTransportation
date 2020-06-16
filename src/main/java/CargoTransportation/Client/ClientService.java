package CargoTransportation.Client;


import java.util.List;

public interface ClientService {
    public List findAll();
    public Client findById(int id);
    public void save(Client client);
    int delete(int id);
}