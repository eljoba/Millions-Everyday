<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
body , html{
margin : 0;
padding : 0;
}

iframe{
	width:100%;
	height:100%;
	/* width:auto;
	height:auto; */ 
	z-index: 1;
	position: absolute;
	margin : 0;
	padding : 0;
	background: transparent;
	
}

.container{
	margin : 0;
	padding : 0;
	
	z-index: 2;
	position: absolute;
	

	top: 0;
	bottom: 0;
	left: 0;
	right: 0;

}
</style>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div>

<iframe src="https://www.youtube.com/embed/W0LHTWG-UmQ?controls=0&showinfo=0&rel=0&autoplay=1&loop=1&playlist=W0LHTWG-UmQ" frameborder="0" allowfullscreen></iframe>

<div class="container">
  
  <ul class="nav nav-tabs">
    <li class="active"><a href="#">Home</a></li>
    <li><a href="${contextPath}/lottery/where">Where to play</a></li>
    <c:if test="${sessionScope.user.role=='reguser'}">
    <li><a href="${contextPath}/lottery/enter">Play</a></li>
    </c:if>
    <li><a href="${contextPath}/lottery/millionWin">Millions everyday winners</a></li>
    <c:if test="${sessionScope.user.role=='retailer'}">
    <li><a href="${contextPath}/retailer/engage">Request</a></li>
    <li><a href="${contextPath}/retailer/checkpay">Payment</a></li>
    </c:if>
    <li><a href="${contextPath}/lottery/ajax">Lottery draws</a></li>
  </ul>
  <form:form action="${contextPath}/logout/"
		method="post">
		<button type="submit" class="btn btn-default">Logout</button>
		</form:form>
  <br>
  <h align="right" style="color:blue;" style="font-size:900%;"><b>MILLIONS EVERYDAY</b></h>
  <br>
  <br>
  <br>
  <a href="${contextPath}/user/register.htm">Register</a><br/>
	<a href="${contextPath}/retailer/register.htm">Register retailer</a><br/>
	<a href="${contextPath}/user/login.htm">Login</a><br/>
</div>
</div>
</body>
</html>
