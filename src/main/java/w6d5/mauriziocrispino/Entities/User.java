package w6d5.mauriziocrispino.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "dispositivoId")
    private Dispositivo dispositivo;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String avatar;

}
