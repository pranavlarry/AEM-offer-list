package com.auki.core.models;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import com.auki.core.services.OfferService;

@Model(adaptables = Resource.class)
public class Offer {
	
	@Inject
	private OfferService offerService;
	
	private ArrayList<OfferModel> offerModel=new ArrayList<>();
	
	@PostConstruct
	protected void init() {

		String pagePath="/content/529/en/offer-page/";
		offerModel=offerService.offerModelList(pagePath);

	}
	
	public ArrayList<OfferModel> getDetails() {
		return offerModel;
	}
		
	
}










//String link="/content/529/en/offer-page/"+pageName;
//resource=resourceResolver.getResource(link+"/jcr:content/root/teaser");
//ValueMap properties = resource.adaptTo(ValueMap.class);
//String image = properties.get("fileReference", (String) null);
//String sdate = properties.get("sdate", (String) null);
//String edate = properties.get("edate", (String) null);
//String description = properties.get("jcr:description", (String) null);
//OfferModel newOfferModel = new  OfferModel(image,description,sdate,edate,link);
