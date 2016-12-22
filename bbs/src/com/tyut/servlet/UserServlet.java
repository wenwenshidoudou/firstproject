package com.tyut.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyut.dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sign = request.getParameter("sign");
		
		HttpSession session = request.getSession();
		UserDao ud=new UserDao();
		if ("login".equals(sign)) {
			System.out.println(11);
			String un = request.getParameter("un")==null?(String)session.getAttribute("un"):request.getParameter("un");
			String pw = request.getParameter("pw")==null?(String)session.getAttribute("pw"):request.getParameter("pw");
			//UserDao ud=new UserDao();
			boolean isE =ud.login(un, pw);//类：方法。判断用户名是否存在

			if (isE) {
				session.setAttribute("un", un);
				session.setAttribute("pw", pw);
				
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			} else {
				//用户错误
				session.invalidate();
				response.sendRedirect("login.jsp");
			}

		} else if ("logout".equals(sign)) {
			session.invalidate();
			response.sendRedirect("login.jsp");
		}else if("userList".equals(sign)){
			System.out.println("heheheh");
			List<Users> userList = ud.getUserList();
																										
			if(userList!=null && userList.size()>0){
				request.setAttribute("size", userList.size());
				request.setAttribute("userList",userList);
			}
			request.setAttribute("userList",userList);
			request.getRequestDispatcher("userList.jsp").forward(request,response);
			
		}else if("delete".equals(sign)){
			
			String id =request.getParameter("id");
			//System.out.println(id+"ss");
			boolean f =ud.deleteUserById(id);
			if(f){
				//删除成功，跳转到用户页面	
				//System.out.println("进去没有111");
				request.getRequestDispatcher("UserServlet?sign=userList").forward(request,response);
			}
			else{
				System.out.println("删除失败");
			}
		}
	}
}
