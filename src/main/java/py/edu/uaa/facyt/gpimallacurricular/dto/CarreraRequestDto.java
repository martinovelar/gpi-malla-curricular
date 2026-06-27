package py.edu.uaa.facyt.gpimallacurricular.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarreraRequestDto {

    @NotBlank
    private String name;
    @NotBlank
    private String code;
    private Integer duration;
    private String coordinador;
    @NotNull
    private Long facultadId;
}
