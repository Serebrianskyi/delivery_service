<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="../template/header.jsp" %>
<script>
    document.title = "<fmt:message key="title.registration"/>";
</script>
<div class="jumbotron align-content-center">
    <form style="max-width: 20rem;" action="${pageContext.request.contextPath}/servlet/registerUser" method="get">
        <label for="firstName"><fmt:message key="registration.first.name"/></label><br>
        <input class="form-control" type="text" name="firstName" id="firstName"/><br>
        <label for="surName"><fmt:message key="registration.sur.name"/></label><br>
        <input class="form-control" type="text" name="surName" id="surName"/><br>
        <label for="lastName"><fmt:message key="registration.last.name"/></label><br>
        <input class="form-control" type="text" name="lastName" id="lastName"/><br>
        <label for="email"><fmt:message key="registration.email"/></label><br>
        <input class="form-control" type="text" name="email" id="email"/><br>
        <label for="password"><fmt:message key="registration.password"/></label><br>
        <input class="form-control" type="password" name="password" id="password"/><br>
        <button class="btn btn-primary" type="submit"><fmt:message key="button.register"/></button><br><br>
        <p class="message"><fmt:message key="registration.already.registered"/>
            <a href="${pageContext.request.contextPath}/servlet/login">
                <fmt:message key="registration.sign.in"/>
            </a>
        </p>
    </form>
</div>
<%@include file="../template/footer.jsp"%>
