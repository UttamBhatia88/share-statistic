/**
 * Copyright (c) 2014. All rights reserved.
 **/
package com.sharestatistics.java.utility;

import com.sharestatistics.java.client.ClientDto;
import com.sharestatistics.java.domain.ShareHoldingVO;

/**
 * The CopyObject is an utility class to copy one object to 
 * another object. To avoid third party api i.e. DOZER mapping,
 * i have to do here.
 *
 * @author Uttam Bhatia
 * @version 1.0
 * @since   2014-05-14 
 *
 */
public class CopyObject {

	public static void copyShareHoldingToClientDto( ShareHoldingVO share, ClientDto clientDto){
		
		clientDto.setMonth(share.getMonth());
		clientDto.setYear(share.getYear());
		clientDto.setTotalShares(share.getTotalShares());
	}
}
