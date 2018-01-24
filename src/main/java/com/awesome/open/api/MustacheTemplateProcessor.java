package com.awesome.open.api;

import com.awesome.open.api.mustache.CustomMustacheFactory;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.github.mustachejava.reflect.ReflectionObjectHandler;
import com.github.mustachejava.reflect.SimpleObjectHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 18.01.2018
 */
public class MustacheTemplateProcessor implements TemplateProcessor {

    private Writer writer;

    public MustacheTemplateProcessor(Writer writer) {
        this.writer = writer;
    }

    public static TemplateProcessor getInstans() {
        return new MustacheTemplateProcessor(new StringWriter());
    }

    public Writer process(String location, Object objectToProcess) {
        DefaultMustacheFactory mf = new CustomMustacheFactory();

        mf.setObjectHandler(new MapMethodReflectionHandler());

        Mustache mustache = mf.compile(location);

        try {
            mustache.execute(writer, objectToProcess).flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return writer;
    }

    private class MapMethodReflectionHandler extends ReflectionObjectHandler {
        @Override
        protected boolean areMethodsAccessible(Map<?, ?> map) {
            return true;
        }
    }
}
