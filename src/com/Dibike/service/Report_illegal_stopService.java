package com.Dibike.service;

import java.util.List;

import com.Dibike.entity.Report_illegal_stop;


public interface Report_illegal_stopService {

	List<Report_illegal_stop> findByStatus(String status);

	Report_illegal_stop findById(String id);

	void updateReport_illegal_stop(Report_illegal_stop report_illegal_stop);
	

}
