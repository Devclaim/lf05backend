/*
 * This file is generated by jOOQ.
 */
package jooq_gen.tables.records;


import jooq_gen.tables.Bestellungskunde;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BestellungskundeRecord extends TableRecordImpl<BestellungskundeRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.bestellungskunde.kundennr</code>.
     */
    public BestellungskundeRecord setKundennr(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.bestellungskunde.kundennr</code>.
     */
    public Integer getKundennr() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.bestellungskunde.bestellnr</code>.
     */
    public BestellungskundeRecord setBestellnr(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.bestellungskunde.bestellnr</code>.
     */
    public Integer getBestellnr() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Bestellungskunde.BESTELLUNGSKUNDE.KUNDENNR;
    }

    @Override
    public Field<Integer> field2() {
        return Bestellungskunde.BESTELLUNGSKUNDE.BESTELLNR;
    }

    @Override
    public Integer component1() {
        return getKundennr();
    }

    @Override
    public Integer component2() {
        return getBestellnr();
    }

    @Override
    public Integer value1() {
        return getKundennr();
    }

    @Override
    public Integer value2() {
        return getBestellnr();
    }

    @Override
    public BestellungskundeRecord value1(Integer value) {
        setKundennr(value);
        return this;
    }

    @Override
    public BestellungskundeRecord value2(Integer value) {
        setBestellnr(value);
        return this;
    }

    @Override
    public BestellungskundeRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BestellungskundeRecord
     */
    public BestellungskundeRecord() {
        super(Bestellungskunde.BESTELLUNGSKUNDE);
    }

    /**
     * Create a detached, initialised BestellungskundeRecord
     */
    public BestellungskundeRecord(Integer kundennr, Integer bestellnr) {
        super(Bestellungskunde.BESTELLUNGSKUNDE);

        setKundennr(kundennr);
        setBestellnr(bestellnr);
    }
}
