package online.agenta.services;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import online.agenta.dto.request.PostRequest;
import online.agenta.dto.request.PostResponse;
import online.agenta.exceptions.notfound.PostNotFoundException;
import online.agenta.mapper.PostMapper;
import online.agenta.models.PostEntity;
import online.agenta.repository.PostJpaRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Data
public class PostService {

    private final PostJpaRepository repository;
    @Qualifier("postMapper")
    private final PostMapper mapper;

    public PostResponse getById(UUID id) {
        PostEntity post = repository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        PostResponse postResponse = mapper.toResponse(post);

        return mapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() -> new PostNotFoundException(id))
        );
    }

    public Set<PostResponse> getAll() {
        Set<PostResponse> postResponseSet = new HashSet<>();
        for (PostEntity postEntity : repository.findAll()) {
            PostResponse response = mapper.toResponse(postEntity);
            postResponseSet.add(response);
        }
        return postResponseSet;
    }

    public PostEntity create(PostRequest postRequest) {

        PostEntity post = PostEntity.builder()
                .text(postRequest.text())
                .build();

        PostEntity postNew = repository.save(post);

        return post;
    }

    public UUID delete(UUID id) {
        repository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));


        repository.deleteById(id);
        return id;
    }

    public UUID update(UUID id, PostRequest postRequest) {
        repository.findById(id)
                            .orElseThrow(() -> new PostNotFoundException(id));


        repository.updateContentById(postRequest.text(), LocalDateTime.now(), id);
        return id;
    }
}