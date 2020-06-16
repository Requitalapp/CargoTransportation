package CargoTransportation.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Modifying
    @Query(value = "UPDATE Client set activesign = 0 where clientid = :id")
    int delete(@Param("id") int id);
    @Query(value = "FROM Client where activesign = 1 order by clientid asc")
    List<Client> findAll();
}