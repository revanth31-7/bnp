package com.app.bo;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.employee;

public interface employeeBO {
	
	public employee createemployee(employee employee);
	public employee getemployeeByID(int id1) throws BusinessException;
	public void removeemployeeByID(int id);
	public List<employee> getAllemployees();
	public List<employee> getemployeessBygender(String gender);

}
