package data_access_object;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Kunde(
        int kundennr,
        String nachname,
        String vorname,
        LocalDate geburtsdatum,
        String telefon,
        String email,
        int adressid) {

}