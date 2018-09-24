package com.timo;

import org.junit.Test;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author qinlinsen
 * @since 2018-09-23 秋分
 */
public class CustomerDateEditorTest {
	private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
	private static final String DATE_EXAMPLE_TEXT = "2018-09-23";
	@Test
	public void testSetAsText(){
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
		CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, true);
		customDateEditor.setAsText(DATE_EXAMPLE_TEXT);
		String date = customDateEditor.getAsText();
		System.out.println(date);
	}
}
