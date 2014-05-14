/**
 * Copyright (c) 2014. All rights reserved.
 **/
package com.sharestatistics.java.client;

import com.sharestatistics.java.client.api.IStatistics;
import com.sharestatistics.java.client.spi.Statistics;

/**
 * The TestClient program is a simple stand-alone console based program 
 * to test the back-end functionality.
 * 
 * @author Uttam Bhatia
 * @version 1.0
 * @since   2014-05-14 
 *
 */
public class TestClient {
	public static void main(String[] args) {

		IStatistics stat=new Statistics();
		stat.getMaxShareHoldingDetail("Company A");
		
	}
}
