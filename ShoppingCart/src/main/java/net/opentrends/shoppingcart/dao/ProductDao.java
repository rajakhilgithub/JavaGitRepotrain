package net.opentrends.shoppingcart.dao;

import java.util.List;

import net.opentrends.shoppingcart.dto.ProductDto;
import net.opentrends.shoppingcart.dto.SellerDto;
import net.opentrends.shoppingcart.model.Product;

public interface ProductDao {
	public List<ProductDto> listAll();

	public ProductDto findById(int id);

	public void delete(int id);

	public void saveOrUpdate(ProductDto productDto);

	public List<ProductDto> getProductsBySellerId(int id);

	public ProductDto getProductByProductName(String productName);
	
	public Product getProductById(Integer id);
}
