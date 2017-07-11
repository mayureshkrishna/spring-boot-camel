package com.cox.bis.customer.comments.util;


public interface LocalConstants{
	// Exception Messages
		final static String NO_HTTP_RESPONSE_EXCEPTION_MESSAGE = "Server failed to respond.  Enable logging on the apache http client library (org.apache.http,org.apache.httpcomponents.httpclient) for further details e.g. log:set DEBUG org.apache.http";
		final static String UNEXPECTED_FAILURE = "Failed to complete operation. Enable logging on the icoms-api bundle (com.cox.bmw.icoms.api) for further details.";
		
		
		//Log Messages
		final static String ICOMS_GATEWAY_MESSAGE_HEADER = "\n *** Icoms Gateway Message *** \n";
		final static String HTTP_RESPONSE_CODE = "Http Response Code : ";
		final static String CONTENT_LENGTH = "Content Length : ";
		final static String CONTENT_TYPE = "Content Type : ";
		final static String BREADCRUMB_ID = "Breadcrumb Id : ";
		final static String RESPONSE_MESSAGE = "Message : \n";
		final static String WRAPPED_INPUT_STREAM_CLASS_NAME = "WrappedInputStream";
		
		
		// Constant Variables
		final static String LINE_BREAK = "\n";
		
		
		// Exchange Property Keys
		final static String REQUEST_OBJECT_KEY = "REQUEST_OBJECT";
		final static String LOG_ENTRY_KEY = "LOG_ENTRY";
		final static String OPERATION_NAME = "OPERATION_NAME";
		final static String TRANSACTION_ID_KEY = "TRANSACTION_ID";
		final static String CLIENT_TRANSACTION_ID_KEY = "CLIENT_TRANSACTION_ID";
		final static String SESSION_ID_KEY = "SESSION_ID";
		final static String CLIENT_SESSION_ID_KEY = "CLIENT_SESSION_ID";
		final static String CLIENT_ID_KEY = "CLIENT_ID";
		final static String CALLING_SERVICE_KEY = "CALLING_SERVICE";
		
	public interface L_Operations{
		static final String ACCOUNTS_SEARCH = "accountsSearch";
		static final String ACCOUNTS_GET = "accountsGet";
		static final String COMMENTS_SEARCH = "commentsSearch";
		static final String COMMENTS_CREATE = "commentsCreate";
		static final String COMMENTS_UPDATE = "commentsUpdate";
		static final String COMMENTS_DELETE = "commentsDelete";
		static final String PREFERENCES_SEARCH = "preferencesSearch";
		static final String PREFERENCES_UPDATE = "preferencesUpdate";
	}

	public interface L_Properties{
		static final String ACCOUNT_NUMBER_KEY = "ACCOUNT_NUMBER";
		static final String ACCOUNT_NUMBERS_KEY = "ACCOUNT_NUMBERS";
		static final String PHONE_KEY = "PHONE";
		static final String EMAIL_KEY = "EMAIL";
		static final String FIRST_NAME_KEY = "FIRST_NAME";
		static final String LAST_NAME_KEY = "LAST_NAME";
		static final String ADDRESS_LINE_1_KEY = "ADDRESS_LINE_1";
		static final String ADDRESS_LINE_2_KEY = "ADDRESS_LINE_2";
		static final String UNIT_KEY = "UNIT";
		static final String CITY_KEY = "ADDRESS_CITY";
		static final String STATE_KEY = "ADDRESS_STATE";
		static final String ZIP5_KEY = "ADDRESS_ZIP5";
		static final String DIRECTIVES_KEY = "DIRECTIVES";
		static final String DEEP_SEARCH_KEY = "DEEP_SEARCH";
		static final String SORT = "SORT";
		static final String NOTIFICATION_METHODS_FLAG = "NOTIFICATION_METHODS_FLAG";
		static final String NOTIFICATION_PREFERENCES_FLAG = "NOTIFICATION_PREFERENCES_FLAG";
		static final String UNASSIGNED_MOBILE_NUMBERS_FLAG = "UNASSIGNED_MOBILE_NUMBERS_FLAG";
		public final String YES = "Y";
		public final String NO = "N";
		public final String BLANK = " ";
		public final String OPT_IN = "I";
		public final String OPT_OUT = "O";
		

	}

