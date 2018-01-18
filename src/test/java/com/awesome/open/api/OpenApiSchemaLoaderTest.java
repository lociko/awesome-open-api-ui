package com.awesome.open.api;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 18.01.2018
 */
public class OpenApiSchemaLoaderTest {

    @Test
    public void shouldLoadOpenApiSchema() throws Exception {
        assertNotNull(new OpenApiSchemaLoader().read("/schema/sampleSchema.yaml"));
    }
}