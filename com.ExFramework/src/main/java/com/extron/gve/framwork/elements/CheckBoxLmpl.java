package com.extron.gve.framwork.elements;

package com.extron.gve.framework.elements;

import org.openqa.selenium.WebElement;

import com.extron.gve.framework.elements.base.ElementImpl;

/**
 * Wrapper class that wraps basic CheckBox functionality. See
 * https://github.com/elisarver/selophane/ for reference.
 *
 */
public class CheckBoxImpl extends ElementImpl implements CheckBox {

	/**
	 * Wraps a WebElement with CheckBox functionality
	 * 
	 * @param element
	 */
	public CheckBoxImpl(WebElement element) {
		super(element);
	}

	@Override
	public void check() {
		if (!isChecked()) {
			toggle();
		}
	}

	@Override
	public boolean isChecked() {
		return getWrappedElement().isSelected();
	}

	@Override
	public void toggle() {
		getWrappedElement().click();
	}

	@Override
	public void uncheck() {
		if (isChecked()) {
			toggle();
		}
	}
}

