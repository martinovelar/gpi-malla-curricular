package py.edu.uaa.facyt.gpimallacurricular.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.edu.uaa.facyt.gpimallacurricular.dto.FacultadRequestDto;
import py.edu.uaa.facyt.gpimallacurricular.dto.FacultadResponseDto;
import py.edu.uaa.facyt.gpimallacurricular.service.FacultadService;

import java.util.List;

@RestController
@RequestMapping("/api/facultad")
public class FacultadController {

    private final FacultadService facultadService;

    public FacultadController(FacultadService facultadService) {
        this.facultadService = facultadService;
    }

    @GetMapping
    public ResponseEntity<List<FacultadResponseDto>> getFacultades() {
        return ResponseEntity.ok(facultadService.getFacultades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultadResponseDto> getFacultadById(@PathVariable Long id){
        return ResponseEntity.ok(facultadService.getFacultadById(id));
    }


    @PostMapping
    public ResponseEntity<FacultadResponseDto> createFacultad(
            @Valid @RequestBody FacultadRequestDto dto
    ) {
        return ResponseEntity.ok(facultadService.createFacultad(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacultadResponseDto> updateFacultad(
            @PathVariable Long id,
            @Valid @RequestBody FacultadRequestDto dto
    ) {
        return ResponseEntity.ok(facultadService.updateFacultad(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FacultadResponseDto> deleteFacultad(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(facultadService.deleteFacultad(id));
    }
}
