package online.agenta.controllers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import online.agenta.api.PostAPI;
import online.agenta.dto.request.PostRequest;
import online.agenta.dto.request.PostResponse;
import online.agenta.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController("/post")
@RequiredArgsConstructor
@Data
public class PostController implements PostAPI {

    private final PostService postService;

    @Override
    public PostResponse getById(UUID id) {
        return postService.getById(id);
    }

    @Override
    public Set<PostResponse> getAll() {
        return postService.getAll();
    }

    @Override
    public void create(PostRequest postRequest) {
        postService.create(postRequest);
    }

    @Override
    public UUID delete(UUID id) {
        return postService.delete(id);
    }

    @Override
    public UUID update(UUID uuid, PostRequest postRequest) {
        return postService.update(uuid, postRequest);
    }
}