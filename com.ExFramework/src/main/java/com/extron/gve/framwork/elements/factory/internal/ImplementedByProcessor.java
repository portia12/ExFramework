package com.extron.gve.framwork.elements.factory.internal;

import com.extron.gve.framework.elements.base.Element;
import com.extron.gve.framework.elements.base.ImplementedBy;

/**
 * Processes the iface type into a useful class reference for wrapping
 * WebElements. See https://github.com/elisarver/selophane/ for reference.
 */
public final class ImplementedByProcessor {
	/**
	 * Gets the wrapper class (descended from ElementImpl) for the
	 * annotation @ImplementedBy.
	 *
	 * @param iface
	 *            iface to process for annotations
	 * @param <T>
	 *            type of the wrapped class.
	 * @return The class name of the class in question
	 */
	public static <T> Class<?> getWrapperClass(Class<T> iface) {
		if (iface.isAnnotationPresent(ImplementedBy.class)) {
			ImplementedBy annotation = iface.getAnnotation(ImplementedBy.class);
			Class<?> clazz = annotation.value();
			if (Element.class.isAssignableFrom(clazz)) {
				return annotation.value();
			}
		}
		throw new UnsupportedOperationException("Apply @ImplementedBy interface to your Interface "
				+ iface.getCanonicalName() + " if you want to extend ");
	}

	private ImplementedByProcessor() {
	}

}

