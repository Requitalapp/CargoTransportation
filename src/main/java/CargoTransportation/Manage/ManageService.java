package CargoTransportation.Manage;


import java.util.List;

public interface ManageService {
    public List findAll();

    public Manage findById(int id);

    public void save(Manage manage);

    int delete(int id);
}
