package cake.back.end.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DolceIngredientePK implements Serializable {

    @Column(name = "DOLCE_ID")
    private Long dolceId;

    @Column(name = "INGREDIENTE_ID")
    private Long ingredienteId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DolceIngredientePK that = (DolceIngredientePK) o;
        return Objects.equals(dolceId, that.dolceId) && Objects.equals(ingredienteId, that.ingredienteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dolceId, ingredienteId);
    }
}
