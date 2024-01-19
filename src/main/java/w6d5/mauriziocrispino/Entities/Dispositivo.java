package w6d5.mauriziocrispino.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Dispositivo {
    @Id
    private UUID id;
    private Stato stato;
}
