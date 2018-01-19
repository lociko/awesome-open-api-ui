package com.awesome.open.api;

import java.io.Writer;
import java.util.Objects;

/**
 * @author Vasyl Spachynskyi
 * @version $Id: Id $
 * @since 18.01.2018
 */
public interface TemplateProcessor {

    Writer process(String location, Object o);
}
