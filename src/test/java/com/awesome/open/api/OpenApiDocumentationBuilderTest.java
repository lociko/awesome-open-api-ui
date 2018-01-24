package com.awesome.open.api;

import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 18.01.2018
 */
public class OpenApiDocumentationBuilderTest {

    @Test
    public void shouldBuildSampleDoc() throws Exception {

        OpenAPI openAPI = new OpenApiSchemaLoader().read("/schema/sampleSchema.yaml");

        Writer writer = new OpenApiDocumentationBuilder()
                .init(openAPI)
                .build();

        File index = new File("target/generated-docs/index.html");

        index.createNewFile();

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("target/generated-docs/index.html"));
        fileWriter.write(writer.toString());
        fileWriter.close();
    }
}