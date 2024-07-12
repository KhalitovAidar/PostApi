package online.agenta.exceptions.notfound;

import java.util.UUID;

public class PostNotFoundException extends NotFoundServiceException {
    public PostNotFoundException(UUID id) {
        super("Post with id = %s not found".formatted(id.toString()));
    }
}
