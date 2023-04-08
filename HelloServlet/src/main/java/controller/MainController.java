package controller;

import entity.Manufacturer;
import entity.Product;
import service.ManufacturerServices;
import service.ProductServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controller", urlPatterns = "/Controller")
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ProductServices productServices = new ProductServices();
        ManufacturerServices manufacturerServices=new ManufacturerServices();
        HttpSession session = request.getSession(true);
        switch (action) {
            case "ListProduct":
                List<Product> lst = productServices.findAll();
                session.setAttribute("products", lst);
                response.sendRedirect("ListProduct.jsp");
                break;
            case "Manufacturer":
                List<Manufacturer> list=manufacturerServices.findAll();
                session.setAttribute("manufacturers",list);
                response.sendRedirect("Manufacturer.jsp");
                break;
            case "add_new_product":
                response.sendRedirect("add-product-form.jsp");
                break;
            case "add_product":
            String productName = request.getParameter("ProductName");
            String description = request.getParameter("Description");
            Product product = new Product(productName, description);
            productServices.save(product);
            response.sendRedirect("Controller?action=ListProduct");
            break;
        case"add_new_manufacturer":
            String manuName=request.getParameter("ManufacturerName");
            String manuContactName=request.getParameter("ManufacturerContactName");
            String manuContactEmail=request.getParameter("ManufacturerEmail");
            String manuContactPhone=request.getParameter("ManufacturerPhone");
            String manuWebsite=request.getParameter("ManufacturerWebsite");
            Manufacturer manufacturer=new Manufacturer(manuName,manuContactName,manuContactEmail,manuContactPhone,manuWebsite);
            response.sendRedirect("Controller?action=Manufacturer");
		case "update_product_view":
            String productid = request.getParameter("id");
            Product selProduct = productServices.findById(new Product(), Long.parseLong(productid));
            session.setAttribute("selProduct",selProduct);
            response.sendRedirect("update_products.jsp");
            break;
         case "update_manufacturer_view":
             String manuId=request.getParameter("id");
             Manufacturer selManu=manufacturerServices.findById(new Manufacturer(),Long.parseLong(manuId));
             session.setAttribute("selManu",selManu);
             response.sendRedirect("update_manufacturer.jsp");
             break;
          case"update_manufacturer":
              manuId=request.getParameter("manufacturerId");
              manuName=request.getParameter("manufacturerName");
              manuContactName=request.getParameter("manuContactName");
              manuContactEmail=request.getParameter("manuContactEmail");
              manuContactPhone=request.getParameter("manuContactPhone");
              manuWebsite=request.getParameter("manuWebsite");

		case "update_product":
            //chuỗi trong parameter("productId") phải trùng vời chuỗi bên file jsp name="productId"
			productid = request.getParameter("productId");
			productName = request.getParameter("productName");
			description = request.getParameter("description");
			Product product1 = new Product(productName, description);
			product1.setProductId(Integer.parseInt(productid));
			productServices.updateProduct(product1);
            response.sendRedirect("Controller?action=ListProduct");
            break;
        case "delete_product":
        	productid = request.getParameter("id");
        	Product delProduct = new Product();
        	delProduct.setProductId(Integer.parseInt(productid));
        	productServices.deleteProduct(delProduct, Long.parseLong(productid));
        	response.sendRedirect("Controller?action=ListProduct");
            break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("out put");
    }
}
