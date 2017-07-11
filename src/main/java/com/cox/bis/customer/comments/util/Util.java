package com.cox.bis.customer.comments.util;

import java.util.List;
import java.util.Map;

import com.cox.bis.customer.comments.exception.BusinessException;

public class Util {
	
	/***
	 * Method: isNullEmpty Description: checks if object is Null or Empty
	 * 
	 * @category method
	 * @author jahill
	 * @param object
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static Boolean isNullEmpty(Object object) {
		Boolean isNullOrEmpty = Boolean.FALSE;
		if (object == null) isNullOrEmpty = Boolean.TRUE;
		else if (object instanceof String && ((String) object).trim().equals("")) isNullOrEmpty = Boolean.TRUE;
		return isNullOrEmpty;
	}

	/***
	 * Method: isNullEmpty Description: checks if List is Null or Empty
	 * 
	 * @category method
	 * @author jahill
	 * @param object
	 *            Object
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("rawtypes")
	public static Boolean isNullEmpty(List<?> object) {
		Boolean isNullOrEmpty = Boolean.FALSE;
		if (object == null) isNullOrEmpty = Boolean.TRUE;
		else if (object instanceof List && ((List) object).isEmpty()) isNullOrEmpty = Boolean.TRUE;
		return isNullOrEmpty;
	}

	/***
	 * Method: isNullEmpty Description: checks if Map is Null or Empty
	 * 
	 * @category method
	 * @author jahill
	 * @param object
	 *            Object
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("rawtypes")
	public static Boolean isNullEmpty(Map<?, ?> object) {
		Boolean isNullOrEmpty = Boolean.FALSE;
		if (object == null) isNullOrEmpty = Boolean.TRUE;
		else if (object instanceof Map && ((Map) object).isEmpty()) isNullOrEmpty = Boolean.TRUE;
		return isNullOrEmpty;
	}
	
	public static Boolean isNotNullEmpty(Object object) {
		Boolean isNotNullOrEmpty = Boolean.TRUE;
		if (object == null) isNotNullOrEmpty = Boolean.FALSE;
		else if (object instanceof String && ((String) object).trim().equals("")) isNotNullOrEmpty = Boolean.FALSE;
		return isNotNullOrEmpty;
	}
	
	public static String[] splitText(String text, int maxLength) throws BusinessException {
		text = text.trim();
		if (text == null || text.isEmpty()) {
			throw new BusinessException("SPLIT_TEXT_FAILURE" + "- The 'text' input for Util.splitText is null or empty");
		} else if (text.length() <= maxLength) { return new String[] { text }; }
		// Generate temporary array length
		String[] tempText = new String[(int) Math.round((double) text.length() / (double) maxLength) * 2];
		String[] splitText = null;
		if (!(text == null || text.isEmpty())) {
			int textIndex = 0;
			int i = 0;
			// Loop through string by 40 characters segments
			while (text.length() > 0) {
				// Break line on (1) less than 40 characters long, (2) 40 character segment minus lastIndexOf <SPACE> to keep words together, (3) 40 character segment if no <SPACE> in last 15
				// characters *break long words over 15 characters
				textIndex = (text.length() > maxLength) ? (text.substring(maxLength - 15, maxLength).contains(" ")) ? text.substring(0, maxLength).lastIndexOf(" ") + 1 : maxLength : text.length();
				tempText[i] = text.substring(0, textIndex);
				text = text.substring(textIndex, text.length());
				i++;
			}
			// New splitText[] Array for Return, *exact Array length based on iteration count and transfer elements from tempText[]
			splitText = new String[i];
			for (int j = 0; j < i; j++)
				splitText[j] = tempText[j];
		}
		return splitText;
	}

}
