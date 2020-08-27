<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cr" %>
<%@ page isELIgnored = "false" %>
<%@ page import="java.util.*, com.school.utilities.*" %>
<html>
    <head></head>
    <body>
        <h1>Form 1</h1>
        <form action="#" method="post">
            Email: <input type="text" name="email"/>
            <input type="submit" value="Submit" />
        </form>

        <cr:out value="${param.email}" />
        <cr:set var="exampleVar" value="${param.email}" scope="application" />

        <br/>
            <a href="next.jsp">Next</a>
        <br/>

        <h1>Form 2</h1>
        <form action="next2.jsp" method="post">
            Email: <input type="text" name="email2"/>
            <br/>
            <br/>
            <br/>
            Number 1: <input type="text" name="number1"/>
            Number 2: <input type="text" name="number2"/>
            Operation: <select name="operation">
                <option value="add">+ (Add)</option>
                <option value="subtract">+ (Subtract)</option>
            <input type="submit" value="Submit" />
        </form>

        <br/>
        <cr:forEach items="${ ShowUser.loopString() }" var="str">
            ${str}<br/>
        </cr:forEach>
    </body>
</html>