package net.opentrends.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.opentrends.shoppingcart.dto.ProductDto;
import net.opentrends.shoppingcart.dto.SellerDto;
import net.opentrends.shoppingcart.model.Product;
import net.opentrends.shoppingcart.model.Seller;
import net.opentrends.shoppingcart.service.SellerService;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<ProductDto> listAll() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Product.class);
		List<Product> productList = criteria.list();
		List<ProductDto> productDtoList = new ArrayList<>();
		for (Product product : productList) {
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(product, productDto);
			productDto.setProductIdentity(product.getProductId());
			productDto.setSellerId(product.getSeller().getSellerId());
			productDto.setSellerName(product.getSeller().getFirstName());
			productDtoList.add(productDto);
		}
		return productDtoList;
	}

	@Override
	public ProductDto findById(int id) {
		Product product = sessionFactory.openSession().get(Product.class, id);
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		productDto.setProductIdentity(product.getProductId());
		productDto.setSellerId(product.getSeller().getSellerId());
		productDto.setSellerName(product.getSeller().getFirstName());
		return productDto;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product product = session.get(Product.class, id);
		session.getTransaction().commit();
		session.close();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		session1.delete(product);
		session1.getTransaction().commit();
		session.close();
	}

	@Override
	public void saveOrUpdate(ProductDto productDto) {

		if (productDto.getProductIdentity() == null) {

			Product product = new Product();
			BeanUtils.copyProperties(productDto, product);
			Seller seller = sessionFactory.openSession().get(Seller.class, productDto.getSellerId());
			product.setSeller(seller);
			sessionFactory.openSession().save(product);
		} else {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Product product = getProductById(productDto.getProductIdentity());
			session.getTransaction().commit();
			session.close();

			System.out.println(product.getProductId());

			Session session1 = sessionFactory.openSession();
			product.setProductName(productDto.getProductName());
			product.setProductPrice(productDto.getProductPrice());
			product.setProductDesc(productDto.getProductDesc());
			session1.beginTransaction();
			session1.saveOrUpdate(product);
			session1.getTransaction().commit();
			session1.close();
			System.out.println("implement");
		}
	}

	@Override
	public List<ProductDto> getProductsBySellerId(int id) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("seller.sellerId", id));
		List<Product> productList = criteria.list();
		List<ProductDto> productDtoList = new ArrayList<>();
		for (Product product : productList) {
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(product, productDto);
			productDto.setProductIdentity(product.getProductId());
			productDto.setSellerId(product.getSeller().getSellerId());
			productDto.setSellerName(product.getSeller().getFirstName());
			productDtoList.add(productDto);
		}
		return productDtoList;
	}

	@Override
	public ProductDto getProductByProductName(String productName) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("productName", productName));
		Product product = (Product) criteria.uniqueResult();
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		productDto.setProductIdentity(product.getProductId());
		productDto.setSellerId(product.getSeller().getSellerId());
		productDto.setSellerName(product.getSeller().getFirstName());
		return productDto;
	}

	@Override
	public Product getProductById(Integer id) {
		return sessionFactory.openSession().get(Product.class, id);
	}

}
