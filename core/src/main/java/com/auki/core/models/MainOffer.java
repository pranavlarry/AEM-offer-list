package com.auki.core.models;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
//import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.*;

@Model(adaptables = Resource.class,defaultInjectionStrategy= DefaultInjectionStrategy.OPTIONAL)
public class MainOffer{
	@Inject
	private String fileReference;
	private static ArrayList<String> link=new ArrayList<>();
	
	@PostConstruct
	void init() {
		setLink(fileReference);
	}
	public String getFileReference() {
		return fileReference;
	}
	public void setFileReference(String fileReference) {
		this.fileReference = fileReference;
	}
	public static String getLink() {
		return link.get(1);
	}
	public static void setLink(String val) {
		MainOffer.link.add(val);
	}
	
	

	
	
	
	
}
