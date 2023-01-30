package database.db.adresse;

import data_access_object.Adresse;
import database.DatabaseException;
import jooq_gen.tables.records.AdresseRecord;
import org.jooq.DSLContext;

import java.util.LinkedList;
import java.util.function.Supplier;

import static jooq_gen.Tables.ADRESSE;
import static jooq_gen.Tables.KUNDE;

public class AdresseDAO implements DBadresse {
    private final Supplier<DSLContext> dslContextSupplier;

    public AdresseDAO(Supplier<DSLContext> dslContextSupplier) {
        this.dslContextSupplier = dslContextSupplier;
    }

    @Override
    public Adresse getAdresseByKundennr(int kundennr) throws DatabaseException {
        var ctx = dslContextSupplier.get();
        var r = ctx.selectFrom(ADRESSE)
                .where(ADRESSE.ADRESSID
                        .eq(ctx.select(KUNDE.ADRESSID).from(KUNDE)
                                .where(KUNDE.KUNDENNR.eq(kundennr))))
                .fetchSingle();
        return mapAdresse(r);
    }

    @Override
    public Adresse[] getAllAdresse() throws DatabaseException {
        var ctx = dslContextSupplier.get();
        var r = ctx.selectFrom(ADRESSE)
                .fetchArray();
        return mapAdresseArray(r);
    }

    private Adresse mapAdresse(AdresseRecord resultSet) {
        return new Adresse(
                resultSet.getAdressid(),
                resultSet.getStrasse(),
                resultSet.getHausnr(),
                resultSet.getRegionid()
        );
    }

    private Adresse[] mapAdresseArray(AdresseRecord[] adresseRecords) {
        final var mappedResults = new LinkedList<Adresse>();

        for (AdresseRecord adresseRecord : adresseRecords) {
            mappedResults.add(mapAdresse(adresseRecord));
        }

        return mappedResults.toArray(new Adresse[]{});
    }
}
