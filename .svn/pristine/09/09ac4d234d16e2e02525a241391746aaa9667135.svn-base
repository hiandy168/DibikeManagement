package com.Dibike.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Dibike.common.Result;

@Controller
@RequestMapping("/file")
public class DataBackupController {
	
	@RequestMapping(value = "/check")
	@ResponseBody
	public Result check(){
		Result result = new Result();
	    List<List<String>> lists=new ArrayList<List<String>>();
        File file = new File("C:\\Users\\Administrator\\Desktop\\bb");
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
	
	@RequestMapping(value = "/download")
	@ResponseBody
	public Result download(String path,String fileName,HttpServletResponse response) throws IOException{
		Result result = new Result();
		File file = new File(path);
		// 取得文件的后缀名。 
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
        // 以流的形式下载文件。
        InputStream fis = new BufferedInputStream(new FileInputStream(path));
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        // 清空response
        response.reset();
        // 设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));
        response.addHeader("Content-Length", "" + file.length());
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
        result.setStatus("0");
        result.setMsg("下载成功");
		return result;
	}

}
