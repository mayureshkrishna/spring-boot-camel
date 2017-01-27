package com.cox.bis.customer.comments.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.cox.bis.customer.comments.model.CustomerComment;

@Component
public class CommentsProcessor {

	@Resource
	private CommentsDataSource commentsDataSource;
	
	/***
	 * Method: searchComments
	 * Description: search xHastage for CommentsProcessor within parameters
	 * @category method
	 * @author ksaurav
	 * @param exchange
	 * @throws BusinessException
	 * @throws Exception
	 */
	@Bean
	public List<CustomerComment> search() throws Exception {
		
		//CommentsDataSource cds = new CommentsDataSource();
		
		
		List<CustomerComment> customerCommentsList = new ArrayList<>();
		
		customerCommentsList = commentsDataSource.findAll();
		
		/*
		CustomerComment customerComment = new CustomerComment();
		customerComment.setCommentId("1");
		customerComment.setEntryDate("1170101");
		customerComment.setSequenceNumber("1");
		customerComment.setCommentLineText("This is a mock test comment");
		customerComment.setUserId("MKRISHNA");
		customerComment.setExpirationDate("1170101");
		customerCommentsList.add(customerComment);
		*/
		return customerCommentsList;
	}
	
}
