package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Manufacturer;
import entity.Product;
import service.ManufacturerServices;
import service.ProductServices;

public class HelloServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("Bat Dau");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Ket Thuc");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		System.out.println("Phuong thuc cua req" + req.getMethod());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        Product product = new Product("Product", "Demo");
        Product product1 = new Product("Product1", "Demo1");
        Product product2 = new Product("Product2", "Demo2");
        Product product3 = new Product("Product3", "Demo3");
        ProductServices productService = new ProductServices();
        productService.save(product);
        productService.save(product1);
        productService.save(product2);
        productService.save(product3);

        Manufacturer manufacturer=new Manufacturer("Manu","Soft","soft@gmail.com","0345456466","softTech");
        Manufacturer manufacturer1=new Manufacturer("Manu1","Soft1","soft1@gmail.com","0345456476","softTech1");
        Manufacturer manufacturer2=new Manufacturer("Manu2","Soft2","soft2@gmail.com","0345454466","softTech2");
        Manufacturer manufacturer3=new Manufacturer("Manu3","Soft3","soft3@gmail.com","0345455666","softTech3");
        Manufacturer manufacturer4=new Manufacturer("Manu4","Soft4","soft4@gmail.com","0345412466","softTech4");

        ManufacturerServices manufacturerServices=new ManufacturerServices();
        manufacturerServices.save(manufacturer);
        manufacturerServices.save(manufacturer1);
        manufacturerServices.save(manufacturer2);
        manufacturerServices.save(manufacturer3);
        manufacturerServices.save(manufacturer4);
        List<Manufacturer>list=manufacturerServices.findAll();
        List<Product> lst = productService.findAll();
        // Hello
        out.println("<html><body>");
        out.println("<h1>" + list + "</h1>");
        out.println("</body></html>");
        out.println("\n");
        out.println("<html><body>");
        out.println("<h1>" + lst + "</h1>");
        out.println("</body></html>");
	}

}
