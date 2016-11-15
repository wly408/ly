//package com.ly.open.common;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.StringReader;
//import java.util.Random;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.ai.common.xmltrans.inner.HttpServiceUtils;
//import com.ai.netweb.protocol.header.Root;
//import com.ai.netweb.protocol.header.RootJson;
//import com.ai.netweb.protocol.header.RspCode;
//import com.ai.utils.DESUtils;
//import com.ai.utils.JSONUtils;
//import com.ai.utils.WebUtils;
//import com.ai.utils.cache.ThreadCommon;
//
///**
// * 对外服务统一接口
// * 
// * 
// */
//public class Service extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static Logger logger = LoggerFactory.getLogger(Service.class);
//
//	/**
//	 * Constructor of the object.
//	 */
//	public Service() {
//		super();
//	}
//
//	/**
//	 * Destruction of the servlet. <br>
//	 */
//	public void destroy() {
//		super.destroy(); // Just puts "destroy" string in log
//		// Put your code here
//	}
//
//	/**
//	 * The doGet method of the servlet. <br>
//	 */
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		// logger.error("不支持get方法");
//		out.print("不支持get方法");
//	}
//
//	/**
//	 * The doPost method of the servlet. <br>
//	 */
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 设置客户端IP线程变量
//		ThreadCommon.setRemoteIp(WebUtils.getRemoteAddr(request));
//		ThreadCommon.setWebBasePath(WebUtils.getBasePath(request));
//		
//		//交易ID
//		String busiId = System.currentTimeMillis() + "_" +(new Random().nextInt(1000));
//		
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		
//		String xmlmsg = request.getParameter("xmlmsg"); //请求报文
//		String type = request.getParameter("type");   //协议格式{json,xml}
//		String ps =  request.getParameter("ps");      //请求报文加密方式{0:明文,1:DES}
//		String rspXML = "";
//
//		if (StringUtils.isBlank(xmlmsg)) {
//			out.print("xmlmsg 为空");
//			response.flushBuffer();	
//			return;
//		} else {
//			xmlmsg = xmlmsg.trim();
//			if(logger.isDebugEnabled()){
//				logger.debug("busiId = " + busiId + " ,request xml =" + StringUtils.replace(xmlmsg, "\n", "") );
//			}
//		}
//
//		//DES请求密文,先解密
//		if(StringUtils.isNotEmpty(ps) && ps.equals("1")){ 			
//			xmlmsg = DESUtils.decrypt(xmlmsg);
//			logger.debug("解密后请求报文:" + StringUtils.replace(xmlmsg, "\n", ""));				
//			if(xmlmsg==null) {
//				out.print("DES解密失败,请检查请求报文格式是否正确");
//				response.flushBuffer();			
//				return;
//			}			
//		}
//		
//		
//		try {
//			if (StringUtils.isNotEmpty(type) && type.toLowerCase().equals("json")) {
//				rspXML = parseJSONAdapter(request, response, xmlmsg ,busiId);
//			} else {
//				// 先判断是否是支付宝请求
//				if (isAlpayHttp(xmlmsg)) {
//					logger.debug("==支付宝请求="+StringUtils.replace(xmlmsg, "\n", ""));
//					rspXML = this.doAlpayHttp(request);
//					logger.debug("==支付宝响应="+StringUtils.replace(rspXML, "\n", ""));
//				} else {
//					rspXML = parseXMLAdapter(request, response, xmlmsg, busiId);
//				}
//			}
//			
//			//DES应答密文
//			if(StringUtils.isNotEmpty(ps) && ps.equals("1")){ 
//				logger.debug("解密后应答报文:" + StringUtils.replace(rspXML, "\n", ""));
//				rspXML = DESUtils.encrypt(rspXML);
//				logger.debug("加密后应答报文:" + StringUtils.replace(rspXML, "\n", ""));
//			}
//			
//
//			// 注意以下这一行,wls环境有影响
//			response.setContentLength(rspXML.getBytes("utf-8").length);
//			out.print(rspXML);
//			response.flushBuffer();
//		} catch (Exception ex) {
//			logger.error("" ,ex);
//		} finally {
//			out.flush();
//			out.close();
//		}
//	}
//	
//	//判断过来的请求是否是支付宝的请求
//	public boolean isAlpayHttp(String xmlmsg) {
//		Root root = null;
//
//		try {
//			// 解析包头
//			StringReader reader = new StringReader(xmlmsg);
//			root = Root.unmarshal(reader);
//			String bizCode = root.getBizCode();
//			if (bizCode.startsWith("AP"))
//				return true;
//			else
//				return false;
//		} catch (Exception ex) {
//			return false;
//		}
//	}
//	
//	public String doAlpayHttp(HttpServletRequest request) throws Exception{
//		String xmlmsg = request.getParameter("xmlmsg"); //请求报文
//		String type = request.getParameter("type");   //协议格式{json,xml}
//		String ps =  request.getParameter("ps");      //请求报文加密方式{0:明文,1:DES}
//		NameValuePair[] data = new NameValuePair[3];
//		data[0] = new NameValuePair("xmlmsg", xmlmsg);
//		data[1] = new NameValuePair("type", type);
//		data[2] = new NameValuePair("ps", ps);
//		String url = HttpServiceUtils.getApAddr();
//		return HttpServiceUtils.doHttpPost(url, data);
//	}
//
//	/**
//	 * 功能描述: json请求报文解析 fangll 2012-10-15上午10:25:10
//	 */
//	public String parseJSONAdapter(HttpServletRequest request, HttpServletResponse response, String xmlmsg ,String  busiId) throws IOException {
//
//		// xmlmsg = {"imei":"test_imei","currentState":"1"}
//		String rspXML = "";
//		RootJson root = null;
//		root = (RootJson) JSONUtils.json2JavaObj(xmlmsg, RootJson.class);
//		
//
//		
//		return rspXML;
//	}
//
//	/**
//	 * 功能描述: xml请求报文解析 fangll 2012-10-15上午10:24:21
//	 */
//	public String parseXMLAdapter(HttpServletRequest request, HttpServletResponse response, String xmlmsg ,String busiId) throws IOException {
//		String rspXML = "";
//		com.ai.netweb.protocol.header.Response rsp = new com.ai.netweb.protocol.header.Response();
//		Root root = null;
//		
//		try {
//
//			// 解析包头
//			StringReader reader = new StringReader(xmlmsg);
//			root = Root.unmarshal(reader);
//		} catch (Exception ex) {
//			logger.error("" ,ex);
//			rsp.setRspCode(RspCode.R2001);
//			rsp.setRspInfo("请求报文格式有误！");
//			rspXML = rsp.toXMLString();		
//			
//			return rspXML;
//		}
//		
//		
//		try{
//			String svcContent = root.getSvcContent();
//			// svcContent =
//			// svcContent.replace("\t","").replace("\n","").replace(" ",""); 
//			String bizCode = root.getBizCode();
//
//			 rspXML = ExecuteActionCommand.executeCommand(bizCode ,root,svcContent ,busiId );
//			 
//			 if(logger.isDebugEnabled()){
//				 logger.debug("busiId=" + busiId +" ,return xml=" + StringUtils.replace(rspXML, "\n", ""));
//			 }
//
//		} catch (Exception ex) {
//			logger.error("接口："+root.getBizCode()+"调用异常,请求报文格式有误,请检查请求报文是否合法的xml或json格式" ,ex);
//			rsp.setRspCode(RspCode.R2001);
//			rsp.setRspInfo(RspCode.getDesc(RspCode.R2001));
//			rspXML = rsp.toXMLString();			
//		}
//		return rspXML;
//	}
// 
//	/**
//	 * The doPut method of the servlet. <br>
//	 * 
//	 */
//	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		// Put your code here
//	}
//
//	/**
//	 * Returns information about the servlet, such as author, version, and
//	 * copyright.
//	 * 
//	 * @return String information about this servlet
//	 */
//	public String getServletInfo() {
//		return "This is my default servlet created by Eclipse";
//	}
//
//	/**
//	 * Initialization of the servlet. <br>
//	 * 
//	 * @throws ServletException
//	 *             if an error occurs
//	 */
//	public void init() throws ServletException {
//		// Put your code here
//	}
//
//}
