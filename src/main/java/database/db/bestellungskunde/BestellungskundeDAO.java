package database.db.bestellungskunde;

import data_access_object.Bestellungskunde;
import data_access_object.Naehrwerte;
import database.DatabaseException;
import jooq_gen.tables.records.BestellungskundeRecord;
import org.jooq.DSLContext;

import java.util.LinkedList;
import java.util.function.Supplier;

import static jooq_gen.Tables.*;
import static org.jooq.impl.DSL.avg;
import static org.jooq.impl.DSL.round;

public class BestellungskundeDAO implements DBbestellungskunde {
    private final Supplier<DSLContext> dslContextSupplier;

    public BestellungskundeDAO(Supplier<DSLContext> dslContextSupplier) {
        this.dslContextSupplier = dslContextSupplier;
    }

    @Override
    public Bestellungskunde[] getAllBestellungskunde() throws DatabaseException {
        var ctx = dslContextSupplier.get();
        var r = ctx.selectFrom(BESTELLUNGSKUNDE)
                .fetchArray();
        return mapBestKundeArray(r);
    }

    @Override
    public Naehrwerte getNaehrwerteFromKundennr(int kundennr) {
        var ctx = dslContextSupplier.get();
        var r = ctx.select(
                        round(avg(ZUTAT.KALORIEN), 2).as("AVG Kalorien"),
                        round(avg(ZUTAT.KOHLENHYDRATE), 2).as("AVG Kohlenhydrate"),
                        round(avg(ZUTAT.PROTEIN), 2).as("AVG Protein"))
                .from(BESTELLUNG)
                .naturalJoin(BESTELLUNGZUTAT)
                .naturalJoin(ZUTAT)
                .naturalJoin(BESTELLUNGSKUNDE)
                .where(BESTELLUNGSKUNDE.KUNDENNR.eq(kundennr))
                .fetchSingle();
        return new Naehrwerte(r.value1(), r.value2(), r.value3());

    }


    private Bestellungskunde mapBestKunde(BestellungskundeRecord resultSet) {
        return new Bestellungskunde(
                resultSet.getKundennr(),
                resultSet.getBestellnr()
        );
    }

    private Bestellungskunde[] mapBestKundeArray(BestellungskundeRecord[] bestellungskundeRecords) {
        final var mappedResults = new LinkedList<Bestellungskunde>();

        for (BestellungskundeRecord bestellungskundeRecord : bestellungskundeRecords) {
            mappedResults.add(mapBestKunde(bestellungskundeRecord));
        }

        return mappedResults.toArray(new Bestellungskunde[]{});
    }

}