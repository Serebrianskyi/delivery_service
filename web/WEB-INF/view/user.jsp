<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.entity.DeliveryType" %>
<%@ page import="model.entity.Department" %>
<%@ page import="model.entity.Request" %>
<%@ page import="model.entity.Weight" %>
<%@ page import="java.util.List" %>
<%@include file="../template/header.jsp" %>
<script>
    document.title = "<fmt:message key="title.user"/>";
</script>
<div class="jumbotron align-content-center">
    <div>
        <p><fmt:message key="user.request.list"/></p>
    </div>
    <table style="width: 90%">
        <tr class="table-dark">
            <th><fmt:message key="request.id"/></th>
            <th><fmt:message key="request.date"/></th>
            <th><fmt:message key="request.department.from"/></th>
            <th><fmt:message key="request.department.to"/></th>
            <th><fmt:message key="request.delivery.type"/></th>
            <th><fmt:message key="request.weight"/></th>
            <th><fmt:message key="request.price"/></th>
            <th></th>
        </tr>
        <%
            List<Request> userRequests = (List<Request>) request.getAttribute("userRequests");
            List<DeliveryType> userDeliveryTypes = (List<DeliveryType>) request.getAttribute("userDeliveryTypes");
            List<Department> userDepartmentsFrom = (List<Department>) request.getAttribute("userDepartmentsFrom");
            List<Department> userDepartmentsTo = (List<Department>) request.getAttribute("userDepartmentsTo");
            List<Weight> userWeights = (List<Weight>) request.getAttribute("userWeights");
            List<Double> userPrices = (List<Double>) request.getAttribute("userPrices");
            for (int i = 0; i < userRequests.size(); i++) {
                out.print("<tr class=\"table-success\"><td>" + userRequests.get(i).getId()
                        + "</td><td>" + userRequests.get(i).getDate()
                        + "</td><td>" + userDepartmentsFrom.get(i).getTown()
                        + "</td><td>" + userDepartmentsTo.get(i).getTown()
                        + "</td><td>" + userDeliveryTypes.get(i).getName()
                        + "</td><td>" + userWeights.get(i).getValue()
                        + "</td><td>" + userPrices.get(i)/100
                        + "</td><td>" + "<a class=\"btn btn-outline-success\" " +
                        "href=\"${pageContext.request.contextPath}/servlet/payDelivery\">\n" +
                        "Pay" +
                        "</a>" +
                        "</td></tr>");
            }
        %>
    </table>
</div>
<div class="jumbotron align-content-center">
    <div>
        <p><fmt:message key="user.create.request"/></p>
    </div>
    <form style="max-width: 20rem;" action="${pageContext.request.contextPath}/servlet/createRequest" method="get">
        <label for="date"><fmt:message key="create.request.date"/></label><br>
        <input class="form-control" type="date" name="date" id="date"/><br>
        <label for="deliveryType"><fmt:message key="create.request.delivery.type"/></label><br>
        <select class="form-control" name="deliveryType" id="deliveryType">
            <c:forEach items="${deliveryTypes}" var="deliveryType">
                <option><c:out value="${deliveryType}"/></option>
            </c:forEach>
        </select><br>
        <label for="weight"><fmt:message key="create.request.weight"/></label><br>
        <select class="form-control" name="weight" id="weight">
            <c:forEach items="${weights}" var="weight">
                <option><c:out value="${weight}"/></option>
            </c:forEach>
        </select><br>
        <label for="departmentFrom"><fmt:message key="create.request.department.from"/></label><br>
        <select class="form-control" name="departmentFrom" id="departmentFrom">
            <c:forEach items="${departments}" var="department">
                <option><c:out value="${department}"/></option>
            </c:forEach>
        </select><br>
        <label for="departmentTo"><fmt:message key="create.request.department.to"/></label><br>
        <select class="form-control" name="departmentTo" id="departmentTo">
            <c:forEach items="${departments}" var="department">
                <option><c:out value="${department}"/></option>
            </c:forEach>
        </select><br>
        <button class="btn btn-primary" type="submit"><fmt:message key="button.create"/></button>
        <br>
    </form>
</div>
<script>
    var date = document.getElementById('date'),
        dateError = document.getElementById("dateError");
    date.addEventListener('change', function () {
        var min = new Date(),
            max = new Date().setDate((new Date().getDay() + 7));
        if (new Date(date.value).getTime() < min.getTime() ||
            new Date(date.value).getTime() > max.getTime()) {
            dateError.innerHTML = "Date must be greater than today and smaller then " +
                new Date(max).toString();
            dateError.style.display = 'inherit';
        } else {
            dateError.cleanData();
            dateError.style.display = 'none';
        }
    })
</script>
<%@include file="../template/footer.jsp" %>
