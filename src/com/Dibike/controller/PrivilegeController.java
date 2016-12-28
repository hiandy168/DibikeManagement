package com.Dibike.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Dibike.common.Result;
import com.Dibike.entity.Action;
import com.Dibike.entity.Action_role;
import com.Dibike.entity.Manage;
import com.Dibike.entity.Manage_action;
import com.Dibike.entity.Manage_role;
import com.Dibike.entity.Role;
import com.Dibike.service.Action_roleService;
import com.Dibike.service.ManageService;
import com.Dibike.service.Manage_actionService;
import com.Dibike.service.Manage_roleService;
import com.Dibike.service.PrivilegeService;
import com.Dibike.service.RoleService;

@Controller
@RequestMapping("/privilege")
public class PrivilegeController {
	private static Logger logger = Logger.getLogger(PrivilegeController.class);
	@Resource
	private PrivilegeService privilegeService;
	@Resource
	private RoleService roleService;
	@Resource
	private Action_roleService action_roleService;
	@Resource
	private Manage_roleService manage_roleService;
	@Resource
	private Manage_actionService manage_actionService;
	@Resource
	private ManageService manageService;
	
	
	@RequestMapping(value = "/queryAll")
	@ResponseBody
	public Result queryAll(){ 
		logger.info("-------查询所有部门 和权限------");
		Result result = new Result();
		List<Role> roleList = roleService.findAllRole();
		List<Action> actionList = privilegeService.findAllAction();
		List<List> list = new ArrayList<List>();
		if(roleList==null||actionList==null){
			result.setStatus("1");
			return result;	
		}
		list.add(roleList);
		list.add(actionList);
		result.setData(list);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/updateRolePrivilege")
	@ResponseBody
	public Result updateRolePrivilegey(String roleID,List<String> actionIDs){ 
		logger.info("-------修改部门权限------");
		Result result = new Result();
		//查询该部门权限
		List<Action_role> action_roleList = action_roleService.findByRoleID(roleID);
		//删除该部门权限
		for(Action_role action_role:action_roleList){
			action_roleService.deleteAction_role(action_role);
		}
		//插入已经更改的权限
		for(String actionID:actionIDs){
			Action_role action_role = new Action_role();
			action_role.setActionID(actionID);
			action_role.setRoleID(roleID);
			action_roleService.saveAction_role(action_role);
		}
		
		/**
		 * 删除不符合的员工权限
		 */
		//查询该部门的员工
		List<Manage_role> Manage_roleList = manage_roleService.findByRoleID(roleID);
		if(Manage_roleList==null){
			result.setStatus("0");
			return result;
		}
		for(Manage_role manage_role:Manage_roleList){
			String manageID = manage_role.getManageID();
			//查询员工的权限id
			List<Manage_action> manage_actionList = manage_actionService.findByManageID(manageID);
			if(manage_actionList==null){
				result.setStatus("0");
				return result;
			}
			for(Manage_action manage_action:manage_actionList){
				String actionID = manage_action.getActionID();
				//部门员工权限ID不在部门权限ID范围之内，则删掉员工该条权限记录
				if(!actionIDs.contains(actionID)){
					//删掉该条记录
					manage_actionService.deleteManage_action(manage_action);
				}
			}
		}
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/queryManageAndRole")
	@ResponseBody
	public Result queryManageAndRole(String roleID){
		logger.info("-------查询出该部门员工和权限------");
		Result result = new Result();
		List<Manage> manageList = manageService.findByRoleID(roleID);
		List<Action> actionList = privilegeService.findByRoleID(roleID);
		List<List> list = new ArrayList<List>();
		list.add(actionList);
		list.add(manageList);
		result.setData(list);
		result.setStatus("0");
		return result;
		
	}

	@RequestMapping(value = "/updateManagePrivilege")
	@ResponseBody
	public Result updateManagePrivilegey(List<String> actionIDs,String manageID){ 
		logger.info("-------修改个人权限------");
		Result result = new Result();
		
		result.setStatus("0");
		return result;
	}
	

}


















