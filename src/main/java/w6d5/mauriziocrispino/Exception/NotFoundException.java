package w6d5.mauriziocrispino.Exception;

import java.util.UUID;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(UUID id) {
        super(id + " non trovato!");
    }
}
