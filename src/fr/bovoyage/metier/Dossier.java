package fr.bovoyage.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import fr.bovoyage.metier.Participant;

@Entity
@Table (name="dossiers")
public class Dossier {
	@Id
	@Column(name="kp_dossier")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="ke_destination")
	private int iddest;
	@Column(name="ke_date_voyage")
	private int iddate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIddest() {
		return iddest;
	}

	public void setIddest(int iddest) {
		this.iddest = iddest;
	}

	public int getIddate() {
		return iddate;
	}

	public void setIddate(int iddate) {
		this.iddate = iddate;
	}

	public Dossier() {
	}
	
	public Dossier(int iddest, int iddate) {
		super();
		this.iddest = iddest;
		this.iddate = iddate;
	}

	
}
