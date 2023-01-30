/*
 * This file is generated by jOOQ.
 */
package jooq_gen.tables;


import jooq_gen.Keys;
import jooq_gen.Public;
import jooq_gen.tables.records.ZutateigenschaftRecord;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Zutateigenschaft extends TableImpl<ZutateigenschaftRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.zutateigenschaft</code>
     */
    public static final Zutateigenschaft ZUTATEIGENSCHAFT = new Zutateigenschaft();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ZutateigenschaftRecord> getRecordType() {
        return ZutateigenschaftRecord.class;
    }

    /**
     * The column <code>public.zutateigenschaft.zutatnr</code>.
     */
    public final TableField<ZutateigenschaftRecord, Integer> ZUTATNR = createField(DSL.name("zutatnr"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.zutateigenschaft.eigenschaftid</code>.
     */
    public final TableField<ZutateigenschaftRecord, Integer> EIGENSCHAFTID = createField(DSL.name("eigenschaftid"), SQLDataType.INTEGER.nullable(false), this, "");

    private Zutateigenschaft(Name alias, Table<ZutateigenschaftRecord> aliased) {
        this(alias, aliased, null);
    }

    private Zutateigenschaft(Name alias, Table<ZutateigenschaftRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.zutateigenschaft</code> table reference
     */
    public Zutateigenschaft(String alias) {
        this(DSL.name(alias), ZUTATEIGENSCHAFT);
    }

    /**
     * Create an aliased <code>public.zutateigenschaft</code> table reference
     */
    public Zutateigenschaft(Name alias) {
        this(alias, ZUTATEIGENSCHAFT);
    }

    /**
     * Create a <code>public.zutateigenschaft</code> table reference
     */
    public Zutateigenschaft() {
        this(DSL.name("zutateigenschaft"), null);
    }

    public <O extends Record> Zutateigenschaft(Table<O> child, ForeignKey<O, ZutateigenschaftRecord> key) {
        super(child, key, ZUTATEIGENSCHAFT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<ForeignKey<ZutateigenschaftRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ZUTATEIGENSCHAFT__ZUTATEIGENSCHAFT_ZUTATNR_FKEY, Keys.ZUTATEIGENSCHAFT__ZUTATEIGENSCHAFT_EIGENSCHAFTID_FKEY);
    }

    private transient Zutat _zutat;
    private transient Eigenschaften _eigenschaften;

    /**
     * Get the implicit join path to the <code>public.zutat</code> table.
     */
    public Zutat zutat() {
        if (_zutat == null)
            _zutat = new Zutat(this, Keys.ZUTATEIGENSCHAFT__ZUTATEIGENSCHAFT_ZUTATNR_FKEY);

        return _zutat;
    }

    /**
     * Get the implicit join path to the <code>public.eigenschaften</code>
     * table.
     */
    public Eigenschaften eigenschaften() {
        if (_eigenschaften == null)
            _eigenschaften = new Eigenschaften(this, Keys.ZUTATEIGENSCHAFT__ZUTATEIGENSCHAFT_EIGENSCHAFTID_FKEY);

        return _eigenschaften;
    }

    @Override
    public Zutateigenschaft as(String alias) {
        return new Zutateigenschaft(DSL.name(alias), this);
    }

    @Override
    public Zutateigenschaft as(Name alias) {
        return new Zutateigenschaft(alias, this);
    }

    @Override
    public Zutateigenschaft as(Table<?> alias) {
        return new Zutateigenschaft(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Zutateigenschaft rename(String name) {
        return new Zutateigenschaft(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Zutateigenschaft rename(Name name) {
        return new Zutateigenschaft(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Zutateigenschaft rename(Table<?> name) {
        return new Zutateigenschaft(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}