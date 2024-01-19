package w6d5.mauriziocrispino.Payloads;

import lombok.Getter;

@Getter
public class NewUserPayload {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String avatar;
}
