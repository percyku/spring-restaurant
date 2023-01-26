<%@ page import = "com.percyku.restaurant.entity.MenuItem" %>
<%@ page import = "java.util.List" %>


<html>
	<body>
	    <jsp:include page="/WEB-INF/view/header.jsp" />
		<h2>Menu</h2>
		<ul>
			<%
			
			List<MenuItem> menuItems = (List<MenuItem>) request.getAttribute("menuItems");
			
			for (MenuItem menuItem : menuItems) {
			%>
				<li><%=menuItem %></li>	
			<%
				}
			%>
		</ul>
	</body>
</html>