/**
 * Copyright (c) 2014. All rights reserved.
 **/
package com.sharestatistics.java.domain;


/**
 * The ShareHoldingVO is a value object which contains data from csv file.
 *
 * @author Uttam Bhatia
 * @version 1.0
 * @since   2014-05-14 
 *
 */
public class ShareHoldingVO  implements Comparable<ShareHoldingVO>{
	private String year;
	private String month;
	private long totalShares;

	/**
	 * @return
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return
	 */
	public long getTotalShares() {
		return totalShares;
	}

	/**
	 * @param totalShares
	 */
	public void setTotalShares(long totalShares) {
		this.totalShares = totalShares;
	}

	/** (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ShareHoldingVO obj) {
      
		if(this.getTotalShares()==obj.getTotalShares()){
			return 0;
		}else if(this.getTotalShares() < obj.getTotalShares()){
			return 1;
		}else{
			return -1;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		ShareHoldingVO other = (ShareHoldingVO) obj;
		return totalShares == other.totalShares;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		long result = 1;
		result = prime * result
				+ ((totalShares == 0) ? 0 : totalShares);

		return (int) result;
	}
	
	@Override
	public  String toString()
	{
	    return "[Year.:" + this.year+",, "+"Month.:"
	                            +this.month +",, "+"Share Price:"
	                           +this.totalShares+"]";
	}
}
