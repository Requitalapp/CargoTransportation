package CargoTransportation.Manage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManageRepository extends JpaRepository<Manage, Integer> {
    @Modifying
    @Query(value = "UPDATE Manage set activesign = 0 where manageid = :id")
    int delete(@Param("id") int id);

    @Query(value = "FROM Manage where activesign = 1 order by manageid asc")
    List<Manage> findAll();
}

