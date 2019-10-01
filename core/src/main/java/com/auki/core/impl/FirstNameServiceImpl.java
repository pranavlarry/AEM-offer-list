package com.auki.core.impl;

import org.osgi.service.component.annotations.Component;
import com.auki.core.services.FirstNameService;

@Component(service=FirstNameService.class,immediate=true)
public class FirstNameServiceImpl implements FirstNameService {

	@Override
	public String firstName() {
		return "Pranav ";
	}

}
