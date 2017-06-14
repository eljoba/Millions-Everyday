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
      <li><a href="${contextPath}/user/retReq">Retailer Requests</a></li>
      <li><a href="${contextPath}/lottery/addNumbers">Add lotteries</a></li>
      <li class="active"><a href="#">Add category</a></li>
      <li><a href="${contextPath}/lottery/addWinning">Add winning numbers</a></li>
    </ul>
  </div>
</nav>
<div class="container">
  
  
  <form:form action="${contextPath}/lottery/insertCategory" modelAttribute="category"
		method="post" >
    <div class="form-group">
      <label for="email">Number of matches in section 1:</label>
      
      <form:input type="number" path="match1" size="30" min="0" required="required" class="form-control" placeholder="Enter number of matches in section 1" />
    </div>
    <div class="form-group">
      <label for="pwd">Match in section 2:</label>
      <form:input type="number" path="match2" size="30" min="0" required="required" class="form-control" placeholder="Enter match in section 2"/>
    </div>
    
    <div class="form-group">
      <label for="pwd">Prize amount:</label>
      <form:input type="number" path="prize" size="30" min="0" required="required" class="form-control" placeholder="Enter the prize amount"/>
    </div>
    
    </br>
    <div>
    <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </form:form>
</div>


</body>
</html>
