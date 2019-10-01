package com.auki.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.auki.core.services.FullNameService;

@Model(adaptables = Resource.class,defaultInjectionStrategy= DefaultInjectionStrategy.OPTIONAL)
public class Name {
	
	@Inject
	private FullNameService fullNameService;
	
	private String name;
	
	@PostConstruct
	protected void init() {

		name = fullNameService.fullName();
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
