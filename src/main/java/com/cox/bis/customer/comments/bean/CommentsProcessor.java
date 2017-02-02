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
		
		List<CustomerComment> customerCommentsList = new ArrayList<>();
		customerCommentsList = commentsDataSource.findAll();
		return customerCommentsList;
	}
	
}
