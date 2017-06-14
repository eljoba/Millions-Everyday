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
  
  
  
  <form:form action="${contextPath}/user/register"  commandName="user" method="post" >
    
      <div class="form-group">
      First Name :<form:input class="form-control" id="firstName" path="firstName" required="required" />
      <font color="red"><form:errors path="firstName" /></font>
    </div>
    <div class="form-group">
      
      LastName :<form:input class="form-control" id="lastName" path="lastName" required="required"/>
      <font color="red"><form:errors path="lastName" /></font>
    </div>
    <div class="form-group">
      
      Phone :<form:input class="form-control" id="phone" path="phone"  required="required"/>
      <font color="red"><form:errors
							path="phone" /></font>
    </div>
    <div class="form-group">
      
   Sex :<form:radiobutton path="sex" value="M" checked="checked"/>Male
<form:radiobutton path="sex" value="F"/>Female
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
    
    
    
    <div>
    <button type="submit" class="btn btn-default">Submit</button>
    </div>
    
  </form:form>
</div>


</body>
</html>
