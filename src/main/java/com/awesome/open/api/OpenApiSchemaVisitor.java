package com.awesome.open.api;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.tags.Tag;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 17.01.2018
 */
public class OpenApiSchemaVisitor {

    public void visit(OpenAPI schema) {
        visit(schema.getInfo());
        visit(schema.getPaths());
        visit(schema.getComponents());

        if (schema.getTags() == null) return;

        for (Tag tag : schema.getTags()) {
            visit(tag);
        }
    }

    public void visit(Tag tag) {
        handelDescription(tag);
    }

    public void visit(Info info) {
        handelDescription(info);
    }

    public void visit(Paths paths) {
        for (PathItem pathItem : paths.values()) {
            visit(pathItem);
        }
    }

    public void visit(PathItem pathItem) {
        handelDescription(pathItem);

        visit(pathItem.getGet());
        visit(pathItem.getPost());
        visit(pathItem.getPut());
        visit(pathItem.getDelete());
        visit(pathItem.getPatch());
        //TODO: Add other operations
    }

    public void visit(Operation operation) {
        if (operation == null) return;

        handelDescription(operation);


        visit(operation.getRequestBody());

        if (operation.getParameters() != null) {
            for (Parameter parameter : operation.getParameters()) {
                visit(parameter);
            }
        }

        if (operation.getResponses() != null) {
            for (ApiResponse apiResponse : operation.getResponses().values()) {
                visit(apiResponse);
            }
        }
    }

    public void visit(Parameter parameter) {
        handelDescription(parameter);
    }

    public void visit(RequestBody requestBody) {
        if (requestBody == null) return;

        handelDescription(requestBody);

        visit(requestBody.getContent());
    }

    public void visit(ApiResponse apiResponse) {
        handelDescription(apiResponse);

        visit(apiResponse.getContent());
    }

    public void visit(Content content) {
        if (content == null) return;
        for (MediaType mediaType : content.values()) {
            visit(mediaType.getSchema());
        }
    }

    public void visit(Components components) {
        for (Schema schema : components.getSchemas().values()) {
            visit(schema);
        }
    }

    public void visit(Schema schema) {
        handelDescription(schema);
        handleExample(schema);
    }

    public void handleExample(Schema schema) {}

    public void handelDescription(Object descriptionObject) {}

}
