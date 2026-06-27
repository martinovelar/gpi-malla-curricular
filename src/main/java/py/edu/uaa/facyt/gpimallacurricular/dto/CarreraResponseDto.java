package py.edu.uaa.facyt.gpimallacurricular.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarreraResponseDto {

    private Long id;
    private String name;
    private String code;
    private Integer duration;
    private String coordinador;
    private Long facultadId;
    private String facultadName;
}
