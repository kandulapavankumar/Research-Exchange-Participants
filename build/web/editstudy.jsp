<%@page import="model.Study"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html class="editstudy">
    <head>
        <title>Researchers Exchange Participants</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/> 
        <jsp:include page="header.jsp"/>
        
        <div class="main">
            <div class="table_div">
                    <table class="tabs">
                        <tr><td><b>Editing a study</b></td></tr>
                    </table>
            </div>
            <% 
                Study study1=(Study) session.getAttribute("myStudy");
            
            %>
            
            <form action="StudyController?action=editstudy" method="post">
            <div style="margin-left:20px;">
                <b><a href="main.jsp"> &lt;&lt; Back to the Main Page</a></b>
            </div>
            <div class="first_input" style="text-align: center; margin-right: 208px;">
                <label>Study Name* </label>
                <input type="text" name="studyname" value="<%=study1.getName() %>" required>
            </div>
            <div class="second_input" style="text-align: center; margin-right: 230px;">
                <label>Question Text* </label>
                <input type="text" name="questiontext" value="<%=study1.getQuestion() %>">
            </div>
            <div class="text_image" style="text-align: center; margin-right: 480px; margin-top: 20px;">Image* </div>
            <div class="browse_div" style="text-align: center; margin-right: 183px; margin-top: 10px; padding-bottom: 20px;"></div>
            <div class="Image" style="text-align: center; margin-right: 250px; margin-top: -55px;">
                <img src="Empty_Image.jpg" alt="Empty_Image">
            </div>
            <div class="Image" style="text-align: center; margin-left: 250px; margin-top: -45px; margin-bottom: 10px;">
                <input class="browse_btn" type="button" value="Browse">  
            </div>
            <div class="third_input" style="text-align: center; margin-left: 208px;">
                <label>#Participants* </label>
                <input type="text" name="participants" value="<%=study1.getNumberofparticipants() %>" >
            </div>
            <div class="fourth_input" style="text-align: center; margin-right: 208px;">
                <label>Description* </label>
                
                <textarea cols='40' rows="10" name="description" style='
                    margin-right: 15px;
                    vertical-align: top;'><%=study1.getDescription() %>
                </textarea>
            </div>
                
             <div class="third_input" style="text-align: center; margin-left: 208px;">
                
                <input type="hidden" name="studyCode" value="<%=study1.getCode()%>" >
            </div>
              
            
            <div class="update_div" style="text-align: center; margin-right: 208px;">
                <input class="update_btn" value="Update" type="submit" >
            </div>
     
                    </form>

        </div>
       <jsp:include page="footer.jsp"/>
