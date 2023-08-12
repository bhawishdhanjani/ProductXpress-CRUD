package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component
public class ProductDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.save(product);
	}
	
	public List<Product> getProducts(){
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	public Product getProduct(int productId) {
		Product product=  this.hibernateTemplate.get(Product.class, productId);
		return product;
	}
	
	@Transactional
	public void deleteProduct(int produtId) {
		this.hibernateTemplate.delete(getProduct(produtId));
	}
	
	
	@Transactional
	public void updateProduct(Product product) {
		this.hibernateTemplate.update(product);
	}

}
