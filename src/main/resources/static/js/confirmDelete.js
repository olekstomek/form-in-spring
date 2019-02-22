$(document).on("click", "[data-toggle=\"confirm\"]", function (e) {
    e.preventDefault();
    var lHref = $(this).attr('href');
/*<![CDATA[*/
    var user = /*[[${session.tempClient}]]*/ 'tempClient';
/*]]>*/
    var lText = "Are you sure that you want delete client ?" /*+ user*/;
    bootbox.confirm(lText, function (confirmed) {
        if (confirmed) {
            window.location.href = lHref;
        }
    });
});
