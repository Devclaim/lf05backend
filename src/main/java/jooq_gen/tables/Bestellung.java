/*
 * This file is generated by jOOQ.
 */
package jooq_gen.tables;


import jooq_gen.Keys;
import jooq_gen.Public;
import jooq_gen.tables.records.BestellungRecord;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Function;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Bestellung extends TableImpl<BestellungRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.bestellung</code>
     */
    public static final Bestellung BESTELLUNG = new Bestellung();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BestellungRecord> getRecordType() {
        return BestellungRecord.class;
    }

    /**
     * The column <code>public.bestellung.bestellnr</code>.
     */
    public final TableField<BestellungRecord, Integer> BESTELLNR = createField(DSL.name("bestellnr"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.bestellung.bestelldatum</code>.
     */
    public final TableField<BestellungRecord, LocalDate> BESTELLDATUM = createField(DSL.name("bestelldatum"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.bestellung.rechnungsbetrag_brutto</code>.
     */
    public final TableField<BestellungRecord, BigDecimal> RECHNUNGSBETRAG_BRUTTO = createField(DSL.name("rechnungsbetrag_brutto"), SQLDataType.NUMERIC(10, 2), this, "");

    /**
     * The column <code>public.bestellung.rechnungsbetrag_netto</code>.
     */
    public final TableField<BestellungRecord, BigDecimal> RECHNUNGSBETRAG_NETTO = createField(DSL.name("rechnungsbetrag_netto"), SQLDataType.NUMERIC(10, 2), this, "");

    private Bestellung(Name alias, Table<BestellungRecord> aliased) {
        this(alias, aliased, null);
    }

    private Bestellung(Name alias, Table<BestellungRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.bestellung</code> table reference
     */
    public Bestellung(String alias) {
        this(DSL.name(alias), BESTELLUNG);
    }

    /**
     * Create an aliased <code>public.bestellung</code> table reference
     */
    public Bestellung(Name alias) {
        this(alias, BESTELLUNG);
    }

    /**
     * Create a <code>public.bestellung</code> table reference
     */
    public Bestellung() {
        this(DSL.name("bestellung"), null);
    }

    public <O extends Record> Bestellung(Table<O> child, ForeignKey<O, BestellungRecord> key) {
        super(child, key, BESTELLUNG);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<BestellungRecord, Integer> getIdentity() {
        return (Identity<BestellungRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<BestellungRecord> getPrimaryKey() {
        return Keys.BESTELLUNG_PKEY;
    }

    @Override
    public Bestellung as(String alias) {
        return new Bestellung(DSL.name(alias), this);
    }

    @Override
    public Bestellung as(Name alias) {
        return new Bestellung(alias, this);
    }

    @Override
    public Bestellung as(Table<?> alias) {
        return new Bestellung(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Bestellung rename(String name) {
        return new Bestellung(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bestellung rename(Name name) {
        return new Bestellung(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bestellung rename(Table<?> name) {
        return new Bestellung(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, LocalDate, BigDecimal, BigDecimal> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super Integer, ? super LocalDate, ? super BigDecimal, ? super BigDecimal, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super Integer, ? super LocalDate, ? super BigDecimal, ? super BigDecimal, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}