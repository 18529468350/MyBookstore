package com.bookstore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.domain.Product;
import com.bookstore.service.ProductService;

public class BookListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用 业务逻辑
		ProductService ps = new ProductService();
		List<Product> list = ps.findAllBooks();
		
		//跳转页面
	
			request.setAttribute("books", list);//把list放入到request对象中
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
