package com.awesome.open.api.model;

import io.swagger.v3.oas.models.Operation;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 24.01.2018
 */
public class OperationTemplateObject {

    private String path;
    private Operation operation;

    public String getPath() {
        return path;
    }

    public OperationTemplateObject setPath(String path) {
        this.path = path;
        return this;
    }

    public Operation getOperation() {
        return operation;
    }

    public OperationTemplateObject setOperation(Operation operation) {
        this.operation = operation;
        return this;
    }
}
