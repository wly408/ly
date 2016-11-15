package com.ly.gp.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.common.exception.BusException;
import com.ly.common.service.impl.BaseSV;
import com.ly.common.util.StringUtils;
import com.ly.gp.data.DataResource;
import com.ly.gp.mybatis.mapper.info.GpInfoMapper;
import com.ly.gp.mybatis.model.info.GpData;
import com.ly.gp.mybatis.model.info.GpInfo;
import com.ly.gp.service.interfaces.IGpDetailDataSV;

@Service("gpDetailDataSV")
@Transactional(rollbackFor = Exception.class)
public class GpDetailDataSVImpl extends BaseSV implements IGpDetailDataSV {
	@Autowired
	private GpInfoMapper gpInfoMapper;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void collGpDetailJd(GpInfo gpInfo, String jd) throws Exception {
		if (StringUtils.isNotBlank(gpInfo.getCollDates())) {
			if (gpInfo.getCollDates().indexOf(jd) > -1) {
				return;
			}
		}
		String html = this.getGpDetailHtmlString(gpInfo, jd);

		// 从网站采集的数据
		List<GpData> list = this.htmlToBean(html, gpInfo.getCode());
		Collections.sort(list, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				GpData t1 = (GpData) o1;
				GpData t2 = (GpData) o2;
				return t1.getMarketDate().compareTo(t2.getMarketDate());
			}
		});
		if (list == null || list.isEmpty()) {
			return;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO GP_DATA(CODE,MARKET_DATE,OPEN_PRICE,LOW_PRICE,HIGHT_PRICE,FINAL_PRICE,"
				+ "TRAD_COUNT,TRAD_PRICE,CREATE_DATE,COLLECT_NUM,increase)");
		sql.append("select ?,?,?,?,?,?,?,?,sysdate,?,-99 from dual where not exists");
		sql.append(" (select 1 from GP_DATA where code=? and MARKET_DATE=?)");

		long next = 0;
		GpData max = this.getMaxCollGpData(gpInfo.getCode());
		next = max == null ? (next + 1) : (max.getCollectNum() + 1);
		List<Object[]> params = new ArrayList<Object[]>();
		for (int i = 0; i < list.size(); i++) {
			GpData data = list.get(i);
			Object[] objs = new Object[11];
			objs[0] = data.getCode();
			objs[1] = data.getMarketDate();
			objs[2] = data.getOpenPrice();
			objs[3] = data.getLowPrice();
			objs[4] = data.getHightPrice();
			objs[5] = data.getFinalPrice();
			objs[6] = data.getTradCount();
			objs[7] = data.getTradPrice();

			objs[8] = next;
			next++;
			objs[9] = data.getCode();
			objs[10] = data.getMarketDate();
			params.add(objs);
		}
		this.getJdbcDao().excuteBatch(sql.toString(), params);
		// 修改已经采集的数据的时间
		String collDates = gpInfo.getCollDates();
		if (StringUtils.isBlank(collDates)) {
			collDates = jd;
		} else {
			collDates += "," + jd;
		}
		gpInfo.setCollDates(collDates);

		this.gpInfoMapper.updateByPrimaryKey(gpInfo);

	}

	public static void main(String[] args) {
		// -- Add/modify columns
		// alter table GP_DATA add var_3 number(10,2);
		String[] dates = { "3", "5", "8", "10", "12", "15", "18", "20", "25",
				"30", "35", "40", "45", "50", "55", "60", "70" };
		for (int i = 0; i < dates.length; i++) {
			System.out.println("alter table GP_DATA add var_" + dates[i]
					+ " number(10,2);");
		}

	}

	private GpData getMaxCollGpData(String code) {
		String sql = "SELECT NVL(max(COLLECT_NUM),0) AS COLLECT_NUM,MAX(T.MARKET_DATE) AS MARKET_DATE   FROM GP_DATA T WHERE CODE='"
				+ code + "'";
		List<GpData> list = this.getJdbcDao().jdbcFindList(sql, null,
				GpData.class);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	private String getGpDetailHtmlString(GpInfo gpInfo, String jd)
			throws Exception {

		StringBuffer html = new StringBuffer();
		// System.out.println("开始采集："+gpInfo.getCode()+",时间"+jd);
		String link = DataResource.DETAIL_URL;// "http://money.finance.sina.com.cn/corp/go.php/vMS_MarketHistory/stockid/{code}.phtml?year={year}&jidu={jidu}";

		link = link.replace("{code}", gpInfo.getCode());
		link = link.replace("{year}", jd.substring(0, 4));
		link = link.replace("{jidu}", jd.substring(4));
		BufferedReader br = null;
		try {
			URL url = new URL(link);
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				html.append(line);
			}
		} catch (NullPointerException e1) {
			e1.printStackTrace();
			throw new BusException(e1.getMessage());
		} catch (ArrayIndexOutOfBoundsException e2) {
			e2.printStackTrace();
			throw new BusException(e2.getMessage());
		} catch (NumberFormatException e3) {
			e3.printStackTrace();
			throw new BusException(e3.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusException(e.getMessage());
		} finally {
			if (br != null) {
				br.close();
			}
		}

		return html.toString();

	}

	private List<GpData> htmlToBean(String html, String code) throws Exception {
		// System.out.println("开始采集："+code);
		List<GpData> list = new ArrayList<GpData>();
		String start = "FundHoldSharesTable";
		String end = "</table>";
		if (html.indexOf(start) < 0) {
			return list;
		}

		html = html.substring(html.indexOf(start), html.length());
		if (html.indexOf("</thead>") < 0) {
			return list;
		}
		html = html.substring(html.indexOf("</thead>"), html.indexOf(end));// 主题
		html = html.substring(html.indexOf("</tr>"), html.length());// 标题

		// System.out.println(html);
		/*
		 * <tr > <td><div align="center"> <a target='_blank' href=
		 * 'http://vip.stock.finance.sina.com.cn/quotes_service/view/vMS_tradehistory.php?symbol=sh601006&date=2015-02-12'>
		 * 2015-02-12 </a> </div></td> <td><div align="center">10.400</div></td>
		 * <td><div align="center">10.570</div></td> <td><div
		 * align="center">10.490</div></td> <td class="tdr"><div
		 * align="center">10.340</div></td> <td class="tdr"><div
		 * align="center">59188456</div></td> <td class="tdr"><div
		 * align="center">620640128</div></td> </tr>
		 */

		int trIndex = html.indexOf(">");
		int count = 0;
		// 读取行
		while (trIndex > -1) {
			// System.out.println(html);
			html = html.substring(trIndex + 1).trim();
			int next = html.indexOf(">");
			if (next < 0)
				break;
			html = html.substring(next).trim();
			int trEnd = html.indexOf("</tr>");
			if (trEnd < 0)
				break;
			String tr = html.substring(trIndex, trEnd).trim();// 一个TR
			// System.out.println(tr);

			/**************** 一行数据解析 *********************/
			// <td><div align="center"><a target='_blank'
			// href='http://vip.stock.finance.sina.com.cn/quotes_service/
			// view/vMS_tradehistory.php?symbol=sh601006&date=2015-01-05'>
			// 2015-01-05 </a>
			// </div></td>
			// <td><div align="center">11.000</div></td>
			// <td><div align="center">11.430</div></td>
			// <td><div align="center">11.200</div></td>
			// <td class="tdr"><div align="center">10.990</div></td>
			// <td class="tdr"><div align="center">265061888</div></td>
			// <td class="tdr"><div align="center">2959629568</div></td>
			// 日期

			String dateHtml = tr.substring(tr.indexOf("href"));
			tr = tr.substring(tr.indexOf("href"));
			dateHtml = dateHtml.substring(dateHtml.indexOf(">") + 1,
					dateHtml.indexOf("</a>"));
			tr = tr.substring(tr.indexOf(">") + 1);
			dateHtml = dateHtml.trim().replace("-", "");

			String startVal = tr.substring(tr.indexOf("<td>") + 4);
			tr = tr.substring(tr.indexOf("<td>") + 4);
			// startVal = startVal.substring(startVal.indexOf("<td>")+4);
			tr = tr.substring(tr.indexOf(">") + 1);
			// System.out.println(startVal);
			startVal = startVal.substring(startVal.indexOf(">") + 1,
					startVal.indexOf("</")).trim();
			// System.out.println(startVal);
			// System.out.println(tr);

			String hightPrice = tr.substring(tr.indexOf("<td>") + 4);
			tr = tr.substring(tr.indexOf("<td>") + 4);
			tr = tr.substring(tr.indexOf(">") + 1);
			hightPrice = hightPrice.substring(hightPrice.indexOf(">") + 1,
					hightPrice.indexOf("</")).trim();
			// hightPrice = hightPrice.substring(startVal.indexOf("<td>")+4);
			// System.out.println(hightPrice);

			String lastPirce = tr.substring(tr.indexOf("<td>") + 4);
			tr = tr.substring(tr.indexOf("<td>") + 4);
			tr = tr.substring(tr.indexOf(">") + 1);
			lastPirce = lastPirce.substring(lastPirce.indexOf(">") + 1,
					lastPirce.indexOf("</")).trim();
			// hightPrice = hightPrice.substring(startVal.indexOf("<td>")+4);
			// System.out.println(lastPirce);

			// System.out.println(tr);

			String lowPrice = tr.substring(tr.indexOf("<td class=\"tdr\">")
					+ ("<td class=\"tdr\">").length());
			tr = tr.substring(tr.indexOf("<td class=\"tdr\">")
					+ ("<td class=\"tdr\">").length());
			tr = tr.substring(tr.indexOf(">") + 1);
			lowPrice = lowPrice.substring(lowPrice.indexOf(">") + 1,
					lowPrice.indexOf("</")).trim();
			// hightPrice = hightPrice.substring(startVal.indexOf("<td>")+4);
			// System.out.println(lowPrice);

			String tradCount = tr.substring(tr.indexOf("<td class=\"tdr\">")
					+ ("<td class=\"tdr\">").length());
			tr = tr.substring(tr.indexOf("<td class=\"tdr\">")
					+ ("<td class=\"tdr\">").length());
			tr = tr.substring(tr.indexOf(">") + 1);
			tradCount = tradCount.substring(tradCount.indexOf(">") + 1,
					tradCount.indexOf("</")).trim();
			// hightPrice = hightPrice.substring(startVal.indexOf("<td>")+4);
			// System.out.println(tradCount);

			String tradMoney = tr.substring(tr.indexOf("<td class=\"tdr\">")
					+ ("<td class=\"tdr\">").length());
			tr = tr.substring(tr.indexOf("<td class=\"tdr\">")
					+ ("<td class=\"tdr\">").length());
			tr = tr.substring(tr.indexOf(">") + 1);
			tradMoney = tradMoney.substring(tradMoney.indexOf(">") + 1,
					tradMoney.indexOf("</")).trim();
			// hightPrice = hightPrice.substring(startVal.indexOf("<td>")+4);
			// System.out.println(tradMoney);

			// startVal =
			// startVal.substring(startVal.indexOf(">")+1,startVal.indexOf("</")).trim();

			/***************************************/

			count++;

			html = html.trim();
			html = html.substring(trEnd).trim();
			// html = html.substring(html.indexOf("<tr")).trim();
			// System.out.println(html.substring(html.indexOf(">")+1));
			// System.out.println(html);
			// trIndex =trEnd;
			trIndex = html.indexOf(">");
			if (count > 0) {
				// break;
			}
			// 如果日期比已经存在则不添加。
			// if(!dao.getData(code, null, dateHtml).isEmpty()){
			// continue;
			// }
			GpData data = new GpData();
			data.setCode(code);
			new BigDecimal(lastPirce);
			data.setFinalPrice(new BigDecimal(lastPirce));
			data.setHightPrice(new BigDecimal(hightPrice));
			data.setLowPrice(new BigDecimal(lowPrice));
			data.setMarketDate(dateHtml);
			data.setOpenPrice(new BigDecimal(startVal));
			data.setTradCount(new BigDecimal(tradCount));
			data.setTradPrice(new BigDecimal(tradMoney));
			list.add(data);
		}

		return list;
	}

	@Override
	public void js(GpInfo gpInfo) throws Exception {

		// 计算涨幅
		StringBuffer sql = new StringBuffer();
		sql.append(" update gp_data t set t.increase       = (select (t.final_price - temp.final_price) /");
		sql.append(" temp.final_price*100 from gp_data temp where temp.code = '"
				+ gpInfo.getCode()
				+ "' and temp.collect_num = (t.collect_num - 1)),");
		sql.append("  t.increase_money = (select (t.final_price - temp.final_price) from gp_data temp");
		sql.append("  where temp.code = '"
				+ gpInfo.getCode()
				+ "' and temp.collect_num = (t.collect_num  - 1) ) where t.increase=-99");
		sql.append(" AND T.CODE='" + gpInfo.getCode() + "'");

		this.getJdbcDao().excute(sql.toString(), null);

		// 计算均值
		String[] dates = { "3", "5", "8", "10", "12", "15", "18", "20", "25",
				"30", "35", "40", "45", "50", "55", "60", "70" };
		for (int i = 0; i < dates.length; i++) {
			sql.delete(0, sql.length());
			sql.append("UPDATE GP_DATA T SET T.VAR_"
					+ dates[i]
					+ "=(select sum(temp.final_price)/"
					+ dates[i]
					+ " "
					+ "from gp_data temp where temp.code=t.code and temp.collect_num>(t.collect_num-"
					+ dates[i] + ") AND TEMP.collect_num<=t.collect_num)");
			sql.append(" WHERE T.VAR_" + dates[i] + " IS  NULL and t.code='"
					+ gpInfo.getCode() + "'");
			this.getJdbcDao().excute(sql.toString(), null);

			String cirValue = getCirValue(gpInfo.getCode());
			GpInfo info = this.gpInfoMapper
					.selectByPrimaryKey(gpInfo.getCode());
			info.setCirValue(new BigDecimal(cirValue));
			this.gpInfoMapper.updateByPrimaryKey(info);

		}

	}

	public static final String getCirValue(String code) throws Exception {
		String link = DataResource.CIR_VALUE_URL;
		// String link = "http://quote.eastmoney.com/sh600604.html";
		String tempCode = code.startsWith("0") ? "sz" + code : "sh" + code;
		link = link.replace("{code}", tempCode);
		BufferedReader br = null;
		StringBuffer html = new StringBuffer();
		try {
			URL url = new URL(link);
			br = new BufferedReader(new InputStreamReader(url.openStream(),
					"gbk"));
			String line = null;
			while ((line = br.readLine()) != null) {
				html.append(line);
			}

			// System.out.println(html);
			// <td>流值：<span id="gt14_2">101.5亿</span></td>
			int index = html.indexOf("<td>流值：<span id=\"gt14_2\">");
			// System.out.println(index);
			if (index < 0) {
				return "-1";
			}
			String temp = html.substring(index, index + 200);
			index = temp.indexOf("亿");
			if (index < 0) {
				return "-1";
			}
			temp = temp
					.substring("<td>流值：<span id=\"gt14_2\">".length(), index);
			return temp.trim();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusException("获取市值错误");

		} finally {
			if (br != null) {
				br.close();
			}
		}

	}

	@Override
	public void recordError(String code, String error) throws Exception {
		GpInfo info = this.gpInfoMapper.selectByPrimaryKey(code);
		info.setState("-1");
		if (StringUtils.isNotBlank(error)) {
			error = error.length() > 1000 ? error.substring(0, 1000) : error;
		}
		info.setRemark(error);
		this.gpInfoMapper.updateByPrimaryKey(info);

	}

	@Override
	public List<GpData> getKLineGpData(String code, int dayCount) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from (select t.*  from gp_data t "
				+ "where t.code='"+code+"' and rownum<="+dayCount+" order by t.market_date desc )m order by m.market_date");

		return this.getJdbcDao().jdbcFindList(sql.toString(), null, GpData.class);
	}

}
