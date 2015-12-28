$(document).ready(function(){

$('#disasterNew').hide();

$.get(contextPath+"/TotalCount", function (data) {
        $('#areaTotalCount').text(data.data[2]);
                $('#helplineTotalCount').text(data.data[1]);
                        $('#volunteerTotalCount').text(data.data[0]);
                        $('#aidAvailableTotalCount').text(data.data[5]);
                        $('#aidNeededTotalCount').text(data.data[4]);
                        $('#disasterTotalCount').text(data.data[3]);


});


$('#newDisaster').click(function(){

$('#disasterNew').show("slow");

});

$("#addDisasterForm").validate({
 rules :{

 disasterName: {
  required : true
//  remote : {
//
//
//
//  }

 }

 },

  highlight: function(element) {
                     $(element).closest('.form-group').addClass('has-error');

                 },
                 unhighlight: function(element) {
                     $(element).closest('.form-group').removeClass('has-error');
                 },
                 errorElement: 'span',
                 errorClass: 'help-block',
                 errorPlacement: function(error, element) {
                     if(element.parent('.input-group').length) {
                         error.insertAfter(element.parent());
                     } else {
                         error.insertAfter(element);
                     }
                 },

         submitHandler: function(form) {
 addDisaster()
      }


});


function addDisaster(){
var disasterName =$('#disasterName').val();
var data = {
"disasterName":$('#disasterName').val()

}

$.ajax({
            url: contextPath+"/disaster/add",
            type: 'post',
            contentType: "application/json",
            dataType: 'json',
            data: JSON.stringify(data),
            success: function(data) {
 if(data.data=="Success"){
 window.location = contextPath+"/"+disasterName+"/home"

 }

                }
            ,
            error: function(request, status, error) {

            }
        });

}

});