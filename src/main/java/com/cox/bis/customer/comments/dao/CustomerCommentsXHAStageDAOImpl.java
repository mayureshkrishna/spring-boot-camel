package com.cox.bis.customer.comments.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cox.bis.customer.comments.dao.config.DataSourceConfig;
import com.cox.bis.customer.comments.dao.model.SearchCustomerCommentsRequest;
import com.cox.bis.customer.comments.dao.model.SearchCustomerCommentsResponse;
import com.cox.bis.customer.comments.model.CustomerComment;

import oracle.jdbc.OracleTypes;


@Component
public class CustomerCommentsXHAStageDAOImpl implements CustomerCommentsXHAStageDAO{
	
	@Autowired
	private DataSourceConfig dataSource;
	public SearchCustomerCommentsResponse searchCustomerComment(SearchCustomerCommentsRequest searchCustomerCommentsRequest) throws Exception {
		List<CustomerComment> customerCommentList=new ArrayList<CustomerComment>();
		try (Connection connection = dataSource.getXhastage().primaryDataSource().getConnection()) {
			
			CallableStatement callableStatement = connection.prepareCall("{call CRM.WS_SEARCH_CUSTOMERCOMMENTS(?,?,?,?,?,?,?,?,?)}");
			callableStatement.setString(1, searchCustomerCommentsRequest.getSiteId());
			callableStatement.setString(2, searchCustomerCommentsRequest.getAccountNumber());
			callableStatement.setString(3, searchCustomerCommentsRequest.getMax() != null ? searchCustomerCommentsRequest.getMax() : null);
			callableStatement.setString(4, searchCustomerCommentsRequest.getStartDate() != null ? searchCustomerCommentsRequest.getStartDate() : null);
			callableStatement.setString(5, searchCustomerCommentsRequest.getEndDate() != null ? searchCustomerCommentsRequest.getEndDate() : null);
			callableStatement.setString(6, searchCustomerCommentsRequest.getSort() != null ? searchCustomerCommentsRequest.getSort() : null);

			callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(9, OracleTypes.CURSOR);

			callableStatement.executeUpdate();
			

			if (callableStatement.getObject(9) != null) {
				ResultSet rs = (ResultSet) callableStatement.getObject(9);
				while (rs.next()) {
					CustomerComment xhastageCustomerComment = new CustomerComment();
					xhastageCustomerComment.setSequenceNumber((rs.getString("SEQUENCE_NUMBER")));
					xhastageCustomerComment.setCommentLineText((rs.getString("COMMENT_TEXT")));
					xhastageCustomerComment.setUserId((rs.getString("USER_ID")));
					xhastageCustomerComment.setEntryDate((rs.getString("COMMENT_ENTER_DATE")));
					xhastageCustomerComment.setExpirationDate((rs.getString("COMMENT_EXPIRATION_DATE")));
					xhastageCustomerComment.setCommentId((rs.getString("COMMENT_ID")));
					customerCommentList.add(xhastageCustomerComment);
				}
			}
		} catch (Exception e) {
			return new SearchCustomerCommentsResponse(e);
		}
		return new SearchCustomerCommentsResponse(customerCommentList);
	}
}