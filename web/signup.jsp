<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html class="signup">
    <head>
        <title>Researchers Exchange Participations</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <jsp:include page="header.jsp"/> 
    
        
        <div class="main">
            <form action="UserController?action=create" method="post">
                <input type="hidden" name="signup" value="create">
            <div class="first_input">
                <label>Name* </label>
                <input type="text" name="name" required>
            </div>
            <div class="second_input">
                <label>Email* </label>
                <input type="email" name="semail" required>
            </div>
            <div class="third_input">
                <label>Password* </label>
                <input type="password" name="spassword" required>
            </div>
            <div class="fourth_input">
                <label>Confirm Password* </label>
                <input type="password" name="cpassword" required>
            </div>
            
            <div class="btn_div">
                <input class="login_btn" type="submit" value="Create Account">
            </div>   
            
        </div>
        <jsp:include page="footer.jsp"/>
