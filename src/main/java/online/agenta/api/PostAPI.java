package online.agenta.api;

import io.swagger.annotations.*;
import online.agenta.dto.request.PostRequest;
import online.agenta.dto.request.PostResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RequestMapping("/posts")
public interface PostAPI {

    @ApiOperation(value = "Получение поста по id", nickname = "get-post-by-id", response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пост получен", response = UUID.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Ошибка сервера")
    })
    @GetMapping("/post/{post-id}")
    @ResponseStatus(HttpStatus.OK)
    PostResponse getById(@PathVariable("post-id") UUID id);

    @ApiOperation(value = "Получение всех постов", nickname = "get-all-posts", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Все посты получены", response = Set.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Ошибка сервера")
    })
    @GetMapping("get-all-posts")
    @ResponseStatus(HttpStatus.OK)
    Set<PostResponse> getAll();

    @ApiOperation(value = "Создание поста", nickname = "post-create", response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Пост был создан", response = UUID.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Ошибка сервера")
    })
    @PostMapping("/create-post")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody PostRequest postRequest);

    @ApiOperation(value = "Удаление поста", nickname = "post-delete", response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пост был удален", response = UUID.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Ошибка сервера")
    })

    @DeleteMapping("/delete-post/{post-id}")
    @ResponseStatus(HttpStatus.OK)
    UUID delete(@PathVariable("post-id") UUID id);

    @ApiOperation(value = "Редактирование поста", nickname = "post-update", response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пост был отредактирован", response = UUID.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Ошибка сервера")
    })
    @PutMapping("/update-post/{post-id}")
    @ResponseStatus(HttpStatus.OK)
    UUID update(@PathVariable("post-id") UUID id, @RequestBody PostRequest postRequest);

}
