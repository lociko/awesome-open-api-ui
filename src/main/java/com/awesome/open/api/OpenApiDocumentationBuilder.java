package com.awesome.open.api;

import io.swagger.v3.oas.models.Operation;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 17.01.2018
 */
public class OpenApiDocumentationBuilder {

    private List<Operation> operations = new ArrayList<Operation>();
    private TemplateProcessor templateProcessor;

    public OpenApiDocumentationBuilder(TemplateProcessor templateProcessor) {
        this.templateProcessor = templateProcessor;
    }

    public OpenApiDocumentationBuilder init() {
        return this;
    }

    public OpenApiDocumentationBuilder addOperation(Operation operation) {
        operations.add(operation);
        return this;
    }

    public void build() {

        for (Operation operation : operations) {
            templateProcessor.process("templates/operationTemplate.mustache", operation);
        }

    }
}
