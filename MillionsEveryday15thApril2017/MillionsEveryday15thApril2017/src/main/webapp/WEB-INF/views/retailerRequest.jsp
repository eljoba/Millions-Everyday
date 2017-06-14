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
<div class="container">
  
  <ul class="nav nav-tabs">
    <li><a href="${contextPath}">Home</a></li>
    <li><a href="${contextPath}/lottery/where">Where to play</a></li>
    <c:if test="${sessionScope.user.role=='reguser'}">
    <li><a href="${contextPath}/lottery/enter">Play</a></li>
    </c:if>
    
    <li><a href="${contextPath}/lottery/millionWin">Millions everyday winners</a></li>
    <li class="active"><a href="#">Request</a></li>
     <c:if test="${sessionScope.user.role=='retailer'}">
    <li><a href="${contextPath}/retailer/checkpay"">Payment</a></li>
    <li><a href="${contextPath}/lottery/ajax">Lottery draws</a></li>
    </c:if>
  </ul>
  <br>
  
  <form:form action="${contextPath}/retailer/request"  commandName="req" method="post" enctype="multipart/form-data">
    
      <div class="form-group">
      Longitude :<form:input class="form-control" id="longitude" path="longitude" type="number" step="0.0000000001"/>
    </div>
    <div class="form-group">
      
      Latitude :<form:input class="form-control" id="latitude" path="latitude" type="number" step="0.0000000001"/>
    </div>
    <div class="form-group">
      
      Address :<form:input class="form-control" id="address" path="address" />
    </div>
    <div class="form-group">
      
      city :<form:input class="form-control" id="city" path="city" />
    </div>
    <div class="form-group">
      
      zip :<form:input class="form-control" id="zip" path="zip" type="number"/>
    </div>
    <div class="form-group">
      
      itvn :<form:input class="form-control" id="itvn" path="itvn" />
    </div>
    
    <div class="form-group">
      
      fsvn :<form:input class="form-control" id="fsvn" path="fsvn" />
    </div>
    
    <div class="form-group">
      
      file name :<form:input class="form-control" id="imagename" path="imagename" />
    </div>
    
    <div class="form-group">
      
      Select photo :<form:input  class="form-control" path="photo" type="file" multiple="multiple" size="30" required="required" />
    </div>
    
    <div>
    <button type="submit" class="btn btn-default">Submit</button>
    </div>
    
  </form:form>
</div>


</body>
</html>
