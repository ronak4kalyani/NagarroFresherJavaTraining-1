package com.nagarro.javatraining.assignment9.BusinessService;

import com.nagarro.javatraining.assignment9.Dao.HrDao;
import com.nagarro.javatraining.assignment9.HB.HrDBAcessService;
import com.nagarro.javatraining.assignment9.modelObjects.Hr;

public class LoginProviderService {
	private Hr tmpHr = new Hr() ;
	
	public Hr getTmpHr() {
		return tmpHr;
	}


	public int provideLogin()
	{
		String userId = tmpHr.getUserId();
		String pass =  tmpHr.getPass();
		
		HrDao HrDBAcesssServiceObject = new HrDBAcessService() ;
		Hr userHr  = HrDBAcesssServiceObject.getHrUser(userId) ;
		
		if (userHr==null){
			System.out.println("No such user Exists");
			return 2 ;
		}
		else if (userHr.getPass().equals(pass)){
			System.out.println("User login Sucessful");
			return 0 ;
		}
		else
		{
			System.out.println("password entered incorrect ");
		return 1 ;
		}
	}
}
