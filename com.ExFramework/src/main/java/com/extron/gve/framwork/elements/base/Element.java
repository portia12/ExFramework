package com.extron.gve.framwork.elements.base;

package com.extron.gve.framework.elements.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

/**
 * Wraps a web element interface with extra functionality. See
 * https://github.com/elisarver/selophane/ for reference.
 */
@ImplementedBy(ElementImpl.class)
public interface Element extends WebElement, Locatable, WrapsElement {

	/**
	 * Returns true when the inner element is ready to be used.
	 *
	 * @return boolean true for an initialized WebElement, or false if we were
	 *         somehow passed a null WebElement.
	 */
	boolean elementWired();
}




