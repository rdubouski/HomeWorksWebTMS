<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>${user.name} profile page</title>
  </head>
  <body>

    <jsp:include page="_header.jsp"/>

    <div class="container">
      <h4>Name: ${user.name}</h4>
      <h4>Username: ${user.username}</h4>
      <h4>Password: ${user.password}</h4>
      <img width="320px" height="320px" src="data:image/png;base64,${avatar}">
    </div>

  </body>
</html>
