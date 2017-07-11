package com.cox.bis.customer.comments.dao;


import com.cox.bis.customer.comments.dao.model.SearchCustomerCommentsRequest;
import com.cox.bis.customer.comments.dao.model.SearchCustomerCommentsResponse;

public interface CustomerCommentsXHAStageDAO {
	public SearchCustomerCommentsResponse searchCustomerComment(SearchCustomerCommentsRequest searchCommentsRequest) throws Exception;
}