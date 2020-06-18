package CargoTransportation.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    @Query(value = "SELECT * FROM Driver INNER JOIN Vehicle ON Vehicle.vehicleid=Driver.vehicleid WHERE Driver.activesign = 1 AND Vehicle.activesign=1", nativeQuery = true)
    List<Driver> findAll();
    @Modifying
    @Query(value = "UPDATE Driver set activesign = 0 where driverid = :id")
    int delete(@Param("id") int id);
}