<%@ page import = "com.percyku.restaurant.entity.MenuItem" %>
<%@ page import = "java.util.List" %>

<html>
	<body>
		<jsp:include page="/WEB-INF/view/header.jsp" />
		<h2>Your search results:</h2>
		<ul>
			<%
System.out.println("123");
			List<MenuItem> menuItems = (List<MenuItem>)request.getAttribute("menuItems");

			for (MenuItem menuItem : menuItems) {
			%>
				<li><%=menuItem %></li>	
			<%
				}
			%>
		</ul>
		
	</body>
</html>