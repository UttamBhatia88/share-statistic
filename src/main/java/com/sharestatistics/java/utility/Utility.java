/**
 * Copyright (c) 2014. All rights reserved.
 **/
package com.sharestatistics.java.utility;

import java.util.Collections;
import java.util.List;

/**
 * The Utility program is for sorting purpose written at on place
 * in order to avoid code scattering or for re-usability.
 *
 * @author Uttam Bhatia
 * @version 1.0
 * @since   2014-05-14 
 *
 */
public class Utility {

	/**
	 * @param list: a generic utility method to sort a list.
	 */
	public static <E extends Comparable> void sort(List<E> list){
		Collections.sort(list);
	}
	
}
