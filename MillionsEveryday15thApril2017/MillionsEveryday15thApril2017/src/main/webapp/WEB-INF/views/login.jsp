<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
#username,#password{
    width: 400px !important;
    
    
}
#full{
    
     position: fixed;
    top: 50%;
    left: 50%;
    margin-top: -100px;
    margin-left: -200px;
    
}

</style>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container" id="full">
  <c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<h2 id="login">Login</h2>
	<form action="${contextPath}/user/admin" method="post">
  

    <div class="input-group" size="5">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user" id="u"></i></span>
      <input id="username" type="text" class="form-control" name="username" placeholder="UserName" size="5">
    </div>
    <br>
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input id="password" type="password" class="form-control" name="password" placeholder="Password" size="5">
    </div>
    <br>
    <button type="submit" class="btn btn-default">Submit</button>
    
  </form>

</div>
  

</body>
</html>

