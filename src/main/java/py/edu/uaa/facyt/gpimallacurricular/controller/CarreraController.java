package py.edu.uaa.facyt.gpimallacurricular.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.edu.uaa.facyt.gpimallacurricular.dto.CarreraRequestDto;
import py.edu.uaa.facyt.gpimallacurricular.dto.CarreraResponseDto;
import py.edu.uaa.facyt.gpimallacurricular.service.CarreraService;

import java.util.List;

@RestController
@RequestMapping("/api/carrera")
public class CarreraController {

    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @GetMapping
    public ResponseEntity<List<CarreraResponseDto>> getCarreras() {
        return ResponseEntity.ok(carreraService.getCarreras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarreraResponseDto> getCarreraById(@PathVariable Long id) {
        return ResponseEntity.ok(carreraService.getCarreraById(id));
    }

    @PostMapping
    public ResponseEntity<CarreraResponseDto> createCarrera(@Valid @RequestBody CarreraRequestDto dto) {
        return ResponseEntity.ok(carreraService.createCarrera(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarreraResponseDto> updateCarrera(
            @PathVariable Long id,
            @Valid @RequestBody CarreraRequestDto dto) {
        return ResponseEntity.ok(carreraService.updateCarrera(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarreraResponseDto> deleteCarrera(@PathVariable Long id) {
        return ResponseEntity.ok(carreraService.deleteCarrera(id));
    }
}
