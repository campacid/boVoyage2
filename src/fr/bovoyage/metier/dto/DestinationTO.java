package fr.bovoyage.metier.dto;

import java.util.List;

import fr.bovoyage.metier.Destination;

public class DestinationTO {

	private int id;
	private String region;
	private String description;
	private List<String> images;
	
	public DestinationTO(Destination destination) {
		super();
		this.id = destination.getId();
		this.region = destination.getRegion();
		this.description = destination.getDescription();
		this.images = destination.getImages();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	
	

}
