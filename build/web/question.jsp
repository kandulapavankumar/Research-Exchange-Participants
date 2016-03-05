<%@page import="model.Study"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html class="question">
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
                    <tr><td>Coins ()</td></tr>
                    <tr><td>Participants ()</td></tr>
                    <tr><td>Participation ()</td></tr>
                    <tr><td></td></tr>
                    <tr><td>Home</td></tr>
                    <tr><td><a href="<%=request.getContextPath() + "/StudyController?action=participate_page"%>">Participate</a></td></tr>
                    <tr><td><a href="<%=request.getContextPath() + "/StudyController?action=studies"%>"> My Studies</a></td></tr>
                    <tr><td><a href="<%=request.getContextPath() + "/StudyController?action=recommend"%>"> Recommend</a></td></tr>
                    <tr><td><a href="<%=request.getContextPath() + "/StudyController?action=contact"%>">Contact</a></td></tr>

                </table>
            </div>

            <div class="table_div" style="margin-left:0px;">
                <table class="tabs1">
                    <tr><td><b>Question</b></td></tr>
                </table>
            </div>
            <form method="POST" id="questionForm" action="<%=request.getContextPath() + "/StudyController?action=answer"%>">
                <div>
                    <img src="Bigtree.jpg" alt="Bigtree" style="height:300px;margin-top: 60px;margin-left: -230px;">
                    <div style="margin-top: -80px; margin-right: 10px;">
                        
                        <%
                            Study study = (Study) session.getAttribute("Study");

                        %>
                        <input name="studyCode" id="studyCode" type="hidden" value="<%=study.getCode()%>" />
                        <span style="margin-left: 241px;"> <%=study.getQuestion()%></span>
                        <div>
                            <select name='answer' style="margin-left: 300px;margin-top: 30px;margin-right: 40px;">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                            </select>
                        </div>
                        <input class="submit_btn" type="button" onclick="submit('questionForm')" value='Submit'>
                    </div>

                </div>    
            </form>

        </div>
    </div>
    <jsp:include page="footer.jsp"/>
