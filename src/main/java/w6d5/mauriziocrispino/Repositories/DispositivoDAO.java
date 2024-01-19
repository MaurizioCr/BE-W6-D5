package w6d5.mauriziocrispino.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import w6d5.mauriziocrispino.Entities.Dispositivo;

import java.util.UUID;

@Repository
public interface DispositivoDAO extends JpaRepository <Dispositivo, UUID> {
}
