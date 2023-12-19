package valerko.lgs.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import valerko.lgs.domain.Bucket;
import valerko.lgs.domain.Product;
import valerko.lgs.domain.User;
import valerko.lgs.service.BucketService;
import valerko.lgs.service.ProductService;
import valerko.lgs.service.UserService;
import valerko.lgs.service.impl.BucketServiceImpl;
import valerko.lgs.service.impl.ProductServiceImpl;
import valerko.lgs.service.impl.UserServiceImpl;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private	BucketService bucketService = BucketServiceImpl.getBucketService();
	private ProductService productService = ProductServiceImpl.getProductService();
	private UserService userService = UserServiceImpl.getUserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
//		String product_id = request.getParameter("product_id");
//		Product product = productService.read(Integer.parseInt(product_id));
		
		Integer user_id = (Integer)session.getAttribute("user_id");
		User user = null;
		if(user_id != null) user = userService.read(user_id);
		
		if(user != null) {
			List <Bucket> buckets = bucketService.readByUser(user);	
			String json = new Gson().toJson(buckets);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String product_id = request.getParameter("product_id");
		Product product = productService.read(Integer.parseInt(product_id));

		Integer user_id = (Integer) session.getAttribute("user_id");
		User user = userService.read(user_id);

		Bucket bucket = new Bucket();
//		bucket.setId(UUID.randomUUID().toString());
		bucket.setProduct(product);
		bucket.setUser(user);
		bucket.setPurchaseDate(new Date());
		bucketService.create(bucket);

		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bucketId = request.getParameter("bucketId");
		bucketService.delete(Integer.parseInt(bucketId));

		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
