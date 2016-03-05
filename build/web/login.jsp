<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html class="login">
    <head>
        <title>Votez - Online Voting</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/> 
        <jsp:include page="header.jsp"/>
        
    <div>${message}</div>
        <div class="main">
            <form action="UserController" method="post">
                
            <div class="first_input">
                <label>Email* </label>
                <input type="text" name="email" required>
            </div>
            <div class="second_input">
                <label>Password* </label>
                <input type="password" name="password" required>
            </div>
            <div class="btn_div">
                <input class="login_btn" type="submit" value="Log in">
               
            </div>
                <input type="hidden" name="action" value="login">
            </form>
            <div class="sign_up_div">
                <a href="signup.jsp" class="signup_a" >Sign up for a new account</a>
            </div>
            
           

        </div>
        
        <jsp:include page="footer.jsp"/>
