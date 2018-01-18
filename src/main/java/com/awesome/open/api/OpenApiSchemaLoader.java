package com.awesome.open.api;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 18.01.2018
 */
public class OpenApiSchemaLoader {

    public OpenAPI read(String location) {
        return new OpenAPIParser().readLocation(location, null, null).getOpenAPI();
    }
}
