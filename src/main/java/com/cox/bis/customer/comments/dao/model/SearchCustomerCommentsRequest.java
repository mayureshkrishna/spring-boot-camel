package com.cox.bis.customer.comments.dao.model;

public class SearchCustomerCommentsRequest {
	private String siteId;
	private String accountNumber;
	private String startDate;
	private String endDate;
	private String max;
	private String sort;
	
	public SearchCustomerCommentsRequest() {
		//Empty Constructor...
	}
	/**
	 * @return the siteId
	 */
	public String getSiteId() {
		return siteId;
	}
	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	/**
	 * @return the accountNumber9
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber9 the accountNumber9 to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the maxSize
	 */
	public String getMax() {
		return max;
	}
	/**
	 * @param maxSize the maxSize to set
	 */
	public void setMax(String max) {
		this.max = max;
	}
	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
}