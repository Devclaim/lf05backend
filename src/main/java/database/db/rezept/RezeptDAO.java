package database.db.rezept;

import data_access_object.Rezept;
import data_access_object.RezeptKalorien;
import data_access_object.RezeptZutatAnzahl;
import database.DatabaseException;
import jooq_gen.tables.records.RezeptRecord;
import org.jooq.DSLContext;
import org.jooq.Record3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

import static jooq_gen.Tables.*;
import static org.jooq.impl.DSL.count;
import static org.jooq.impl.DSL.sum;

public class RezeptDAO implements DBrezept {
    private final Supplier<DSLContext> dslContextSupplier;

    public RezeptDAO(Supplier<DSLContext> dslContextSupplier) {
        this.dslContextSupplier = dslContextSupplier;
    }

    @Override
    public Rezept[] getAllRezept() throws DatabaseException {
        var ctx = dslContextSupplier.get();
        var r = ctx.selectFrom(REZEPT).fetchArray();
        return mapRezeptArray(r);
    }

    @Override
    public Rezept[] getRezepteByZutat(int zutatId) throws DatabaseException {
        var ctx = dslContextSupplier.get();
        return ctx.selectFrom(REZEPT)
                .where(REZEPT.REZEPTNR.in(ctx.select(REZEPTZUTAT.REZEPTNR)
                        .from(REZEPTZUTAT).where(REZEPTZUTAT.ZUTATNR.eq(zutatId))))
                .stream()
                .map(this::mapRezept)
                .toArray(Rezept[]::new);
    }

    @Override
    public Rezept[] getRezeptByRezeptnr(int rezeptnr) {
        var ctx = dslContextSupplier.get();
        var r = ctx.selectFrom(REZEPT)
                .where(REZEPT.REZEPTNR.eq(rezeptnr))
                .fetchArray();
        return mapRezeptArray(r);
    }

    @Override
    public RezeptZutatAnzahl[] getRezepteWhereZutatenAnzahlMax(int maxZutaten) {
        var ctx = dslContextSupplier.get();
        var r = ctx.select(REZEPT.REZEPTNR, REZEPT.REZEPTNAME, count(REZEPTZUTAT.ZUTATNR))
                .from(REZEPT)
                .join(REZEPTZUTAT)
                .on(REZEPT.REZEPTNR.eq(REZEPTZUTAT.REZEPTNR))
                .groupBy(REZEPT.REZEPTNR).having(count(REZEPTZUTAT.ZUTATNR)
                        .lessThan(maxZutaten + 1))
                .orderBy(REZEPT.REZEPTNR)
                .fetchArray();
        return mapRezeptZutatenMengeArray(r);
    }

    @Override
    public RezeptKalorien[] getRezeptByMaxKalorien(int maxKalorien) {
        var ctx = dslContextSupplier.get();

        var r = ctx.select(REZEPT.REZEPTNR,REZEPT.REZEPTNAME, sum(ZUTAT.KALORIEN.multiply(REZEPTZUTAT.MENGE)))
                .from(REZEPT)
                .join(REZEPTZUTAT)
                .on(REZEPTZUTAT.REZEPTNR.eq(REZEPT.REZEPTNR))
                .join(ZUTAT).on(ZUTAT.ZUTATNR.eq(REZEPTZUTAT.ZUTATNR))
                .groupBy(REZEPT.REZEPTNR)
                .having(sum(ZUTAT.KALORIEN.multiply(REZEPTZUTAT.MENGE))
                        .lessThan(BigDecimal.valueOf(maxKalorien)))
                .orderBy(REZEPT.REZEPTNR)
                .fetchArray();

        return mapRezeptKalArray(r);
    }


