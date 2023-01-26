<html>
	<head>
		<title>Percy's Restaurant - find your favourite dish</title>
	</head>
	<body>
		<h1>Percy's Restaurant</h1>
		<h2>Find your favourite dish</h2>
		<form action="${pageContext.request.contextPath}/restaurant/showSearchResults" method="GET">
			Find all dishes containing : <input type="text" name="menuItemName" id="menuItemName" /> <input type="submit" value="search" />
		</form>
	</body>
</html>