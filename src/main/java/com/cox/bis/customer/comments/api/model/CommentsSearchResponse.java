package com.cox.bis.customer.comments.api.model;


import java.io.Serializable;
import java.util.List;

import com.cox.bis.customer.comments.model.CustomerComment;

public class CommentsSearchResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7981124347136945658L;
	private List<CustomerComment> customerComments;
	
	public CommentsSearchResponse() {

	}
	


	/**
	 * @return the customerComments
	 */
	public List<CustomerComment> getCustomerComments() {
		return customerComments;
	}
	
	/**
	 * @param customerComments
	 *            the customerComments to set
	 */
	public void setCustomerComments(List<CustomerComment> customerComments) {
		this.customerComments = customerComments;
	}
}