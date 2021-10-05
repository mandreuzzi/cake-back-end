package cake.back.end.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Dolce")
@Table(name="DOLCI", schema = "cake-repo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dolce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="NOME")
    private String nome;

    @Column(name="PREZZO")
    private BigDecimal prezzo;

    @Column(name="DESCRIZIONE")
    private String descrizione;

    @Column(name="IMAGE_URL")
    private String imageUrl;

    @Column(name="SCADUTO")
    private boolean scaduto;

    @Column(name="UNITA_DISPONIBILI")
    private int unitaDisponibili;

    @Column(name="CALORIE")
    private int calorie;

    @Column(name="DATA_CREAZIONE")
    @CreationTimestamp
    private Date dataCreazione;

    @Column(name="IMAGE_NAME")
    private String imgName;

   @OneToMany(fetch = FetchType.EAGER)
    @JoinTable
            (
            name="DOLCI_INGREDIENTI",
            joinColumns={ @JoinColumn(name="DOLCE_ID", referencedColumnName="ID") },
            inverseJoinColumns={ @JoinColumn(name="INGREDIENTE_ID", referencedColumnName="ID") }
            )
    private List<Ingrediente> ingredienti = new ArrayList<>();

}
