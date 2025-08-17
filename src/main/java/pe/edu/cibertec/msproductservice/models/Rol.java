package pe.edu.cibertec.msproductservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rols")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(nullable = false, length = 50)
    private String name;
}