package com.service;

import com.model.LoginModel;
import com.repository.AdminLoginRepository;

public class AdminLoginService {

	AdminLoginRepository adRepo=new AdminLoginRepository();
	public boolean isAdminLogin(LoginModel model)
	{
		return adRepo.isAdminLogin(model);
	}
}