    @Override
    public RezeptZutatAnzahl[] getRezepteByEigenschaftName(String bezeichnung, int maxResults) throws DatabaseException {
        var ctx = dslContextSupplier.get();

        var zCount = ctx.select(REZEPT.REZEPTNR, REZEPT.REZEPTNAME, count(REZEPT.REZEPTNR).as("AnzahlRezZutaten"))
                .from(REZEPT)
                .join(REZEPTZUTAT)
                .on(REZEPTZUTAT.REZEPTNR.eq(REZEPT.REZEPTNR))
                .groupBy(REZEPT.REZEPTNR)
                .orderBy(REZEPT.REZEPTNR)
                .fetchArray();

        var lCount = ctx.select(REZEPT.REZEPTNR, REZEPT.REZEPTNAME, count(REZEPT.REZEPTNR)
                .as("AnzahlLegRezZutaten"))
                .from(REZEPT)
                .join(REZEPTZUTAT)
                .on(REZEPTZUTAT.REZEPTNR.eq(REZEPT.REZEPTNR))
                .join(ZUTAT).on(ZUTAT.ZUTATNR.eq(REZEPTZUTAT.ZUTATNR))
                .join(ZUTATEIGENSCHAFT)
                .on(ZUTATEIGENSCHAFT.ZUTATNR.eq(ZUTAT.ZUTATNR))
                .join(EIGENSCHAFTEN)
                .on(EIGENSCHAFTEN.EIGENSCHAFTID.eq(ZUTATEIGENSCHAFT.EIGENSCHAFTID))
                .where(EIGENSCHAFTEN.BEZEICHNUNG.eq(bezeichnung)/*.and(count(REZEPT.REZEPTNR).eq())*/)
                .groupBy(REZEPT.REZEPTNR)
                .orderBy(REZEPT.REZEPTNR)
                .fetchArray();

        RezeptZutatAnzahl[] zutatCount = mapRezeptZutatenMengeArray(zCount);
        RezeptZutatAnzahl[] legalCount = mapRezeptZutatenMengeArray(lCount);

        List<RezeptZutatAnzahl> resultList = new ArrayList<>();

        int add = 0;
        for (int i = 0; i < legalCount.length; ++i) {
            if (legalCount[i].rezeptnr() != zutatCount[i + add].rezeptnr()) {
                ++add;
            }
            if (legalCount[i].anzahlZutaten() == zutatCount[i + add].anzahlZutaten() && legalCount[i].anzahlZutaten() <= maxResults) {
                resultList.add(legalCount[i]);
            }
        }

        return resultList.toArray(new RezeptZutatAnzahl[]{});
    }

    private Rezept mapRezept(RezeptRecord resultSet) {
        return new Rezept(resultSet.getRezeptnr(), resultSet.getRezeptname());
    }

    private Rezept[] mapRezeptArray(RezeptRecord[] rezeptRecords) {
        final var mappedResults = new LinkedList<Rezept>();

        for (RezeptRecord rezeptRecord : rezeptRecords) {
            mappedResults.add(mapRezept(rezeptRecord));
        }

        return mappedResults.toArray(new Rezept[]{});
    }

    private RezeptKalorien[] mapRezeptKalArray(Record3<Integer, String, BigDecimal>[] rezeptKalRecords) {
        final var mappedResults = new LinkedList<RezeptKalorien>();

        for (Record3 rezeptKalRecord : rezeptKalRecords) {
            mappedResults.add(mapRezeptKal(rezeptKalRecord));
        }

        return mappedResults.toArray(new RezeptKalorien[]{});
    }

    private RezeptKalorien mapRezeptKal(Record3 resultSet) {
        return new RezeptKalorien(((int) resultSet.value1()), ((String) resultSet.value2()), ((BigDecimal) resultSet.value3()));
    }

    private RezeptZutatAnzahl[] mapRezeptZutatenMengeArray(Record3<Integer, String, Integer>[] rezeptZutatenAnzahlRecords) {
        final var mappedResults = new LinkedList<RezeptZutatAnzahl>();

        for (Record3 rezeptZutatenAnzahlRecord : rezeptZutatenAnzahlRecords) {
            mappedResults.add(mapRezeptZutatenAnzahl(rezeptZutatenAnzahlRecord));
        }


        return mappedResults.toArray(new RezeptZutatAnzahl[]{});
    }

    private RezeptZutatAnzahl mapRezeptZutatenAnzahl(Record3 resultSet) {
        return new RezeptZutatAnzahl(((int) resultSet.value1()), ((String) resultSet.value2()), ((int) resultSet.value3()));
    }
}