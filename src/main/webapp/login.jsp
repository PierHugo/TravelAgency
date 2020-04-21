<jsp:useBean id="registerSuccess" scope="request" type="java.lang.String" class="java.lang.String"/>
<jsp:useBean id="message" scope="request" type="java.lang.String" class="java.lang.String"/>
<html>
<head>
    <title>Log in</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<%@include file="header.jsp" %>
<body>
<div class="container border border-light rounded pt-5 mt-5 mb-5 pb-5">
    <div class="heading text-center pt-4">
        <h3 class="card-title">Log in</h3>
    </div>
    <form method="post" id="loginForm" action="login">
        <div class="row mb-3 mt-3">
            <div class="col-12 col-lg-8 offset-lg-2">
                <div class="md-form">
                    <input id="login" type="text" name="login" class="form-control">
                    <label for="login">Username</label>
                </div>
            </div>
        </div>
        <div class="row mb-3 mt-3">
            <div class="col-12 col-lg-8 offset-lg-2">
                <div class="md-form">
                    <input id="password" type="password" name="password" class="form-control">
                    <label for="password">Password</label>
                </div>
            </div>
        </div>
        <div class="row mb-3 mt-3">
            <div class="col-12 col-lg-8 offset-lg-2 text-center text-danger" id="error">
                ${message}
            </div>
            <div class="col-12 col-lg-8 offset-lg-2 text-center text-info" id="success">
                ${registerSuccess}
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-lg-8 offset-lg-2">
                <button class="btn btn-dark w-100" type="submit">Log in</button>
            </div>
        </div>
    </form>
    <div class="text-center mt-2 pb-3">
        <p>Not loged in yet ?
            <a href="register">Register</a>
        </p>
    </div>
</div>
</body>
<%@include file="footer.jsp" %>
</html>
