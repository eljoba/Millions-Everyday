
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
#ball{
    width: 80px !important;
    
    
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
<div class="container">
  
  <ul class="nav nav-tabs">
    <li><a href="${contextPath}">Home</a></li>
    <li><a href="${contextPath}/lottery/where">Where to play</a></li>
    <c:if test="${sessionScope.user.role=='reguser'}">
    <li><a href="${contextPath}/lottery/enter">Play</a></li>
    </c:if>
    <li class="active"><a href="#">Millions everyday winners</a></li>
    <c:if test="${sessionScope.user.role=='retailer'}">
    <li><a href="${contextPath}/retailer/engage">Request</a></li>
    <li><a href="${contextPath}/retailer/checkpay">Payment</a></li>
    </c:if>
    <li><a href="${contextPath}/lottery/ajax">Lottery draws</a></li>
  </ul>
  <br>
  <div>
  
  <form action="${contextPath}/lottery/retailersList"
		method="post" class="form-inline">
    <div class="form-group">
    
     
      
      <c:forEach var="mi" items="${million}">
      <div class="table-responsive">          
  <table class="table table-hover">
    <thead>
      <tr>
        <th>User Name</th>
        <th>Date played</th>
        <th>number1</th>
        <th>number2</th>
        <th>number3</th>
        <th>number4</th>
         <th>number5</th>
        <th>number6</th>
        <th>prize</th>
        
      </tr>
    </thead>
    <tbody>
    
      <tr>
        <td>${mi.registeredUser.firstName} ${mi.registeredUser.lastName}</td>
        
        <td>${mi.datePlayed}</td>
        <td>${mi.num1}</td>
        <td>${mi.num2}</td>
        <td>${mi.num3}</td>
        <td>${mi.num4}</td>
        <td>${mi.num5}</td>
        <td>${mi.num6}</td>
        <td>${mi.prize}$</td>
        
      </tr>
      
    </tbody>
  </table>
  </div>
  </c:forEach>
      
    </div>
    
    
  </form>
  
</div>

</div>

</body>
</html>
