<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

<spring:url value="/resources/css/bootstrap.min.css" var="bootstarp" />
<spring:url value="/resources/css/custom.css" var="custom" />
<spring:url value="/resources/fonts/css/font-awesome.min.css" var="font" />
<spring:url value="/resources/datatables/dataTables.tableTools.css" var="datatables" />

<link href="${bootstarp}" rel="stylesheet" />
<link href="${datatables}" rel="stylesheet" />
<link href="${font}" rel="stylesheet" />
<link href="${custom}" rel="stylesheet" />

<spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />
<script src="${jqueryJs}"></script>
<script>var contextPath = "${pageContext.request.contextPath}"</script>
<spring:url value="/resources/js/bootstrap.min.js" var="bootstarpJs" />
<script src="${bootstarpJs}"></script>
<spring:url value="/resources/js/custom.js" var="customJs" />
<script src="${customJs}"></script>


</head>


<body class="nav-md">

    <div class="container body">


        <div class="main_container">
            <div class="col-md-3 col-lg-3 col-sm-3 col-xs-3 left_col">
                <div class="left_col scroll-view">

                    <div class="navbar nav_title" style="border: 0;">
                        <a href="index.html" class="site_title"><span>Disaster Help!</span></a>
                    </div>
                    <div class="clearfix"></div>

                    <!-- menu prile quick info -->

                    <br />
		<tiles:insertAttribute name="menu"></tiles:insertAttribute>

           </div>
                 </div>
<!-- sidebar menu -->
		<tiles:insertAttribute name="topNavigation"></tiles:insertAttribute>


<div class="right_col" role="main">
<div class = "row col-md-9 col-lg-9 col-sm-9 col-xs-9 ">
				<tiles:insertAttribute name="body"></tiles:insertAttribute>

</div>
</div>
</div>
    </div>


    <spring:url value="/resources/js/jquery.nicescroll.min.js" var="niceScroll" />
<spring:url value="/resources/datatables/jquery.dataTables.js" var="dataJs2" />
<spring:url value="/resources/js/jquery.validate.js" var="validate" />

<script src="${niceScroll}"></script>
<script src="${dataJs2}"></script>
<script src="${validate}"></script>


</body>

</html>
