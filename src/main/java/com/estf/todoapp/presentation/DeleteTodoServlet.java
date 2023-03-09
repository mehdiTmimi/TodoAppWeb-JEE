package com.estf.todoapp.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estf.todoapp.beans.Todo;
import com.estf.todoapp.business.DefaultServices;

/**
 * Servlet implementation class DeleteTodoServlet
 */
@WebServlet("/deleteTodo")
public class DeleteTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(!id.isEmpty()) {
			Todo todo=DefaultServices.getInstance().getTodo(id);
			todo = DefaultServices.getInstance().deleteTodo(todo);
			//verification
			response.sendRedirect("listTodo");
			//request.getRequestDispatcher("/WEB-INF/listTodos.jsp").forward(request, response);
		}
	}

	

}
