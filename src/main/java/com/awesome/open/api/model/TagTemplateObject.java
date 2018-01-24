package com.awesome.open.api.model;

import io.swagger.v3.oas.models.tags.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 24.01.2018
 */
public class TagTemplateObject {

    private Tag tag;
    private List<OperationTemplateObject> operations = new ArrayList<OperationTemplateObject>();

    public Tag getTag() {
        return tag;
    }

    public TagTemplateObject setTag(Tag tag) {
        this.tag = tag;
        return this;
    }

    public List<OperationTemplateObject> getOperations() {
        return operations;
    }

    public TagTemplateObject setOperationTemplateObjects(List<OperationTemplateObject> operations) {
        this.operations = operations;
        return this;
    }

    public TagTemplateObject addOperation(OperationTemplateObject operation) {
        operations.add(operation);
        return this;
    }
}
