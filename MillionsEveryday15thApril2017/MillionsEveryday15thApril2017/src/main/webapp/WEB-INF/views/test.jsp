<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>How many books do you want to add?</h1></div>
        <form name='myForm' method="post" action="book">
                <input type="number" name="noBooks" min="1" required/>
                <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
