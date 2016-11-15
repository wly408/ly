package com.ly.gp.data;

public final class DataResource {

	//股票列表基本信息来源,只包括代码跟名称
	public static final String INFO_LIST_URL = "http://quote.eastmoney.com/stocklist.html";
	
	public static final String CIR_VALUE_URL = "http://quote.eastmoney.com/{code}.html";
	
	public static final String DETAIL_URL = "http://money.finance.sina.com.cn/corp/go.php/vMS_MarketHistory/stockid/{code}.phtml?year={year}&jidu={jidu}";
	
}
