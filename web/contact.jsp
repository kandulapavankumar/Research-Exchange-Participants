<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html class="contact">
    <head>
        <title>Researchers Exchange Participations</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/> 
            
   <jsp:include page="header.jsp"/>
        
        <div class="main">
            <div class="table_div">
                    <table class="tabs">
                        <tr><td><b>Contact</b></td></tr>
                    </table>
            </div>
            <div style="margin-left:20px;">
                <b> <a href="<%=request.getContextPath() + "/UserController?action=home"%>"> &lt;&lt; Back to the Main Page</a></b>
            </div>

            <div class="first_input">
                <label>Name* </label>
                <input type="text">
            </div>
            <div class="second_input">
                <label>Email* </label>
                <input type="email">
            </div>
            <div class="third_input">
                <label>Message* </label>
                <textarea cols='40' rows="10" style='
                    margin-right: 15px;
                    vertical-align: top;'>
                </textarea>
            </div>
            <div class="btn_div">
                <input class="login_btn" type="button" value="Submit" onclick="location.href = 'StudyController?action=confirmc'">
            </div>   
            
        </div>
        
        <jsp:include page="footer.jsp"/>
