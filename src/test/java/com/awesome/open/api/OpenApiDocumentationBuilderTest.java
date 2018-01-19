package com.awesome.open.api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.*;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 18.01.2018
 */
public class OpenApiDocumentationBuilderTest {

    @Test
    public void shouldBuildSampleDoc() throws Exception {
        StringWriter writer = new StringWriter();
        TemplateProcessor processor = new MustacheTemplateProcessor(writer);

        Operation operation = new Operation()
                .description("Test operation")
                .summary("Test summary");

        new OpenApiDocumentationBuilder(processor)
                .addOperation(operation)
                .build();

        writer.toString();
    }

    @Test
    public void shouldBuildSampleDoc2() throws Exception {
        StringWriter writer = new StringWriter();
        TemplateProcessor processor = new MustacheTemplateProcessor(writer);

        OpenAPI openAPI = new OpenApiSchemaLoader().read("/schema/sampleSchema.yaml");
        Operation operation = openAPI.getPaths().get("/pets").getGet();

        new OpenApiDocumentationBuilder(processor)
                .addOperation(operation)
                .build();

        writer.toString();

    }
}