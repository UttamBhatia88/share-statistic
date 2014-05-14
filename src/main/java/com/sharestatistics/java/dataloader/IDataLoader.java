/**
 * Copyright (c) 2014. All rights reserved.
 **/
package com.sharestatistics.java.dataloader;

import java.util.Map;

import com.sharestatistics.java.domain.ShareHoldingVO;
/**
 * The IDataLoader is an interface. In order to adopt a design principle
 * i prefer to code interface instead of giving client the concrete class.
 *
 * @author Uttam Bhatia
 * @version 1.0
 * @since   2014-05-14 
 *
 */
public interface IDataLoader {
	/**
	 * @param companyName
	 * @return
	 */
	public ShareHoldingVO load(final String companyName);
	/**
	 * @return
	 */
	public Map<String,String> getCompanyNames();
}
