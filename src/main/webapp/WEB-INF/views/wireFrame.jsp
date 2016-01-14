<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%--
  Created by IntelliJ IDEA.
  User: jovin
  Date: 9/1/16
  Time: 7:09 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><tiles:getAsString name="title" /></title>

    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/css/datepicker3.css" var="datepickerCss"/>
    <spring:url value="/resources/css/styles.css" var="defaultStyleCss"/>
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${datepickerCss}" rel="stylesheet" />
    <link href="${defaultStyleCss}" rel="stylesheet" />

    <spring:url value="/resources/js/jquery-1.11.1.min.js" var="jqueryJs" />
    <script src="${jqueryJs}"></script>
    <spring:url value="/resources/js/bootstrap.js" var="bootstrapJs" />
    <script src="${bootstrapJs}"></script>
    <spring:url value="/resources/js/jquery.validate.js" var="validateJs" />
    <script src="${validateJs}"></script>
    <script>var contextPath = "${pageContext.request.contextPath}"</script>
    <spring:url value="/resources/datatables/dataTables.tableTools.css" var="datatables" />
    <link href="${datatables}" rel="stylesheet" />
    <spring:url value="/resources/datatables/jquery.dataTables.js" var="dataJs" />
    <script src="${dataJs}"></script>
    <!--Icons-->
    <spring:url value="/resources/js/lumino.glyphs.js" var="iconJs" />
    <script src="${iconJs}"></script>

    <!--[if lt IE 9]>
    <spring:url value="/resources/js/html5shiv.js" var="ie1Js" />
    <spring:url value="/resources/js/respond.min.js" var="ie2Js" />
    <script src="${ie1Js}"></script>
    <script src="${ie2Js}"></script>
    <![endif]-->

</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <tiles:insertAttribute name="topNavigation"></tiles:insertAttribute>
</nav>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <tiles:insertAttribute name="menu"></tiles:insertAttribute>
</div>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <tiles:insertAttribute name="body"></tiles:insertAttribute>
</div>



<spring:url value="/resources/js/bootstrap-datepicker.js" var="bootDateJs" />
<script src="${bootDateJs}"></script>
<spring:url value="/resources/js/common.js" var="commonJs" />
<script src="${commonJs}"></script>

</body>

</html>