package data_access_object;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Adresse(
        int adressid,
        String strasse,
        String hausnr,
        int regionid) {
}
