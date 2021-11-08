package com.jrp.pma.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.EmployeeRepository;

@Service
public class TestService {
	
//	@Qualifier("testPrimaryandQualifier1")
//	@Autowired
	TestPrimaryandQualifier tpq;
	
//	@Autowired
//	public void setEmpRepo(TestPrimaryandQualifier tpq) {
//		this.tpq=tpq;
//	}

	public TestService(@Qualifier("testPrimaryandQualifier1")  TestPrimaryandQualifier tpq) {
		super();
		this.tpq=tpq;
		}
}
