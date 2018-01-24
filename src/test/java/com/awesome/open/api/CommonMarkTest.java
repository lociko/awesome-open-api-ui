package com.awesome.open.api;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 24.01.2018
 */
public class CommonMarkTest {

    @Test
    public void testName() throws Exception {
        Parser parser = Parser.builder().build();
        Node document = parser.parse("This is *Sparta*");
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        Assert.assertEquals(renderer.render(document), ("<p>This is <em>Sparta</em></p>\n"));  // "<p>This is <em>Sparta</em></p>\n"
    }
}
