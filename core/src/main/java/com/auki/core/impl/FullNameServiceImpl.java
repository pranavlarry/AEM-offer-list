package com.auki.core.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.core.services.FullNameService;
import com.day.cq.wcm.api.Page;
import com.auki.core.services.FirstNameService;


@Component(service=FullNameService.class,immediate=true)
public class FullNameServiceImpl implements FullNameService {
	
	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	
	public String fullName() {
		final Map<String, Object> params = new HashMap<>();
		params.put(ResourceResolverFactory.SUBSERVICE, "test");
		
		ResourceResolver resourceResolver=null;
		
		try {
			resourceResolver= resourceResolverFactory.getServiceResourceResolver(params);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		firstNameService.firstName() +
		
		Resource resource=resourceResolver.getResource("/content/529/en/offer-page");
		Page parentPage =resource.adaptTo(Page.class);
		return  parentPage.getName();
	}
}


