<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="../template/header.jsp" %>
<script>
    document.title = "<fmt:message key="title.about"/>";
</script>
<div class="jumbotron">
    <h1 class="display-3"><fmt:message key="nav.brand"/></h1><h2><fmt:message key="company.shortcut"/></h2>
    <div>
        <legend><fmt:message key="company.opportunities"/></legend>
        <ol class="breadcrumb">
            <li class="breadcrumb-item active"><fmt:message key="company.first.opportunities"/></li>
        </ol>
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><fmt:message key="company.second.opportunities"/></li>
        </ol>
        <ol class="breadcrumb">
            <li class="breadcrumb-item"> <fmt:message key="company.third.opportunities"/></li>
        </ol>
    </div>
</div>
<%@include file="../template/footer.jsp"%>
