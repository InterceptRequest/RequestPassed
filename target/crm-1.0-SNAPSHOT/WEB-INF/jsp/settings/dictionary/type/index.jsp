<%@page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/static/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="/static/jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="/static/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
				jQuery(function ($) {
					$("#allChe").click(function(){
						$(":checkbox[name=checkbox]").prop("checked",this.checked);
					})
					$(":checkbox[name=checkbox]").click(function () {
						$("#allChe").prop("checked",$(":checkbox[name=checkbox]:checked").size() == $(":checkbox[name=checkbox]").size())

					})

					$("#delBtn").click(function () {
						var $codes = $(":checkbox[name=checkbox]:checked")
						if($codes.size()==0){
							alert("请选择删除项!")
							return;
						}

						if(!confirm("是否删除？")) return;


						var codes = [];
						$codes.each(function () {
							codes.push(this.value);
						})
						codes=codes.join(",")

						$.ajax({
							url:"/type/delete.json",
							data:{
								ids:codes
							}, success:function (data) {
								if(data.length>0){
									data = data.join(" , ")
									alert("编码被引用:"+data)
									return
								}
								location = "/type/delete.do?ids="+codes
							}
						})


					})
                    $("#insBtn").click(function () {

                    })
                    $("#updateBtn").click(function () {
						var code = $(":checkbox[name=checkbox]:checked")
						if(code.size() != 1){
							alert("请选择仅一项！")
							return
						}
						location = "/type/update.html?code="+code.val()
					})
				})
	</script>
</head>

<body>

	<div>
		<div style="position: relative; left: 30px; top: -10px;">
			<div class="page-header">
				<h3>字典类型列表</h3>
			</div>
		</div>
	</div>
	<div class="btn-toolbar" role="toolbar" style="background-color: #F7F7F7; height: 50px; position: relative;left: 30px;">
		<div class="btn-group" style="position: relative; top: 18%;">
		  <button type="button" class="btn btn-primary" id="insBtn"onclick="window.location.href='/settings/dictionary/type/save.html'"><span class="glyphicon glyphicon-plus"></span> 创建</button>
		  <button type="button" class="btn btn-default" id="updateBtn"<%--onclick="window.location.href='/type/edit.do'"--%>><span class="glyphicon glyphicon-edit"></span> 编辑</button>
		  <button type="button" class="btn btn-danger" id="delBtn"><span class="glyphicon glyphicon-minus"></span> 删除</button>
		</div>
	</div>
	<div style="position: relative; left: 30px; top: 20px;">
		<table class="table table-hover">
			<thead>
				<tr style="color: #B3B3B3;">
					<td><input type="checkbox" id="allChe"/></td>
					<td>序号</td>
					<td>编码</td>
					<td>名称</td>
					<td>描述</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${typeALl}" var = "t" varStatus="sta">
				<tr class="${sta.index%2==0?"active":""}">
					<td><input type="checkbox" value="${t.code}" name = "checkbox"/></td>
					<td>${sta.count}</td>
					<td>${t.code}</td>
					<td>${t.name}</td>
					<td>${t.description}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>