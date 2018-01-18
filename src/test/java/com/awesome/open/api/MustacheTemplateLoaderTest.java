package com.awesome.open.api;

import io.swagger.models.Response;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 18.01.2018
 */
public class MustacheTemplateLoaderTest {
    @Test
    public void testName() throws Exception {
        Info info = new Info()
                .description("The sample description")
                .title("Test API");

        StringWriter writer = new StringWriter();
        TemplateProcessor processor = new MustacheTemplateProcessor(writer);
        processor.processor("mustacheTemplates/sampleTemplate.mustache", info);

        assertEquals(writer.toString(),
                "# Test API\r\n" +
                "\r\n" +
                "The sample description");

    }
}