<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">MILLIONS EVERYDAY</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Retailer Requests</a></li>
      <li><a href="${contextPath}/lottery/addNumbers">Add lotteries</a></li>
      <li><a href="${contextPath}/lottery/addCategory">Add category</a></li>
      <li><a href="${contextPath}/lottery/addWinning">Add winning numbers</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
  
	<form:form action="${contextPath}/logout/"
		method="post">
		<button type="submit" class="btn btn-default">Logout</button>
		</form:form>
	
	
	<c:forEach var="req" items="${requests}">
	<form:form action="${contextPath}/retailer/accept" commandName="reqobj"
		method="post">
		<form:hidden path="requestId"
                        value="${req.requestId}" />
	<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<td><b>Retailer Name</b></td>
			<td><b>Addrress</b></td>
			<td><b>City</b></td>
			<td><b>Zip</b></td>
			<td><b>ITVM</b></td>
			<td><b>FSVM</b></td>
			<td><b>Logitude</b></td>
			<td><b>Latitude</b></td>
			<td><b>requestDate</b></td>
			<td><b>Status</b></td>
			<td><b>Action</b></td>
			<td><b>Confirmation</b></td>
			<c:forEach items="${req.filename}">
			
			<td><b>image</b></td>
			</c:forEach>
		</tr>
		
			 <tr>
				<td><form:label path="retailerName" >${req.retailerName}</form:label></td>
				<td><form:label path="address" >${req.address}</form:label></td>
				<td><form:label path="city" >${req.city}</form:label></td>
				<td><form:label path="zip" >${req.zip}</form:label></td>
				<td><form:label path="city" >${req.city}</form:label></td>
				<td><form:label path="itvn" >${req.itvn}</form:label></td>
				<td><form:label path="fsvn" >${req.fsvn}</form:label></td>
				<td><form:label path="longitude" >${req.longitude}</form:label></td>
				<td><form:label path="requestDate" >${req.requestDate}</form:label></td>
				
				
				
				
				
                    <td style="background-color : #E1E7FF; width: 60px"><form:input path="status" size="30" class="${req.requestId}" required="required" />
                    <%-- <form:select name="dropDown" path="status">
            <form:options items="${status}"/>
            
            </form:select> --%>
                    </td>
                    <td style="background-color : #E1E7FF; width: 60px "><a class="a${req.requestId}" href="#">approve</a><br><a class="r${req.requestId}" href="#">reject</a></td>
                    <td style="background-color : #E1E7FF; width: 60px"><input type="submit" value="submit" /></td>
                    <c:forEach var="filenames" items="${req.filename}">
                    	<td> <img height="150" width="150" src="${filenames.fname}" /></td>
                    </c:forEach>
			</tr>
			
			<script
  src="https://code.jquery.com/jquery-3.2.1.js"
  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  crossorigin="anonymous"></script>
  <script>
  $(".a${req.requestId}").click(function(event){
  	event.preventDefault();
  	$(".${req.requestId}").val("approved"); 
  	/* $(this).parent().html("approved"); */
  });
  $(".r${req.requestId}").click(function(event){
	  	event.preventDefault();
	  	$(".${req.requestId}").val("rejected"); 
	  	/* $(this).parent().html("approved"); */
	  });
  
  
  </script>
		
	</table>
	</form:form>
	</c:forEach>
</div>

</body>
</html>
