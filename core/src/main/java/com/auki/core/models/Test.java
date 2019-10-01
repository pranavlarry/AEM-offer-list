package com.auki.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
//import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.*;

import com.auki.core.services.FullNameService;

@Model(adaptables = Resource.class,defaultInjectionStrategy= DefaultInjectionStrategy.OPTIONAL)
public class Test {
	
	@Inject
	private FullNameService fullNameService;
	
	@Inject 
	private String path;
	
	@Inject @Default(values="enter some text")
	private String text;
	
	private String filename;
	
	@PostConstruct
	protected void init() {
//		setFilename();
////		setText("hello there");
		filename = fullNameService.fullName();
		
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFilename() {
		return this.filename;
	}
//	public void setFilename() {
//		this.filename = this.path.substring( this.path.lastIndexOf('/')+1, this.path.lastIndexOf('.'));
//	}
	
	
	
}
