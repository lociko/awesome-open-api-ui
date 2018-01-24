package com.awesome.open.api;

import io.swagger.v3.oas.models.tags.Tag;
import org.junit.Test;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 24.01.2018
 */
public class OpenApiSchemaProcessorTest {

    @Test
    public void testName() throws Exception {
        Tag tag = new Tag().description("test\n\n<table></table>");
        new OpenApiSchemaProcessor().handelDescription(tag);

    }
}