package com.awesome.open.api;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import io.swagger.v3.oas.models.examples.Example;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.Writer;

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

    public Object processor(String location, Object objectToProcess) {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(location);

        try {
            mustache.execute(writer, objectToProcess).flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
