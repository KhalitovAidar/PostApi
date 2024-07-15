package online.agenta.repository;

import online.agenta.models.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostJpaRepository extends JpaRepository<PostEntity, UUID> {
    Optional<PostEntity> findById(UUID id);

    @Modifying
    @Query("update PostEntity p set p.text = ?1, p.updatedDate = ?2 where p.id = ?3")
    void updateContentById(String text, LocalDateTime date, UUID id);

    @Modifying
    @Query("update PostEntity p set p.text = ?1, p.updatedDate = ?2 where p.id = ?3")
    void updateTextById(String text, LocalDateTime date, UUID id);
}
