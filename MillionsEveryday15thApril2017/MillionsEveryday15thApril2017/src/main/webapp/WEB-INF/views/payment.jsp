<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>

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
  
  
 <form:form class="form-horizontal" action="${contextPath}/retailer/payFinal" method="post" commandName="pa">
    <div class="form-group">
      <label class="control-label col-sm-2" for="amount">Amount:</label>
      <div class="col-sm-10">
        <label class="control-label col-sm-2" for="amount">${sessionScope.amount}</label>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Credit card number:</label>
      <div class="col-sm-10">          
	<form:input path="creditCard" size="30" type="number" min="0" class="form-control" placeholder="Enter credit card number"
						 required="required" /> 
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Expiry date:</label>
      <div class="col-sm-10">          
	<form:input path="expiryDate" size="30" class="form-control"
						type="date" required="required" /> 
      </div>
    </div>
	
	<div class="form-group">
      <label class="control-label col-sm-2" for="pwd">CVV:</label>
      <div class="col-sm-10">          
	<form:input path="cvv" type="number" min="0"  size="30" class="form-control" placeholder="Enter CVV" required="required" />
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form:form>
</div>

</body>
</html>
