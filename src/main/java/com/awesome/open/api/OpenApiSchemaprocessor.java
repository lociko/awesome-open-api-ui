package com.awesome.open.api;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 17.01.2018
 */
public class OpenApiSchemaProcessor extends OpenApiSchemaVisitor {
    private static final String DESCRIPTION_FIELD = "description";

    public void handelDescription(Object descriptionObject) {
        if (descriptionObject == null) return;

        String value = get(descriptionObject, DESCRIPTION_FIELD);
        if (value == null) return;

        Parser parser = Parser.builder().build();
        Node document = parser.parse(value);
        HtmlRenderer renderer = getCommonMarkHtmlRender();

        String result = renderer.render(document);
        set(descriptionObject, DESCRIPTION_FIELD, result);
    }

    private HtmlRenderer getCommonMarkHtmlRender() {
        return HtmlRenderer.builder()
                .attributeProviderFactory(new AttributeProviderFactory() {
                    public AttributeProvider create(AttributeProviderContext context) {
                        return new TableProvider();
                    }
                })
                .build();
    }

    public String get(Object object, String fieldName) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                return (String) field.get(object);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        throw new IllegalArgumentException("The object: " + object + " is not support descriptions.");
    }

    public boolean set(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
                return true;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return false;
    }

    class TableProvider implements AttributeProvider {

        public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
            //TODO: add attributes
        }
    }
}
