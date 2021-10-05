package cake.back.end.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "DolceIngrediente")
@Table(name="DOLCI_INGREDIENTI", schema = "cake-repo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DolceIngrediente {

    /*@EmbeddedId
    private DolceIngredientePK id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @MapsId("dolce_id")
    @JoinColumn(name = "DOLCE_ID")
    private Dolce dolce;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @MapsId("ingrediente_id")
    @JoinColumn(name = "INGREDIENTE_ID")
    private Ingrediente ingrediente;*/
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DOLCE_ID")
    Dolce dolce;

    @ManyToOne
    @JoinColumn(name = "INGREDIENTE_ID")
    Ingrediente ingredient;

    private String quantita;

    private String unitaDiMisura;

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DolceIngrediente that = (DolceIngrediente) o;
        return Objects.equals(id, that.id) && Objects.equals(dolce, that.dolce) && Objects.equals(ingrediente, that.ingrediente) && Objects.equals(quantita, that.quantita) && Objects.equals(unitaDiMisura, that.unitaDiMisura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dolce, ingrediente, quantita, unitaDiMisura);
    }*/
}
