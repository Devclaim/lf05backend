package data_access_object;

import java.math.BigDecimal;

public record RezeptKalorien(

        int rezeptnr,
        String rezeptname,
        BigDecimal sumKalorien
) {
}
