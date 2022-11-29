<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
	<title>尚硅谷会员注册页面</title>
<!--使用静态包含引入css样式jQuery和base标签-->
	<%@ include file="/pages/common/head.jsp"%>
	<script>
	$(function(){

		//给用户名绑定失去焦点事件
		$("#username").blur(function(){
			//1.获取用户名
			var username=this.value;
			//获得JSON，并得到json对象
			$.getJSON("http://localhost:8087/book2/UserServlet","action=ajaxExistUsername&username="+username,function(data){
				if(data.existsUsername){
             $("span.errorMsg").text("用户名已存在");
				}
				else
				{
					$("span.errorMsg").text("用户名可用");
				}
			});

		});



		/*
		给验证码的图片绑定单击事件
		 */
		$("#codeimg").click(function(){
			//在事件响应的function函数中有一个this对象，是当前正在响应事件的dom对象
			//src属性表示验证码img标签的  图片路径，它可读，它可写
			//下面给它赋值之后，就会自动再生成一个图片
			this.src="${basePath}kaptcha.jpg?d="+new Date();

		});








	//1.验证用户名，必须由数字字母下划线组成，并且长度为5到12位
		$("#sub_btn").click(function(){
		//1.获取用户名输入框中的内容
		var username=$("#username").val();
		//2.创建正则表达式对象
		var pattern=/^\w{5,12}$/;
		//3.使用test方法进行验证
		if(!pattern.test(username)){
		$("span.errorMsg").text("用户名不合法");
		//有了return false不会跳转
				return false;
		}
//2.验证密码
		//1.获取用户名输入框中的内容
		var password=$("#password").val();
		//2.创建正则表达式对象
		var pspattern=/^\w{5,12}$/;
		//3.使用test方法进行验证
		if(!pspattern.test(password)){
		$("span.errorMsg").text("密码不合法");
		//有了return false不会跳转
				return false;
		}


//3.确认密码
        //1.获取确认密码内容
        var repassword =$("#repwd").val();
        if(repassword!=password){
        $("span.errorMsg").text("确认密码与密码不一致");
        return false;
        }

//4.验证邮箱
        //1.获取邮箱当中的内容
        var emailText=$("#email").val();
        var emailpt=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if(!emailpt.test(emailText)){
        $("span.errorMsg").text("邮箱格式不合法");
        return false;
        }


//5.验证码，验证由输入内容即可
        var codeText=$("#code").val();
        //去掉验证码前后空格
        codeText=$.trim(codeText);
        if(codeText==null||codeText==""){
        $("span.errorMsg").text("无验证码");
        return false;
        }

        		$("span.errorMsg").text("");//如果用户名密码邮箱又合法了再给他改过来
});
		});

	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									<%--<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
									 ${empty requestScope.msg?"请输入用户密码和用户名":requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"
									<%--value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"--%>
										   value="${requestScope.username}"
									/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email"
										   <%--value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"--%>
										   value="${requestScope.email}"
									/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 100px;" id="code"/>
									<img id="codeimg" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px;width:100px;height:28px ">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<!--静态包含页脚的代码-->
		<%@include file="/pages/common/footer.jsp" %>
</body>
</html>