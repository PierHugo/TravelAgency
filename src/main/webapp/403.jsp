<jsp:useBean id="offerList" scope="request" class="java.util.ArrayList"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Forbidden</title>
</head>

<%@include file="header.jsp" %>

<body class="main-body page-content">
<section class="container">
    <div class="row">
        <div class="col-sm-12 col-md-7">
            <h1>403 Forbidden</h1>
            <p class="text-justify">The page you were trying to reach is forbidden for some reason</p>
        </div>
        <div class="col-sm-12 col-md-5">
            <a class="nav-link" href="home">Back to home</a>
            <a class="nav-link" href="login">Back to login</a>
        </div>
    </div>
</section>
</body>

<%@include file="footer.jsp" %>
</html>
