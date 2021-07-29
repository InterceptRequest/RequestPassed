<%@page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/static/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="/static/jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="/static/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function ($) {
			load()
			function load() {
				$.ajax({
					url:"/dept/getAll.json",
					success:function (data) {
						var arr = []
						$(data).each(function (index) {
							arr.push(`
								<tr class="`+(index%2==0?"active":"")+`">
									<td><input type="checkbox" name="id" value="`+this.id+`"/></td>
									<td>`+(this.no||"")+`</td>
									<td>`+(this.name||"")+`</td>
									<td>`+(this.manager||"")+`</td>
									<td>`+(this.phone||"")+`</td>
									<td>`+(this.description||"")+`</td>
								</tr>
							`)
						})
						$("#tbody").html(arr.join(""))
					}
				})
			}

			$("#delBtn").click(function () {

				var ids = $(":checkbox[name=id]:checked").map(function (value) {
					return this.value
				}).get().join(",")
				if(!ids){
					alert("请选择删除项！")
					return;
				}

				if(!confirm("确认删除？")) return
				$.ajax({
					url:"/dept/delete.do",
					data:{
						ids:ids
					},success(data){
						if(data.success){
							alert(data.msg)
							load()
							$("#allBtn").prop("checked",false)
						}
					}
				})
			})

			$("#allBtn").click(function () {
				$(":checkbox[name=id]").prop("checked",this.checked)
			})

			$("#tbody").on("click",":checkbox[name=id]",function () {
				$("#allBtn").prop("checked",$(":checkbox[name=id]:checked").size() == $(":checkbox[name=id]").size())
			})


			$("#bcBut").click(function () {
				if(!$("#create-no").val()) {
					alert("编号不能为空")
					return
				}
				if(!(/^\d{4}$/.test($("#create-no").val()))){
					alert("编号只能由四位数字组成")
					return;
				}
				$.ajax({
					url:"/dept/insert.do",
					data:{
						no:$("#create-no").val(),
						name:$("#createn-name").val(),
						manager:$("#createn-manager").val(),
						description:$("#createn-description").val(),
						phone:$("#createn-phone").val()
					},
					type:"post",
					success(data) {
						if(data.success){
							$("#createDeptModal").modal("hide").find(":input").val("")

							load()
						}else {
							alert(data.msg)
						}

					}
				})
			})

			$("#upBtn").click(function () {
				var id = $(":checkbox[name=id]:checked")
				if( id.size() == 0 ){
					alert("请选择编辑项！")
					return
				}
				if( id.size() != 1 ){
					alert("只能编辑一项，请重新选择！")
					return
				}
				$.ajax({
					url:"/dept/getId.json",
					data:{
						id:id.val()
					}, success (data) {
						$("#edit-id").val(data.id)
						$("#edit-no").val(data.no)
						$("#edit-name").val(data.name)
						$("#edit-manager").val(data.manager)
						$("#edit-description").val(data.description)
						$("#edit-phone").val(data.phone)
						$("#editDeptModal").modal("show")
					}
				})

			})

			$("#updateBtn").click(function () {
				$.ajax({
					url:"/dept/update.do",
					data:{
						id:$("#edit-id").val(),
						no:$("#edit-no").val(),
						name:$("#edit-name").val(),
						manager:$("#edit-manager").val(),
						description:$("#edit-description").val(),
						phone:$("#edit-phone").val()
					}, success(data){
						if(data.success){
							alert(data.msg)
							$("#editDeptModal").modal("hide")
							load()
						}
					}
				})
			})
		})
	</script>
