package py.edu.uaa.facyt.gpimallacurricular.service;

import org.springframework.stereotype.Service;
import py.edu.uaa.facyt.gpimallacurricular.dto.FacultadRequestDto;
import py.edu.uaa.facyt.gpimallacurricular.dto.FacultadResponseDto;
import py.edu.uaa.facyt.gpimallacurricular.exception.ResourceNotFoundException;
import py.edu.uaa.facyt.gpimallacurricular.mapper.FacultadMapper;
import py.edu.uaa.facyt.gpimallacurricular.model.Facultad;
import py.edu.uaa.facyt.gpimallacurricular.repository.FacultadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultadService {

    private final FacultadRepository facultadRepository;
    private final FacultadMapper mapper;

    public FacultadService(FacultadRepository facultadRepository, FacultadMapper mapper) {
        this.facultadRepository = facultadRepository;
        this.mapper = mapper;
    }

    public List<FacultadResponseDto> getFacultades() {
        return facultadRepository.findAll()
                .stream()
                .map(mapper::toFacultadResponseDto)
                .toList();
    }

    public  FacultadResponseDto getFacultadById(Long id){
       Facultad facultad = facultadRepository
               .findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("Facultad con id: " + id + "no encontrada"));
        return mapper.toFacultadResponseDto(facultad);
    }



    public FacultadResponseDto createFacultad(FacultadRequestDto dto){
        Facultad facultad = mapper.toEntityFromFacultadRequestDto(dto);
        Facultad savedFacultad = facultadRepository.save(facultad);

        return mapper.toFacultadResponseDto(savedFacultad);
    }

    public FacultadResponseDto updateFacultad(Long id, FacultadRequestDto dto){
        Facultad facultad = facultadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facultad no encontrada con id: " + id));

        mapper.updateEntityFromDto(dto, facultad);
        Facultad updatedFacultad = facultadRepository.save(facultad);

        return mapper.toFacultadResponseDto(updatedFacultad);
    }

    public FacultadResponseDto deleteFacultad(Long id){
        Facultad facultad = facultadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facultad no encontrada con id: " + id));

        facultadRepository.delete(facultad);
        return mapper.toFacultadResponseDto(facultad);

    }
}
