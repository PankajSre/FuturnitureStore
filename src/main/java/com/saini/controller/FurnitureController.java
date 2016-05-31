package com.saini.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.saini.model.*;
import com.saini.service.CartService;
import com.saini.service.ProductsService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FurnitureController {

	Path path;
	static int data=1;
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = { "/", "/index" })
	public ModelAndView indexPage() {

		return new ModelAndView("index");
	}

	
	@RequestMapping(value = "/login")
	public ModelAndView loginPage(@RequestParam(value="error", required = false)
	String error,@RequestParam(value="logout", required = false)String logout,Model model) {
		if(error != null){
			model.addAttribute("error", "Invalid username and password");
			}

			if (logout !=null){
			model.addAttribute("msg", "You have been logged out successfully !!!!");
			}
			
		return new ModelAndView("loginPage");
	}

	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String doLogin(@Valid @ModelAttribute("validate") Login validate,
	            BindingResult result, Map<String, Object> model) {
	 
	        if (result.hasErrors()) {
	            return "loginPage";
	        }
	 
	        return "loginPage";
	    }

	@RequestMapping(value = "/about")
	public ModelAndView aboutPage() {

		return new ModelAndView("aboutPage");
	}


	@RequestMapping(value = "/products")
	public String productsPage(ModelMap model) {
     
		List<Products> products=productsService.getAllProducts();
	
		model.addAttribute("products", products);
		return "products";
	}
	
	

	/*
	@RequestMapping("/admin/prodRegistration")
	
	   public String productRegistration() {
	      return "prodRegistration";
	   }
	@ModelAttribute("insertProductCommand")
	public Products construct()
	{
	return new Products();
	}
*/

	
	@RequestMapping(value = "/prodRegistration")
	public String registrationPage(ModelMap map) {
		Products prodRegistration = new Products();
		map.put("products", prodRegistration);
		return "prodRegistration";

	}
	@ModelAttribute("products")
	public Products getLast()
	{
		return new Products();
		
	}
	@RequestMapping(value="/admin/prodRegistration",method=RequestMethod.POST)
	public ModelAndView insertProduct(@ModelAttribute("products")
	Products p, HttpServletRequest request, BindingResult result)
	{
		//productsService.add(product);
	
		
		
		System.out.println(p.getProductId());
		ServletContext context=request.getServletContext(); 
		String path=context.getRealPath("/resources/"+data+".jpg"); 
		System.out.println("Path = "+path); 
		System.out.println("File name = "+p.getImagePath().getOriginalFilename()); 
		File f=new File(path); 
		if(!p.getImagePath().isEmpty()) {
			try { 
		   //filename=p.getImagePath().getOriginalFilename(); 
			byte[] bytes=p.getImagePath().getBytes();
			BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
			bs.write(bytes); 
			bs.close(); 
			System.out.println("Image uploaded");
			productsService.add(p);
			
			System.out.println("Data Inserted");
			}
			catch(Exception ex)
			{
			System.out.println(ex.getMessage());
			}
			}
		/*
		 MultipartFile productImage = product.getImagePath();
	        String rootDirectory = request.getServletContext().getRealPath("/");
	         path = Paths.get(rootDirectory + "/WEB-INF/resources/" + product.getProductId() + ".jpg");

	        if(productImage != null && !productImage.isEmpty()){
	            try {
	                productImage.transferTo(new File(path.toString()));
	            } catch (Exception ex){
	                ex.printStackTrace();
	                throw new RuntimeException("Product image saving failed", ex);
	            }
	        }
	        */
	      return new ModelAndView("prodRegistration");
	
	}
	
/*
	@RequestMapping(value = "/admin/prodRegistration.do", method = RequestMethod.GET)
	public String doActions(@ModelAttribute Products products,
			BindingResult results, @RequestParam String action,
			Map<String, Object> map,HttpServletRequest request) {
		Products productResult = new Products();
		switch (action) {
		case "add":
              productsService.add(products);
              productResult=products;
			break;
		case "edit":
			productsService.edit(products);
            productResult=products;
			break;
		case "delete":
			productsService.delete(products.getProductId());
            productResult=new Products();
			break;
		case "search":
               Products searchProducts=productsService.getProduct(products.getProductId());
               productResult=searchProducts !=null ? searchProducts : new Products();
			break;

		}
		map.put("prodRegistration", productResult);
		map.put("productList", productsService.getAllProducts());
		return "prodRegistration";

	}
	*/

	@RequestMapping("/viewProduct")
	public String getProductById(@RequestParam("productId") int productId, Model model){
		Products p = productsService.getProduct(productId);
		model.addAttribute("product", p);
		return "viewProduct";
	}
	
	@RequestMapping("/delete")
	 public String deleteUser(@RequestParam int productId) {
		productsService.delete(productId);
	  return "redirect:products";
	 }
	
	@RequestMapping("/editProduct")
	public String editProductById(@RequestParam("productId") int productId, Model model){
		Products p = productsService.getProduct(productId);
		model.addAttribute("product", p);
		return "editProduct";
	}
	
	
	
	@RequestMapping(value="/editProducts/{productId}", method=RequestMethod.POST)
	public String editProduct(@PathVariable("productId")Integer productId,
	        @ModelAttribute("products") Products product, Map model){
	 
	    productsService.edit(product);
	    List productList=productsService.getAllProducts();
	    model.put("productList", productList);
	 
	    return "redirect:/products";
	}
	
	@RequestMapping("/cart")
	public String getCart(@RequestParam("productId") int productId, Model model){
		Products p = productsService.getProduct(productId);
		model.addAttribute("product", p);
		
		return "cart";
	}
	
	@RequestMapping("/deleteCart")
	 public String deleteCart(@RequestParam int productId) {
		productsService.delete(productId);
	  return "redirect:cart";
	 }
	
	@RequestMapping("/orderConfirmation")
	public String setCart(@RequestParam("productId") int productId, Model model){
		Products p = productsService.getProduct(productId);
		model.addAttribute("product", p);
		
		return "orderConfirmation";
	}
	
	@ModelAttribute("instOrder")
	public Cart authentication()
	{
		return new Cart();
	}
	@RequestMapping("/orderConfirm")
	public String addNewOrder(@ModelAttribute("instOrder") Cart cart , BindingResult result,Model model)
	{
		
		 Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		 String name=auth.getName();
		 cart.setQuantity(1);
		 cart.setUsername(name);
	     cartService.addTocart(cart);
	     model.addAttribute("cart", cart);
	   
	   
		return "thankCustomer";
	}
}