</head>
<body>

	<!-- 我的资料 -->
	<div class="modal fade" id="myInformation" role="dialog">
		<div class="modal-dialog" role="document" style="width: 30%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">我的资料</h4>
				</div>
				<div class="modal-body">
					<div style="position: relative; left: 40px;">
						姓名：<b>张三</b><br><br>
						登录帐号：<b>zhangsan</b><br><br>
						组织机构：<b>1005，市场部，二级部门</b><br><br>
						邮箱：<b>zhangsan@bjpowernode.com</b><br><br>
						失效时间：<b>2017-02-14 10:10:10</b><br><br>
						允许访问IP：<b>127.0.0.1,192.168.100.2</b>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 修改密码的模态窗口 -->
	<div class="modal fade" id="editPwdModal" role="dialog">
		<div class="modal-dialog" role="document" style="width: 70%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">修改密码</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="oldPwd" class="col-sm-2 control-label">原密码</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="oldPwd" style="width: 200%;">
							</div>
						</div>
						
						<div class="form-group">
							<label for="newPwd" class="col-sm-2 control-label">新密码</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="newPwd" style="width: 200%;">
							</div>
						</div>
						
						<div class="form-group">
							<label for="confirmPwd" class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="confirmPwd" style="width: 200%;">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal"  onclick="window.location.href='../login.html';">更新</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 退出系统的模态窗口 -->
	<div class="modal fade" id="exitModal" role="dialog">
		<div class="modal-dialog" role="document" style="width: 30%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">离开</h4>
				</div>
				<div class="modal-body">
					<p>您确定要退出系统吗？</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="window.location.href='../../login.html';">确定</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 顶部 -->
	<div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
		<div style="position: absolute; top: 5px; left: 0px; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman'">CRM &nbsp;<span style="font-size: 12px;">&copy;2017&nbsp;动力节点</span></div>
		<div style="position: absolute; top: 15px; right: 15px;">
			<ul>
				<li class="dropdown user-dropdown">
					<a href="javascript:void(0)" style="text-decoration: none; color: white;" class="dropdown-toggle" data-toggle="dropdown">
						<span class="glyphicon glyphicon-user"></span> zhangsan <span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="../../workbench/index.html"><span class="glyphicon glyphicon-home"></span> 工作台</a></li>
						<li><a href="../index.html"><span class="glyphicon glyphicon-wrench"></span> 系统设置</a></li>
						<li><a href="javascript:void(0)" data-toggle="modal" data-target="#myInformation"><span class="glyphicon glyphicon-file"></span> 我的资料</a></li>
						<li><a href="javascript:void(0)" data-toggle="modal" data-target="#editPwdModal"><span class="glyphicon glyphicon-edit"></span> 修改密码</a></li>
						<li><a href="javascript:void(0);" data-toggle="modal" data-target="#exitModal"><span class="glyphicon glyphicon-off"></span> 退出</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	
	<!-- 创建部门的模态窗口 -->
	<div class="modal fade" id="createDeptModal" role="dialog">
		<div class="modal-dialog" role="document" style="width: 80%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-plus"></span> 新增部门</h4>
				</div>
				<div class="modal-body">
				
					<form class="form-horizontal" role="form">
					
						<div class="form-group">
							<label for="create-code" class="col-sm-2 control-label">编号<span style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-no" style="width: 200%;" placeholder="编号为四位数字，不能为空，具有唯一性">
							</div>
						</div>
						
						<div class="form-group">
							<label for="create-name" class="col-sm-2 control-label">名称</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="createn-name" style="width: 200%;">
							</div>
						</div>
						
						<div class="form-group">
							<label for="create-manager" class="col-sm-2 control-label">负责人</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="createn-manager" style="width: 200%;">
							</div>
						</div>
						
						<div class="form-group">
							<label for="create-phone" class="col-sm-2 control-label">电话</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="createn-phone" style="width: 200%;">
							</div>
						</div>
						
						<div class="form-group">
							<label for="create-describe" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10" style="width: 55%;">
								<textarea class="form-control" rows="3" id="createn-description"></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="bcBut"class="btn btn-primary" <%--data-dismiss="modal"--%>>保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 修改部门的模态窗口 -->
	<div class="modal fade" id="editDeptModal" role="dialog">
		<div class="modal-dialog" role="document" style="width: 80%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-edit"></span> 编辑部门</h4>
				</div>
				<div class="modal-body">
				
					<form class="form-horizontal" role="form">
						<input type="hidden"   id="edit-id">
						<div class="form-group">
							<label for="create-code" class="col-sm-2 control-label">编号<span style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" readonly class="form-control" id="edit-no" style="width: 200%;" placeholder="编号为四位数字，不能为空，具有唯一性" value="1110">
							</div>
						</div>
						
						<div class="form-group">
							<label for="create-name" class="col-sm-2 control-label">名称</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-name" style="width: 200%;" value="财务部">
							</div>
						</div>
						
						<div class="form-group">
							<label for="create-manager" class="col-sm-2 control-label">负责人</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-manager" style="width: 200%;" value="张飞">
							</div>
						</div>
						
						<div class="form-group">
							<label for="create-phone" class="col-sm-2 control-label">电话</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-phone" style="width: 200%;" value="010-84846004">
							</div>
						</div>
						
						<div class="form-group">
							<label for="create-describe" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10" style="width: 55%;">
								<textarea class="form-control" rows="3" id="edit-description">description info</textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="updateBtn" <%--data-dismiss="modal"--%>>更新</button>
				</div>
			</div>
		</div>
	</div>
	
	<div style="width: 95%">
		<div>
			<div style="position: relative; left: 30px; top: -10px;">
				<div class="page-header">
					<h3>部门列表</h3>
				</div>
			</div>
		</div>
		<div class="btn-toolbar" role="toolbar" style="background-color: #F7F7F7; height: 50px; position: relative;left: 30px; top:-30px;">
			<div class="btn-group" style="position: relative; top: 18%;">
			  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createDeptModal"><span class="glyphicon glyphicon-plus"></span> 创建</button>
			  <button type="button" class="btn btn-default" data-toggle="modal" <%--data-target="#editDeptModal"--%> id="upBtn"><span class="glyphicon glyphicon-edit"></span> 编辑</button>
			  <button type="button" id="delBtn"class="btn btn-danger"><span class="glyphicon glyphicon-minus"></span> 删除</button>
			</div>
		</div>
		<div style="position: relative; left: 30px; top: -10px;">
			<table class="table table-hover">
				<thead>
					<tr style="color: #B3B3B3;">
						<td><input type="checkbox" id="allBtn"/></td>
						<td>编号</td>
						<td>名称</td>
						<td>负责人</td>
						<td>电话</td>
						<td>描述</td>
					</tr>
				</thead>
				<tbody id="tbody">
					<%--<tr class="active">
						<td><input type="checkbox" /></td>
						<td>1110</td>
						<td>财务部</td>
						<td>张飞</td>
						<td>010-84846005</td>
						<td>description info</td>
					</tr>--%>
				</tbody>
			</table>
		</div>
		
		<%--<div style="height: 50px; position: relative;top: 0px; left:30px;">
			<div>
				<button type="button" class="btn btn-default" style="cursor: default;">共<b>50</b>条记录</button>
			</div>
			<div class="btn-group" style="position: relative;top: -34px; left: 110px;">
				<button type="button" class="btn btn-default" style="cursor: default;">显示</button>
				<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
						10
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">20</a></li>
						<li><a href="#">30</a></li>
					</ul>
				</div>
				<button type="button" class="btn btn-default" style="cursor: default;">条/页</button>
			</div>
			<div style="position: relative;top: -88px; left: 285px;">
				<nav>
					<ul class="pagination">
						<li class="disabled"><a href="#">首页</a></li>
						<li class="disabled"><a href="#">上一页</a></li>
						<li><a href="#">下一页</a></li>
						<li class="disabled"><a href="#">末页</a></li>
					</ul>
				</nav>
			</div>
		</div>--%>
			
	</div>
	
</body>
</html>