package database.db.zutat;

import data_access_object.Zutat;
import database.DatabaseException;
import jooq_gen.tables.records.ZutatRecord;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Supplier;

import static jooq_gen.Tables.*;

public class ZutatDAO implements DBzutat {
    private final Supplier<DSLContext> dslContextSupplier;

    public ZutatDAO(Supplier<DSLContext> dslContextSupplier) {
        this.dslContextSupplier = dslContextSupplier;
    }

    @Override
    public Zutat[] getAll() throws DatabaseException {
        var ctx = dslContextSupplier.get();
        var r = ctx.selectFrom(ZUTAT)
                .fetchArray();
        return mapZutatArray(r);
    }


    @Override
    public Zutat[] getByRezept(int id) throws DatabaseException {
        var ctx = dslContextSupplier.get();
        return ctx.selectFrom(ZUTAT)
                .where(ZUTAT.ZUTATNR.in(
                        ctx.select(REZEPTZUTAT.ZUTATNR)
                                .from(REZEPTZUTAT)
                                .where(REZEPTZUTAT.REZEPTNR.eq(id))))
                .stream()
                .map(this::mapZutat)
                .toArray(Zutat[]::new);
    }

    @Override
    public Zutat[] getZutatenNotContainedInAnyRezept() throws DatabaseException {
        var ctx = dslContextSupplier.get();
        var r = ctx.select().from(ZUTAT)
                .leftAntiJoin(REZEPTZUTAT)
                .on(REZEPTZUTAT.ZUTATNR.eq(ZUTAT.ZUTATNR))
                .fetchArray();
        return mapZutatArray(mapZutatJoin(r));
    }

    @Override
    public Zutat[] getZutatenByRezeptName(String rezeptName) {
        var ctx = dslContextSupplier.get();

        var r = ctx.select().from(ZUTAT)
                .join(REZEPTZUTAT)
                .on(REZEPTZUTAT.ZUTATNR.eq(ZUTAT.ZUTATNR))
                .join(REZEPT)
                .on(REZEPT.REZEPTNR.eq(REZEPTZUTAT.REZEPTNR))
                .where(REZEPT.REZEPTNAME.eq(rezeptName))
                .orderBy(ZUTAT.ZUTATNR.asc())
                .fetchArray();


        return mapZutatArray(mapZutatJoin(r));
    }

@Override
    public Zutat[] getZutatenRankedByCO2() {
        var ctx = dslContextSupplier.get();

        var r = ctx.selectFrom(ZUTAT)
                .orderBy(ZUTAT.CO2BILANZ.asc())
                .fetchArray();

        return mapZutatArray(r);
    }


    private Zutat[] mapZutatArray(ZutatRecord[] zutatRecords) {
        final var mappedResults = new LinkedList<Zutat>();

        for (ZutatRecord zutatRecord : zutatRecords) {
            mappedResults.add(mapZutat(zutatRecord));
        }

        return mappedResults.toArray(new Zutat[]{});
    }

    private Zutat mapZutat(ZutatRecord resultSet) {
        return new Zutat(
                resultSet.getZutatnr(),
                resultSet.getBezeichnung(),
                resultSet.getEinheit(),
                resultSet.getEinkaufspreis(),
                resultSet.getVerkaufspreis(),
                resultSet.getBestand(),
                resultSet.getLieferantennr(),
                resultSet.getKalorien(),
                resultSet.getKohlenhydrate(),
                resultSet.getProtein(),
                resultSet.getCo2bilanz()
        );
    }

    private ZutatRecord[] mapZutatJoin(Record[] resultSet) {
        return Arrays.stream(resultSet).map(x -> x.into(ZUTAT)).toArray(ZutatRecord[]::new);
    }
}