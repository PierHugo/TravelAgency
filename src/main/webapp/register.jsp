<jsp:useBean id="message" scope="request" type="java.lang.String" class="java.lang.String"/>
<html>
<head>
    <title>Register</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<%@ include file="header.jsp" %>
<body>
<div class="container border-light border rounded mt-5 pt-5 mb-5 pb-5">
    <div class="heading text-center pt-4">
        <h3 class="card-title">Register</h3>
    </div>
    <form method="post" id="registerForm" action="register">
        <div class="row mb-3 mt-3">
            <div class="col-12 col-lg-8 offset-lg-2">
                <div class="md-form">
                    <input id="firstname" type="text" name="firstname" class="form-control">
                    <label for="firstname">First name</label>
                </div>
            </div>
        </div>
        <div class="row mb-3 mt-3">
            <div class="col-12 col-lg-8 offset-lg-2">
                <div class="md-form">
                    <input id="lastname" type="text" name="lastname" class="form-control">
                    <label for="lastname">Last name</label>
                </div>
            </div>
        </div>
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
        <div class="row">
            <div class="col-12 col-lg-8 offset-lg-2" id="success">

            </div>
        </div>
        <div class="row">
            <div class="col-12 col-lg-8 offset-lg-2">
                <button class="btn btn-dark w-100" type="submit" id="btnSubmit">Register</button>
            </div>
        </div>
    </form>
    <div class="text-center mt-2 pb-3">
        <p>Already registered ?
            <a href="login">Sign in</a>
        </p>
    </div>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
