package com.Dibike.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Dibike.common.Result;

@Controller
@RequestMapping("/file")
public class FileUploadController {
	
	@RequestMapping(value = "/check")
	@ResponseBody
	public Result check(){
		Result result = new Result();
	    List<List<String>> lists=new ArrayList<List<String>>();
        File file = new File("C:/intsmaze");
        //获取子文件
        File[] tempList = file.listFiles();
        //获取子文件的名字
        for(File temp:tempList){
        	List<String> list=new ArrayList<String>();
        	list.add(temp.getName());
        	list.add(temp.getAbsolutePath());
        	lists.add(list);
        }
        result.setData(lists);
        result.setStatus("0");
		return result;
	}
	
	@RequestMapping(value = "/upload")
	@ResponseBody
	public Result upload(String path,String fileName){
		return null;
		
	}

}
