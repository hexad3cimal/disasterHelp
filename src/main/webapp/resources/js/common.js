/**
 * Created by jovin on 10/1/16.
 */
!function ($) {
    $(document).on("click","ul.nav li.parent > a > span.icon", function(){
        $(this).find('em:first').toggleClass("glyphicon-minus");
    });
    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
}(window.jQuery);

$(window).on('resize', function () {
    if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
})
$(window).on('resize', function () {
    if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
})

$(function(){

    var url = window.location;
    $('#sidebar a[href="' + url + '"]').parent('li').addClass('active');
    $('#sidebar a').filter(function () {
        return this.href == url;
    }).parent('li').addClass('active');


});