package com.cox.bis.customer.comments.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cox.bis.customer.comments.model.CustomerComment;

@Component
public class CommentsDataSource {
	
	@Value("${spring.datasource.platform}")
    private String platform;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<CustomerComment> findAll() {
		System.out.println("Query employees: platform->" + platform);
		try {
			System.out.println(jdbcTemplate.getDataSource().getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jdbcTemplate.query("SELECT cc.SEQ_NBR, cc.ACCOUNT_NUMBER, cc.COMMENT_LINE,cc.USER_ID,cc.COMMENT_EXPIRATION_DATE,cc.COMMENT_ENTER_DATE,(CRM.FN_FORMATDATE_V2(cc.COMMENT_ENTER_DATE,NULL) || LPAD(cc.SEQ_NBR,3,'0')) FROM ICOMS.PHX_CUSTOMER_COMMENTS cc where cc.ACCOUNT_NUMBER = 552118401 AND cc.SITE_ID = 436", new CommentsRowMapper());		
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
			cc.setEntryDate(rs.getString("COMMENT_ENTER_DATE"));
			cc.setUserId(rs.getString("USER_ID"));
			
			
			return cc;
		}
	}

}
