package py.edu.uaa.facyt.gpimallacurricular.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private Integer credits;
    private Integer semester;
    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;
    @Builder.Default
    private Boolean active = true;
}
