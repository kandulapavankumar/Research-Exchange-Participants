<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html class="recommend">
    <head>
        <title>Researchers Exchange Participants</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/> 
        <jsp:include page="header.jsp"/>
    <form method="post" action="StudyController">
        <input type="hidden" name="action" value="confirmr">
        <div style="margin-left:20px;">
            <b><a href="<%=request.getContextPath() + "/UserController?action=home"%>"> &lt;&lt; Back to the Main Page</a></b>
        </div>
        <div class="second_input">
            <label>Name* </label>
            <input type="text" name="name" value="name" >
        </div>
        <div class="second_input">
            <label>Email* </label>
            <input type="email" name="senderemail"  >
        </div>
        <div class="third_input">
            <label>Friend's Email* </label>
            <input type="email" name="receiveremail">
        </div>
        <div class="fourth_input">
            <label>Message* </label>
            <textarea cols='40' rows="10" style='
                      margin-right: 15px;
                      vertical-align: top;'>
            </textarea>
        </div>

        <div style='text-align: center'>
            <b><i>When your friend logs in and participates in one user study, you'll get 2 coins bonus</i></b>
        </div>

        <input type="submit" value="Submit">
    </form>
    <jsp:include page="footer.jsp"/>

