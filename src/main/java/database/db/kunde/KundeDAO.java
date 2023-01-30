package database.db.kunde;

import data_access_object.Kunde;
import jooq_gen.tables.records.KundeRecord;
import org.jooq.DSLContext;
import org.jooq.Record7;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.function.Supplier;

import static jooq_gen.Tables.*;

public class KundeDAO implements DBkunde {

    private final Supplier<DSLContext> dslContextSupplier;

    public KundeDAO(Supplier<DSLContext> dslContextSupplier) {
        this.dslContextSupplier = dslContextSupplier;
    }

    @Override
    public Kunde getKundeByKundennr(int id) {
        var ctx = dslContextSupplier.get();
        var r = ctx.selectFrom(KUNDE)
                .where(KUNDE.KUNDENNR.eq(id))
                .fetchSingle();
        return mapKunde(r);
    }

    @Override
    public Kunde[] getAllKunde() {
        var ctx = dslContextSupplier.get();
        var r = ctx.selectFrom(KUNDE)
                .fetchArray();
        return mapKundeArray(r);
    }

    @Override
    public Kunde[] getKundenByRegion(String plz) {
        var ctx = dslContextSupplier.get();
        var r = ctx.select(
                        KUNDE.KUNDENNR,
                        KUNDE.NACHNAME,
                        KUNDE.VORNAME,
                        KUNDE.GEBURTSDATUM,
                        KUNDE.TELEFON,
                        KUNDE.EMAIL,
                        KUNDE.ADRESSID
                )
                .from(KUNDE)
                .join(ADRESSE)
                .on(KUNDE.ADRESSID.eq(ADRESSE.ADRESSID))
                .leftJoin(REGION)
                .on(ADRESSE.REGIONID.eq(REGION.REGIONID))
                .where(REGION.PLZ.eq(plz))
                .fetchArray();


        return mapRecords7(r);
    }

    @Override
    public void insertKunde(Kunde kunde) {
        var ctx = dslContextSupplier.get();
        ctx.insertInto(KUNDE)
                .set(KUNDE.KUNDENNR, kunde.kundennr())
                .set(KUNDE.NACHNAME, kunde.nachname())
                .set(KUNDE.VORNAME, kunde.vorname())
                .set(KUNDE.GEBURTSDATUM, kunde.geburtsdatum())
                .set(KUNDE.TELEFON, kunde.telefon())
                .set(KUNDE.EMAIL, kunde.email())
                .set(KUNDE.ADRESSID, kunde.adressid())
                .execute();
    }

    @Override
    public String deleteKunde(int kundennr) {
        var ctx = dslContextSupplier.get();
        if (ctx.fetchExists(ctx.selectFrom(KUNDE).where(KUNDE.KUNDENNR.eq(kundennr)))) {
            try {
                ctx.deleteFrom(KUNDE)
                        .where(KUNDE.KUNDENNR.eq(kundennr))
                        .execute();
                return "Kunde wurde aus Datenbank entfernt.";
            } catch (Exception e) {
                return "Kunde konnte nicht entfernt werden!";
            }
        } else {
            return "Kunde existiert nicht!";
        }
    }

    private Kunde mapKunde(KundeRecord resultSet) {
        return new Kunde(
                resultSet.getKundennr(),
                resultSet.getNachname(),
                resultSet.getVorname(),
                resultSet.getGeburtsdatum(),
                resultSet.getTelefon(),
                resultSet.getEmail(),
                resultSet.getAdressid()
        );
    }

    private Kunde[] mapKundeArray(KundeRecord[] kundeRecords) {
        final var mappedResults = new LinkedList<Kunde>();

        for (KundeRecord kundeRecord : kundeRecords) {
            mappedResults.add(mapKunde(kundeRecord));
        }

        return mappedResults.toArray(new Kunde[]{});
    }

    private Kunde[] mapRecords7(Record7<Integer, String, String, LocalDate, String, String, Integer>[] record7s) {
        final var mappedResults = new LinkedList<Kunde>();

        for (Record7 kundeRecord : record7s) {
            mappedResults.add(mapRecord7(kundeRecord));
        }
        return mappedResults.toArray(new Kunde[]{});
    }

    private Kunde mapRecord7(Record7 resultSet) {
        return new Kunde(
                ((int) resultSet.value1()),
                ((String) resultSet.value2()),
                ((String) resultSet.value3()),
                ((LocalDate) resultSet.value4()),
                ((String) resultSet.value5()),
                ((String) resultSet.value6()),
                ((int) resultSet.value7()
                ));
    }
}
