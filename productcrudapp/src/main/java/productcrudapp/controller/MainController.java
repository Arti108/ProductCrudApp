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
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String index(Model m) {
		System.out.println("product crud app");
		List<Product> productsList=productDao.getProducts();
		m.addAttribute("productsList",productsList);
		return "index";
	}
	//show add product form
	@RequestMapping("add-product")
	public String addProduct(Model m)
	{
		m.addAttribute("title", "Add Product");
		return "add-product";
	}
	//handle add product form
	@RequestMapping(value="/handle-product",method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,
			HttpServletRequest req) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(req.getContextPath()+"/");
	
		return redirectView;
	}
		
		//delete handler
		@RequestMapping("/delete/{productId}")
		public RedirectView deleteProduct(@PathVariable("productId") int productId,
				HttpServletRequest req) {
			this.productDao.deleteProduct(productId);
			RedirectView redirectView=new RedirectView();
		
			redirectView.setUrl(req.getContextPath()+"/");
			return redirectView;
			
	}
		
		//update product
		@RequestMapping("/update/{productId}")
		public String updateProduct(@PathVariable("productId") int productId,Model model) {
			Product product=this.productDao.getProduct(productId) ;
			model.addAttribute("product",product);
			return "update-product";
		}
}
