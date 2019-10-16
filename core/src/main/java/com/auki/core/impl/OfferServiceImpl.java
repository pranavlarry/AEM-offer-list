package com.auki.core.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.sling.api.resource.Resource;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import com.auki.core.models.OfferModel;
import com.auki.core.services.OfferService;
import com.day.cq.wcm.api.Page;

@Component(service=OfferService.class,immediate=true)
@Designate(ocd = OfferServiceImpl.Config.class)
public class OfferServiceImpl implements OfferService {

	@Reference
	private ResourceResolverFactory resourceResolverFactory;
	
	private String path;
	
	@ObjectClassDefinition(name = "Test config", description = "Test config path")
	public static @interface Config{
		@AttributeDefinition(name = "path value")
		String path_value() default "/content/529/en/offer-page/";
	}
	
	
	
	@Activate
	protected void active(final Config config) {
		this.path=config.path_value();
	}
	
	
	
	
	@Override
	public ArrayList<OfferModel> offerModelList(String pagePath) {
		
		ArrayList<OfferModel> offerModel=new ArrayList<>();
		
		final Map<String, Object> params = new HashMap<>();
		params.put(ResourceResolverFactory.SUBSERVICE, "test");
		
		ResourceResolver resourceResolver = null;
		
		try {
			resourceResolver = resourceResolverFactory.getServiceResourceResolver(params);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Resource resource=resourceResolver.getResource(this.path);
			Page parentPage =resource.adaptTo(Page.class);
			if(parentPage!=null) {
				Iterator<Page> listChildPages=parentPage.listChildren();
				while(listChildPages.hasNext()) {
					String pageName=listChildPages.next().getName();
					try {
						String link=this.path+pageName;
						resource=resourceResolver.getResource(link+"/jcr:content/root/teaser");
						ValueMap properties = resource.adaptTo(ValueMap.class);
						String image = properties.get("fileReference", (String) null);
						String sdate = properties.get("sdate", (String) null);
						String edate = properties.get("edate", (String) null);
						String description = properties.get("jcr:description", (String) null);
						OfferModel newOfferModel = new  OfferModel(image,description,sdate,edate,link);
						offerModel.add(newOfferModel);
					}
					catch(Exception e) {
						
					}
				}
			}
		}catch(Exception e) {
			
		}
		// TODO Auto-generated method stub
		return offerModel;
	}

}
