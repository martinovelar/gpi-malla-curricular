package py.edu.uaa.facyt.gpimallacurricular.service;

import org.springframework.stereotype.Service;
import py.edu.uaa.facyt.gpimallacurricular.dto.CarreraRequestDto;
import py.edu.uaa.facyt.gpimallacurricular.dto.CarreraResponseDto;
import py.edu.uaa.facyt.gpimallacurricular.exception.ResourceNotFoundException;
import py.edu.uaa.facyt.gpimallacurricular.mapper.CarreraMapper;
import py.edu.uaa.facyt.gpimallacurricular.model.Carrera;
import py.edu.uaa.facyt.gpimallacurricular.model.Facultad;
import py.edu.uaa.facyt.gpimallacurricular.repository.CarreraRepository;
import py.edu.uaa.facyt.gpimallacurricular.repository.FacultadRepository;

import java.util.List;

@Service
public class CarreraService {

    private final CarreraRepository carreraRepository;
    private final FacultadRepository facultadRepository;
    private final CarreraMapper mapper;

    public CarreraService(CarreraRepository carreraRepository, FacultadRepository facultadRepository, CarreraMapper mapper) {
        this.carreraRepository = carreraRepository;
        this.facultadRepository = facultadRepository;
        this.mapper = mapper;
    }

    public List<CarreraResponseDto> getCarreras() {
        return carreraRepository.findAll()
                .stream()
                .map(mapper::toCarreraResponseDto)
                .toList();
    }

    public CarreraResponseDto getCarreraById(Long id) {
        Carrera carrera = carreraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carrera con id: " + id + " no encontrada"));
        return mapper.toCarreraResponseDto(carrera);
    }

    public CarreraResponseDto createCarrera(CarreraRequestDto dto) {
        Carrera carrera = mapper.toEntityFromCarreraRequestDto(dto);
        carrera.setFacultad(resolverFacultad(dto.getFacultadId()));
        return mapper.toCarreraResponseDto(carreraRepository.save(carrera));
    }

    public CarreraResponseDto updateCarrera(Long id, CarreraRequestDto dto) {
        Carrera carrera = carreraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carrera no encontrada con id: " + id));
        mapper.updateEntityFromDto(dto, carrera);
        carrera.setFacultad(resolverFacultad(dto.getFacultadId()));
        return mapper.toCarreraResponseDto(carreraRepository.save(carrera));
    }

    public CarreraResponseDto deleteCarrera(Long id) {
        Carrera carrera = carreraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carrera no encontrada con id: " + id));
        carreraRepository.delete(carrera);
        return mapper.toCarreraResponseDto(carrera);
    }

    private Facultad resolverFacultad(Long facultadId) {
        return facultadRepository.findById(facultadId)
                .orElseThrow(() -> new ResourceNotFoundException("Facultad con id: " + facultadId + " no encontrada"));
    }
}
