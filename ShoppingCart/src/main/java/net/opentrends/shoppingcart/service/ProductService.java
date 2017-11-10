package net.opentrends.shoppingcart.service;

import java.util.List;

import net.opentrends.shoppingcart.dto.ProductDto;
import net.opentrends.shoppingcart.dto.SellerDto;

public interface ProductService {
	public List<ProductDto> listAll();

	public ProductDto findById(int id);

	public void delete(int id);

	public void saveOrUpdate(ProductDto productDto);

	public List<ProductDto> getProductsBySellerId(int id);

	public boolean findProductExists(ProductDto productDto);

	public ProductDto getProductByProductName(String productName);

}
