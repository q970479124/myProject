package com.poetry.utils;

/**
 * 常量
 * 
 * @author Administrator
 *
 */
public class Property {
	//state
	public static final int STATE_1 = 0;
	public static final int STATE_2 = 1;
	public static final int STATE_3 = -1;

	//code
	public static final String CODE_LOGIN_PASSWORD_ERROR = "00001";
	public static final String CODE_LOGIN_USERNAME_ERROR = "00002";
	public static final String CODE_REGISTER_USERNAME_EXIST = "00003";
	public static final String CODE_DB_ERROR = "00004";
	public static final String CODE_PARAMETER_ERROR = "00005";
	public static final String CODE_SEARCH_ZERO = "00006";
	public static final String CODE_AUTH_ZERO = "00007";
	public static final String CODE_DYNASTY_MATCH = "00008";

	//message
	public static final String MESSAGE_LOGIN_PASSWORD_ERROR = "密码不正确！";
	public static final String MESSAGE_LOGIN_USERNAME_ERROR = "该用户不存在！";
	public static final String MESSAGE_REGISTER_USERNAME_EXIST = "该用户已存在！";
	public static final String MESSAGE_DB_ERROR = "数据库异常！";
	public static final String MESSAGE_PARAMETER_ERROR = "参数不正常！";
	public static final String MESSAGE_SEARCH_ZERO = "检索为零件！";
	public static final String MESSAGE_AUTH_ZERO = "该作者不存在，请刷新重试！";
	public static final String MESSAGE_DYNASTY_MATCH = "作者与朝代不匹配";
	
	//常量
	public static final String TAB_RECOMMEND = "1";
	public static final String TAB_POETRY = "2";
	public static final String TAB_ANCIENT = "3";
	public static final String TAB_AUTH = "4";
	public static final String TAB_FAMOUS = "5";
	
	public static final String INDEX = "1";
	//普通用户
	public static final int AUTHORITY = 1;
	
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	
}
