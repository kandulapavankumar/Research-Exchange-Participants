<%@page import="model.Study"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html class="studies">
    <head>
        <title>Researchers Exchange Participations</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
       
        <jsp:include page="header.jsp"/> 

    <div class="main">
        <div class="table_div1">
            <table class="tabs">
                <tr><td><b>My Studies</b></td></tr>
            </table>
        </div>
        <div style="margin-left:20px;">
            <b><a href="<%=request.getContextPath() + "/StudyController?action=newstudy_pg"%>"> Add a new study</a></b>
            <br><b><a href="<%=request.getContextPath() + "/UserController?action=home"%>"> &lt;&lt; Back to the Main Page</a></b>
        </div>
        <form method="POST" id="editStudyForm" action="<%=request.getContextPath() + "/StudyController?action=editstudy_pg"%>">
            <div class="table_div2">
                <input name="studyCode" id="studyCode" type="hidden" value="" />
                <table class="tabs">
                    <tr>
                        <td><b>Study Name</b></td>
                        <td><b>Requested Participants</b></td>
                        <td><b>Participations</b></td>
                        <td><b>Status</b></td>
                        <td><b>Action</b></td>
                    </tr>


                    <%
                        List<Study> studies = (List) session.getAttribute("Studies");
                        for (Study study1 : studies) {
                    %>

                    <tr>
                        <td><%=study1.getName()%></td>
                        <td><%=study1.getRequestedparticipants()%></td>
                        <td><%=study1.getNumberofparticipants()%></td>
                        <td>
                            <%
                                if ("Start".equalsIgnoreCase(study1.getStatus())) {
                            %>
                            <input type="button" id="<%="status_button" + study1.getCode()%>" value="Stop" onclick="updateStudyStatus('<%=study1.getCode()%>', '<%=request.getContextPath() + "/StudyController?action=stop"%>')" class="button_study"  >
                            <%} else {%>
                            <input type="button" id="<%="status_button" + study1.getCode()%>" value="Start" onclick="updateStudyStatus('<%=study1.getCode()%>', '<%=request.getContextPath() + "/StudyController?action=start"%>')" class="button_study" >      
                            <%}%>

                        </td>
                        <td><a href="StudyController?action=edit&studyCode=<%=study1.getCode()%>" <button onclick="submit('<%=study1.getCode()%>')" class="button_study" type="button">Edit</button>

                    </tr>

                    <%}%>

                    <tr>
                        <td><b></b></td>
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
