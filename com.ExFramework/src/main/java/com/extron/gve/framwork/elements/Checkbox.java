import com.extron.gve.framework.elements.base.Element;
import com.extron.gve.framework.elements.base.ImplementedBy;

/**
 * Interface that wraps a WebElement in CheckBox functionality. See
 * https://github.com/elisarver/selophane/ for reference.
 *
 */
@ImplementedBy(CheckBoxImpl.class)
public interface CheckBox extends Element {
	/**
	 * Checks checkbox if it's unchecked.
	 */
	void check();

	/**
	 * Check if checkbox is selected, and return true if so.
	 * 
	 * @return true if checkbox is checked, return false otherwise.
	 */
	boolean isChecked();

	/**
	 * Toggles the state of the checkbox.
	 */
	void toggle();

	/**
	 * Unchecks checkbox if its checked.
	 */
	void uncheck();
}

















