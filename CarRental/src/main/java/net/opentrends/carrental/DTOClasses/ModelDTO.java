package net.opentrends.carrental.DTOClasses;

import java.io.Serializable;

public class ModelDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6768649154498764761L;
	private int modelID;
	private String modelNo;
	private int stock;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
