<%@page import="com.estf.todoapp.beans.Todo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%List<Todo> todos= (List<Todo>) request.getAttribute("todos"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<main>
<table>
	<thead>
		<tr>
			<th>id</th>
			<th>title</th>
			<th>completed</th>
			<th>options</th>
		</tr>
	</thead>
	<tbody>
		<%for(Todo todo:todos){ %>
			<tr>
				<td><%=todo.getId() %></td>
				<td><%=todo.getTitle()%></td>
				<td><%=todo.getCompleted() %></td>
				<td><a href="deleteTodo?id=<%=todo.getId() %>">X</a></td>
			</tr>
		<%} %>
	</tbody>
</table>
</main>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>