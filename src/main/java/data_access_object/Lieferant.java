package data_access_object;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Lieferant(
        int lieferantennr,
        String lieferantenname,
        String telefon,
        String email,
        int adressid) {
}
