package w6d5.mauriziocrispino.Payloads;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
public class NewUserPayload {
    private UUID dispositivoID;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String avatar;
}
