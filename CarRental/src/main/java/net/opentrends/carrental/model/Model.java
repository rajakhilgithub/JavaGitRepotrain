package net.opentrends.carrental.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Model")
public class Model implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Model_ID")
	private int modelID;
	@Column(name="Model_No")
	private String modelNo;
	@Column(name="Stock")
	private Integer stock;
	
	@ManyToOne
	@JoinColumn(name="Brand_ID")
	private Brand brand;
	
	@OneToOne(mappedBy="model",cascade=CascadeType.ALL)
	private Rent rent;
	
	@OneToMany(mappedBy="model",cascade=CascadeType.ALL)
	private Set<Booking> booking=new HashSet<Booking>();
	
	public Model() {};
	public Model(String modelNo, int stock, Rent rent) {
		super();
		this.modelNo = modelNo;
		this.stock = stock;
		this.rent = rent;
	}
	public int getModelID() {
		return modelID;
	}
	public void setModelID(int modelID) {
		this.modelID = modelID;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Rent getRent() {
		return rent;
	}
	public void setRent(Rent rent) {
		this.rent = rent;
	}
	public Set<Booking> getBooking() {
		return booking;
	}
	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}
	
	
}
