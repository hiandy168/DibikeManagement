package com.Dibike.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
import com.Dibike.service.ActionService;
import com.Dibike.service.Action_roleService;
import com.Dibike.service.ManageService;
import com.Dibike.service.Manage_actionService;
import com.Dibike.service.Manage_roleService;
import com.Dibike.service.RoleService;

@Controller
@RequestMapping("/action")
public class ActionController {
	private static Logger logger = Logger.getLogger(ActionController.class);
	@Resource
	private ActionService actionService;
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
	
	
	@RequestMapping(value = "/queryAllRole")
	@ResponseBody
	public Result queryAllRole(){ 
		logger.info("-------查询所有部门 ------");
		Result result = new Result();
		List<Role> roleList = roleService.findAllRole();
		if(roleList==null){
			result.setStatus("1");
			return result;	
		}
		result.setData(roleList);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/queryAllAction")
	@ResponseBody
	public Result queryAllAction(){ 
		logger.info("-------查询所有权限------");
		Result result = new Result();
		//获取所有的父节点
		List<String> pids = actionService.findAllpids();
		List<List> lists = new ArrayList<List>();
		for(String pid:pids){
			List<List> list = new ArrayList<List>();
			List<Action> actiona = actionService.findByActionID(pid);
			List<String> pidNameList = new ArrayList<String>();
			//父节点的名字
			String pidName = actiona.get(0).getName();
			pidNameList.add(pidName);
			//获取该父节点的所有子节点的名字
			List<String> midNameList = actionService.findActionSonBypid(pid); 
			list.add(pidNameList);
			list.add(midNameList);
			lists.add(list);
		}
		result.setData(lists);
		result.setStatus("0");
		return result;
	}
	
	
	@RequestMapping(value = "/updateRoleAction")
	@ResponseBody
	public Result updateRoleAction(String roleID,String[] actionIDs){ 
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
				for(int i=0;i<actionIDs.length-1;i++){
					if(actionIDs[i]!=actionID){
						//删掉该条记录
						manage_actionService.deleteManage_action(manage_action);
					}
				}
			}
		}
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/queryManage")
	@ResponseBody
	public Result queryManage(String roleID){
		logger.info("-------查询出该部门员工------");
		Result result = new Result();
		List<Manage> manageList = manageService.findByRoleID(roleID);
		result.setData(manageList);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/queryAction")
	@ResponseBody
	public Result queryAction(String roleID){
		logger.info("-------查询出该部门权限------");
		Result result = new Result();
		//查询该部门权限
		//查询该部门父节点
		List<String> pids = actionService.findpidsByRoleID(roleID);
		List<List> lists = new ArrayList<List>();
		if(pids==null){
			result.setData(lists);
			result.setStatus("0");
			return result;
		}
		for(String pid:pids){
			List<List> list = new ArrayList<List>();
			List<Action> actiona = actionService.findByActionID(pid);
			List<String> pidNameList = new ArrayList<String>();
			String pidName = actiona.get(0).getName();
			//获取父节点名字
			pidNameList.add(pidName);
			//获取该部门该父节点下的子节点名字
			List<String> midNameList = actionService.findmidNameByRoleID(pid,roleID); 
			list.add(pidNameList);
			list.add(midNameList);
			lists.add(list);
		}
		result.setData(lists);
		result.setStatus("0");
		return result;
		
	}

	@RequestMapping(value = "/updateManageAction")
	@ResponseBody
	public Result updateManageAction(String[] actionIDs,String manageID){ 
		logger.info("-------修改个人权限------");
		Result result = new Result();
		//删除员工原有权限
		List<Manage_action> manage_actionList = manage_actionService.findByManageID(manageID);
		if(manage_actionList!=null){
			for(Manage_action manage_action:manage_actionList){
				manage_actionService.deleteManage_action(manage_action);
			}
		}
		//将修改之后的员工权限存进表
		for(String actionID:actionIDs){
			Manage_action manage_action = new Manage_action();
			manage_action.setManageID(manageID);
			manage_action.setActionID(actionID);
			manage_actionService.saveManage_action(manage_action);
		}
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/queryPidName")
	@ResponseBody
	public Result queryPidName(){ 
		logger.info("-------查询所有的父节点------");
		Result result = new Result();
		String pid = "0";
		List<String> pidsNameAndActionID = actionService.findNameAndActionIDByPid(pid); 
		result.setStatus("0");
		result.setData(pidsNameAndActionID);
		return result;
	}
	
	@RequestMapping(value = "/addAction")
	@ResponseBody
	public Result addAction(String name,String pid){ 
		logger.info("-------增加菜单------");
		Result result = new Result();
		Action action = new Action();
		action.setName(name);
		action.setPid(pid);
		//生成actionID
		List<Action> actions = actionService.findAllAction();
		Action actionExtra = actions.get(actions.size()-1);
		String actionID = actionExtra.getActionID();
		int i = Integer.parseInt(actionID);
		String number = String.valueOf(i+1);
		action.setActionID(number);
		actionService.saveAction(action);
		result.setStatus("0");
		return result;
	}
	
//	@RequestMapping(value = "/checkAction")
//	@ResponseBody
//	public Result checkAction(String manageID,String actionID){ 
//		logger.info("-------判断是否有权限------");
//		Result result = new Result();
//		//获取员工权限
//		List<Manage_action> manage_actionList = manage_actionService.findByManageID(manageID);
//		if(manage_actionList==null){
//			result.setStatus("1");
//			result.setMsg("无权限");
//			return result;
//		}
//		List<String> actionIDList = new ArrayList<>();
//		for(Manage_action manage_action:manage_actionList){
//			String actionIDd = manage_action.getActionID();
//			actionIDList.add(actionIDd);
//		}
//		if(actionIDList.contains(actionID)){
//			result.setStatus("0");
//			result.setMsg("有权限");
//			return result;
//		}
//		result.setStatus("1");
//		result.setMsg("无权限");
//		return result;
//	}
	
}


















