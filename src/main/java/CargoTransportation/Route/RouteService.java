package CargoTransportation.Route;

import java.util.List;

public interface RouteService {
    List findAll();

    Route findById(int id);

    void save(Route cargo);

    int delete(int id);
}

