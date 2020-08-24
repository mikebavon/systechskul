<!DOCTYPE html>
<html>
<%@ include file="./page/header.html" %>
<body>
<%@ include file="./page/navbar.jsp" %>
<% out.println(session.getAttribute("username")); %>
<div id="module-content"></div>
<script src="./js/departments.js"></script>
</body>
</html>