<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	

	<ul class="nav nav-tabs">
    <li><a href="${contextPath}">Home</a></li>
    <li><a href="${contextPath}/lottery/where">Where to play</a></li>
    <c:if test="${sessionScope.user.role=='reguser'}">
    <li><a href="${contextPath}/lottery/enter">Play</a></li>
    </c:if>
    <li><a href="${contextPath}/lottery/millionWin">Millions everyday winners</a></li>
    <c:if test="${sessionScope.user.role=='retailer'}">
    <li><a href="${contextPath}/retailer/engage">Request</a></li>
    <li  class="active"><a href="#">Payment</a></li>
    </c:if>
    <li><a href="${contextPath}/lottery/ajax">Lottery draws</a></li>
  </ul>

	
	

		
	<table border="1" cellpadding="5" cellspacing="5" class="table table-hover">
		<tr>
			<th><b>Request Id</b></th>
			<th><b>Payment</b></th>
			
			
		</tr>
		<c:forEach var="req" items="${request}">
		<form:form action="${contextPath}/retailer/pay" commandName="pay" method="post" >
		<form:hidden path="requestId"
                        value="${req.requestId}" />
			 <tr>
				<td>${req.requestId}</td>
				<td colspan="2"><input type="submit" value="Make payment" /></td>
				</tr>
				</form:form>
				</c:forEach>
				
				</table>

	
	
</body>
</html>