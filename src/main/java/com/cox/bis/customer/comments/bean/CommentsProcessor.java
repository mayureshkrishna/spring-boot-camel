package com.cox.bis.customer.comments.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cox.bis.customer.comments.api.model.CommentsSearchRequest;
import com.cox.bis.customer.comments.api.model.CommentsSearchResponse;
import com.cox.bis.customer.comments.dao.CustomerCommentsXHAStageDAOImpl;
import com.cox.bis.customer.comments.dao.model.SearchCustomerCommentsRequest;
import com.cox.bis.customer.comments.dao.model.SearchCustomerCommentsResponse;
import com.cox.bis.customer.comments.exception.BusinessException;
import com.cox.bis.customer.comments.model.CustomerComment;
import com.cox.bis.customer.comments.util.DateTimeProcessor;
import com.cox.bis.customer.comments.util.LocalConstants.L_ErrorCodes;
import com.cox.bis.customer.comments.util.LocalConstants.L_Errors;
import com.cox.bis.customer.comments.util.Util;

@Component("commentsProcessor")
public class CommentsProcessor {

	@Autowired
	private CustomerCommentsXHAStageDAOImpl customerCommentsXHAStageDAOImpl;

	/***
	 * Method: searchComments Description: search xHastage for CommentsProcessor
	 * within parameters
	 * 
	 * @category method
	 * @author Mayuresh Krishna
	 * @param exchange
	 * @throws BusinessException
	 * @throws Exception
	 */
	public CommentsSearchResponse search(Exchange exchange, CommentsSearchRequest request) throws Exception {

		CommentsSearchResponse response = new CommentsSearchResponse();

		SearchCustomerCommentsRequest searchCustomerCommentsRequest = new SearchCustomerCommentsRequest();

		searchCustomerCommentsRequest.setAccountNumber(request.getAccountNumber());
		searchCustomerCommentsRequest.setSiteId(request.getSiteId());
		searchCustomerCommentsRequest.setSort("desc");
		searchCustomerCommentsRequest.setMax("100");

		if (Util.isNotNullEmpty(exchange.getIn().getBody(CommentsSearchRequest.class).getStartDate()))
			searchCustomerCommentsRequest.setStartDate(DateTimeProcessor
					.toCenturyDate(exchange.getIn().getBody(CommentsSearchRequest.class).getStartDate()));
		if (Util.isNotNullEmpty(exchange.getIn().getBody(CommentsSearchRequest.class).getEndDate()))
			searchCustomerCommentsRequest.setEndDate(DateTimeProcessor
					.toCenturyDate(exchange.getIn().getBody(CommentsSearchRequest.class).getEndDate()));
		if (Util.isNotNullEmpty(exchange.getIn().getBody(CommentsSearchRequest.class).getStartDate())
				&& Util.isNotNullEmpty(exchange.getIn().getBody(CommentsSearchRequest.class).getEndDate())) {
			if (Integer.parseInt(exchange.getIn().getBody(CommentsSearchRequest.class).getStartDate()) > Integer
					.parseInt(exchange.getIn().getBody(CommentsSearchRequest.class).getEndDate()))
				throw new BusinessException(L_ErrorCodes.CUSTOMER_COMMENTS_SEARCH_FAILED + " -- "
						+ L_Errors.CUSTOMER_COMMENTS_SEARCH_FAILED + ": startDate cannot be greater than endDate");
		}

		SearchCustomerCommentsResponse searchCustomerCommentsResponse = customerCommentsXHAStageDAOImpl
				.searchCustomerComment(searchCustomerCommentsRequest);

		List<CustomerComment> customerCommentsList = new ArrayList<>();

		for (int i = 0; i < searchCustomerCommentsResponse.getCustomerComments().size(); i++) {
			CustomerComment customerComment = new CustomerComment();
			customerComment.setCommentId(searchCustomerCommentsResponse.getCustomerComments().get(i).getCommentId());
			if (searchCustomerCommentsResponse.getCustomerComments().get(i).getEntryDate().contains("999")
					|| searchCustomerCommentsResponse.getCustomerComments().get(i).getEntryDate().equals("0"))
				customerComment
						.setEntryDate(searchCustomerCommentsResponse.getCustomerComments().get(i).getEntryDate());
			else
				customerComment.setEntryDate(DateTimeProcessor
						.fromCenturyDate(searchCustomerCommentsResponse.getCustomerComments().get(i).getEntryDate()));
			customerComment
					.setSequenceNumber(searchCustomerCommentsResponse.getCustomerComments().get(i).getSequenceNumber());
			customerComment.setCommentLineText(
					searchCustomerCommentsResponse.getCustomerComments().get(i).getCommentLineText());
			customerComment.setUserId(searchCustomerCommentsResponse.getCustomerComments().get(i).getUserId());
			if (searchCustomerCommentsResponse.getCustomerComments().get(i).getExpirationDate().contains("999")
					|| searchCustomerCommentsResponse.getCustomerComments().get(i).getExpirationDate().equals("0"))
				customerComment.setExpirationDate(null);
			else
				customerComment.setExpirationDate(DateTimeProcessor.fromCenturyDate(
						searchCustomerCommentsResponse.getCustomerComments().get(i).getExpirationDate()));
			customerCommentsList.add(customerComment);
		}

		if (customerCommentsList.isEmpty()) {
		} else
			response.setCustomerComments(customerCommentsList);
		return response;

	}

