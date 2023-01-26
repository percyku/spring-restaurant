<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import = "java.util.List" %>

<html>

    <head>

		<script>

			function updateStatus() {
				var request = new XMLHttpRequest();
				request.onreadystatechange = function() {
				console.log(this.readyState);
					if (this.readyState == 4) {
					console.log(this.responseText);
						var json = JSON.parse(this.responseText);
						document.getElementById("status").innerHTML = json.status;
					}
				}
				request.open("GET","${pageContext.request.contextPath}/order/api/checkOrderStatus?id=${id}",true)
				request.send();
			}

			window.setInterval(
				function() {
					updateStatus();
				}
					, 2000);

		</script>

	</head>

	<body>
		<jsp:include page="/WEB-INF/view/header.jsp" />
		<h2>Order your food</h2

		<p>Thank you - your order has been received. You need to pay ${total}
		<p>The current status of your order is : <span id="status">${status}</span>  <input type="button" value="refresh status" onclick="updateStatus()" />  </p>
	</body>
</html>