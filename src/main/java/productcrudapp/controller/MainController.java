package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {
	@Autowired
	ProductDao productDao;
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Product List");
		List<Product> products = productDao.getProducts();
		model.addAttribute("products", products);
		return "index";
	}
	@RequestMapping("/add-product")
	public String addProduct(Model model) {
		model.addAttribute("title", "Add Product");
		return "add_product_form";
	}
	@RequestMapping(path = "/handle-product" , method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product , HttpServletRequest request) {
		
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}

	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProdut(@PathVariable("productId") int productId , HttpServletRequest request) {
		this.productDao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/update/{productId}")
	public String update(@PathVariable("productId") int productId , Model model) {
		
		Product product =  this.productDao.getProduct(productId);
		model.addAttribute("product", product);
		model.addAttribute("title", "Update Product");
		return "update_product_form";
	}
	
	@RequestMapping(path = "/update-product" , method = RequestMethod.POST )
	public RedirectView updateProduct(@ModelAttribute Product product , HttpServletRequest request) {
		System.out.println(product);
		productDao.updateProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}

}
