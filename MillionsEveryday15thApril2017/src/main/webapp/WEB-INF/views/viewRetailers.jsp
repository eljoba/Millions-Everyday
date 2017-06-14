
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
    <li class="active"><a href="#">Where to play</a></li>
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
  <br>
  <div>
  
  <form action="${contextPath}/lottery/retailersList"
		method="post" class="form-inline">
    <div class="form-group">
    
      <c:if test="${empty reatiler}">
      Search city:<input class="form-control" id="city" name="city" />
      <div>
    <button type="submit" class="btn btn-default">Search</button>
    </div>
      </c:if>
      <c:if test="${not empty reatiler}">
      <c:forEach var="req" items="${reatiler}">
      <div class="table-responsive">          
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Retailer Name</th>
        <th>Address</th>
        <th>City</th>
        <th>Zip</th>
        <th>ITVM</th>
        <th>FSVM</th>
        <c:forEach items="${req.filename}">
			
			<th><b>image</b></th>
			</c:forEach>
      </tr>
    </thead>
    <tbody>
    
      <tr>
        <td>${req.retailerName}</td>
        <td><a href="${contextPath}/retailer/map?lon=${req.longitude}&lat=${req.latitude}">${req.address}</a><br/></td>
        <td>${req.city}</td>
        <td>${req.zip}</td>
        <td>${req.itvn}</td>
        <td>${req.fsvn}</td>
        <c:forEach var="filenames" items="${req.filename}">
                    	<td> <img height="150" width="150" src="${filenames.fname}" /></td>
                    </c:forEach>
      </tr>
      
    </tbody>
  </table>
  </div>
  </c:forEach>
      </c:if>
    </div>
    
    
  </form>
  
</div>

</div>

</body>
</html>
