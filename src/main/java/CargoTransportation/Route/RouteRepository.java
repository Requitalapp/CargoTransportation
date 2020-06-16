package CargoTransportation.Route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Integer> {
    @Modifying
    @Query(value = "UPDATE Route set activesign = 0 where routeid = :id")
    int delete(@Param("id") int id);

    @Query(value = "FROM Route where activesign = 1 order by routeid  asc")
    List<Route> findAll();
}
