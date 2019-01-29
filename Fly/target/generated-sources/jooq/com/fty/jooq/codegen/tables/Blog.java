/*
 * This file is generated by jOOQ.
 */
package com.fty.jooq.codegen.tables;


import com.fty.jooq.codegen.Indexes;
import com.fty.jooq.codegen.Keys;
import com.fty.jooq.codegen.Smallprogram;
import com.fty.jooq.codegen.tables.records.BlogRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Blog extends TableImpl<BlogRecord> {

    private static final long serialVersionUID = -30777885;

    /**
     * The reference instance of <code>smallprogram.blog</code>
     */
    public static final Blog BLOG = new Blog();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BlogRecord> getRecordType() {
        return BlogRecord.class;
    }

    /**
     * The column <code>smallprogram.blog.id</code>.
     */
    public final TableField<BlogRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>smallprogram.blog.title</code>.
     */
    public final TableField<BlogRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>smallprogram.blog.content</code>.
     */
    public final TableField<BlogRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a <code>smallprogram.blog</code> table reference
     */
    public Blog() {
        this(DSL.name("blog"), null);
    }

    /**
     * Create an aliased <code>smallprogram.blog</code> table reference
     */
    public Blog(String alias) {
        this(DSL.name(alias), BLOG);
    }

    /**
     * Create an aliased <code>smallprogram.blog</code> table reference
     */
    public Blog(Name alias) {
        this(alias, BLOG);
    }

    private Blog(Name alias, Table<BlogRecord> aliased) {
        this(alias, aliased, null);
    }

    private Blog(Name alias, Table<BlogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Blog(Table<O> child, ForeignKey<O, BlogRecord> key) {
        super(child, key, BLOG);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Smallprogram.SMALLPROGRAM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BLOG_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<BlogRecord, Integer> getIdentity() {
        return Keys.IDENTITY_BLOG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<BlogRecord> getPrimaryKey() {
        return Keys.KEY_BLOG_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<BlogRecord>> getKeys() {
        return Arrays.<UniqueKey<BlogRecord>>asList(Keys.KEY_BLOG_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Blog as(String alias) {
        return new Blog(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Blog as(Name alias) {
        return new Blog(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Blog rename(String name) {
        return new Blog(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Blog rename(Name name) {
        return new Blog(name, null);
    }
}
