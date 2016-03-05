<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html class="main1">
    <head>
        <title>Researchers Exchange Participations</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/> 
        <jsp:include page="header.jsp"/>
        <div class="main">
            <div class="content">
                <div class="table_div">
                    <table class="tabs">
                        <tr><td>Coins (2)</td></tr>
                        <tr><td>Participants (3)</td></tr>
                        <tr><td>Participation (5)</td></tr>
                        <tr><td></td></tr>
                        <tr><td>Home</td></tr>
                        <tr><td><a href="<%=request.getContextPath() + "/StudyController?action=participate_page"%>">Participate</a></td></tr>
                        <tr><td><a href="<%=request.getContextPath() + "/StudyController?action=studies"%>"> My Studies</a></td></tr>
                        <tr><td><a href="<%=request.getContextPath() + "/StudyController?action=recommend"%>"> Recommend</a></td></tr>
                        <tr><td><a href="<%=request.getContextPath() + "/StudyController?action=contact"%>">Contact</a></td></tr>
                        
                    </table>
                </div>
                
                <div class="tab_content">
                    <div class="tab_content_inner">
                        <span><b>How it works.</b></span>
                        <span>This site was built to help researchers conduct their user studies</span>
                        <span>1 participation = 1 coin</span>
                        <span><b>To Participate</b>,go to "Participation" section and choose a study to complete</span>
                        <span><b>To get participants</b>,submit your user study here to start getting participations.In order to do so, you must have enough coins in Your account</span>
                    </div>
                </div>
            </div>
        </div>
       <jsp:include page="footer.jsp"/>
