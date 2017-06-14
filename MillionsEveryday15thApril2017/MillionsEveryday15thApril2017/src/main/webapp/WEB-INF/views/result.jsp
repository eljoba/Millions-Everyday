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
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<body>
Congratulations you have won ${prize} 
<c:if test="${chance=='yes'}">
<div>
<form action="${contextPath}/user/second" method="post">
<div>Lucky you!!!!!!!! Try again!!!</div>
    <button type="submit" class="btn btn-default">Launch</button>
    </form>
    </div>
</c:if>
</body>
</html>