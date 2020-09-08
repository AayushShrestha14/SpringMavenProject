<%-- 
    Document   : detail
    Created on : Jun 18, 2018, 2:22:27 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${student.first_name} ${student.middle_name} ${student.last_name}</h1>
        <div>
            <h2>Email: ${student.email}</h2>
        </div>
    </body>
</html>
