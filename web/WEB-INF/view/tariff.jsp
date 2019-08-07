<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="model.entity.Department" %>
<%@ page import="model.entity.Tariff" %>
<%@ page import="java.util.List" %>
<%@include file="../template/header.jsp" %>
<script>
    document.title = "<fmt:message key="title.tariff"/>";
</script>
<%
    List<Tariff> documentTariffs = (List<Tariff>) request
            .getAttribute("documentTariffs");
    List<Tariff> cargoTariffs = (List<Tariff>) request
            .getAttribute("cargoTariffs");
    List<Department> documentTariffDepartmentsFrom = (List<Department>) request.
            getAttribute("documentTariffDepartmentsFrom");
    List<Department> cargoTariffDepartmentsFrom = (List<Department>) request
            .getAttribute("cargoTariffDepartmentsFrom");
    List<Department> documentTariffDepartmentsTo = (List<Department>) request
            .getAttribute("documentTariffDepartmentsTo");
    List<Department> cargoTariffDepartmentsTo = (List<Department>) request
            .getAttribute("cargoTariffDepartmentsTo");
%>
<div class="jumbotron align-content-center">
    <div class="card-header" style="width: 90%">
        <h2><fmt:message key="tariff.documents"/></h2>
    </div>
    <table style="width: 90%">
        <tr class="table-dark">
            <th><fmt:message key="tariff.department.from"/></th>
            <th><fmt:message key="tariff.department.to"/></th>
            <th><fmt:message key="tariff.price"/></th>
        </tr>
        <%
            for (int i = 0; i < documentTariffs.size(); i++) {
                out.print("<tr class=\"table-success\">" +
                        "<td>" + documentTariffDepartmentsFrom.get(i).getTown() + "</td>" +
                        "<td>" + documentTariffDepartmentsTo.get(i).getTown() + "</td>" +
                        "<td>" + documentTariffs.get(i).getPrice()/100 + "</td></tr>");
            }
        %>
    </table>
    <br>
    <div class="card-header" style="width: 90%">
        <h2><fmt:message key="tariff.cargo"/></h2>
    </div>
    <table style="width: 90%">
        <tr class="table-dark">
            <th><fmt:message key="tariff.department.from"/></th>
            <th><fmt:message key="tariff.department.to"/></th>
            <th><fmt:message key="tariff.price"/></th>
        </tr>
        <%
            for (int i = 0; i < documentTariffs.size(); i++) {
                out.print("<tr class=\"table-success\">" +
                        "<td>" + cargoTariffDepartmentsFrom.get(i).getTown() + "</td>" +
                        "<td>" + cargoTariffDepartmentsTo.get(i).getTown() + "</td>" +
                        "<td>" + cargoTariffs.get(i).getPrice()/100 + "</td></tr>");
            }
        %>
    </table>
</div>
<%@include file="../template/footer.jsp" %>
