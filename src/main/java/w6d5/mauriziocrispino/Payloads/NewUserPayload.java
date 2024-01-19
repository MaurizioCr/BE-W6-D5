package w6d5.mauriziocrispino.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
public class NewUserPayload {
    private String name;
    @NotNull(message = "Inserisci il tuo nome")
    @Size(min = 4, max = 20, message = "almeno 4 caratteri, massimo 20")
    private UUID dispositivoID;
    @NotNull(message = "Inserisci il tuo cognome")
    @Size(min = 4, max = 20, message = "almeno 4 caratteri, massimo 20")
    private String surname;
    @NotNull(message = "inserisci un username")
    @Size(min = 4, max = 30, message = "minimo 4 caratteri, massimo 30")
    private String username;
    @NotNull(message = "Inserisci la tua email")
    @Email(message = "l'email inserita non è valida")
    private String email;
    private String avatar;
}
