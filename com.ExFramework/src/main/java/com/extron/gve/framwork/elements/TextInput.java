package com.extron.gve.framwork.elements;

import com.extron.gve.framework.elements.base.Element;
import com.extron.gve.framework.elements.base.ImplementedBy;

/**
 * Text field functionality
 */
@ImplementedBy(TextInputImpl.class)
public interface TextInput extends Element {
	/**
	 * Takes given text and enters it into the field
	 * 
	 * @param text
	 *            the Text to type into the field
	 */
	void set(String text);
}



