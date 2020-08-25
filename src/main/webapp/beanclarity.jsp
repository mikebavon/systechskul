<!DOCTYPE html>
<%@ page isELIgnored = "false" %>
<html>
    <body>

        <h1>Using useBean</h1><br/>
        <jsp:useBean id="sampleUser" class="com.school.utilities.User" scope="request" />
        <jsp:setProperty name="sampleUser" property="*"/>

        Name: <jsp:getProperty name="sampleUser" property="name" /><br/>
        Address: <jsp:getProperty name="sampleUser" property="address" /><br/>
        Email: <jsp:getProperty name="sampleUser" property="email" /><br/>
        Password: <jsp:getProperty name="sampleUser" property="password" /><br/>

        <hr/>
        <h1>Using EXPRESSION LANGUAGE (EL)</h1><br/>
        Name: ${param.name}<br/>
        Address: ${param.address}<br/>
        Email: ${param.email}<br/>
        Password: ${param.password}<br/>

        <form action="#" method="post">
            Name: <input type="text" name="name"/>
            Address: <input type="text" name="address"/>
            Email: <input type="text" name="email"/>
            Password: <input type="password" name="password"/>
            <input type="submit" value="Submit">
        </form>

        <%
            String fromTown = "";
            if (sampleUser.getName() != null && sampleUser.getName().equals("MIKE"))
                fromTown = "Migori Town";
            else
                fromTown = "Unknown";

        %>

        <%= fromTown %>
        ${fromTown}
        <%= sampleUser.showAge() %>

    </body>


</html>