<%@page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="/static/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="/static/jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="/static/jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="/static/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function ($) {
			$("#saveBtn").click(function () {
				var code = $("#code").val();
				if(!code) {
					alert("编号不能为空！")
					return
				}
				if((/[\u4E00-\u9FA5]/).test(code)){
					alert("编号不能包含中文！")
					return
				}

				$.ajax({
					url:"/type/codeVerification.json",
					data:{code:code},
					success:function (data) {
						if(data){
							alert("编号重复！")
							return
						}
						$("form").submit()
					}
				})


			})
		})
	</script>
</head>
<body>

	<div style="position:  relative; left: 30px;">
		<h3>新增字典类型</h3>
	  	<div style="position: relative; top: -40px; left: 70%;">
			<button type="button" id="saveBtn" class="btn btn-primary">保存</button>
			<button type="button" class="btn btn-default" onclick="window.history.back();">取消</button>
		</div>
		<hr style="position: relative; top: -40px;">
	</div>
	<form class="form-horizontal" role="form" action="/type/save.do" method="post">
					
		<div class="form-group">
			<label for="code" class="col-sm-2 control-label">编码<span style="font-size: 15px; color: red;">*</span></label>
			<div class="col-sm-10" style="width: 300px;">
				<input type="text" class="form-control" id="code" name="code" style="width: 200%;" placeholder="编码作为主键，不能是中文">
			</div>
		</div>


		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">名称</label>
			<div class="col-sm-10" style="width: 300px;">
				<input type="text" name="name" class="form-control" id="name" style="width: 200%;">
			</div>
		</div>
		
		<div class="form-group">
			<label for="describe" class="col-sm-2 control-label">描述</label>
			<div class="col-sm-10" style="width: 300px;">
				<textarea class="form-control" name="description" rows="3" id="describe" style="width: 200%;"></textarea>
			</div>
		</div>
	</form>
	
	<div style="height: 200px;"></div>
</body>
</html>