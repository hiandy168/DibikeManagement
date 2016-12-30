package com.Dibike.controller;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Dibike.common.Result;
import com.Dibike.common.SHA1;
import com.Dibike.entity.Action;
import com.Dibike.entity.Manage;
import com.Dibike.service.ActionService;
import com.Dibike.service.ManageService;
import com.Dibike.service.Manage_actionService;

@Controller
@RequestMapping("/manage")
public class ManageController {
	private static Logger logger = Logger.getLogger(ManageController.class);
	@Resource
	private ManageService manageService;
	@Resource
	private Manage_actionService manage_actionService;
	@Resource
	private ActionService actionService;
	
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public Result manageLogin(String username,String password){
		logger.info("-------登录------");
		Result result = new Result();
		Manage manage = manageService.findByName(username);
		if(manage!=null && manage.getPassword().equals(new SHA1().getDigestOfString(password.getBytes()))){
			logger.info("-------登录成功-------");
			//显示该员工拥有的权限
			//获取父节点ID
			List<String> pids = actionService.findpidsByManageID(manage.getManageID());
			List<List> lists = new ArrayList<List>();
			if(pids==null){
				result.setStatus("0");
				result.setData(lists);
				return result;
			}
			for(String pid:pids){
				//遍历每个父节点
				List<List> list = new ArrayList<List>();
				List<Action> actiona = actionService.findByActionID(pid);
				List<String> pidNameList = new ArrayList<String>();
				if(actiona==null){
					result.setStatus("0");
					result.setData(lists);
					return result;
				}
				String pidName = actiona.get(0).getName();
				//获取一个父节点的名字
				pidNameList.add(pidName);
				//根据这个父节点和用户id查询该用户可以有的权限
				List<String> midNameList = actionService.findmidNameByManageID(manage.getManageID(),pid);
				list.add(pidNameList);
				list.add(midNameList);
				lists.add(list);
			}
			result.setStatus("0");
			result.setData(lists);
			return result;
		}
		logger.info("-------登录失败-------");
		result.setStatus("1");
		result.setMsg("用户名或密码错误");
		return result;
	}

	@RequestMapping("/updateManage")
	@ResponseBody
	public Result updateManage(String oldName,String newName){
		logger.info("-------修改个人信息------");
		Result result = new Result();
		if(oldName==null || newName==null){
			result.setMsg("修改个人信息失败");
			return result;
		}
		Manage manage = manageService.findByName(oldName);
		manage.setName(newName);
		manageService.updateManage(manage);
		result.setStatus("0");
		result.setMsg("修改个人信息成功");
		result.setData(manage);
		return result;
	}
	
	@RequestMapping("/updateManagePassword")
	@ResponseBody
	public Result updateManagePassword(String name,String newPassword){
		logger.info("-------修改密码------");
		Result result = new Result();
		if(newPassword==null){
			result.setMsg("修改密码失败");
			return result;
		}
		Manage manage = manageService.findByName(name);
		manage.setPassword(new SHA1().getDigestOfString(newPassword.getBytes()));
		manageService.updateManage(manage);
		result.setStatus("0");
		result.setMsg("修改密码成功");
		result.setData(manage);
		return result;
	}
	
//	@RequestMapping("/addManage")
//	@ResponseBody
//	public Result addManage(String name){
//		logger.info("-------增加管理员------");
//		Result result = new Result();
//		if(name!=null && !name.equals("")){
//			Manage manage = new Manage();
//			manage.setName(name);
//			//初始密码为123456
//			manage.setPassword(new SHA1().getDigestOfString("123456".getBytes()));
//			manageService.saveManage(manage);
//			result.setStatus("0");
//			result.setMsg("增加管理员成功");
//			return result;
//		}
//		result.setStatus("1");
//		result.setMsg("增加管理员失败");
//		return result;
//	}

}

 























