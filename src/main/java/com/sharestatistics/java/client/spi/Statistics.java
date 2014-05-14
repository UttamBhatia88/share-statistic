/**
 * Copyright (c) 2014. All rights reserved.
 **/
package com.sharestatistics.java.client.spi;

import java.util.Collection;

import com.sharestatistics.java.client.ClientDto;
import com.sharestatistics.java.client.api.IStatistics;
import com.sharestatistics.java.dataloader.IDataLoader;
import com.sharestatistics.java.dataloader.InMemoryDataLoader;
import com.sharestatistics.java.domain.ShareHoldingVO;
import com.sharestatistics.java.utility.CopyObject;

/**
 * The Statistics is a concrete class to serve all the 
 * user request
 *
 * @author Uttam Bhatia
 * @version 1.0
 * @since   2014-05-14 
 *
 */
public class Statistics implements IStatistics{

	private IDataLoader loader=new InMemoryDataLoader();
	/** (non-Javadoc)
	 * @see com.sharestatistics.java.client.api.IStatistics#getMaxShareHoldingDetail(java.lang.String)
	 */
	@Override
	public ClientDto getMaxShareHoldingDetail(String companyName) {

		ClientDto clientDto=new ClientDto();
		ShareHoldingVO data= loader.load(companyName);
		CopyObject.copyShareHoldingToClientDto(data, clientDto);
		System.out.print("Comp Name:"+companyName+" price:"+data.getTotalShares());
		return clientDto;
	}
	/** (non-Javadoc)
	 * @see com.sharestatistics.java.client.api.IStatistics#getCompanyName()
	 */
	@Override
	public String[] getCompanyName() {
		Collection<String> nameSet=loader.getCompanyNames().values();
		String[] companyNames=new String[nameSet.size()];
		nameSet.toArray(companyNames);
		return companyNames;
	}

}
