package com.auki.core.models;

import java.util.ArrayList;
import java.util.Iterator;
//import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Source;
import com.day.cq.wcm.api.Page;

@Model(adaptables = SlingHttpServletRequest.class)
public class MainOffer{
	@Inject
	@Source("sling-object")
	private ResourceResolver resourceResolver;
	private static ArrayList<PageDetails> details=new ArrayList<>();
	
	@PostConstruct
	void init() {
		try {
			Resource resource = resourceResolver.getResource("/content/529/en/offer-page");
			if(resource!=null) {
				Page parentPage =resource.adaptTo(Page.class);
				if(parentPage!=null) {
					Iterator<Page> listChildPages= parentPage.listChildren();
					while (listChildPages.hasNext()) {
						Page childPage = listChildPages.next();
						PageDetails detail = new  PageDetails();
						detail.setTitle(childPage.getTitle());
//						detail.setTitle("hello");
						detail.setDescription(childPage.getDescription());
						details.add(detail);
					}
				}
			}
		}
		catch(Exception e) { 
			e.printStackTrace();
		}
	}

	public static ArrayList<PageDetails> getDetails() {
		return details;
	}	
	
}
