package com.learning.sc.propertyeditor;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		String newString = text.toUpperCase();
		setValue(newString);
	}

}
