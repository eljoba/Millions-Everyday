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
      <li  class="active"><a href="#">Add lotteries</a></li>
      <li><a href="${contextPath}/lottery/addCategory">Add category</a></li>
      <li><a href="${contextPath}/lottery/addWinning">Add winning numbers</a></li>
    </ul>
  </div>
</nav>
<div class="container">
  
  
  <form:form action="${contextPath}/lottery/addCategory" modelAttribute="lottery"
		method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="email">Lottery Name:</label>
      
      <form:input path="lotteryName" size="30" required="required" class="form-control" placeholder="Enter lottery name" />
    </div>
    <div class="form-group">
      <label for="pwd">Logo file Name:</label>
      <form:input path="filename" size="30" required="required" class="form-control" placeholder="Enter logo file name"/>
    </div>
    <div class="form-group">
      
      <label class="btn btn-default btn-file">
    Select logo: 
    </br>
    <form:input style="display: none;" path="logo" type="file" size="30" required="required"/>
</label>
      
    </div>
    </br>
    <div>
    <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </form:form>
</div>


</body>
</html>
