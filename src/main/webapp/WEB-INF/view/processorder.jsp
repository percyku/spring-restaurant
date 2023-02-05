<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import = "com.percyku.restaurant.entity.Order" %>
<%@ page import = "java.util.List" %>

<html>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />
	<h2>Update Orders</h2>

	<table style="border: 1px solid;">
		<tr>
		    <th>Order ID</th>
		    <th>Price</th>
		    <th>Status</th>
		</tr>

		<c:forEach var="tempOrder" items ="${orders}">
        <form action='${pageContext.request.contextPath}/manage/processorder' method='POST' >
            <tr>
                <td>
                    ${tempOrder.id}
                    <input type="hidden" name="orderId" value="${tempOrder.id}">
                </td>

                <td>
                    ${tempOrder.contents}
                </td>


                <td>
                    <form:select path="statuses" name ="orderStatus">
                        <form:option value="${tempOrder.status}" label="${tempOrder.status}" />
                        <c:forEach items="${statuses}" var="item">
                           <c:if test="${!item.equals(tempOrder.status)}">
                              <form:option value="${item}" label="${item}" />
                           </c:if>
                        </c:forEach>
                    </form:select>
                </td>
                <td>
                    <td><input type="submit" value="update" /></td>
                </td>

            </tr>

            <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
        </form>
		</c:forEach>

	</table>

	<form:form action="${pageContext.request.contextPath}/logout" method ="POST">
            	<input type="submit" value="Logout"/>
     </form:form>

</body>
</html>