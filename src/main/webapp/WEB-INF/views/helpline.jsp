    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <%--Custom javascript--%>
        <spring:url value="/resources/js/home.js" var="home"/>
        <script src="${home}"></script>

        <%--Heading--%>
        <div class="row row-centered">
        <h1 id="mainH1" class="col-centered">Chennai</h1>
        </div>


        <%--Tiles--%>
        <div class="row tile_count ">
        <div class="animated flipInY col-lg-3 col-md-3 col-sm-3 col-xs-3 tile_stats_count">
        <div class="x_panel">
        <div class="right">
        <span class="count_top"><i class="fa fa-user"></i> Total</span>
        <div class="count green" id="volunteerNos"></div>
        <span class="count_bottom">volunteers registered</span>
        <div class="row col-lg-12 col-md-12 col-sm-12 row-centered">
        <button type="button" id ="newVolunteer" class=" btn btn-success pull-left">Add new volunteer</button>
        </div>
        </div>
        </div>

        </div>
        <div class="animated flipInY col-lg-3 col-md-3 col-sm-3 col-xs-3 tile_stats_count">
        <div class="x_panel">

        <div class="right">
        <span class="count_top"><i class="fa fa-user"></i> Total</span>
        <div class="count green" id="areaCount"></div>
        <span class="count_bottom">areas listed</span>
        <div class="row col-lg-12 col-md-12 col-sm-12 row-centered">
        <button type="button" id ="newArea" class=" btn btn-success pull-left responsive-width">Add new area</button>
        </div>
        </div>
        </div>

        </div>
        <div class="animated flipInY col-lg-3 col-md-3 col-sm-3 col-xs-3 tile_stats_count">
        <div class="x_panel">
        <div class="right">
        <span class="count_top"><i class="fa fa-user"></i> Total</span>
        <div class="count green" id="helplineCount"></div>
        <span class="count_bottom">helplines available</span>
        <div class="row col-lg-12 col-md-12 col-sm-12 row-centered">
        <button type="button" id ="newHelpLine" class=" btn btn-success pull-left responsive-width">Add new
        helpline</button>
        </div>
        </div>
        </div>
        </div>

        <div class="animated flipInY col-lg-3 col-md-3 col-sm-3 col-xs-3 tile_stats_count">
        <div class="x_panel">
        <div class="right">
        <span class="count_top"><i class="fa fa-user"></i> Total</span>
        <div class="count green" id="aidNeededNos"></div>
        <span class="count_bottom">aid needed</span>
        <div class="row col-lg-12 col-md-12 col-sm-12 row-centered">
        <button type="button" id ="newAid" class=" btn btn-success pull-left responsive-width">Request aid</button>
        </div>
        </div>
        </div>
        </div>

        <div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-4 col-md-offset-4 tile_stats_count">
        <div class="x_panel">
        <div class="right">
        <span class="count_top"><i class="fa fa-user"></i> Total</span>
        <div class="count green" id="aidAvailableNos"></div>
        <span class="count_bottom">aid Available</span>
        <div class="row col-lg-12 col-md-12 col-sm-12 row-centered">
        <button type="button" id ="newAidAvailable" class=" btn btn-success pull-left responsive-width">New aid</button>
        </div>
        </div>
        </div>
        </div>


        </div>
        <!-- Tiles End -->

        <%--Search box--%>
        <div id="searchBox">
        <div class="row row-centered col-md-12 col-sm-12 col-xs-12 col-lg-12">

        <div class="input-group col-md-8 col-md-offset-2">
        <input type="text" id="areaSearch" placeholder="Enter the area" class="form-control input-lg"/>
        <span class="input-group-addon">
        <i class="fa fa-search"></i>
        </span>
        </div>
        </div>


        </div>

        <%--Data tables--%>
        <div id="DataTable">
        <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
        <h2>Volunteers available</h2>
        <div class="clearfix"></div>
        <div class="x_content">
        <table id="volunteerTable" class="table table-striped responsive-utilities jambo_table" cellspacing="0"
        width="100%">
        <thead>
        <tr>
        <th>Name</th>
        <th>Contact</th>
        <th>Type</th>
        <th>Gender</th>

        </tr>
        </thead>
        <tfoot>
        <tr>
        <th>Name</th>
        <th>Contact</th>
        <th>Type</th>
        <th>Gender</th>
        </tr>
        </tfoot>
        </table>
        </div>
        </div>
        </div>


        <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
        <h2>Helplines available</h2>
        <div class="clearfix"></div>
        <div class="x_content">
        <table id="helplineTable" class="table table-striped responsive-utilities jambo_table" cellspacing="0"
        width="100%">
        <thead>
        <tr>
        <th>Contact</th>
        <th>Type</th>


        </tr>
        </thead>
        <tfoot>
        <tr>
        <th>Contact</th>
        <th>Type</th>

        </tr>
        </tfoot>
        </table>
        </div>
        </div>
        </div>


        <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
        <h2>Aid Needed</h2>
        <div class="clearfix"></div>
        <div class="x_content">
        <table id="aidNeededTable" class="table table-striped responsive-utilities jambo_table" cellspacing="0"
        width="100%">
        <thead>
        <tr>
        <th>Aid</th>
        <th>Contact</th>


        </tr>
        </thead>
        <tfoot>
        <tr>
        <th>Aid</th>
        <th>Contact</th>
        </tr>
        </tfoot>
        </table>
        </div>
        </div>
        </div>


        <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
        <h2>Aid available</h2>
        <div class="clearfix"></div>
        <div class="x_content">
        <table id="aidAvailableTable" class="table table-striped responsive-utilities jambo_table" cellspacing="0"
        width="100%">
        <thead>
        <tr>
        <th>Aid</th>
        <th>Contact</th>


        </tr>
        </thead>
        <tfoot>
        <tr>
        <th>Aid</th>
        <th>Contact</th>
        </tr>
        </tfoot>
        </table>
        </div>
        </div>
        </div>
        </div>


        <%--Input forms--%>
        <div id="addHelpline">
        <form id="addHelplineForm" data-parsley-validate class="form-horizontal form-label-left">
        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="helplineNo">Helpline No <span
        class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="helplineNo" name="helplineNo" required="required" class="form-control col-md-7
        col-xs-12">
        </div>
        </div>
        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="helplineArea">Area <span class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="helplineArea" name="helplineArea" required="required" class="form-control col-md-7
        col-xs-12">
        </div>
        </div>
        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="supportType">Support Type <span
        class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="supportType" name="supportType" class="form-control col-md-7 col-xs-12">
        </div>
        </div>

        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" id='helplineCaptchaLabel' for="captchaText"></label>
        <div class="col-md-6 col-sm-6 col-xs-12">

        <input type="text" id="captchaText" name='captchaText' placeholder="Enter the above text" class="form-control
        col-md-7 col-xs-12" >
        </div>
        </div>


        <div class="form-group">
        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
        <button type="submit" class="btn btn-primary pull-right">Add</button>
        </div>
        </div>
        </form>
        </div>


        <div id="addnewArea">
        <form id="addAreaForm" data-parsley-validate class="form-horizontal form-label-left">
        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="areaName">Area<span class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="areaName" name="areaName" required="required" class="form-control col-md-7 col-xs-12">
        </div>
        </div>
        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" id='areaCaptchaLabel' for="captchaText"></label>
        <div class="col-md-6 col-sm-6 col-xs-12">

        <input type="text" id="captchaText" name='captchaText' placeholder="Enter the above text" class="form-control
        col-md-7 col-xs-12" >
        </div>
        </div>

        <div class="form-group">
        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
        <button type="submit" class="btn btn-primary pull-right">Add</button>
        </div>
        </div>
        </form>
        </div>


        <div id="addNewVolunteer">
        <form id="addVolunteerForm" data-parsley-validate class="form-horizontal form-label-left">
        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="volunteerName">Name<span class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="volunteerName" name="volunteerName" required="required" class="form-control col-md-7
        col-xs-12">
        </div>
        </div>
        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="volunteerArea">Area <span
        class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="volunteerArea" name="volunteerArea" required="required" class="form-control col-md-7
        col-xs-12">
        </div>
        </div>
        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="volunteerSupportType">Support Type <span
        class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="volunteerSupportType" name="volunteerSupportType" class="form-control col-md-7
        col-xs-12">
        </div>
        </div>
        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="volunteerContact">Contact <span
        class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="volunteerContact" name="volunteerContact" required="required" class="form-control
        col-md-7 col-xs-12">
        </div>
        </div>

        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="volunteerGender">Gender<span
        class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="volunteerGender" name="volunteerGender" class="form-control col-md-7 col-xs-12">
        </div>
        </div>

        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" id='volunteerCaptchaLabel' for="captchaText"></label>
        <div class="col-md-6 col-sm-6 col-xs-12">

        <input type="text" id="captchaText" name='captchaText' placeholder="Enter the above text" class="form-control
        col-md-7 col-xs-12" >
        </div>
        </div>


        <div class="form-group">
        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
        <button type="submit" class="btn btn-primary pull-right">Add</button>
        </div>
        </div>
        </form>
        </div>


        <div id="addNewAid">
        <form id="addAidForm" data-parsley-validate class="form-horizontal form-label-left">
        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="aidAreaName">Area<span class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="aidAreaName" name="aidAreaName" required="required" class="form-control col-md-7
        col-xs-12">
        </div>
        </div>

        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="aidType">Aid Type<span class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="aidType" name="aidType" required="required" class="form-control col-md-7 col-xs-12">
        </div>
        </div>

        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="aidContact">Contact no<span
        class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="aidContact" name="aidContact" required="required" class="form-control col-md-7
        col-xs-12">
        </div>
        </div>
        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" id='newAidCaptchaLabel' for="captchaText"></label>
        <div class="col-md-6 col-sm-6 col-xs-12">

        <input type="text" id="captchaText" name='captchaText' placeholder="Enter the above text" class="form-control
        col-md-7 col-xs-12" >
        </div>
        </div>
        <div class="form-group">
        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
        <button type="submit" class="btn btn-primary pull-right">Add</button>
        </div>
        </div>
        </form>
        </div>

        <div id="requestNewAid">
        <form id="requestNewAidForm" data-parsley-validate class="form-horizontal form-label-left">
        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="requestAidAreaName">Area<span
        class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="requestAidAreaName" name="requestAidAreaName" required="required" class="form-control
        col-md-7 col-xs-12">
        </div>
        </div>

        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="requestAidType">Aid Type<span
        class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="requestAidType" name="requestAidType" required="required" class="form-control col-md-7
        col-xs-12">
        </div>
        </div>

        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="aidRequestContact">Contact no<span
        class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="aidRequestContact" name="aidRequestContact" required="required" class="form-control
        col-md-7 col-xs-12">
        </div>
        </div>
        <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" id='requestAidCaptchaLabel' for="captchaText"></label>
        <div class="col-md-6 col-sm-6 col-xs-12">

        <input type="text" id="captchaText" name='captchaText' placeholder="Enter the above text" class="form-control
        col-md-7 col-xs-12" >
        </div>
        </div>

        <div class="form-group">
        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
        <button type="submit" class="btn btn-primary pull-right">Add</button>
        </div>
        </div>
        </form>
        </div>

