package CargoTransportation.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    @Query(value = "FROM Driver where activesign = 1 order by driverid asc")
    List<Driver> findAll();
    @Modifying
    @Query(value = "UPDATE Driver set activesign = 0 where driverid = :id")
    int delete(@Param("id") int id);
}