	public CommentsSearchResponse getComments(String clientId, String siteId, String accountNumber, String sort,
			String startDate, String endDate, String max) throws Exception {

		CommentsSearchResponse response = new CommentsSearchResponse();

		SearchCustomerCommentsRequest searchCustomerCommentsRequest = new SearchCustomerCommentsRequest();

		searchCustomerCommentsRequest.setAccountNumber(accountNumber);
		searchCustomerCommentsRequest.setSiteId(siteId);
		searchCustomerCommentsRequest.setSort("desc");
		searchCustomerCommentsRequest.setMax("100");

		if (Util.isNotNullEmpty(startDate))
			searchCustomerCommentsRequest.setStartDate(DateTimeProcessor.toCenturyDate(startDate));
		if (Util.isNotNullEmpty(endDate))
			searchCustomerCommentsRequest.setEndDate(DateTimeProcessor.toCenturyDate(endDate));
		if (Util.isNotNullEmpty(startDate) && Util.isNotNullEmpty(endDate)) {
			if (Integer.parseInt(startDate) > Integer.parseInt(endDate))
				throw new BusinessException(L_ErrorCodes.CUSTOMER_COMMENTS_SEARCH_FAILED + " -- "
						+ L_Errors.CUSTOMER_COMMENTS_SEARCH_FAILED + ": startDate cannot be greater than endDate");
		}

		SearchCustomerCommentsResponse searchCustomerCommentsResponse = customerCommentsXHAStageDAOImpl
				.searchCustomerComment(searchCustomerCommentsRequest);

		List<CustomerComment> customerCommentsList = new ArrayList<>();

		for (int i = 0; i < searchCustomerCommentsResponse.getCustomerComments().size(); i++) {
			CustomerComment customerComment = new CustomerComment();
			customerComment.setCommentId(searchCustomerCommentsResponse.getCustomerComments().get(i).getCommentId());
			if (searchCustomerCommentsResponse.getCustomerComments().get(i).getEntryDate().contains("999")
					|| searchCustomerCommentsResponse.getCustomerComments().get(i).getEntryDate().equals("0"))
				customerComment
						.setEntryDate(searchCustomerCommentsResponse.getCustomerComments().get(i).getEntryDate());
			else
				customerComment.setEntryDate(DateTimeProcessor
						.fromCenturyDate(searchCustomerCommentsResponse.getCustomerComments().get(i).getEntryDate()));
			customerComment
					.setSequenceNumber(searchCustomerCommentsResponse.getCustomerComments().get(i).getSequenceNumber());
			customerComment.setCommentLineText(
					searchCustomerCommentsResponse.getCustomerComments().get(i).getCommentLineText());
			customerComment.setUserId(searchCustomerCommentsResponse.getCustomerComments().get(i).getUserId());
			if (searchCustomerCommentsResponse.getCustomerComments().get(i).getExpirationDate().contains("999")
					|| searchCustomerCommentsResponse.getCustomerComments().get(i).getExpirationDate().equals("0"))
				customerComment.setExpirationDate(null);
			else
				customerComment.setExpirationDate(DateTimeProcessor.fromCenturyDate(
						searchCustomerCommentsResponse.getCustomerComments().get(i).getExpirationDate()));
			customerCommentsList.add(customerComment);
		}

		if (customerCommentsList.isEmpty()) {
		} else
			response.setCustomerComments(customerCommentsList);
		return response;
	}

	public String ping(Exchange exchange) {

		String response = "success";
		return response;

	}
}