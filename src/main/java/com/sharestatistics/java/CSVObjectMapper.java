/**
 * Copyright (c) 2014. All rights reserved.
 **/

package com.sharestatistics.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sharestatistics.java.domain.ShareHoldingVO;

/**
 * The CSVObjectMapper program implements an application that
 * parse a csv file and map the result-set to an object.
 *
 * @author Uttam Bhatia
 * @version 1.0
 * @since   2014-05-14 
 *
 */
public class CSVObjectMapper {

	private Map<String,String> companyName = new HashMap<String,String>();
	private String csvFileToRead = "csvFiles/csvToRead.csv";

	private BufferedReader br = null;
	private String row = "";
	private String splitBy = ",";

	/**
	 * @return Map<String,List<ShareHoldings>>: containing key value pair of company name and list of all its records till date.
	 * 
	 * To make the search faster store all the csv file data in-memory.
	 */
	public Map<String,List<ShareHoldingVO>> csvToObjectMapper() {

		Map<String,List<ShareHoldingVO>> mapList = new HashMap<String,List<ShareHoldingVO>>();

		try {

			int count=0;
			br = new BufferedReader(new FileReader(csvFileToRead));
			while ((row = br.readLine()) != null) {

				String[] columns = row.split(splitBy);

				if(count==0){
					for(int i=2;i<columns.length;i++){
						List<ShareHoldingVO> list=new ArrayList<ShareHoldingVO>();
						if(columns[i]!=null && !columns[i].equalsIgnoreCase("")){
							companyName.put(i+"", columns[i].trim());
							mapList.put(columns[i].trim(),list);
						}

					}
					count++;
				}else{

					resultSetMap(mapList, columns);

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return mapList;
	}

	/**
	 * @param mapList
	 * @param columns
	 */
	private void resultSetMap(Map<String, List<ShareHoldingVO>> mapList,
			String[] columns) {

		for(int i=2;i<columns.length;i++){

			ShareHoldingVO carObject = new ShareHoldingVO();

			if(columns[0]!=null && !columns[0].equalsIgnoreCase("")){
				carObject.setYear(columns[0]);
			}else{
				carObject.setYear("");
			}
			if(columns[1]!=null && !columns[1].equalsIgnoreCase("")){
				carObject.setMonth(columns[1]);
			}else{
				carObject.setMonth("");
			}

			if(columns[i]!=null && !columns[i].equalsIgnoreCase("")){
				carObject.setTotalShares(Long.parseLong(columns[i].trim()));
			}else{
				carObject.setTotalShares(0);
			}
			mapList.get(companyName.get(i+"")).add(carObject);
		}
	}

	public Map<String,String> getCompanyNames(){
		return this.companyName;
	}

}
