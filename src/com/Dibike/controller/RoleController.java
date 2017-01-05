package com.Dibike.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Dibike.common.Result;
import com.Dibike.entity.Role;
import com.Dibike.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	private static Logger logger = Logger.getLogger(RoleController.class);
	@Resource
	private RoleService roleService;
	
	@RequestMapping("/addRole")
	@ResponseBody
	public Result addRole(String name ){
		logger.info("-------增加部门------");
		Result result = new Result();
		Role r = roleService.findByName();
		if(r==null){
			Role role = new Role();
			//生成roleID
			List<Role> roles = roleService.findAllRole();
			Role roleExtra = roles.get(roles.size()-1);
			String roleID = roleExtra.getRoleID();
			int i = Integer.parseInt(roleID);
			String number = String.valueOf(i+1);
			
			role.setRoleID(number);
			role.setName(name);
			result.setStatus("0");
			result.setMsg("增加部门成功");
			return result;
		}
		result.setStatus("1");
		result.setMsg("增加部门失败");
		return result;
	}

}
