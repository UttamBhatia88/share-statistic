/**
 * Copyright (c) 2014. All rights reserved.
 **/
package com.sharestatistics.java.client;

/**
 * The ClientDto is a DTO which contains data to be moved from server to client
 *  in case of server-client application.
 *
 * @author Uttam Bhatia
 * @version 1.0
 * @since   2014-05-14 
 *
 */
public class ClientDto {

	private String year;
	private String month;
	private long totalShares;

	/**
	 * @return year
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
	 * @return month
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
	 * @return totalShares
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

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		ClientDto other = (ClientDto) obj;
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
