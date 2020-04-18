<%@ page import="main.java.model.Employee" %><%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<% new Employee(); %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Page d'accueil</title>

</head>

<%@include file="nav.jsp" %>

<body class="main-body page-content">
<div class="container pt-5 mt-5 mb-5 pb-5 border border-light rounded">
    <div class="col-12">
        <table class="table table-hover table-striped text-nowrap w-100 display">
            <thead>
            <tr>
                <td>Nom</td>
                <td>Prénom</td>
            </tr>
            </thead>
            <tbody>

            </tbody>
            <tfoot>

            </tfoot>
        </table>
    </div>
</div>
</body>

<%@include file="footer.jsp" %>
</html>
