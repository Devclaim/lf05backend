package data_access_object;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RezeptKalorienList(RezeptKalorien[] rezepteKalorien) {
}