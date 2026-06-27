package py.edu.uaa.facyt.gpimallacurricular.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MateriaResponseDto {

    private Long id;
    private String name;
    private String code;
    private Integer credits;
    private Integer semester;
    private Long carreraId;
    private String carreraName;
}
