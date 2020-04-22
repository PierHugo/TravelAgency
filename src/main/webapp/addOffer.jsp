<jsp:useBean id="destination" scope="request" type="java.lang.String" class="java.lang.String"/>
<jsp:useBean id="description" scope="request" type="java.lang.String" class="java.lang.String"/>
<jsp:useBean id="price" scope="request" type="java.lang.String" class="java.lang.String"/>
<jsp:useBean id="mustsees" scope="request" type="java.lang.String" class="java.lang.String"/>
<jsp:useBean id="activities" scope="request" type="java.lang.String" class="java.lang.String"/>
<jsp:useBean id="successMessage" scope="request" type="java.lang.String" class="java.lang.String"/>
<jsp:useBean id="errorMessage" scope="request" type="java.lang.String" class="java.lang.String"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Add offer</title>

</head>

<%@include file="header.jsp" %>
<body>
<div class="container border-light border rounded mt-5 pt-5 mb-5 pb-5">
    <div class="heading text-center pt-4">
        <h3 class="card-title">Add offer</h3>
    </div>
    <form method="post" action="" class="animated fadeIn">
        <jsp:useBean id="option" scope="request" type="java.lang.String" class="java.lang.String"/>
        <c:choose>
            <c:when test="${option == 'add'}">
                <div class="row">
                    <div class="col-12 col-lg-8 offset-lg-2">
                        <div class="md-form">
                            <input id="destinationAdd" type="text" name="destinationAdd" class="form-control"
                                   value="${destination}">
                            <label for="destinationAdd">Destination</label>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="row">
                    <div class="col-12 col-lg-8 offset-lg-2">
                        <div class="md-form">
                            <input id="destinationEdit" type="text" name="destinationEdit" class="form-control"
                                   value="${destination}" disabled>
                            <label for="destinationEdit">Destination</label>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
        <div class="row">
            <div class="col-12 col-lg-8 offset-lg-2">
                <div class="md-form">
                    <input id="description" type="text" name="description" class="form-control" value="${description}">
                    <label for="description">Description</label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-lg-8 offset-lg-2">
                <div class="md-form">
                    <input id="price" type="number" name="price" class="form-control" value="${price}">
                    <label for="price">Price</label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-lg-8 offset-lg-2">
                <div class="md-form">
                    <input id="mustsees" type="text" name="mustsees" class="form-control" value="${mustsees}">
                    <label for="mustsees">Must-sees</label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-lg-8 offset-lg-2">
                <div class="md-form">
                    <input id="activities" type="text" name="activities" class="form-control" value="${activities}">
                    <label for="activities">Activities</label>
                </div>
            </div>
        </div>
        <div class="row mb-3 mt-3">
            <div class="col-12 col-lg-8 offset-lg-2 text-center text-danger" id="error">
                ${errorMessage}
            </div>
            <div class="col-12 col-lg-8 offset-lg-2 text-center text-info" id="success">
                ${successMessage}
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-lg-8 offset-lg-2">
                <button class="btn btn-dark w-100" type="submit" id="btnSubmit">Add offer</button>
            </div>
        </div>
    </form>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
