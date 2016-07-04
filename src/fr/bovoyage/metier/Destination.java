package fr.bovoyage.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;

@Entity
@Table (name="destinations")
public class Destination {

	@Id
	@Column(name="kp_destination")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String region;
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ke_destination")
	private List<DatesVoyage> datesVoyages = new ArrayList<>();
	
	// le nombre d'images étant limité et comme on ne véhicule que le nom de l'image il n'est pas 
	// dangereux de passer en mode EAGER pour cette collection.
	@ElementCollection(fetch = FetchType.EAGER) 
	@CollectionTable(name="images",joinColumns=@JoinColumn(name="ke_destination"))
	@Column(name="image")
	
	private List<String> images;
	
	public Destination(){
		
	}

	public Destination(String region, String description, List<DatesVoyage> datesVoyages, List<String> images) {
		this.region = region;
		this.description = description;
		this.datesVoyages = datesVoyages;
		this.images = images;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
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
	public List<DatesVoyage> getDatesVoyages() {
		return datesVoyages;
	}

	public void setDatesVoyages(List<DatesVoyage> datesVoyages) {
		this.datesVoyages = datesVoyages;
	}
	
	
}
