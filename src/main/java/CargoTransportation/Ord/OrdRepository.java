package CargoTransportation.Ord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdRepository extends JpaRepository<Ord, Integer> {
    @Query(value = "SELECT * FROM Ord\n" +
            "INNER JOIN Manage ON Manage.manageid=Ord.manageid\n" +
            "INNER JOIN Client ON Client.clientid=Ord.clientid\n" +
            "INNER JOIN Route ON Route.routeid=Ord.routeid\n" +
            "INNER JOIN Cargo ON Cargo.cargoid=Ord.cargoid\n" +
            "INNER JOIN Driver ON Driver.driverid=Ord.driverid\n" +
            "INNER JOIN Vehicle ON Vehicle.vehicleid=Driver.vehicleid\n" +
            "WHERE Ord.activesign = 1 AND Manage.activesign = 1 AND Client.activesign = 1 AND Route.activesign = 1 AND Cargo.activesign = 1 AND\n" +
            "Driver.activesign = 1 AND Vehicle.activesign = 1\n", nativeQuery = true)
    List<Ord> findAll();

    @Modifying
    @Query(value = "UPDATE Ord set activesign = 0 where ordid = :id")
    int delete(@Param("id") int id);
}