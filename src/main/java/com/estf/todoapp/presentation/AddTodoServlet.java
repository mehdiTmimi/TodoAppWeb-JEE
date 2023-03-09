package com.estf.todoapp.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estf.todoapp.beans.Todo;
import com.estf.todoapp.business.DefaultServices;


@WebServlet("/addTodo")
public class AddTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private String title;
	private String completed;
    public AddTodoServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/addTodo.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			title=request.getParameter("title");
			completed=request.getParameter("completed");
			if(title.isEmpty() || completed.isEmpty())
			{
				request.setAttribute("message", "all field are required");
				request.getRequestDispatcher("/WEB-INF/addTodo.jsp").forward(request, response);
			}
			else
			{
				Todo todo=new Todo();
				todo.setTitle(title);
				todo.setCompleted(completed.equals("true"));
				todo = DefaultServices.getInstance().addTodo(todo);
				if(todo==null)
				{
					request.setAttribute("message", "please try again later");
					request.getRequestDispatcher("/WEB-INF/addTodo.jsp").forward(request, response);		
				}
				else
					response.sendRedirect("listTodo");
			}
	}

}
