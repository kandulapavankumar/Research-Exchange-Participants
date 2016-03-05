<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html class="aboutl">
    <head>
        <title>Researchers Exchange Participations</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="styles/main.css" type="text/css"/> 
        <jsp:include page="header.jsp"/>
    <body>

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
                        <span><b>About us</b></span>
                        <span>Researchers exchange participations is a platform for researchers to exchange participations</span>
                        <span>The aim of this platform is to encourage researchers participate in each others user studies. Moreover,recruiting serious participants has been always a burden on a researcher's shoulder, thus, this platform gives researchers the opportunity to do that effectively and in a suitable time.</span>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>
