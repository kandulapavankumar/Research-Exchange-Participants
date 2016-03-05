

<%@page import="model.User"%>
<title>Researchers Exchange Participations</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <script src="script/newjavascript.js"></script>
<link rel="stylesheet" href="styles/main.css" type="text/css"/> 

</head>

<body>
    <div class="header" >
        <div class="h_first">
            <a href="<%=request.getContextPath() + "/UserController?action=home"%>">Researchers Exchange Participations</a>
        </div>
        <div class="h_last">
            <div class="h_span"><a href="<%=request.getContextPath() + "/UserController?action=about"%>"><span style="color: blue;"><i><u>About us</u></i></span></a></div>
            <div class="h_span"><a href="<%=request.getContextPath() + "/UserController?action=how"%>">How it works</a></div>
            
            <%
                User user = (User) session.getAttribute("theUser");
                if(user != null){
            %>
               <div class="h_span">Hello, ${theUser.name}</div>
            <%
                } else {
            %>
                 <div class="h_span"><a href="login.jsp">Log In</a></div>
            <%
                }
            %>     
            </div>
        </div>
</body>