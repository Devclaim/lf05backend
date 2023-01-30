package data_access_object;

import java.math.BigDecimal;

public record Naehrwerte(
        BigDecimal avgkalorien,
        BigDecimal avgkohlenhydrate,
        BigDecimal avgprotein
) {
}
