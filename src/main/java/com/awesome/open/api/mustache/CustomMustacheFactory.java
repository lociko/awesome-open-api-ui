package com.awesome.open.api.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheVisitor;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 24.01.2018
 */
public class CustomMustacheFactory extends DefaultMustacheFactory {

    @Override
    public MustacheVisitor createMustacheVisitor() {
        return new CustomMustacheVisitor(this);
    }
}
