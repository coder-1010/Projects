<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h2>Registration Forms</h2>
        <form action="servlet" method="post">
            <label for="id">Id:</label><br>
            <input type="text" id="id" name="id"><br>
            <label for="fname">Product Name:</label><br>
            <input type="text" name="fname"><br>
            <label for="lname">Price:</label><br>
            <input type="text" name="price"><br><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>