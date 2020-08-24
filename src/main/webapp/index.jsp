<%@ page import="java.util.*, com.school.utilities.*" %>
<!DOCTYPE html>
<html>
    <%@ include file="./page/header.html" %>
    <body>
        <%@ include file="./page/navbar.jsp" %>
        <div id="module-content"></div>
        <%
            List<User> users;
            if (session.getAttribute("users") == null)
                users = new ArrayList<User>();
            else
                users = (List<User>) session.getAttribute("users");

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String password = request.getParameter("password");

            if (name != null || email != null || address != null || password != null){
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setAddress(address);
                user.setPassword(password);

                users.add(user);

            }

            for (User user : users)
                out.println(ShowUser.show(user));

            session.setAttribute("users", users);

        %>

        <form action="#" method="post">
            Name: <input type="text" name="name"/>
            Address: <input type="text" name="address"/>
            Email: <input type="text" name="email"/>
            Password: <input type="password" name="password"/>
            <input type="submit" value="Submit">
        </form>

    </body>
</html>