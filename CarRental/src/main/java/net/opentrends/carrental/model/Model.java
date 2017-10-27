package net.opentrends.carrental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Model")
public class Model {
	@Id
	@GeneratedValue
	int modelID;
	@Column(name="Model_No")
	String modelNo;
	@Column(name="Stock")
	int stock;
	@ManyToOne
	@JoinColumn(name="Brand_ID")
	Brand brand;

}
