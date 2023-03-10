/*
 * This file is generated by jOOQ.
 */
package jooq_gen.tables.records;


import jooq_gen.tables.Zutat;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;

import java.math.BigDecimal;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ZutatRecord extends UpdatableRecordImpl<ZutatRecord> implements Record11<Integer, String, String, BigDecimal, BigDecimal, Integer, Integer, Integer, BigDecimal, BigDecimal, BigDecimal> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.zutat.zutatnr</code>.
     */
    public ZutatRecord setZutatnr(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.zutat.zutatnr</code>.
     */
    public Integer getZutatnr() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.zutat.bezeichnung</code>.
     */
    public ZutatRecord setBezeichnung(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.zutat.bezeichnung</code>.
     */
    public String getBezeichnung() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.zutat.einheit</code>.
     */
    public ZutatRecord setEinheit(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.zutat.einheit</code>.
     */
    public String getEinheit() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.zutat.verkaufspreis</code>.
     */
    public ZutatRecord setVerkaufspreis(BigDecimal value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.zutat.verkaufspreis</code>.
     */
    public BigDecimal getVerkaufspreis() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>public.zutat.einkaufspreis</code>.
     */
    public ZutatRecord setEinkaufspreis(BigDecimal value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.zutat.einkaufspreis</code>.
     */
    public BigDecimal getEinkaufspreis() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>public.zutat.bestand</code>.
     */
    public ZutatRecord setBestand(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.zutat.bestand</code>.
     */
    public Integer getBestand() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.zutat.lieferantennr</code>.
     */
    public ZutatRecord setLieferantennr(Integer value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.zutat.lieferantennr</code>.
     */
    public Integer getLieferantennr() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>public.zutat.kalorien</code>.
     */
    public ZutatRecord setKalorien(Integer value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.zutat.kalorien</code>.
     */
    public Integer getKalorien() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>public.zutat.kohlenhydrate</code>.
     */
    public ZutatRecord setKohlenhydrate(BigDecimal value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.zutat.kohlenhydrate</code>.
     */
    public BigDecimal getKohlenhydrate() {
        return (BigDecimal) get(8);
    }

    /**
     * Setter for <code>public.zutat.protein</code>.
     */
    public ZutatRecord setProtein(BigDecimal value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.zutat.protein</code>.
     */
    public BigDecimal getProtein() {
        return (BigDecimal) get(9);
    }

    /**
     * Setter for <code>public.zutat.co2bilanz</code>.
     */
    public ZutatRecord setCo2bilanz(BigDecimal value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.zutat.co2bilanz</code>.
     */
    public BigDecimal getCo2bilanz() {
        return (BigDecimal) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<Integer, String, String, BigDecimal, BigDecimal, Integer, Integer, Integer, BigDecimal, BigDecimal, BigDecimal> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<Integer, String, String, BigDecimal, BigDecimal, Integer, Integer, Integer, BigDecimal, BigDecimal, BigDecimal> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Zutat.ZUTAT.ZUTATNR;
    }

    @Override
    public Field<String> field2() {
        return Zutat.ZUTAT.BEZEICHNUNG;
    }

    @Override
    public Field<String> field3() {
        return Zutat.ZUTAT.EINHEIT;
    }

    @Override
    public Field<BigDecimal> field4() {
        return Zutat.ZUTAT.VERKAUFSPREIS;
    }

    @Override
    public Field<BigDecimal> field5() {
        return Zutat.ZUTAT.EINKAUFSPREIS;
    }

    @Override
    public Field<Integer> field6() {
        return Zutat.ZUTAT.BESTAND;
    }

    @Override
    public Field<Integer> field7() {
        return Zutat.ZUTAT.LIEFERANTENNR;
    }

    @Override
    public Field<Integer> field8() {
        return Zutat.ZUTAT.KALORIEN;
    }

    @Override
    public Field<BigDecimal> field9() {
        return Zutat.ZUTAT.KOHLENHYDRATE;
    }

    @Override
    public Field<BigDecimal> field10() {
        return Zutat.ZUTAT.PROTEIN;
    }

    @Override
    public Field<BigDecimal> field11() {
        return Zutat.ZUTAT.CO2BILANZ;
    }

    @Override
    public Integer component1() {
        return getZutatnr();
    }

    @Override
    public String component2() {
        return getBezeichnung();
    }

    @Override
    public String component3() {
        return getEinheit();
    }

    @Override
    public BigDecimal component4() {
        return getVerkaufspreis();
    }

    @Override
    public BigDecimal component5() {
        return getEinkaufspreis();
    }

    @Override
    public Integer component6() {
        return getBestand();
    }

    @Override
    public Integer component7() {
        return getLieferantennr();
    }

    @Override
    public Integer component8() {
        return getKalorien();
    }

    @Override
    public BigDecimal component9() {
        return getKohlenhydrate();
    }

    @Override
    public BigDecimal component10() {
        return getProtein();
    }

    @Override
    public BigDecimal component11() {
        return getCo2bilanz();
    }

    @Override
    public Integer value1() {
        return getZutatnr();
    }

    @Override
    public String value2() {
        return getBezeichnung();
    }

    @Override
    public String value3() {
        return getEinheit();
    }

    @Override
    public BigDecimal value4() {
        return getVerkaufspreis();
    }

    @Override
    public BigDecimal value5() {
        return getEinkaufspreis();
    }

    @Override
    public Integer value6() {
        return getBestand();
    }

    @Override
    public Integer value7() {
        return getLieferantennr();
    }

    @Override
    public Integer value8() {
        return getKalorien();
    }

    @Override
    public BigDecimal value9() {
        return getKohlenhydrate();
    }

    @Override
    public BigDecimal value10() {
        return getProtein();
    }

    @Override
    public BigDecimal value11() {
        return getCo2bilanz();
    }

    @Override
    public ZutatRecord value1(Integer value) {
        setZutatnr(value);
        return this;
    }

    @Override
    public ZutatRecord value2(String value) {
        setBezeichnung(value);
        return this;
    }

    @Override
    public ZutatRecord value3(String value) {
        setEinheit(value);
        return this;
    }

    @Override
    public ZutatRecord value4(BigDecimal value) {
        setVerkaufspreis(value);
        return this;
    }

    @Override
    public ZutatRecord value5(BigDecimal value) {
        setEinkaufspreis(value);
        return this;
    }

    @Override
    public ZutatRecord value6(Integer value) {
        setBestand(value);
        return this;
    }

    @Override
    public ZutatRecord value7(Integer value) {
        setLieferantennr(value);
        return this;
    }

    @Override
    public ZutatRecord value8(Integer value) {
        setKalorien(value);
        return this;
    }

    @Override
    public ZutatRecord value9(BigDecimal value) {
        setKohlenhydrate(value);
        return this;
    }

    @Override
    public ZutatRecord value10(BigDecimal value) {
        setProtein(value);
        return this;
    }

    @Override
    public ZutatRecord value11(BigDecimal value) {
        setCo2bilanz(value);
        return this;
    }

    @Override
    public ZutatRecord values(Integer value1, String value2, String value3, BigDecimal value4, BigDecimal value5, Integer value6, Integer value7, Integer value8, BigDecimal value9, BigDecimal value10, BigDecimal value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ZutatRecord
     */
    public ZutatRecord() {
        super(Zutat.ZUTAT);
    }

    /**
     * Create a detached, initialised ZutatRecord
     */
    public ZutatRecord(Integer zutatnr, String bezeichnung, String einheit, BigDecimal verkaufspreis, BigDecimal einkaufspreis, Integer bestand, Integer lieferantennr, Integer kalorien, BigDecimal kohlenhydrate, BigDecimal protein, BigDecimal co2bilanz) {
        super(Zutat.ZUTAT);

        setZutatnr(zutatnr);
        setBezeichnung(bezeichnung);
        setEinheit(einheit);
        setVerkaufspreis(verkaufspreis);
        setEinkaufspreis(einkaufspreis);
        setBestand(bestand);
        setLieferantennr(lieferantennr);
        setKalorien(kalorien);
        setKohlenhydrate(kohlenhydrate);
        setProtein(protein);
        setCo2bilanz(co2bilanz);
    }
}
