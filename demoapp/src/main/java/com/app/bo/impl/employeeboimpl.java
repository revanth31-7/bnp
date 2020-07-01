package com.app.bo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.bo.employeeBO;
import com.app.exception.BusinessException;
import com.app.model.employee;

public class employeeboimpl implements employeeBO {
private static Map<Integer,employee> employeeMap=new HashMap<>();
private static int count=0;

	
	@Override
	public employee createemployee(employee employee) {
		((com.app.model.employee) employee).setId(++count);
		employeeMap.put(employee.getId(), employee);
		return employee;
	}

	@Override
	public employee getemployeeByID(int id) throws BusinessException {
		employee employee=null;
		if(employeeMap.containsKey(id)) {
			employee=employeeMap.get(id);
		}else {
			throw new BusinessException("employee with id" +id+"not found");
		}
		
		return employee;
	}

	@Override
	public void removeemployeeByID(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<employee> getAllemployees() {
		List<employee> employeeList=new ArrayList<>(employeeMap.values());
		return employeeList;
	}

	@Override
	public List<employee> getemployeessBygender(String gender) {
		// TODO Auto-generated method stub
		return null;
	}

}
