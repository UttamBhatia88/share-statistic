/**
 * Copyright (c) 2014. All rights reserved.
 **/
package com.sharestatistics.java.dataloader;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import com.sharestatistics.java.CSVObjectMapper;
import com.sharestatistics.java.domain.ShareHoldingVO;
import com.sharestatistics.java.utility.Utility;

/**
 * The InMemoryDataLoader program cache all the data from csv file
 * in the form of map containing list records associated with a
 * company.
 *
 * @author Uttam Bhatia
 * @version 1.0
 * @since   2014-05-14 
 *
 */
public class InMemoryDataLoader implements IDataLoader{

	private static Map<String,List<ShareHoldingVO>> mapList;
	private static Map<String,String> companyName;
	
	static{
		if(mapList==null){
			CSVObjectMapper csvToJavaObject = new CSVObjectMapper();
			mapList=csvToJavaObject.csvToObjectMapper();
			companyName=csvToJavaObject.getCompanyNames();
		}
	}
	
	/** (non-Javadoc)
	 * @see com.sharestatistics.java.dataloader.IDataLoader#load(java.lang.String)
	 */
	@Override
	public ShareHoldingVO load(final String companyName){
		
		List<ShareHoldingVO> listData=mapList.get(companyName);
		Utility.sort(listData);
		TreeSet<ShareHoldingVO> tree=new TreeSet<ShareHoldingVO>(listData);
		SortedSet<ShareHoldingVO> stree=tree.headSet(listData.get(0));
		
		return listData.get(0);
		
	}

	/** (non-Javadoc)
	 * @see com.sharestatistics.java.dataloader.IDataLoader#getCompanyNames()
	 */
	@Override
	public Map<String, String> getCompanyNames() {
		return companyName;
	}
}
