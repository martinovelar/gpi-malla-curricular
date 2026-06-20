package py.edu.uaa.facyt.gpimallacurricular.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacultadRequestDto {

    @NotBlank
    private String name;
    @NotBlank
    private String code;
    @Email
    private String email;
    private String address;
    private String phoneNumber;
    private String dean;
}
