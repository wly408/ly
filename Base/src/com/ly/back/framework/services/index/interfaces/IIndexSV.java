package com.ly.back.framework.services.index.interfaces;

import java.util.List;

import com.ly.back.framework.mybatis.model.sys.SysMenu;

/**
 * 首页服务
 * @author ly
 *
 */
public interface IIndexSV {
	
	public List<SysMenu> getUserMenuList(String userId,String parentMenuId)throws Exception;

}
