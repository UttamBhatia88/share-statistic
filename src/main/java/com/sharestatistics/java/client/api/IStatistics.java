/**
 * Copyright (c) 2014. All rights reserved.
 **/
package com.sharestatistics.java.client.api;

import com.sharestatistics.java.client.ClientDto;

/**
 * The IStatistics is an interface. In order to adopt a design principle
 * i prefer to code interface instead of giving client the concrete class.
 *
 * @author Uttam Bhatia
 * @version 1.0
 * @since   2014-05-14 
 *
 */
public interface IStatistics {

	/**
	 * @param companyName
	 * @return
	 */
	public ClientDto getMaxShareHoldingDetail(final String companyName);
	/**
	 * @return
	 */
	public String[] getCompanyName();
}
