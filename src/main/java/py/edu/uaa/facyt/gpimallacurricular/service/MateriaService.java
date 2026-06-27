package py.edu.uaa.facyt.gpimallacurricular.service;

import org.springframework.stereotype.Service;
import py.edu.uaa.facyt.gpimallacurricular.dto.MateriaRequestDto;
import py.edu.uaa.facyt.gpimallacurricular.dto.MateriaResponseDto;
import py.edu.uaa.facyt.gpimallacurricular.exception.ResourceNotFoundException;
import py.edu.uaa.facyt.gpimallacurricular.mapper.MateriaMapper;
import py.edu.uaa.facyt.gpimallacurricular.model.Carrera;
import py.edu.uaa.facyt.gpimallacurricular.model.Materia;
import py.edu.uaa.facyt.gpimallacurricular.repository.CarreraRepository;
import py.edu.uaa.facyt.gpimallacurricular.repository.MateriaRepository;

import java.util.List;

@Service
public class MateriaService {

    private final MateriaRepository materiaRepository;
    private final CarreraRepository carreraRepository;
    private final MateriaMapper mapper;

    public MateriaService(MateriaRepository materiaRepository, CarreraRepository carreraRepository, MateriaMapper mapper) {
        this.materiaRepository = materiaRepository;
        this.carreraRepository = carreraRepository;
        this.mapper = mapper;
    }

    public List<MateriaResponseDto> getMaterias() {
        return materiaRepository.findAll()
                .stream()
                .map(mapper::toMateriaResponseDto)
                .toList();
    }

    public MateriaResponseDto getMateriaById(Long id) {
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materia con id: " + id + " no encontrada"));
        return mapper.toMateriaResponseDto(materia);
    }

    public MateriaResponseDto createMateria(MateriaRequestDto dto) {
        Materia materia = mapper.toEntityFromMateriaRequestDto(dto);
        materia.setCarrera(resolverCarrera(dto.getCarreraId()));
        return mapper.toMateriaResponseDto(materiaRepository.save(materia));
    }

    public MateriaResponseDto updateMateria(Long id, MateriaRequestDto dto) {
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrada con id: " + id));
        mapper.updateEntityFromDto(dto, materia);
        materia.setCarrera(resolverCarrera(dto.getCarreraId()));
        return mapper.toMateriaResponseDto(materiaRepository.save(materia));
    }

    public MateriaResponseDto deleteMateria(Long id) {
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrada con id: " + id));
        materiaRepository.delete(materia);
        return mapper.toMateriaResponseDto(materia);
    }

    private Carrera resolverCarrera(Long carreraId) {
        return carreraRepository.findById(carreraId)
                .orElseThrow(() -> new ResourceNotFoundException("Carrera con id: " + carreraId + " no encontrada"));
    }
}
