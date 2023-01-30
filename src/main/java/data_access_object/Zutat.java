package data_access_object;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Zutat(
        Integer zutatennr,
        String bezeichnung,
        String einheit,
        BigDecimal einkaufspreis,
        BigDecimal verkaufspreis,
        Integer bestand,
        int lieferantennr,
        Integer kalorien,
        BigDecimal kohlenhydrate,
        BigDecimal protein,
        BigDecimal co2bilanz) {
}
