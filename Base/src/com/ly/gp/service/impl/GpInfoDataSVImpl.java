package com.ly.gp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.common.exception.BusException;
import com.ly.common.service.impl.BaseSV;
import com.ly.common.util.DateUtils;
import com.ly.common.util.EasyUiGirdUtil;
import com.ly.gp.mybatis.mapper.info.GpInfoMapper;
import com.ly.gp.mybatis.model.info.GpInfo;
import com.ly.gp.mybatis.model.info.GpInfoExample;
import com.ly.gp.searchModel.GpInfoSearchModel;
import com.ly.gp.service.interfaces.IGpInfoDataSV;
@Service("gpInfoDataSV")
public class GpInfoDataSVImpl extends BaseSV implements IGpInfoDataSV {
	
	@Autowired
	private GpInfoMapper gpInfoMapper;

	@Override
	public void initGpInfo(List<GpInfo> infoList) throws BusException {
		if(infoList==null||infoList.isEmpty()){
			return;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO GP_INFO(CODE,SHORT_NAME,NAME,STYPE,STATE,REMARK,CREATE_DATE)");
		sql.append("SELECT ?,?,?,?,?,?,SYSDATE FROM DUAL WHERE NOT exists");
		sql.append("(SELECT 1 FROM GP_INFO T WHERE T.CODE=?)");
		List<Object[]> params = new ArrayList<Object[]>();
		for (int i = 0; i < infoList.size(); i++) {
			GpInfo gpInfo = infoList.get(i);
			Object[] param = new Object[7];
			param[0] = gpInfo.getCode();
			param[1] = gpInfo.getName();
			param[2] = gpInfo.getName();
			param[3] = "1";
			param[4] = "1";
			param[5] = DateUtils.formatDate(new Date(), "yyyyMMdd HH:mm:ss")+"采集的数据";
			param[6] = gpInfo.getCode();
			params.add(param);
		}
		
		this.getJdbcDao().excuteBatch(sql.toString(), params);
		
		
	}

	@Override
	public String queryList(GpInfoSearchModel infoSearchModel) throws BusException {
		String sql = "select * from gp_info where state!='0'";
		List<Object> params = new ArrayList<Object>();
		
		int total = this.getJdbcDao().jdbcGetSize(sql, params);
		List<GpInfo> list = this.getJdbcDao().jdbcFindList(EasyUiGirdUtil.getPageSql(sql, infoSearchModel.getPage(),
				infoSearchModel.getRows()), params, GpInfo.class);


		return EasyUiGirdUtil
				.dataToGirdJson(total, infoSearchModel.getRows(), list);
	}

	@Override
	public List<GpInfo> queryAllList() throws BusException {
		GpInfoExample example = new GpInfoExample();
		GpInfoExample.Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo("1");
		return gpInfoMapper.selectByExample(example);
	}

	@Override
	public GpInfo getGpInfByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return gpInfoMapper.selectByPrimaryKey(code);
	}
}
