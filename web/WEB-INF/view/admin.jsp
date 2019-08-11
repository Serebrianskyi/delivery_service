<%@include file="../template/header.jsp" %>
<script>
    document.title = "<fmt:message key="title.admin"/>";
</script>
<div class="jumbotron align-content-center">
    <div>
        <h3><fmt:message key="admin.create.tariff"/></h3>
    </div>
    <form style="max-width: 20rem;" action="${pageContext.request.contextPath}/servlet/createTariff" method="get">
        <label for="valueTariff"><fmt:message key="create.tariff.value"/></label><br>
        <input class="form-control" type="text" name="value" id="valueTariff"/><br>
        <label for="price"><fmt:message key="create.tariff.price"/></label><br>
        <input class="form-control" type="text" name="price" id="price"/><br>
        <label for="departmentFromId"><fmt:message key="create.tariff.depart.from"/></label><br>
        <input class="form-control" type="text" name="departmentFromId" id="departmentFromId"/><br>
        <label for="departmentToId"><fmt:message key="create.tariff.depart.to"/></label><br>
        <input class="form-control" type="text" name="departmentToId" id="departmentToId"/><br>
        <label for="deliveryTypeId"><fmt:message key="create.tariff.delivery.type"/></label><br>
        <input class="form-control" type="text" name="deliveryTypeId" id="deliveryTypeId"/><br>
        <button class="btn btn-primary" type="submit"><fmt:message key="button.create"/></button><br>
    </form>
</div>
<div class="jumbotron align-content-center">
    <div>
        <h3><fmt:message key="admin.create.weight"/></h3>
    </div>
    <form style="max-width: 20rem;" action="${pageContext.request.contextPath}/servlet/createWeight" method="get">
        <label for="valueWeight"><fmt:message key="create.weight.value"/></label><br>
        <input class="form-control" type="text" name="value" id="valueWeight"/><br>
        <label for="coefficient"><fmt:message key="create.weight.coefficient"/></label><br>
        <input class="form-control" type="text" name="coefficient" id="coefficient"/><br>
        <button class="btn btn-primary" type="submit"><fmt:message key="button.create"/></button><br>
    </form>
</div>
<div class="jumbotron align-content-center">
    <div>
        <h3><fmt:message key="admin.create.department"/></h3>
    </div>
    <form style="max-width: 20rem;" action="${pageContext.request.contextPath}/servlet/createDepartment" method="get">
        <label for="town"><fmt:message key="create.department.town"/></label><br>
        <input class="form-control" type="text" name="town" id="town"/><br>
        <label for="street"><fmt:message key="create.department.street"/></label><br>
        <input class="form-control" type="text" name="street" id="street"/><br>
        <label for="buildingNumber"><fmt:message key="create.department.building.number"/></label><br>
        <input class="form-control" type="text" name="buildingNumber" id="buildingNumber"/><br>
        <label for="scheduleId"><fmt:message key="create.department.schedule.id"/></label><br>
        <input class="form-control" type="text" name="scheduleId" id="scheduleId"/><br>
        <button class="btn btn-primary" type="submit"><fmt:message key="button.create"/></button><br>
    </form>
</div>
<div class="jumbotron align-content-center">
    <div>
        <h3><fmt:message key="admin.create.schedule"/></h3>
    </div>
    <form style="max-width: 20rem;" action="${pageContext.request.contextPath}/servlet/createSchedule" method="get">
        <label for="timeBegin"><fmt:message key="create.schedule.timeBegin"/></label><br>
        <input class="form-control" id="timeBegin" type="time" name="timeBegin"/><br>
        <label for="timeEnd"><fmt:message key="create.schedule.timeEnd"/></label><br>
        <input class="form-control" id="timeEnd" type="time" name="timeEnd"/><br>
        <button class="btn btn-primary" type="submit"><fmt:message key="button.create"/></button><br>
    </form>
</div>
<div class="jumbotron align-content-center">
    <div>
        <h3><fmt:message key="admin.create.delivery.type"/></h3>
    </div>
    <form style="max-width: 20rem;" action="${pageContext.request.contextPath}/servlet/createDeliveryType" method="get">
        <label for="nameDeliveryType" ><fmt:message key="create.delivery.type.name"/></label><br>
        <input class="form-control" type="text" name="name" id="nameDeliveryType"/><br>
        <label for="descriptionDeliveryType"><fmt:message key="create.delivery.type.description"/></label><br>
        <input class="form-control" type="text" name="description" id="descriptionDeliveryType"/><br>
        <button class="btn btn-primary" type="submit"><fmt:message key="button.create"/></button><br>
    </form>
</div>

<%@include file="../template/footer.jsp" %>
