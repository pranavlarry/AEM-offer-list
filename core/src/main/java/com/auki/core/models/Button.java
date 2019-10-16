package com.auki.core.models;

//import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
//import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.*;

@Model(adaptables = Resource.class,defaultInjectionStrategy= DefaultInjectionStrategy.OPTIONAL)
public class Button {
	@Inject @Default(values="button")
	private String type;
	@Inject @Default(values="button")
	private String title;
	@Inject @Default(values="#")
	private String link;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
