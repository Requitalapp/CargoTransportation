package CargoTransportation.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    @Modifying
    @Query(value = "UPDATE Cargo set activesign = 0 where cargoid = :id")
    int delete(@Param("id") int id);
    @Query(value = "FROM Cargo where activesign = 1 order by cargoid asc")
    List<Cargo> findAll();
}
