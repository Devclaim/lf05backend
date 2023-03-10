/*
 * This file is generated by jOOQ.
 */
package jooq_gen.tables;


import jooq_gen.Keys;
import jooq_gen.Public;
import jooq_gen.tables.records.ZutatRecord;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Zutat extends TableImpl<ZutatRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.zutat</code>
     */
    public static final Zutat ZUTAT = new Zutat();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ZutatRecord> getRecordType() {
        return ZutatRecord.class;
    }

    /**
     * The column <code>public.zutat.zutatnr</code>.
     */
    public final TableField<ZutatRecord, Integer> ZUTATNR = createField(DSL.name("zutatnr"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.zutat.bezeichnung</code>.
     */
    public final TableField<ZutatRecord, String> BEZEICHNUNG = createField(DSL.name("bezeichnung"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.zutat.einheit</code>.
     */
    public final TableField<ZutatRecord, String> EINHEIT = createField(DSL.name("einheit"), SQLDataType.VARCHAR(25), this, "");

    /**
     * The column <code>public.zutat.verkaufspreis</code>.
     */
    public final TableField<ZutatRecord, BigDecimal> VERKAUFSPREIS = createField(DSL.name("verkaufspreis"), SQLDataType.NUMERIC(10, 2), this, "");

    /**
     * The column <code>public.zutat.einkaufspreis</code>.
     */
    public final TableField<ZutatRecord, BigDecimal> EINKAUFSPREIS = createField(DSL.name("einkaufspreis"), SQLDataType.NUMERIC(10, 2), this, "");

    /**
     * The column <code>public.zutat.bestand</code>.
     */
    public final TableField<ZutatRecord, Integer> BESTAND = createField(DSL.name("bestand"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.zutat.lieferantennr</code>.
     */
    public final TableField<ZutatRecord, Integer> LIEFERANTENNR = createField(DSL.name("lieferantennr"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.zutat.kalorien</code>.
     */
    public final TableField<ZutatRecord, Integer> KALORIEN = createField(DSL.name("kalorien"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.zutat.kohlenhydrate</code>.
     */
    public final TableField<ZutatRecord, BigDecimal> KOHLENHYDRATE = createField(DSL.name("kohlenhydrate"), SQLDataType.NUMERIC(10, 2), this, "");

    /**
     * The column <code>public.zutat.protein</code>.
     */
    public final TableField<ZutatRecord, BigDecimal> PROTEIN = createField(DSL.name("protein"), SQLDataType.NUMERIC(10, 2), this, "");

    /**
     * The column <code>public.zutat.co2bilanz</code>.
     */
    public final TableField<ZutatRecord, BigDecimal> CO2BILANZ = createField(DSL.name("co2bilanz"), SQLDataType.NUMERIC(10, 2), this, "");

    private Zutat(Name alias, Table<ZutatRecord> aliased) {
        this(alias, aliased, null);
    }

    private Zutat(Name alias, Table<ZutatRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.zutat</code> table reference
     */
    public Zutat(String alias) {
        this(DSL.name(alias), ZUTAT);
    }

    /**
     * Create an aliased <code>public.zutat</code> table reference
     */
    public Zutat(Name alias) {
        this(alias, ZUTAT);
    }

    /**
     * Create a <code>public.zutat</code> table reference
     */
    public Zutat() {
        this(DSL.name("zutat"), null);
    }

    public <O extends Record> Zutat(Table<O> child, ForeignKey<O, ZutatRecord> key) {
        super(child, key, ZUTAT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<ZutatRecord> getPrimaryKey() {
        return Keys.ZUTAT_PKEY;
    }

    @Override
    public List<ForeignKey<ZutatRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ZUTAT__ZUTAT_LIEFERANTENNR_FKEY);
    }

    private transient Lieferant _lieferant;

    /**
     * Get the implicit join path to the <code>public.lieferant</code> table.
     */
    public Lieferant lieferant() {
        if (_lieferant == null)
            _lieferant = new Lieferant(this, Keys.ZUTAT__ZUTAT_LIEFERANTENNR_FKEY);

        return _lieferant;
    }

    @Override
    public Zutat as(String alias) {
        return new Zutat(DSL.name(alias), this);
    }

    @Override
    public Zutat as(Name alias) {
        return new Zutat(alias, this);
    }

    @Override
    public Zutat as(Table<?> alias) {
        return new Zutat(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Zutat rename(String name) {
        return new Zutat(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Zutat rename(Name name) {
        return new Zutat(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Zutat rename(Table<?> name) {
        return new Zutat(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<Integer, String, String, BigDecimal, BigDecimal, Integer, Integer, Integer, BigDecimal, BigDecimal, BigDecimal> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function11<? super Integer, ? super String, ? super String, ? super BigDecimal, ? super BigDecimal, ? super Integer, ? super Integer, ? super Integer, ? super BigDecimal, ? super BigDecimal, ? super BigDecimal, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function11<? super Integer, ? super String, ? super String, ? super BigDecimal, ? super BigDecimal, ? super Integer, ? super Integer, ? super Integer, ? super BigDecimal, ? super BigDecimal, ? super BigDecimal, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
