<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<fmt:setBundle basename="messages"/>
<fmt:setLocale value="uk-UA"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/servlet/main">
            <fmt:message key="nav.brand"/></a>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/servlet/delivery">
                        <fmt:message key="nav.delivery"/></a>
                </li>
                <a class="nav-link" href="${pageContext.request.contextPath}/servlet/about">
                    <fmt:message key="nav.about"/></a>
                </li>
            </ul>
            <div class="navbar-right">
                <c:choose>
                    <c:when test="${sessionScope.user != null}">
                        <c:choose>
                            <c:when test="${sessionScope.role == 1}">
                                <a class="btn btn-outline-success"
                                   href="${pageContext.request.contextPath}/servlet/user">
                                    <fmt:message key="nav.user.cabinet"/>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a class="btn btn-outline-success"
                                   href="${pageContext.request.contextPath}/servlet/admin">
                                    <fmt:message key="nav.admin.cabinet"/>
                                </a>
                            </c:otherwise>
                        </c:choose>

                        <a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/servlet/logout">
                            <fmt:message key="nav.logout"/>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/servlet/login">
                            <fmt:message key="nav.log.in"/>
                        </a>
                        <a class="btn btn-outline-success"
                           href="${pageContext.request.contextPath}/servlet/registration">
                            <fmt:message key="nav.sign.up"/>
                        </a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </nav>
</header>
