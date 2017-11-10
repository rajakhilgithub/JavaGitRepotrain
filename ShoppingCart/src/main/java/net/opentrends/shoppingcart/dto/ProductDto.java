package net.opentrends.shoppingcart.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
	private Integer sellerId;
	private String sellerName;
	private Integer productIdentity;
	private String productName;
	private Integer productPrice;
	private String productDesc;

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Integer getProductIdentity() {
		return productIdentity;
	}

	public void setProductIdentity(Integer productIdentity) {
		this.productIdentity = productIdentity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

}
