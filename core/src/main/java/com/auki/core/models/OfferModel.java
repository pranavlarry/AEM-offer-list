package com.auki.core.models;


public class OfferModel {
	private String image;
	private String description;
	private String sdate;
	private String edate;
	private String link;

	public String getImage() {
		return image;
	}

	public OfferModel(String image, String description,String sdate,String edate,String link) {
		super();
		this.image = image;
		this.description = description;
		this.sdate = sdate;
		this.edate = edate;
		this.link = link;
	}



	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
