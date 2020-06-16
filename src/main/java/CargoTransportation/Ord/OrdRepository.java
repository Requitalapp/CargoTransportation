package CargoTransportation.Ord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdRepository extends JpaRepository<Ord, Integer> {
    @Query(value = "FROM Ord where activesign = 1 order by ordid asc")
    List<Ord> findAll();

    @Modifying
    @Query(value = "UPDATE Ord set activesign = 0 where ordid = :id")
    int delete(@Param("id") int id);
}
