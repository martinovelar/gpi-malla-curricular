package py.edu.uaa.facyt.gpimallacurricular.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import py.edu.uaa.facyt.gpimallacurricular.dto.FacultadRequestDto;
import py.edu.uaa.facyt.gpimallacurricular.dto.FacultadResponseDto;
import py.edu.uaa.facyt.gpimallacurricular.model.Facultad;

@Mapper(componentModel = "spring")
public interface FacultadMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    Facultad toEntityFromFacultadRequestDto(FacultadRequestDto dto);

    FacultadResponseDto toFacultadResponseDto(Facultad entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    void updateEntityFromDto(FacultadRequestDto dto, @MappingTarget Facultad entity);
}
