<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url value="/resources/js/homepage.js" var="home" />
<script src="${home}"></script>


<div id="homeBlock">
<div class="row tile_count ">
      <div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-4 tile_stats_count">
      <div class="x_panel">
          <div class="right">
              <span class="count_top"><i class="fa fa-user"></i> Total</span>
              <div class="count green" id="volunteerTotalCount"></div>
              <span class="count_bottom">volunteers registered</span>
                   </div>
          </div>

      </div>

      <div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-4 tile_stats_count">
            <div class="x_panel">

          <div class="right">
              <span class="count_top"><i class="fa fa-user"></i> Total</span>
              <div class="count green" id="areaTotalCount"></div>
              <span class="count_bottom">areas listed</span>

          </div>
      </div>

      </div>

      <div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-4 tile_stats_count">
      <div class="x_panel">
          <div class="right">
              <span class="count_top"><i class="fa fa-user"></i> Total</span>
              <div class="count green" id="helplineTotalCount"></div>
              <span class="count_bottom">helplines available</span>

          </div>
      </div>
      </div>

 <div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-4 tile_stats_count">
      <div class="x_panel">
          <div class="right">
              <span class="count_top"><i class="fa fa-user"></i> Total</span>
              <div class="count green" id="aidNeededTotalCount"></div>
              <span class="count_bottom">aids needed</span>

          </div>
      </div>
    </div>


      <div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-4 tile_stats_count">
            <div class="x_panel">
                <div class="right">
                    <span class="count_top"><i class="fa fa-user"></i> Total</span>
                    <div class="count green" id="aidAvailableTotalCount"></div>
                    <span class="count_bottom">aids available</span>

                </div>
            </div>
          </div>


            <div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-4 tile_stats_count">
                  <div class="x_panel">
                      <div class="right">
                          <span class="count_top"><i class="fa fa-user"></i> Total</span>
                          <div class="count green" id="disasterTotalCount"></div>
                          <span class="count_bottom">disasters listed</span>

                      </div>
                  </div>
                  </div>
                </div>
              </div>

              <div class="row row-centered col-md-12 col-sm-12 col-xs-12 col-lg-12">


               <div class="input-group col-md-8 col-md-offset-2">
                                                                  <button type="button" id="newDisaster" class="btn btn-danger btn-lg">Add new disaster</button>
                       </div>

              </div>



              <div id="disasterNew">


               <form id="addDisasterForm" data-parsley-validate class="form-horizontal form-label-left">
                           <div class="form-group">
                                          <label class="control-label col-md-3 col-sm-3 col-xs-12" for="disasterName">Disaster<span class="required">*</span>
                                          </label>
                                          <div class="col-md-6 col-sm-6 col-xs-12">
                                              <input type="text" id="disasterName" name="disasterName" required="required" class="form-control col-md-7 col-xs-12">
                                          </div>
                                      </div>

                          <div class="form-group">
                              <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                  <button type="submit" class="btn btn-primary pull-right">Add</button>
                              </div>
                          </div>
                      </form>

              </div>



