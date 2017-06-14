<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    <li><a href="#">Home</a></li>
    <li><a href="${contextPath}/lottery/where">Where to play</a></li>
    <li class="active"><a href="#">Play</a></li>
    <li><a href="${contextPath}/lottery/millionWin">Millions everyday winners</a></li>
  </ul>
  <br>
  <div>
  <form:form action="${contextPath}/lottery/win" commandName="millions"
		method="post" class="form-inline">
    <div class="form-group">
      
      <form:input class="form-control" id="ball" path="num1" type="number" min="0"/>
    </div>
    <div class="form-group">
      
      <form:input class="form-control" id="ball" path="num2" type="number" min="0"/>
    </div>
    <div class="form-group">
      
      <form:input class="form-control" id="ball" path="num3" type="number" min="0"/>
    </div>
    <div class="form-group">
      
      <form:input class="form-control" id="ball" path="num4" type="number" min="0"/>
    </div>
    <div class="form-group">
      
      <form:input class="form-control" id="ball" path="num5" type="number" min="0"/>
    </div>
    <div class="form-group">
      
      <form:input class="form-control" id="jackpot" path="num6" type="number" min="0"/>
    </div>
    
    <div>
    <button type="submit" class="btn btn-default">Launch</button>
    </div>
    
  </form:form>
</div>
</div>

</body>
</html>
