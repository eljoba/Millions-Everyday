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
  
  <ul class="nav nav-tabs">
    <li><a href="${contextPath}">Home</a></li>
    <li><a href="${contextPath}/lottery/where">Where to play</a></li>
    <c:if test="${sessionScope.user.role=='reguser'}">
    <li><a href="${contextPath}/lottery/enter">Play</a></li>
    </c:if>
    <li><a href="${contextPath}/lottery/millionWin">Millions everyday winners</a></li>
    <c:if test="${sessionScope.user.role=='retailer'}">
    <li><a href="${contextPath}/retailer/engage">Request</a></li>
    <li><a href="${contextPath}/retailer/checkpay">Payment</a></li>
    </c:if>
    <li class="active"><a href="#">Lottery draws</a></li>
  </ul>
  <br>
  <div class="form-group">
    
     
      Search Lottery name:<input class="form-control" id="name" name="name" />
      <div>
    <button  id="bt" class="btn btn-default">Search</button>
    </div>
    <div class="table-responsive">
<!--     <table id="mysearch" class="table table-hover"> -->
    <div id="mysearch">
    </div>
    <script>

$(document).ready(function() {
    
    console.log("ready"); 
    
    $("#bt").click(function() {

            var x = document.getElementById("name").value;
                                    if (x == null || x == "") {
                                        alert("Filed cannot be empty");
                                        return false;
                                    }
                                    console.log("x is "+x);
                                    var lotSearch = $("#name").val();
                                    console.log("lotSearch"+lotSearch);
                                    $.post("${contextPath}/lottery/ajax", 
                                            {
                                                name : lotSearch
                                            },
                                        function(data) {

                                        var v = $.parseJSON(data);

                                        console.log(v);
                                        
                                       

                                            $("#mysearch").append(
                                            		'<table  class="table table-hover">'+
                                            		"<th>Number1</th>"+
                                            		"<th>Number2</th>"+
                                            		"<th>Number3</th>"+
                                            		"<th>Number4</th>"+
                                            		"<th>Number5</th>"+
                                            		"<th>Number6</th>"+
                                            		"<th>Prize</th>"+
                                            		"<th>Jackpot date</th>"+
                                            		"<th>Next jackpot</th>"+
                                                    "<tr ><td>"
                                                            + v.number1 + "</td>"
                                                            + "<td>" + v.number2
                                                            + "</td>" + "<td>"
                                                            + v.number3
                                                            + "</td>" + "<td>"
                                                            + v.number4
                                                            + "</td>"
                                                            + "<td>"
                                                            + v.number5
                                                            + "</td>"
                                                            + "<td>"
                                                            + v.number6
                                                            + "</td>"
                                                            + "<td>"
                                                            + v.prize
                                                            +"</td>"
                                                            + "<td>"
                                                            + v.jackpotDate
                                                            +"</td>"
                                                            + "<td>"
                                                            + v.nextJackpot
                                                            +"</td>"
                                                            +"</tr>"+
                                                            "</table>");
                                            
                                       

                                    });
                                    
                                                                        
                                });

                    });

</script>
    
    </div>
</div>
</div>
<br>




</body>
</html>
