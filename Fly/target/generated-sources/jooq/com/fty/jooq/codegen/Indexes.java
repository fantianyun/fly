/*
 * This file is generated by jOOQ.
 */
package com.fty.jooq.codegen;


import com.fty.jooq.codegen.tables.Blog;
import com.fty.jooq.codegen.tables.MallAd;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>smallprogram</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index BLOG_PRIMARY = Indexes0.BLOG_PRIMARY;
    public static final Index MALL_AD_PRIMARY = Indexes0.MALL_AD_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index BLOG_PRIMARY = Internal.createIndex("PRIMARY", Blog.BLOG, new OrderField[] { Blog.BLOG.ID }, true);
        public static Index MALL_AD_PRIMARY = Internal.createIndex("PRIMARY", MallAd.MALL_AD, new OrderField[] { MallAd.MALL_AD.AD_ID }, true);
    }
}
