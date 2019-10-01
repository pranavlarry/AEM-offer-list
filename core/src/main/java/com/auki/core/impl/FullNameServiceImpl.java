package com.auki.core.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.core.services.FullNameService;
import com.auki.core.services.FirstNameService;


@Component(service=FullNameService.class,immediate=true)
public class FullNameServiceImpl implements FullNameService {
	
	@Reference
	private FirstNameService firstNameService;

	
	public String fullName() {
		return firstNameService.firstName() + "lari";
	}
}


