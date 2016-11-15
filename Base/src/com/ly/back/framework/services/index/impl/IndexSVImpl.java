package com.ly.back.framework.services.index.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.back.framework.mybatis.mapper.sys.SysMenuMapper;
import com.ly.back.framework.mybatis.model.sys.SysMenu;
import com.ly.back.framework.mybatis.model.sys.SysMenuExample;
import com.ly.back.framework.services.index.interfaces.IIndexSV;
import com.ly.common.service.impl.BaseSV;
import com.ly.common.util.StringUtils;
@Service("indexSV")
public class IndexSVImpl extends BaseSV implements IIndexSV{
	@Autowired
	private SysMenuMapper menuMapper;

	@Override
	public List<SysMenu> getUserMenuList(String userId,String parentMenuId) throws Exception {
		SysMenuExample example = new SysMenuExample();
		SysMenuExample.Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo("1");
		if(StringUtils.isNotBlank(parentMenuId)){
			criteria.andParentMenuIdEqualTo(parentMenuId);
		}
		
		return menuMapper.selectByExample(example);
	}

}
