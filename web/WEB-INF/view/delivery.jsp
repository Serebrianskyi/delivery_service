<%@include file="../template/header.jsp" %>
<script>
    document.title = "<fmt:message key="title.delivery"/>";
</script>
<div class="jumbotron">
    <span class="card border-info mb-3">
        <div class="card-header"><h2><fmt:message key="delivery.choose.us"/></h2></div>
        <div class="card-body">
            <ol class="breadcrumb">
                <li class="breadcrumb-item active"><fmt:message key="delivery.first.adv"/></li>
            </ol>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><fmt:message key="delivery.second.adv"/></li>
            </ol>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><fmt:message key="delivery.third.adv"/></li>
            </ol>
        </div>
    </span>
    <span class="card border-success mb-3">
        <div class="card-header"><h2><fmt:message key="delivery.order"/></h2></div>
        <div class="card-body">
            <ol class="breadcrumb">
                <li class="breadcrumb-item active"><fmt:message key="order.step.first"/></li>
            </ol>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><fmt:message key="order.step.second"/></li>
            </ol>
        </div>
    </span>
    <span class="card border-danger mb-3">
        <div class="card-header"><h2><fmt:message key="delivery.get"/></h2></div>
        <div class="card-body">
            <ol class="breadcrumb">
                <li class="breadcrumb-item active"><fmt:message key="get.step.first"/></li>
            </ol>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><fmt:message key="get.step.second"/></li>
            </ol>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><fmt:message key="get.step.third"/></li>
            </ol>
        </div>
    </span>
</div>
<%@include file="../template/footer.jsp"%>