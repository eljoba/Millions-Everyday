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
  
  
  
  <form:form action="${contextPath}/retailer/register"  commandName="retailer" method="post" >
    
      <div class="form-group">
      Name :<form:input class="form-control" id="name" path="name" required="required" />
      <font color="red"><form:errors path="name" /></font>
    </div>
    <div class="form-group">
      
      Phone :<form:input class="form-control" id="phone" path="phone" required="required"/>
      <font color="red"><form:errors path="phone" /></font>
    </div>
    <div class="form-group">
      
      Email Id :<form:input class="form-control" id="email" path="email" type="email" required="required"/>
      <font color="red"><form:errors
							path="email" /></font>
    </div>
    <div class="form-group">
      

      
      User Name :<form:input class="form-control" id="userName" path="userName" required="required"/>
      <font color="red"><form:errors path="userName" /></font>
    </div>
    
    <div class="form-group">
      
      Password :<form:input type="password" class="form-control" id="password" path="password" required="required"/>
      <font color="red"><form:errors
							path="password" /></font>
    </div>
    
    <div class="form-group">
      

      
      Street :<form:input class="form-control" id="address.street" path="address.street" required="required"/>
      <font color="red"><form:errors path="address.street" /></font>
    </div>
     <div class="form-group">
      

      
      City :<form:input class="form-control" id="address.city" path="address.city" required="required"/>
      <font color="red"><form:errors path="address.city" /></font>
    </div>
    
    
    
    <div class="form-group">
      

      
      State :<form:input class="form-control" id="address.state" path="address.state" required="required"/>
      <font color="red"><form:errors path="address.street" /></font>
    </div>
    
    
    <div>
    <button type="submit" class="btn btn-default">Submit</button>
    </div>
    
  </form:form>
</div>


</body>
</html>
