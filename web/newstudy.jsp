<%@page import="model.Study"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html class="newstudy">
    <head>
        <title>Researchers Exchange Participants</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/> 
        <jsp:include page="header.jsp"/>
        
        <div class="main">
              <form action="StudyController?action=newstudy" method="post">
            <div class="table_div">
                    <table class="tabs">
                        <tr><td><b>Adding a study</b></td></tr>
                    </table>
            </div>
              
            <div style="margin-left:20px;">
                <b><a href="<%=request.getContextPath() + "/UserController?action=home"%>"> &lt;&lt; Back to the Main Page</a></b>
            </div>
            <div class="first_input"  style="text-align: center; margin-right: 208px;">
                <label>Study Name* </label>
                <input type="text" name="studyname" id="studyname">
            </div>
            <div class="second_input" style="text-align: center; margin-right: 230px;">
                <label>Question Text* </label>
                <input type="text" name="question">
            </div>
            <div class="text_image" style="text-align: center; margin-right: 480px; margin-top: 30px;">
                <label>Image* </label>
            </div>
            <div class="btn_div1" style="text-align: center; margin-right: 208px; margin-top: -45px; padding-bottom: 20px;">
                <input class="login_btn1" type="button" value="Browse">
            </div>
            <div class="third_input" style="text-align: center; margin-left: 208px;">
                <label>#Participants* </label>
                <input type="text" name="participants">
            </div>
            <div class="fourth_input" style="text-align: center; margin-right: 208px;">
                <label>Description* </label>
                <textarea cols='40' rows="10" name="description" style='margin-right: 15px;vertical-align: top;'>
                </textarea>
            </div>
            
            <div class="btn_div2" style="text-align: center; margin-right: 208px;">
                <input class="login_btn2" type="submit" value="Submit">
            </div>
                    </form>

        </div>
            <jsp:include page="footer.jsp"/>
