package CargoTransportation.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    @Modifying
    @Query(value = "UPDATE Vehicle set activesign = 0 where vehicleid = :id")
    int delete(@Param("id") int id);

    @Query(value = "FROM Vehicle where activesign = 1 order by vehicleid asc")
    List<Vehicle> findAll();
}
