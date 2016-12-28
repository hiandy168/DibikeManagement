package com.Dibike.controller;


import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Dibike.common.Result;
import com.Dibike.entity.Certification;
import com.Dibike.entity.Member;
import com.Dibike.service.CertificationService;
import com.Dibike.service.MemberService;

@Controller
@RequestMapping("/certification")
public class CertificationController {
	private static Logger logger = Logger.getLogger(CertificationController.class);
	@Resource 
	private CertificationService certificationService;
	
	@Resource 
	private MemberService memberService;
	
	@RequestMapping(value = "/queryNoCheck")
	@ResponseBody
	public Result queryNoCheck(){
		logger.info("-------查询外籍认证未审核------");
		Result result = new Result();
		String status = "Y";
		List<Certification> list = certificationService.findByStatus(status);
		result.setData(list);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/queryPass")
	@ResponseBody
	public Result queryPass(){
		logger.info("-------查询外籍认证审核通过------");
		Result result = new Result();
		String status = "O";
		List<Certification> list = certificationService.findByStatus(status);
		result.setData(list);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/queryNoPass")
	@ResponseBody
	public Result queryNoPass(){
		logger.info("-------查询外籍认证审核驳回------");
		Result result = new Result();
		String status = "N";
		List<Certification> list = certificationService.findByStatus(status);
		result.setData(list);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/check")
	@ResponseBody
	public Result check(String memberID){
		logger.info("-------外籍友人认证审核------");
		Result result = new Result();
		Certification certification = certificationService.findByMemberID(memberID);
		result.setStatus("0");
		result.setData(certification);
		return result;
	}
	
	
	@RequestMapping(value = "/checkPass")
	@ResponseBody
	public Result checkPass(String memberID){
		logger.info("-------外籍友人认证通过------");
		Result result = new Result();
		Certification certification = certificationService.findByMemberID(memberID);
		certification.setStatus("O");
		certificationService.updateCertification(certification);
		//认证通过的修改member表中的字段
		Member member = memberService.findByMemberID(memberID);
		member.setBank2("A");
		memberService.saveMember(member);
		result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/checkNoPass")
	@ResponseBody
	public Result checkNoPass(String memberID){
		logger.info("-------外籍友人认证不通过------");
		Result result = new Result();
		Certification certification = certificationService.findByMemberID(memberID);
		certification.setStatus("N");
		certificationService.updateCertification(certification);
		result.setStatus("0");
		return result;
	}
	

}
