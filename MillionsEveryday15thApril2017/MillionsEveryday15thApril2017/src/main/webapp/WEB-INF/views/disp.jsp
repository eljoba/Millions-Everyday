<%-- 
    Document   : addBook
    Created on : Feb 4, 2017, 11:12:09 PM
    Author     : Elton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="display">
         
        <table width="59%" border="1" align="center">
            <tr>
            <th style="width:60px;">ISBN</th>
            <th style="width:20px;">Book Title</th> 
            <th style="width:20px;">Authors</th>
            <th style="width:20px;">Price</th>
            </tr>
           
            <c:forEach begin="1" end="${sessionScope.noBooks}" var="val">
             <tr>
                 
                     <td>test</td>
                     <td>test</td>
                     <td>test</td>
                     <td>test</td>
                                 
                </tr>
               
                </c:forEach>
                
                
                </table>
                
                <br/>
                <div style="text-align: center;"><input type="submit" value="Add Books"></div>
                </form>
    </body>
</html>
