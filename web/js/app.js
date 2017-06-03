/**
 * Created by hhy on 2017/6/2.
 */
(function ($) {
var row=3;
var column=3;
var url="/am";
function create_map() {
    var map = $("#map");
    map.html("");
    for(var i=0;i<row;i++) {
        for(var j=0;j<column;j++){
            var id_temp = i+'-'+j;
            map.append('<div '+'id='+id_temp+' class="item"></div>');
        }
    }
}
function next() {
    console.log("next");
    $.get(url,{}, function (data) {
        var parsedJson = jQuery.parseJSON(data);
        console.log(data);
        $.each(parsedJson, function (idx, item) {
            // console.log(item.x);
            var id_temp = item.x+'-'+item.y;
            $("#"+id_temp).css("background","white");
        });
    })
}
    $(function () {
        // alert("init done");
        create_map();
        next();
        window.setInterval(next, 1000);
    });
})(jQuery);