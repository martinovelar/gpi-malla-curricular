package py.edu.uaa.facyt.gpimallacurricular.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.edu.uaa.facyt.gpimallacurricular.dto.MateriaRequestDto;
import py.edu.uaa.facyt.gpimallacurricular.dto.MateriaResponseDto;
import py.edu.uaa.facyt.gpimallacurricular.service.MateriaService;

import java.util.List;

@RestController
@RequestMapping("/api/materia")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public ResponseEntity<List<MateriaResponseDto>> getMaterias() {
        return ResponseEntity.ok(materiaService.getMaterias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaResponseDto> getMateriaById(@PathVariable Long id) {
        return ResponseEntity.ok(materiaService.getMateriaById(id));
    }

    @PostMapping
    public ResponseEntity<MateriaResponseDto> createMateria(@Valid @RequestBody MateriaRequestDto dto) {
        return ResponseEntity.ok(materiaService.createMateria(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaResponseDto> updateMateria(
            @PathVariable Long id,
            @Valid @RequestBody MateriaRequestDto dto) {
        return ResponseEntity.ok(materiaService.updateMateria(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MateriaResponseDto> deleteMateria(@PathVariable Long id) {
        return ResponseEntity.ok(materiaService.deleteMateria(id));
    }
}
