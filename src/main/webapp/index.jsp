<jsp:useBean id="offerList" scope="request" class="java.util.ArrayList"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>List of offers</title>

</head>

<%@include file="header.jsp" %>

<body class="main-body page-content">
<div class="container pt-5 mt-5 mb-5 pb-5 border border-light rounded">
    <div class="heading text-center pt-4">
        <h3 class="card-title">List of offers</h3>
    </div>
    <div class="row animated fadeIn">
        <div class="col-12">
            <table class="table table-hover table-striped text-nowrap w-100">
                <thead>
                <tr>
                    <th>Destination</th>
                    <th>Description</th>
                    <th>Price</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="offer" items="${offerList}">
                    <tr>
                        <td>
                            <c:out value="${offer.getDestination()}">
                                ${offer.getDestination()}
                            </c:out>
                        </td>
                        <td>
                            <c:out value="${offer.getDescription()}">
                                ${offer.getDescription()}
                            </c:out>
                        </td>
                        <td>
                            <c:out value="${offer.getPrice()}">
                                ${offer.getPrice()}
                            </c:out>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

<%@include file="footer.jsp" %>
</html>
