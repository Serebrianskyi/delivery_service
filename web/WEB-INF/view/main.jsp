<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="../template/header.jsp" %>
<script>
    document.title = "<fmt:message key="title.home"/>";
</script>
<div class="jumbotron">
    <h1 class="display-3"><fmt:message key="nav.brand"/></h1>
    <p class="lead"><fmt:message key="main.greeting"/></p>
    <hr class="my-4">
    <p></p>
    <p class="lead">
        <a class="btn btn-primary btn-lg" href="#" role="button">Create delivery</a>
    </p>
</div>
<%@include file="../template/footer.jsp"%>
