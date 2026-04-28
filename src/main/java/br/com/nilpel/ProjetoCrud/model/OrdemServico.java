package br.com.nilpel.ProjetoCrud.model;

import br.com.nilpel.ProjetoCrud.enums.StatusOS;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Table(name = "crud_teste_os")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

   @ManyToOne
    private Moto moto;

    @ManyToMany
    @JoinTable(
            name = "crud_teste_os_mecanico",
            joinColumns = @JoinColumn(name = "os_id"),
            inverseJoinColumns = @JoinColumn(name = "mecanico_id")
    )
    private List<Mecanico> mecanicos;
    
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private String descricao;
    private Double valor;

    @Enumerated(EnumType.STRING)
    private StatusOS status;


}
