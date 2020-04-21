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
    <form method="post" id="loginForm" action="LoginServlet">
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
            <div class="col-6 offset-lg-2 col-lg-4 text-left">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                    <label class="custom-control-label" for="defaultLoginFormRemember">Remember me</label>
                </div>
            </div>
            <div class="col-6 col-lg-4 text-right">
                <a data-toggle="modal" data-target="#exampleModalPreview" href="">Password forgotten ?</a>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-lg-8 offset-lg-2" id="success">

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
            <a href="register.jsp">Register</a>
        </p>
    </div>
</div>
</body>

<!-- Modal -->
<div class="modal fade top" id="exampleModalPreview" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalPreviewLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalPreviewLabel">Forgotten password</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row mb-3 mt-3">
                    <div class="col-12 col-lg-8 offset-lg-2">
                        <div class="md-form">
                            <label for="password_forgotten">Username</label>
                            <input id="password_forgotten" type="text" name="login" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-dark" formaction="PasswordForgotten" formmethod="post">Recover your
                    password
                </button>
                <button type="button" class="btn btn-dark" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>
</html>
