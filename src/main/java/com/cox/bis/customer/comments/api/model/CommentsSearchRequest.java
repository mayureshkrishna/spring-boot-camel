package com.cox.bis.customer.comments.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Mayuresh Krishna
 *
 * 
 */
@ApiModel(description = "Customer Comments Search Request Object")
public class CommentsSearchRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2652675616025992144L;
	private String siteId;
	private String accountNumber;
	private String startDate;
	private String endDate;
	private String directives;

	public CommentsSearchRequest() {

	}

	/**
	 * @return the siteId
	 */
	@ApiModelProperty(value = "ICOMS Site ID", required = true)
	public String getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId
	 *            the siteId to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return the accountNumber
	 */
	@ApiModelProperty(value = "Customer Account Number", required = true)
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the directives
	 */
	public String getDirectives() {
		return directives;
	}

	/**
	 * @param directives
	 *            the directives to set
	 */
	public void setDirectives(String directives) {
		this.directives = directives;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}