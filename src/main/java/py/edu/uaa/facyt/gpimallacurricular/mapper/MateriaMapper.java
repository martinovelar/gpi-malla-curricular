package py.edu.uaa.facyt.gpimallacurricular.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import py.edu.uaa.facyt.gpimallacurricular.dto.MateriaRequestDto;
import py.edu.uaa.facyt.gpimallacurricular.dto.MateriaResponseDto;
import py.edu.uaa.facyt.gpimallacurricular.model.Materia;

@Mapper(componentModel = "spring")
public interface MateriaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "carrera", ignore = true)
    Materia toEntityFromMateriaRequestDto(MateriaRequestDto dto);

    @Mapping(target = "carreraId", source = "carrera.id")
    @Mapping(target = "carreraName", source = "carrera.name")
    MateriaResponseDto toMateriaResponseDto(Materia entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "carrera", ignore = true)
    void updateEntityFromDto(MateriaRequestDto dto, @MappingTarget Materia entity);
}
