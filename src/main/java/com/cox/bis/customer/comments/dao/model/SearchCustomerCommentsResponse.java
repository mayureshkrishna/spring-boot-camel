package com.cox.bis.customer.comments.dao.model;

import java.util.List;

import com.cox.bis.customer.comments.model.CustomerComment;

public class SearchCustomerCommentsResponse {
private List<CustomerComment> customerComments;
	
	public SearchCustomerCommentsResponse(Exception exception) {
	}

	public SearchCustomerCommentsResponse(List<CustomerComment> customerComments) {
		setCustomerComments(customerComments);
	}
	
	/**
	 * @return the customerComments
	 */
	public List<CustomerComment> getCustomerComments() {
		return customerComments;
	}

	/**
	 * @param customerComments the customerComments to set
	 */
	public void setCustomerComments(List<CustomerComment> customerComments) {
		this.customerComments = customerComments;
	}

}