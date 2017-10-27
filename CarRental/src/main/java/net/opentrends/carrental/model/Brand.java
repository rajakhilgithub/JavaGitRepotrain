package net.opentrends.carrental.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Brand")
public class Brand {
	@Id
	@GeneratedValue
	private int brandID;
	@Column(name="Name")
	private String name;
	@Column(name="Country_Origin")
	private String countryOrigin;
	@OneToMany(mappedBy="brand")
	Set<Model> model=new HashSet<Model>();
	public Brand(String name, String countryOrigin) {
		super();
		this.name = name;
		this.countryOrigin = countryOrigin;
	}
	public int getBrandID() {
		return brandID;
	}
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryOrigin() {
		return countryOrigin;
	}
	public void setCountryOrigin(String countryOrigin) {
		this.countryOrigin = countryOrigin;
	}
	public Set<Model> getModel() {
		return model;
	}
	public void setModel(Set<Model> model) {
		this.model = model;
	}
	

	
	
}
