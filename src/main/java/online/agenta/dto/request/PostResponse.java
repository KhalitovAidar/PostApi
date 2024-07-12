package online.agenta.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
public class PostResponse {
    private UUID id;
    private String text;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
