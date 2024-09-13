<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <jsp:include page="_header.jsp"/>

    <div class="container">
      <div class="row justify-content-center">
        <form class="col-4" action="/user/login" method="post">
          <div class="alert alert-warning" role="alert">
            ${message}
          </div>
          <div class="mb-3">
            <label for="exampleInputEmail2" class="form-label">Username</label>
            <input type="text" name="username" class="form-control" id="exampleInputEmail2">
          </div>
          <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1">
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
  </body>
</html>