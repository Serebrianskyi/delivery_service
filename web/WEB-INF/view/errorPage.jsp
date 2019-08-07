<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="../template/header.jsp" %>
<script>
    document.title = "<fmt:message key="title.error"/>";
</script>
<div>
    <h2>ACCESS DENIED</h2>
    <h3>You are not authorized. Please login.</h3>
</div>
<%@include file="../template/footer.jsp" %>
