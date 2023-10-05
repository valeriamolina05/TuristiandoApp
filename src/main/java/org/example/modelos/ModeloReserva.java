package org.example.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservas")

public class ModeloReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Integer id;
    private Double costoTotal = 0.0;
    private LocalDate fechaReserva;

    private Integer numeroPersonas =0;
}
