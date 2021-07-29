<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/static/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="/static/jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="/static/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" >
		jQuery(function ($) {
			$("#che").click(function () {
				$(":checkbox[name=danOn]").prop("checked",this.checked)
			})
			$(":checkbox[name=danOn]").click(function () {
				$("#che").prop("checked",
					$(":checkbox[name=danOn]").size() == $(":checkbox[name=danOn]:checked").size()
				)
			})

			$("#delBtn").click(function () {
				var ids = $(":checkbox[name=danOn]:checked")
				if(ids.size()==0){
					alert("请选择删除序号")
					return;
				}
				if(!confirm("确认删除？"))return;
				var $ids = []
				ids.each(function () {
					$ids.push(this.value)
				})
				$ids=$ids.join(",")

				location = "/value/delete.do?ids="+$ids;
			})
			$("#upBtn").click(function () {
				if($(":checkbox[name=danOn]:checked").size() != 1){
					alert("至多选择一项！")
					return
				}

				location = "/value/update.html?id="+$(":checkbox[name=danOn]:checked").val()
			})
		})
	</script>
</head>
<body>

	<div>
		<div style="position: relative; left: 30px; top: -10px;">
			<div class="page-header">
				<h3>字典值列表</h3>
			</div>
		</div>
	</div>
	<div class="btn-toolbar" role="toolbar" style="background-color: #F7F7F7; height: 50px; position: relative;left: 30px;">
		<div class="btn-group" style="position: relative; top: 18%;">
		  <button type="button" class="btn btn-primary" onclick="window.location.href='/value/save.html'"><span class="glyphicon glyphicon-plus"></span> 创建</button>
		  <button type="button" id="upBtn" class="btn btn-default" ><span class="glyphicon glyphicon-edit"></span> 编辑</button>
		  <button type="button" id="delBtn" class="btn btn-danger"><span class="glyphicon glyphicon-minus"></span> 删除</button>
		</div>
	</div>
	<div style="position: relative; left: 30px; top: 20px;">
		<table class="table table-hover">
			<thead>
				<tr style="color: #B3B3B3;">
					<td><input type="checkbox" id="che"/></td>
					<td>序号</td>
					<td>字典值</td>
					<td>文本</td>
					<td>排序号</td>
					<td>字典类型编码</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${value}" varStatus="value" var="va">
				<input type="hidden" name="id" value="${va.id}">
				<tr>
					<td><input type="checkbox" value="${va.id}" name="danOn"/></td>
					<td>${value.count}</td>
					<td>${va.value}</td>
					<td>${va.text}</td>
					<td>${va.orderNo}</td>
					<td>${va.typeCode}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>