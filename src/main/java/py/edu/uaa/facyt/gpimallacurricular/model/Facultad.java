package py.edu.uaa.facyt.gpimallacurricular.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "facultad")
public class Facultad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String email;
    private String address;
    private String phoneNumber;
    private String dean;
    @Builder.Default
    private Boolean active = true;

}
