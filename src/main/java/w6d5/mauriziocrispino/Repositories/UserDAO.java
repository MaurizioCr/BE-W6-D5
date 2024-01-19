package w6d5.mauriziocrispino.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import w6d5.mauriziocrispino.Entities.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserDAO extends JpaRepository <User, UUID> {

    Optional <User> findByEmail(String email);
}
