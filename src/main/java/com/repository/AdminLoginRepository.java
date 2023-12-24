package com.repository;

import com.model.LoginModel;

public class AdminLoginRepository extends DBConfig{

	public boolean isAdminLogin(LoginModel model)
	{
		try
		{
			stmt=conn.prepareStatement("select * from adminlogin where username=? and password=?");
			stmt.setString(1, model.getUsername());
			stmt.setString(2, model.getPassword());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}
}
