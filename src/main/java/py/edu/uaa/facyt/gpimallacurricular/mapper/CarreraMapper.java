package py.edu.uaa.facyt.gpimallacurricular.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import py.edu.uaa.facyt.gpimallacurricular.dto.CarreraRequestDto;
import py.edu.uaa.facyt.gpimallacurricular.dto.CarreraResponseDto;
import py.edu.uaa.facyt.gpimallacurricular.model.Carrera;

@Mapper(componentModel = "spring")
public interface CarreraMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "facultad", ignore = true)
    Carrera toEntityFromCarreraRequestDto(CarreraRequestDto dto);

    @Mapping(target = "facultadId", source = "facultad.id")
    @Mapping(target = "facultadName", source = "facultad.name")
    CarreraResponseDto toCarreraResponseDto(Carrera entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "facultad", ignore = true)
    void updateEntityFromDto(CarreraRequestDto dto, @MappingTarget Carrera entity);
}
