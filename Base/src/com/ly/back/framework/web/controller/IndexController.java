package com.ly.back.framework.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.back.framework.mybatis.model.sys.SysMenu;
import com.ly.back.framework.services.index.interfaces.IIndexSV;
import com.ly.common.util.AjaxResultUtil;

@Controller
@RequestMapping("/back/index")
public class IndexController {

//	private Log logger = LogFactory.getLog(IndexController.class);
	@Autowired
	private IIndexSV indexSV;// 服务接口

	/**
	 * 进入首页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/home.html")
	public String home() throws Exception {
		System.out.println("进入 home.html");
		return "/content/back/framework/home/index";
	}

	/**
	 * 获取菜单
	 */
	@RequestMapping("getMenus.ajax")
	@ResponseBody
	public Map<String, Object> getMenus(SysMenu sysMenu) {
	
		try {
			List<SysMenu> menuList = indexSV.getUserMenuList("",sysMenu.getParentMenuId());
			return AjaxResultUtil.getJsonMap(menuList);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResultUtil.getJsonMap(e);
		}
		
	}
	
}
