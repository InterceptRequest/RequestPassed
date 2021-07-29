<%--
  Created by IntelliJ IDEA.
  User: 13101
  Date: 2021/7/20
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<script>
    jQuery(function ($) {
        closeModal = function () {
            $("div.modal:visible").modal("hide")
        }

        op = function () {
            $("div.modal[eh=r]").modal("show")
        }
    })
</script>