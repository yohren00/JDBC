package Len;

import java.sql.Date;
import java.util.List;

import Len.dao.EmpDAO;

public class Service {
	
	public void addEmp(String lastName , String firstName ,String birthDate) {
		//轉換DATE中的/換成-
		birthDate =birthDate.replace("/", "-");
		Date date = Date.valueOf(birthDate);
		
		EmpDAO empdao = new EmpDAO();
		empdao.insert(lastName, firstName, date);
		
	}
	
	public List<String[]> findAllEmp(){
		EmpDAO empdao = new EmpDAO();
		List<String[]> list = empdao.selectAll();
		
		
		return list;
	}

}
