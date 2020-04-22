<jsp:useBean id="successMessage" scope="request" type="java.lang.String" class="java.lang.String"/>
<jsp:useBean id="errorMessage" scope="request" type="java.lang.String" class="java.lang.String"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Select offer</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<%@ include file="header.jsp" %>
<body>
<div class="container border-light border rounded mt-5 pt-5 mb-5 pb-5">
    <div class="heading text-center pt-4">
        <h3 class="card-title">Select offer</h3>
    </div>
    <form method="get" action="" class="animated fadeIn">
        <div class="row mb-3 mt-3">
            <div class="col-12 col-lg-8 offset-lg-2">
                <div class="">
                    <label for="selectOffer">Offer to edit</label>
                    <select class="custom-select default-browser" name="destination" id="selectOffer">
                        <option selected disabled value="">Select offer</option>
                        <jsp:useBean id="offerList" scope="request" type="java.util.List"/>
                        <c:forEach var="offer" items="${offerList}">
                            <option value="${offer.getDestination()}">${offer.getDestination()}</option>
                        </c:forEach>
                    </select>
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
                <button class="btn btn-dark w-100" type="submit" id="btnSubmit" name="Offer" value="editing">Edit
                    offer
                </button>
            </div>
        </div>
    </form>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
