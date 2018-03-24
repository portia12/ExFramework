package com.extron.gve.framwork.elements;

import org.openqa.selenium.WebElement;

import com.extron.gve.framework.elements.base.Element;
import com.extron.gve.framework.elements.base.ImplementedBy;

/**
 * Custom Element that provides Table functionality.
 */
@ImplementedBy(TableImpl.class)
public interface Table extends Element {

	/**
	 * Gets the WebElement of the cell at the specific index in the table
	 * 
	 * @param rowIdx
	 *            The zero based index of the row
	 * @param colIdx
	 *            The zero based index of the column
	 * @return the WebElement of the cell at the specified index
	 */
	WebElement getCellAtIndex(int rowIdx, int colIdx);

	/**
	 * Gets the number of columns in the table
	 * 
	 * @return int equal to the number of columns in the table
	 */
	int getColumnCount();

	/**
	 * Gets the number of rows in the table
	 * 
	 * @return int equal to the number of rows in the table
	 */
	int getRowCount();
}


