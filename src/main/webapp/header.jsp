<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<link href="css/style.css" rel="stylesheet">
<link href="lib/material-design-4.7.1/css/bootstrap.min.css" rel="stylesheet">
<link href="lib/material-design-4.7.1/css/mdb.min.css" rel="stylesheet">

<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="">
            <span class="fas fa-plane"></span>
            <span class="px-1">Travel Agency</span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="home">Homepage</a>
                </li>
                <c:if test="${sessionScope.type == 'admin'}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                           aria-haspopup="true"
                           aria-expanded="false">Offers</a>
                        <div class="dropdown-menu dropdown-secondary">
                            <form method="get" action="offer">
                                <button class="dropdown-item" name="Offer" value="add">Add</button>
                                <button class="dropdown-item" name="Offer" value="edit">Edit</button>
                                <button class="dropdown-item" name="Offer" value="delete">Delete</button>
                            </form>
                        </div>
                    </li>
                </c:if>
            </ul>
            <ul class="navbar-nav">
                <c:choose>
                    <c:when test="${sessionScope.type == 'client' || sessionScope.type == 'admin'}">
                        <li class="nav-item">
                            <a class="nav-link" href="login">Log out</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="login">Log in</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>
</header>
