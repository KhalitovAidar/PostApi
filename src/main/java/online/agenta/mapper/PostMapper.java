package online.agenta.mapper;

import online.agenta.dto.request.PostRequest;
import online.agenta.dto.request.PostResponse;
import online.agenta.models.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    PostEntity toEntity(PostRequest postRequest);

    @Mapping(target = "id", ignore = true)
    PostResponse toResponse(PostEntity postEntity);
}
