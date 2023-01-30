/*
 * This file is generated by jOOQ.
 */
package jooq_gen;


import jooq_gen.tables.*;
import jooq_gen.tables.records.GetrezeptebyzutateigenschaftRecord;
import org.jooq.Configuration;
import org.jooq.Field;
import org.jooq.Result;


/**
 * Convenience access to all tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.adresse</code>.
     */
    public static final Adresse ADRESSE = Adresse.ADRESSE;

    /**
     * The table <code>public.beschraenkungen</code>.
     */
    public static final Beschraenkungen BESCHRAENKUNGEN = Beschraenkungen.BESCHRAENKUNGEN;

    /**
     * The table <code>public.bestellung</code>.
     */
    public static final Bestellung BESTELLUNG = Bestellung.BESTELLUNG;

    /**
     * The table <code>public.bestellungskunde</code>.
     */
    public static final Bestellungskunde BESTELLUNGSKUNDE = Bestellungskunde.BESTELLUNGSKUNDE;

    /**
     * The table <code>public.bestellungsrezept</code>.
     */
    public static final Bestellungsrezept BESTELLUNGSREZEPT = Bestellungsrezept.BESTELLUNGSREZEPT;

    /**
     * The table <code>public.bestellungzutat</code>.
     */
    public static final Bestellungzutat BESTELLUNGZUTAT = Bestellungzutat.BESTELLUNGZUTAT;

    /**
     * The table <code>public.eigenschaften</code>.
     */
    public static final Eigenschaften EIGENSCHAFTEN = Eigenschaften.EIGENSCHAFTEN;

    /**
     * The table <code>public.getrezeptebyzutateigenschaft</code>.
     */
    public static final Getrezeptebyzutateigenschaft GETREZEPTEBYZUTATEIGENSCHAFT = Getrezeptebyzutateigenschaft.GETREZEPTEBYZUTATEIGENSCHAFT;

    /**
     * Call <code>public.getrezeptebyzutateigenschaft</code>.
     */
    public static Result<GetrezeptebyzutateigenschaftRecord> GETREZEPTEBYZUTATEIGENSCHAFT(
          Configuration configuration
        , String eigenschaftname
    ) {
        return configuration.dsl().selectFrom(jooq_gen.tables.Getrezeptebyzutateigenschaft.GETREZEPTEBYZUTATEIGENSCHAFT.call(
              eigenschaftname
        )).fetch();
    }

    /**
     * Get <code>public.getrezeptebyzutateigenschaft</code> as a table.
     */
    public static Getrezeptebyzutateigenschaft GETREZEPTEBYZUTATEIGENSCHAFT(
          String eigenschaftname
    ) {
        return jooq_gen.tables.Getrezeptebyzutateigenschaft.GETREZEPTEBYZUTATEIGENSCHAFT.call(
            eigenschaftname
        );
    }

    /**
     * Get <code>public.getrezeptebyzutateigenschaft</code> as a table.
     */
    public static Getrezeptebyzutateigenschaft GETREZEPTEBYZUTATEIGENSCHAFT(
          Field<String> eigenschaftname
    ) {
        return jooq_gen.tables.Getrezeptebyzutateigenschaft.GETREZEPTEBYZUTATEIGENSCHAFT.call(
            eigenschaftname
        );
    }

    /**
     * The table <code>public.kunde</code>.
     */
    public static final Kunde KUNDE = Kunde.KUNDE;

    /**
     * The table <code>public.lieferant</code>.
     */
    public static final Lieferant LIEFERANT = Lieferant.LIEFERANT;

    /**
     * The table <code>public.region</code>.
     */
    public static final Region REGION = Region.REGION;

    /**
     * The table <code>public.rezept</code>.
     */
    public static final Rezept REZEPT = Rezept.REZEPT;

    /**
     * The table <code>public.rezeptzutat</code>.
     */
    public static final Rezeptzutat REZEPTZUTAT = Rezeptzutat.REZEPTZUTAT;

    /**
     * The table <code>public.zutat</code>.
     */
    public static final Zutat ZUTAT = Zutat.ZUTAT;

    /**
     * The table <code>public.zutatbeschraenkung</code>.
     */
    public static final Zutatbeschraenkung ZUTATBESCHRAENKUNG = Zutatbeschraenkung.ZUTATBESCHRAENKUNG;

    /**
     * The table <code>public.zutateigenschaft</code>.
     */
    public static final Zutateigenschaft ZUTATEIGENSCHAFT = Zutateigenschaft.ZUTATEIGENSCHAFT;
}
