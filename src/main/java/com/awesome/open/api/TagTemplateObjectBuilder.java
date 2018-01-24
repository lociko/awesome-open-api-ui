package com.awesome.open.api;

import com.awesome.open.api.model.OperationTemplateObject;
import com.awesome.open.api.model.TagTemplateObject;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.tags.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 17.01.2018
 */
public class TagTemplateObjectBuilder extends OpenApiSchemaVisitor {
    private Map<String, TagTemplateObject> operationByTag;

    private String currentPath;

    public TagTemplateObjectBuilder() {
        operationByTag = new HashMap<String, TagTemplateObject>();
    }

    @Override
    public void visit(Tag tag) {
        super.visit(tag);
        if (operationByTag.get(tag.getName()) == null) {
            operationByTag.put(tag.getName(), new TagTemplateObject()
                    .setTag(tag));
        } else {
            operationByTag.get(tag.getName()).setTag(tag);
        }
    }

    @Override
    public void visit(Paths paths) {
        if (paths == null) return;

        for (String path : paths.keySet()) {
            currentPath = path;
            visit(paths.get(path));
        }
    }

    @Override
    public void visit(Operation operation) {
        super.visit(operation);
        if (operation == null) return;
        if (operation.getTags() == null) return;

        for (String tag : operation.getTags()) {

            OperationTemplateObject op = new OperationTemplateObject()
                    .setPath(currentPath)
                    .setOperation(operation);

            if (operationByTag.get(tag) != null) {
                operationByTag.get(tag).getOperations().add(op);
            } else {
                operationByTag.put(tag, new TagTemplateObject()
                        .addOperation(op));
            }
        }
    }

    public List<TagTemplateObject> build(OpenAPI openAPI) {
        visit(openAPI);

        return new ArrayList<TagTemplateObject>(operationByTag.values());
    }
}
