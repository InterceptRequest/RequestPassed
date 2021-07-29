<%--
  Created by IntelliJ IDEA.
  User: 13101
  Date: 2021/7/20
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<script>
    jQuery(function ($) {
        if($("select[owner]").size() != 0) {
            $.ajax({
                url: "/user/getOwner.json",
                type: "get",
                success(data) {
                    var html = ""
                    $(data).each(function (index) {
                        html += `<option>` + this + `</option>`;
                    })
                    $("select[owner]").html(html)
                }
            })
        }
    })
</script>
