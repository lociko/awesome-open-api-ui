package com.awesome.open.api;

import com.awesome.open.api.model.OperationTemplateObject;
import com.awesome.open.api.model.TagTemplateObject;
import io.swagger.v3.oas.models.OpenAPI;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 17.01.2018
 */
public class OpenApiDocumentationBuilder {

    private OpenAPI openAPI;

    public OpenApiDocumentationBuilder() {
    }

    public OpenApiDocumentationBuilder init(OpenAPI openAPI) {
        this.openAPI = openAPI;

        return this;
    }

    public Writer build() {
        Map<String, Object> scopes = new HashMap<String, Object>();
        scopes.put("body", buildTags(openAPI));

        return MustacheTemplateProcessor.getInstans().process("templates/baseTemplate.mustache", scopes);
    }

    private Writer buildTags(OpenAPI openAPI) {
        List<TagTemplateObject> tagTemplateObjects = new TagTemplateObjectBuilder().build(openAPI);

        StringWriter resultWriter = new StringWriter();
        for (TagTemplateObject templateObject : tagTemplateObjects) {
            resultWriter.append(MustacheTemplateProcessor.getInstans()
                    .process("templates/tagTemplate.mustache", templateObject.getTag()).toString());

            resultWriter.append(buildOperations(templateObject).toString());

        }
        return resultWriter;
    }

    private Writer buildOperations(TagTemplateObject templateObject) {
        StringWriter resultWriter = new StringWriter();

        for (OperationTemplateObject operation : templateObject.getOperations()) {
            resultWriter.append(MustacheTemplateProcessor.getInstans()
                    .process("templates/operationTemplate.mustache", operation).toString());
        }
        return resultWriter;
    }
}
