/*
 * This file is generated by jOOQ.
 */
package jooq_gen.tables.records;


import jooq_gen.tables.Zutateigenschaft;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ZutateigenschaftRecord extends TableRecordImpl<ZutateigenschaftRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.zutateigenschaft.zutatnr</code>.
     */
    public ZutateigenschaftRecord setZutatnr(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.zutateigenschaft.zutatnr</code>.
     */
    public Integer getZutatnr() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.zutateigenschaft.eigenschaftid</code>.
     */
    public ZutateigenschaftRecord setEigenschaftid(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.zutateigenschaft.eigenschaftid</code>.
     */
    public Integer getEigenschaftid() {
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
        return Zutateigenschaft.ZUTATEIGENSCHAFT.ZUTATNR;
    }

    @Override
    public Field<Integer> field2() {
        return Zutateigenschaft.ZUTATEIGENSCHAFT.EIGENSCHAFTID;
    }

    @Override
    public Integer component1() {
        return getZutatnr();
    }

    @Override
    public Integer component2() {
        return getEigenschaftid();
    }

    @Override
    public Integer value1() {
        return getZutatnr();
    }

    @Override
    public Integer value2() {
        return getEigenschaftid();
    }

    @Override
    public ZutateigenschaftRecord value1(Integer value) {
        setZutatnr(value);
        return this;
    }

    @Override
    public ZutateigenschaftRecord value2(Integer value) {
        setEigenschaftid(value);
        return this;
    }

    @Override
    public ZutateigenschaftRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ZutateigenschaftRecord
     */
    public ZutateigenschaftRecord() {
        super(Zutateigenschaft.ZUTATEIGENSCHAFT);
    }

    /**
     * Create a detached, initialised ZutateigenschaftRecord
     */
    public ZutateigenschaftRecord(Integer zutatnr, Integer eigenschaftid) {
        super(Zutateigenschaft.ZUTATEIGENSCHAFT);

        setZutatnr(zutatnr);
        setEigenschaftid(eigenschaftid);
    }
}
