package com.cox.bis.customer.comments.model;

import java.util.ArrayList;
import java.util.List;

import com.cox.bis.customer.comments.model.Message;

public class CustomerComment {
	
	private String siteId;
	private String accountNumber;
	private String commentId;
	private String entryDate;
	private String sequenceNumber;
	private String success;
	private List<Message> messages;
	private String commentLineText;
	private String userId;
	private String expirationDate;
	
	public CustomerComment() {
		//Do nothing...
	}

	public CustomerComment(String commentLineText) {
		this.commentLineText = commentLineText;
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
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}	

	/**
	 * @return the commentId
	 */
	public String getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(String commentId) {
	//	if (CommonUtilsProcessor.isNullEmpty(commentId)) this.commentId = entryDate + String.format("%03d", Integer.parseInt(sequenceNumber));
	//	else 
			this.commentId = commentId;
	}

	/**
	 * @return the entryDate
	 */
	public String getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return the sequenceNumber
	 */
	public String getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * @param sequenceNumber
	 *            the sequenceNumber to set
	 */
	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = String.format("%03d", Integer.parseInt(sequenceNumber));
	}
	
	/**
	 * @return the commentLineText
	 */
	public String getCommentLineText() {
		return commentLineText;
	}

	/**
	 * @param commentLineText
	 *            the commentLineText to set
	 * @throws BusinessException 
	 */
	public void setCommentLineText(String commentLineText) {
		this.commentLineText = commentLineText;
	}
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the expirationDate
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate
	 *            the expirationDate to set
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public List<Message> getMessages() {
		if(messages == null){
			messages = new ArrayList<Message>();
		}
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

}
