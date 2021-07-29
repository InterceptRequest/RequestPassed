<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<script>
    jQuery(function($){

        $("input[date]").datetimepicker({
            language: "zh-CN",
            format: "yyyy-mm-dd",//显示格式
            minView: "month", // 日期时间选择器所能够提供的最精确的时间选择视图。
            initialDate: new Date(),//初始化当前日期
            autoclose: true, //选中自动关闭
            pickerPosition: "bottom-right"
        }).attr("autocomplete", "off");

        $("input[datetime]").datetimepicker({
            language: "zh-CN",
            format: "yyyy-mm-dd hh:ii:ss",//显示格式
            minView: "hour", // 日期时间选择器所能够提供的最精确的时间选择视图。
            initialDate: new Date(),//初始化当前日期
            autoclose: true, //选中自动关闭
            pickerPosition: "bottom-right"
        }).attr("autocomplete", "off");

    });
</script>
