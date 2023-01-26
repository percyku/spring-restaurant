<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import = "java.util.List" %>

<html>
	<body>
		<jsp:include page="/WEB-INF/view/header.jsp" />
		<h2>Order your food</h2>

		<form action='${pageContext.request.contextPath}/order/getOrder' method='POST' >
		<ul>
		<c:forEach var="tempMenuItem" items ="${menuItems}">
		    <li>
                ${tempMenuItem.name}
                <input type='text' name="item_${tempMenuItem.id}"/>
		    </li>


		</c:forEach>

		
		</ul>
		<input type='submit' />
		</form>
		
	</body>
</html>