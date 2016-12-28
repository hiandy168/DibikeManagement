package com.Dibike.service;

import java.util.List;

import com.Dibike.entity.Certification;

public interface CertificationService {

	List<Certification> findByStatus(String status);

	void updateCertification(Certification certification);

	Certification findByMemberID(String memberID);

}
