<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="../template/header.jsp" %>
<script>
    document.title = "<fmt:message key="title.login"/>";
</script>
<div class="jumbotron align-content-center">
    <form style="max-width: 20rem;"
          action="${pageContext.request.contextPath}/servlet/loginUser" method="get">
        <label for="email"><fmt:message key="registration.email"/></label><br>
        <input class="form-control" type="text" name="email" id="email"/><br>
        <label for="password"><fmt:message key="registration.password"/></label><br>
        <input class="form-control" type="password" name="password" id="password"/><br>
        <button class="btn btn-primary"><fmt:message key="button.login"/></button><br><br>
        <p class="message"><fmt:message key="login.not.registered"/>
            <a href="${pageContext.request.contextPath}/servlet/registration">
                <fmt:message key="login.create.account"/>
            </a>
        </p>
    </form>
</div>
<%@include file="../template/footer.jsp"%>
