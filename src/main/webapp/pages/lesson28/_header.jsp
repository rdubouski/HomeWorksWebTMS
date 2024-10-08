<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <a class="navbar-brand" href="/">Logo</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <c:if test="${currentUser == null}">
                <a class="nav-link disabled" aria-disabled="true">Hello Guest</a>
              </c:if>
              <c:if test="${currentUser != null}">
                <a class="nav-link disabled" aria-disabled="true">Hello ${currentUser.name}</a>
              </c:if>
            </li>
            <c:if test="${currentUser == null}">
              <li class="nav-item">
                <a class="nav-link" href="/user/reg">Registration</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/user/login">Login</a>
              </li>
            </c:if>
            <c:if test="${currentUser != null}">
              <li class="nav-item">
                <a class="nav-link" href="/user/logout">Logout</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/user/profile?username=${currentUser.username}">Profile</a>
              </li>
            </c:if>
          </ul>
        </div>
      </div>
    </nav>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
  </body>
</html>