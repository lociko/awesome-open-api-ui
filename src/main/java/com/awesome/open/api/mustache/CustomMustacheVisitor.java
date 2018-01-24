package com.awesome.open.api.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.DefaultMustacheVisitor;
import com.github.mustachejava.TemplateContext;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 24.01.2018
 */
public class CustomMustacheVisitor extends DefaultMustacheVisitor {
    public CustomMustacheVisitor(DefaultMustacheFactory df) {
        super(df);
    }

    @Override
    public void value(TemplateContext tc, String variable, boolean encoded) {
        super.value(tc, variable, false);
    }
}
