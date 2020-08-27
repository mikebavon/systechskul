<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cr" %>
<%@ page isELIgnored = "false" %>
<html>
    <head></head>
    <body>
        Showing email in next page: <cr:out value="${param.email2}" /><br/><br/><br/><br/><br/>

        <cr:if test="${ param.email2 == 'bavomike@gmail.com' }">
            <cr:set var="invite" value="Invite ${param.email2} for an interview on Saturday" />
        </cr:if>

        <br/><br/><br/><br/>

        <cr:out value="${invite}" />

        <br/><br/><br/><br/>
        <cr:choose>
            <cr:when test="${ param.email2 == 'bavomike@gmail.com' }">
                This is my email
            </cr:when>
            <cr:when test="${ param.email2 == 'john.snow@gmail.com' }">
                This email is for Game of throne
            </cr:when>
            <cr:when test="${ param.email2 == 'john.cena@gmail.com' }">
                This is WWE
            </cr:when>
            <cr:otherwise>
                 <span style="color:red;font-size:15px;font-weight:bold;">Unknown type</span>
            </cr:otherwise>
        </cr:choose>

        <cr:choose>
            <cr:when test="${ param.operation == 'add' }">
                <cr:set var="operationResult" value="${param.number1 + param.number2}" />
            </cr:when>
            <cr:when test="${ param.operation == 'subtract' }">
                <cr:set var="operationResult" value="${param.number1 - param.number2}" />
            </cr:when>
            <cr:otherwise>
                 <cr:set var="operationResult" value="0" />
            </cr:otherwise>
        </cr:choose>
        <br/><br/><br/><br/> Calculator Result: <cr:out value="${operationResult}" />

    </body>
</html>