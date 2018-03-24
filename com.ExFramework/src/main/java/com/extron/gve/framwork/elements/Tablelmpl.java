package com.extron.gve.framwork.elements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.extron.gve.framework.elements.base.ElementImpl;

/**
 * Table wrapper for WebElements
 */
public class TableImpl extends ElementImpl implements Table {

	/**
	 * Creates a Table for the given WebElement
	 * 
	 * @param element
	 *            element to wrap in Table wrapper
	 */
	public TableImpl(WebElement element) {
		super(element);
	}

	@Override
	public WebElement getCellAtIndex(int rowIdx, int colIdx) {
		// Grab the row at the rowIdx
		WebElement row = getRows().get(rowIdx);
		List<WebElement> cells;

		// Cells are most likely to be td tags, so early return case
		if ((cells = row.findElements(By.tagName("td"))).size() > 0) {
			return cells.get(colIdx);
		}

		// If Cells are not td, try th tags
		else if ((cells = row.findElements(By.tagName("th"))).size() > 0) {
			return cells.get(colIdx);
		}

		// Cell was not found for index, throw error
		else {
			String error = String.format("Could not find cell at row: %s column: %s, throwing error.", rowIdx, colIdx);
			throw new RuntimeException(error);
		}
	}

	@Override
	public int getColumnCount() {
		return findElement(By.cssSelector("tr")).findElements(By.cssSelector("*")).size();
	}

	@Override
	public int getRowCount() {
		return getRows().size();
	}

	/**
	 * Gets all the rows in the table in order of header -> body -> footer
	 * 
	 * @return list of row WebElements on the Table
	 */
	private List<WebElement> getRows() {
		List<WebElement> rows = new ArrayList<WebElement>();

		// Header rows
		rows.addAll(findElements(By.cssSelector("thead tr")));

		// Body rows
		rows.addAll(findElements(By.cssSelector("tbody tr")));

		// Footer rows
		rows.addAll(findElements(By.cssSelector("tfoot tr")));

		return rows;
	}
}




