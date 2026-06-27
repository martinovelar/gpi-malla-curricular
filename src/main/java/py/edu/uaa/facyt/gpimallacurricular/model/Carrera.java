package py.edu.uaa.facyt.gpimallacurricular.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "carrera")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private Integer duration;
    private String coordinador;
    @ManyToOne
    @JoinColumn(name = "facultad_id")
    private Facultad facultad;
    @Builder.Default
    private Boolean active = true;
}
