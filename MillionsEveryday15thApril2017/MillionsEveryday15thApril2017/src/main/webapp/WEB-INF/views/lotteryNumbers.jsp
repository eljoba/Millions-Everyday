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
      <li><a href="${contextPath}/lottery/addCategory">Add category</a></li>
      <li class="active"><a href="#">Add winning numbers</a></li>
    </ul>
  </div>
</nav>
<div class="container">
   
  
  <form action="${contextPath}/lottery/lotNumber"
		method="post" class="form-inline" >
    <div class="form-group">
    
      <c:if test="${empty lotto}">
      Search lottery name:<input class="form-control" id="lot" name="lot" />
      
      <br>
      <div>
    <button type="submit" class="btn btn-default">Search</button>
    </div>
    </c:if>
    </div>
  </form>
  <c:if test="${not empty lotto}">
  <form:form action="${contextPath}/lottery/lotNumberSet" method="post" class="form-inline" commandName="lotNum">
		<div class="form-group">
		Number 1:<form:input class="form-control" type="number"  path="num1" min="0" required="required" />
      
      <br>
      Number 2:<form:input class="form-control" type="number" id="num2" name="num2" min="0" path="num2" required="required" />
      
      <br>
      Number 3:<form:input class="form-control" type="number" id="num3" name="num3" min="0" path="num3" required="required" />
      
      <br>
      Number 4:<form:input class="form-control" type="number" id="num4" name="num4" min="0" path="num4" required="required" />
      
      <br>
      Number 6:<form:input class="form-control" type="number" id="num6" name="num6" min="0" path="num5" required="required" />
      
      <br>
      prize:<form:input class="form-control" type="number" id="prize" name="prize" min="0" path="prize" required="required" />
      
      <br>
      jackpotDate:<form:input class="form-control" type="date" id="jackpotDate" name="jackpotDate" path="jackpotDate" required="required" />
      
      <br>
      nextJackpot:<form:input class="form-control" type="date" id="nextJackpot" name="nextJackpot" path="nextJackpot" required="required" />
      
      <br>
      <button type="submit" class="btn btn-default">Add</button>
		</div>
		</form:form>
		</c:if>
</div>


</body>
</html>
