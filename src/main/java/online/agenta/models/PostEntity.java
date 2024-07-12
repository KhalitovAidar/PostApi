package online.agenta.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "posts")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity extends AbstractEntity {
    @Column(name = "text", nullable = false)
    private String text;
}