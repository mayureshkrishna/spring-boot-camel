package com.cox.bis.customer.comments.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cox.bis.customer.comments.model.CustomerComment;

@Component
public class CommentsDataSource {
	
	@Value("${spring.datasource.platform}")
    private String platform;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<CustomerComment> findAll() {
		System.out.println("Query employees: platform->" + platform);
		return jdbcTemplate.query("SELECT cc.SEQ_NBR, cc.ACCOUNT_NUMBER, cc.COMMENT_LINE,cc.USER_ID,cc.COMMENT_EXPIRATION_DATE,cc.COMMENT_ENTER_DATE,(CRM.FN_FORMATDATE_V2(cc.COMMENT_ENTER_DATE,NULL) || LPAD(cc.SEQ_NBR,3,'0')) FROM ICOMS.PHX_CUSTOMER_COMMENTS cc where cc.ACCOUNT_NUMBER = 1604 AND cc.SITE_ID = 436", new CommentsRowMapper());		
	}
	
	
	class CommentsRowMapper implements RowMapper<CustomerComment>
	{

		@Override
		public CustomerComment mapRow (ResultSet rs, int rowNum) throws SQLException 
		{
			CustomerComment cc = new CustomerComment();
			cc.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
			cc.setCommentLineText(rs.getString("COMMENT_LINE"));
			cc.setSequenceNumber(rs.getString("SEQ_NBR"));
			
			
			return cc;
		}
	}

}
