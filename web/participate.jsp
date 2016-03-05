<%@page import="java.util.List"%>
<%@page import="model.Study"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Template
and open the template in the editor.
-->
<html class="participate">
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
                    <tr style="background-color: #C8E6F3;"><td>Home</td></tr>
                    <tr><td><a href="<%=request.getContextPath() + "/StudyController?action=participate_page"%>">Participate</a></td></tr>
                    <tr><td><a href="<%=request.getContextPath() + "/StudyController?action=studies"%>"> My Studies</a></td></tr>
                    <tr><td><a href="<%=request.getContextPath() + "/StudyController?action=recommend"%>"> Recommend</a></td></tr>
                    <tr><td><a href="<%=request.getContextPath() + "/StudyController?action=contact"%>">Contact</a></td></tr>

                </table>
            </div>

            <div class="table_div" style="margin-left:0px;">
                <table class="tabs1">
                    <tr><td><b>Studies</b></td></tr>
                </table>
            </div>
            <form method="POST" id="parcipateForm" action="<%=request.getContextPath() + "/StudyController?action=participate"%>">

                <input name="studyCode" id="studyCode" type="hidden" value="" />
                <div class="table_div2">
                    <table class="tabs1">
                        <thead>
                            <tr>
                                <td><b>Study Name</b></td>
                                <td><b>Image</b></td>
                                <td><b>Question names</b></td>
                                <td><b>Action</b></td>
                            </tr>
                        </thead>
                        <tfoot>
                            <% List<Study> studies = (List) session.getAttribute("StudiesParticipate");
                                if (studies != null && studies.size() > 0) {
                                    for (Study study : studies) {
                                        if (study.getStatus().equalsIgnoreCase("Start")) {

                            %>

                            <tr>
                                <td><%=study.getName()%></td>
                                <td><div><img alt="Study Image" class="div_image1" src="<%=request.getContextPath() + "/uploadImage?filename=" + study.getGetImage()%>"></div></td>
                                <td><%=study.getQuestion()%></td>
                                <td><button onclick="submitForm('<%=study.getCode()%>')" type="button">Participate</button></td>  
                            </tr>
                            <%
                                    }
                                }
                            } else {
                            %>

                            <tr>
                                <td colspan="4">No records to display.</td>
                            </tr>

                            <%
                                }
                            %>
                        </tfoot>



                        <tr>
                            <td><b></b></td>
                            <td><b></b></td>
                            <td><b></b></td>
                            <td><b></b></td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
