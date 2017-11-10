package net.opentrends.carrental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Rent")
public class Rent {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="Rent_ID")
int rentID;
@Column(name="Daily_Rent")
Integer dailyRent;
@OneToOne
@JoinColumn(name="Model_ID")
Model model;
public Rent() {}
public Rent(Integer dailyRent) {
	super();
	this.dailyRent = dailyRent;
}
public int getRentID() {
	return rentID;
}
public void setRentID(Integer rentID) {
	this.rentID = rentID;
}
public Integer getDailyRent() {
	return dailyRent;
}
public void setDailyRent(int dailyRent) {
	this.dailyRent = dailyRent;
}
public Model getModel() {
	return model;
}
public void setModel(Model model) {
	this.model = model;
}

}
