package net.opentrends.shoppingcart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.opentrends.shoppingcart.dao.ProductDao;
import net.opentrends.shoppingcart.dao.SellerDao;
import net.opentrends.shoppingcart.dto.ProductDto;
import net.opentrends.shoppingcart.dto.SellerDto;
import net.opentrends.shoppingcart.model.Product;
import net.opentrends.shoppingcart.model.Seller;

@Repository
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	@Autowired
	SellerDao sellerDao;

	@Override
	@Transactional
	public List<ProductDto> listAll() {

		return this.productDao.listAll();
	}

	@Override
	@Transactional
	public ProductDto findById(int id) {
		return this.productDao.findById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.productDao.delete(id);

	}

	@Override
	public void saveOrUpdate(ProductDto productDto) {
		this.productDao.saveOrUpdate(productDto);
	}

	@Override
	@Transactional
	public List<ProductDto> getProductsBySellerId(int id) {
		return this.productDao.getProductsBySellerId(id);
	}

	@Override
	@Transactional
	public boolean findProductExists(ProductDto productDto) {
		ProductDto productDto1 = new ProductDto();
		if (productDto.getProductIdentity() != null) {
			productDto1 = this.productDao.findById(productDto.getProductIdentity());
		}
		System.out.println("prodid:" + productDto.getProductIdentity());
		if (productDto.getProductIdentity() == null
				|| !(productDto.getProductName().equalsIgnoreCase(productDto1.getProductName()))) {
			List<ProductDto> productDtoList = this.productDao.listAll();
			for (ProductDto productDtoTemp : productDtoList) {
				if (productDtoTemp.getProductName().equalsIgnoreCase(productDto.getProductName())) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	@Transactional
	public ProductDto getProductByProductName(String productName) {
		return this.productDao.getProductByProductName(productName);
	}

}
