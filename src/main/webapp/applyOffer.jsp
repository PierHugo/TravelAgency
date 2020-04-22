<jsp:useBean id="offerList" scope="request" class="java.util.ArrayList"/>
<jsp:useBean id="successMessage" scope="request" type="java.lang.String" class="java.lang.String"/>
<jsp:useBean id="errorMessage" scope="request" type="java.lang.String" class="java.lang.String"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Apply offer</title>

</head>

<%@include file="header.jsp" %>
<body>
<div class="container mt-5 pt-5 mb-5 pb-5 border border-light rounded">
    <div class="heading text-center pt-4">
        <h3 class="card-title">Apply offer</h3>
    </div>
    <form method="post" action="" class="animated fadeIn">
        <div class="row mb-3 mt-3">
            <div class="col-12 col-lg-8 offset-lg-2">
                <label for="selectOffer">Offer to apply</label>
                <select class="browser-default custom-select" name="destination" id="selectOffer">
                    <option selected disabled value="">Select offer</option>
                    <c:forEach var="offer" items="${offerList}">
                        <option value="${offer.getDestination()}">${offer.getDestination()}</option>
                    </c:forEach>
                </select>
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
                <button class="btn btn-dark w-100" type="submit" id="btnSubmit">Apply offer</button>
            </div>
        </div>
    </form>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