	public interface L_HeaderFields{
		static final String ACCOUNT_NUMBER_KEY = "accountNumber";
		static final String ACCOUNT_NUMBERS_KEY = "accountNumbers";
		static final String PHONE_KEY = "phone";
		static final String EMAIL_KEY = "email";
		static final String FIRST_NAME_KEY = "firstName";
		static final String LAST_NAME_KEY = "lastName";
		static final String ADDRESS_LINE_1_KEY = "addressLine1";
		static final String ADDRESS_LINE_2_KEY = "addressLine2";
		static final String UNIT_KEY_KEY = "unit";
		static final String CITY_KEY = "city";
		static final String STATE_KEY = "state";
		static final String ZIP5_KEY = "zip5";
		static final String DIRECTIVES_KEY = "directives";
		static final String DEEP_SEARCH_KEY = "deepSearch";
		static final String SORT = "sort";
		static final String  SHOW_KEY = "show";
		static final String  HIDE_KEY = "hide";
		static final String NOTIFICATION_METHODS_KEY = "notificationMethods";
		static final String NOTIFICATION_PREFERENCES_KEY = "notificationPreferences";
		static final String UNASSIGNED_MOBILE_NUMBERS_KEY = "unassignedSMSMobileNumbers";
		public final String SHOW_LIST = "notificationMethods,notificationPreferences,unassignedMobileNumbers";
	}

	public interface L_LogFields{
		static final String ACCOUNT_NUMBER_KEY = "accountNumber";
		static final String ACCOUNT_NUMBERS_KEY = "accountNumbers";
		static final String PHONE_KEY = "phone";
		static final String EMAIL_KEY = "email";
		static final String FIRST_NAME_KEY = "firstName";
		static final String LAST_NAME_KEY = "lastName";
		static final String ADDRESS_LINE_1_KEY = "addressLine1";
		static final String ADDRESS_LINE_2_KEY = "addressLine2";
		static final String UNIT_KEY_KEY = "unit";
		static final String CITY_KEY = "city";
		static final String STATE_KEY = "state";
		static final String ZIP5_KEY = "zip5";
		static final String DIRECTIVES_KEY = "directives";
		static final String DEEP_SEARCH_KEY = "deepSearch";
	}

	public interface L_MessageCodes{
		static final String STEP_NETCRACKER_SP_CALL = "STEP_NETCRACKER_SP_CALL";		
		static final String STEP_CUSTOMER_PREFERENCE_UPDATE = "STEP_CUSTOMER_PREFERENCE_UPDATE";		
		static final String STEP_CUSTOMER_PREFERENCE_SEARCH = "STEP_CUSTOMER_PREFERENCE_SEARCH";		
		
	}

	public interface L_Messages{
		static final String TRUE_KEY="true";
		static final String FALSE_KEY="false";
		static final String BLANK_KEY=" ";
		static final String STEP_FAILED="STEP_FAILED";
		static final String STEP_SUCCESS="STEP_SUCCESS";
	}

	public interface L_ErrorCodes{
		static final String CUSTOMER_COMMENTS_SEARCH_FAILED = "CUSTOMER_COMMENTS_SEARCH_FAILED";
		static final String CUSTOMER_COMMENTS_CREATE_FAILED = "CUSTOMER_COMMENTS_ADD_FAILED";
		static final String CUSTOMER_COMMENTS_UPDATE_FAILED = "CUSTOMER_COMMENTS_UPDATE_FAILED";
		static final String CUSTOMER_COMMENTS_DELETE_FAILED = "CUSTOMER_COMMENTS_DELETE_FAILED";
		static final String CUSTOMER_PREFERENCE_SEARCH_FAILED="CUSTOMER_PREFERENCE_SEARCH_FAILED";
		static final String ICOMS_SQL_API_FAILURE ="ICOMS_SQL_API_FAILURE";
	}

	public interface L_Errors {
		static final String CUSTOMER_COMMENTS_SEARCH_FAILED = "Search Customer IPLookupProcessor Failed";
		static final String CUSTOMER_COMMENTS_CREATE_FAILED = "Create Customer IPLookupProcessor Failed";
		static final String CUSTOMER_COMMENTS_UPDATE_FAILED = "Update Customer IPLookupProcessor Failed";
		static final String CUSTOMER_COMMENTS_DELETE_FAILED = "Delete Customer IPLookupProcessor Failed";
		static final String CUSTOMER_PREFERENCE_SEARCH_FAILED = "Search Customer Preference Failed";
	}

	public interface L_Formats {
	}
}
