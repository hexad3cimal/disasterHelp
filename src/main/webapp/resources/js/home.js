$(document).ready(function () {

    $("#DataTable").hide();

    $('#areaSearch').on('change', function () {
        helplineTable.ajax.reload();
        aidAvailableTable.ajax.reload();
        aidNeededTable.ajax.reload();
        volunteerTable.ajax.reload();
        $("#DataTable").show("slow");

    });


    $("#addHelpline").hide();
    $("#addNewVolunteer").hide();
    $("#addnewArea").hide();
    $("#requestNewAid").hide();
    $("#addNewAid").hide();


    $('#newHelpLine').click(function () {
        $("#helplineTable").hide("slow");
        $("#volunteerTable").hide("slow");
        $("#addnewArea").hide();
        $("#requestNewAid").hide();
        $("#addNewAid").hide();
        $("#searchBox").hide();
        $("#addHelpline").show("slow");
        $("#addNewVolunteer").hide();


    });

    $('#newArea').click(function () {
        $("#helplineTable").hide("slow");
        $("#volunteerTable").hide("slow");
        $("#addHelpline").hide();
        $("#requestNewAid").hide();
        $("#addNewAid").hide();
        $("#searchBox").hide();
        $("#addNewVolunteer").hide();
        $("#addnewArea").show("slow");


    });

    $('#newVolunteer').click(function () {
        $("#volunteerTable").hide("slow");
        $("#helplineTable").hide("slow");
        $("#requestNewAid").hide();
        $("#addNewAid").hide();
        $("#addHelpline").hide("slow");
        $("#searchBox").hide("slow");
        $("#addNewVolunteer").show("slow");


    });

    $('#newAidAvailable').click(function () {
        $("#volunteerTable").hide("slow");
        $("#helplineTable").hide("slow");
        $("#requestNewAid").hide();
        $("#addNewAid").show("slow");
        $("#addHelpline").hide("slow");
        $("#searchBox").hide("slow");
        $("#addNewVolunteer").hide("slow");


    });

    $('#newAid').click(function () {
        $("#volunteerTable").hide("slow");
        $("#helplineTable").hide("slow");
        $("#requestNewAid").show("slow");
        $("#addNewAid").hide("hide");
        $("#addHelpline").hide("slow");
        $("#searchBox").hide("slow");
        $("#addNewVolunteer").hide("slow");


    });


    var path = $(location).attr('href');
    var splitted = path.split('/');
    var disaster = splitted[4];
    document.getElementById("mainH1").innerHTML = disaster;


    var volunteerTable = $('#volunteerTable').DataTable({
        dom: "rfltip",
        ajax: {

            "url": contextPath + "/" + disaster + "/volunteer/getlist",
            "type": 'POST',
            "data": function (d) {
                d.areaSearch = $('#areaSearch').val();
            }
        },
        columns: [

            {data: "fullName"},
            {data: "contactNo"},
            {data: "type"},
            {data: "gender"}
        ],
        select: true

    });

    var helplineTable = $('#helplineTable').DataTable({
        dom: "rfltip",
        ajax: {

            "url": contextPath + "/" + disaster + "/helpline/getlist",
            "type": 'POST',
            "data": function (d) {
                d.areaSearch = $('#areaSearch').val();
            }
        },
        columns: [

            {data: "helplineno"},
            {data: "type"}
        ],
        select: true

    });


    var aidNeededTable = $('#aidNeededTable').DataTable({
        dom: "rfltip",
        ajax: {

            "url": contextPath + "/" + disaster + "/aid/aidNeededList",
            "type": 'POST',
            "data": function (d) {
                d.areaSearch = $('#areaSearch').val();
            }
        },
        columns: [

            {data: "aidType"},
            {data: "contactNo"}
        ],
        select: true

    });

    var aidAvailableTable = $('#aidAvailableTable').DataTable({
        dom: "rfltip",
        ajax: {

            "url": contextPath + "/" + disaster + "/aid/aidAvailableList",
            "type": 'POST',
            "data": function (d) {
                d.areaSearch = $('#areaSearch').val();
            }
        },
        columns: [

            {data: "aidType"},
            {data: "contactNo"}
        ],
        select: true

    });


    //Setting captcha
    var preview = document.getElementById("captchaLabel");
    $.get(contextPath + "/getCaptcha", function (data) {
        var img = document.createElement("img");
        img.src = data.data;
        document.getElementById("helplineCaptchaLabel").appendChild(img.cloneNode(true));
        document.getElementById("volunteerCaptchaLabel").appendChild(img.cloneNode(true));
        document.getElementById("areaCaptchaLabel").appendChild(img.cloneNode(true));
        document.getElementById("newAidCaptchaLabel").appendChild(img.cloneNode(true));
        document.getElementById("requestAidCaptchaLabel").appendChild(img.cloneNode(true));


    });


    //Getting count based on disaster
    $.get(contextPath + "/disasterCount", {"disaster": disaster}).done(function (data) {

        $('#aidAvailableNos').text(data.data[0]);
        $('#helplineCount').text(data.data[2]);
        $('#areaCount').text(data.data[3]);
        $('#volunteerNos').text(data.data[1]);
        $('#aidNeededNos').text(data.data[4]);


    });


    $("#addHelplineForm").validate({

        // Specify the validation rules
        rules: {
            name: {
                required: true
            },
            contactNo: {
                required: true
            },
            helplineArea: {
                required: true
            },
            supportType: {
                required: true
            },
            gender: {
                required: true
            },
            captchaText: {
                required: true,
                remote: {
                    url: contextPath + "/validateCaptcha",
                    type: "GET"
                }
            }
        },

        // Specify the validation error messages
        messages: {
            captchaText: {required: "Please enter a valid Name", remote: "This name already exist"}

        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');

        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function (error, element) {
            if (element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        },

        submitHandler: function (form) {
            addHelpline()
        }
    });


    $('#addVolunteerForm').validate({

        rules: {

            volunteerName: {
                required: true
            },
            volunteerArea: {
                required: true
            },
            volunteerSupportType: {
                required: true
            },
            volunteerGender: {
                required: true
            },
            captchaText: {
                required: true,
                remote: {
                    url: contextPath + "/validateCaptcha",
                    type: "GET"
                }

            }

        },
        messages: {
            captchaText: {required: "Please enter a valid Name", remote: "This name already exist"}

        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');

        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function (error, element) {
            if (element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        },

        submitHandler: function (form) {
            addVolunteer()
        }

    });


    $('#addAidForm').validate({

        rules: {

            aidAreaName: {
                required: true
            },
            aidType: {
                required: true
            },
            captchaText: {
                required: true,
                remote: {
                    url: contextPath + "/validateCaptcha",
                    type: "GET"
                }

            }

        },
        messages: {
            captchaText: {required: "Please enter a valid Name", remote: "This name already exist"}

        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');

        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function (error, element) {
            if (element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        },

        submitHandler: function (form) {
            addAid()
        }

    });


    $('#requestNewAidForm').validate({

        rules: {

            requestAidAreaName: {
                required: true
            },
            requestAidType: {
                required: true
            },
            captchaText: {
                required: true,
                remote: {
                    url: contextPath + "/validateCaptcha",
                    type: "GET"
                }

            }

        },
        messages: {
            captchaText: {required: "Please enter a valid Name", remote: "This name already exist"}

        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');

        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function (error, element) {
            if (element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        },

        submitHandler: function (form) {
            requestAid()
        }

    });


    $('#addAreaForm').validate({

        rules: {

            areaName: {
                required: true
            },
            captchaText: {
                required: true,
                remote: {
                    url: contextPath + "/validateCaptcha",
                    type: "GET"
                }

            }

        },
        messages: {
            captchaText: {required: "Please enter a valid Name", remote: "This name already exist"}

        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');

        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function (error, element) {
            if (element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        },

        submitHandler: function (form) {
            addArea()
        }

    });

});


//Function for adding Helpline via ajax post
function addHelpline() {
    var path = $(location).attr('href');
    var splitted = path.split('/');
    var disaster = splitted[4];
    var helplineArea = $('#helplineArea').val();
    var data = {
        "contactNo": $('#helplineNo').val(),
        "area": helplineArea,
        "supportType": $('#supportType').val()

    };

    $.ajax({
        url: contextPath + "/" + disaster + "/helpline/add",
        type: 'post',
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data),
        success: function (data) {
            if (data.data == "Success") {
                window.location = contextPath + "/" + disaster + "/home"

            }

        }
        ,
        error: function (request, status, error) {

        }
    });
}

//Function for adding Volunteer via ajax post
function addVolunteer() {
    var path = $(location).attr('href');
    var splitted = path.split('/');
    var disaster = splitted[4];
    var data = {
        "volunteerName": $("#volunteerName").val(),
        "area": $('#volunteerArea').val(),
        "supportType": $('#volunteerSupportType').val(),
        "volunteerGender": $('#volunteerGender').val(),
        "contactNo": $('#volunteerContact').val()
    };

    $.ajax({
        url: contextPath + "/" + disaster + "/volunteer/add",
        type: 'post',
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data),
        success: function (data) {
            if (data.data == "Success") {
                window.location = contextPath + "/" + disaster + "/home"

            }

        }
        ,
        error: function (request, status, error) {

        }
    });


}

//Function for adding Aid via ajax post
function addAid() {
    var path = $(location).attr('href');
    var splitted = path.split('/');
    var disaster = splitted[4];
    var data = {
        "area": $('#aidAreaName').val(),
        "supportType": $('#aidType').val(),
        "contactNo": $('#aidContact').val()
    };

    $.ajax({
        url: contextPath + "/" + disaster + "/aid/add",
        type: 'post',
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data),
        success: function (data) {
            if (data.data == "Success") {
                window.location = contextPath + "/" + disaster + "/home"

            }

        }
        ,
        error: function (request, status, error) {

        }
    });
}

//Function for requesting Aid via ajax post
function requestAid() {
    var path = $(location).attr('href');
    var splitted = path.split('/');
    var disaster = splitted[4];
    var data = {
        "area": $('#requestAidAreaName').val(),
        "supportType": $('#requestAidType').val(),
        "contactNo": $('#aidRequestContact').val()
    };

    $.ajax({
        url: contextPath + "/" + disaster + "/aid/request",
        type: 'post',
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data),
        success: function (data) {
            if (data.data == "Success") {
                window.location = contextPath + "/" + disaster + "/home"

            }

        }
        ,
        error: function (request, status, error) {

        }
    });


}


//Function for adding Area via ajax post
function addArea() {
    var path = $(location).attr('href');
    var splitted = path.split('/');
    var disaster = splitted[4];
    var data = {
        "area": $('#areaName').val(),
    };

    $.ajax({
        url: contextPath + "/" + disaster + "/area/add",
        type: 'post',
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data),
        success: function (data) {
            if (data.data == "Success") {
                window.location = contextPath + "/" + disaster + "/home"

            }

        }
        ,
        error: function (request, status, error) {

        }
    });


}

