<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<!--使用静态包含引入css样式jQuery和base标签-->
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function(){
			//给删除绑定一个单击事件
			$("a.deleteItem").click(function(){

				//返回true是单击事件发生，返回false是单击事件不发生
				return confirm("你确定要删除"+$(this).parent().parent().find("td:first").text()+"】吗");
			});

               //给清空购物车邦单击事件
			$("a.deleteAll").click(function(){
				return confirm("你确定要删除全部的图书么");
			});
			//给数量输入框加入改变事件，就是内容改变就触发该事件
			$(".updateCount").change(function(){
				var num=$(this).parent().parent().find("td:first").text();
				var count=this.value;
				var id=$(this).attr('bookId');
				if( confirm("你确定要将这本【"+num+"】的数量改编为【"+count+"】")){
					//发起请求给服务器保存修改
					location.href="http://localhost:8087/book2/CartServlet?action=updateCount&count="+count+"&id="+id;
				}
				else
				{
					//this.defaultValue它是表单项dom对象的属性，它表示默认的value属性值
					this.value=this.defaultValue;
				}
			});
		});


	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<!--静态包含jsp文件-->
		<%@ include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<%--空的时候输出--%>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">亲，当前购物车为空快去浏览商品吧</a></td>

				</tr>
			</c:if>


			<%--非空的时候输出--%>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input class="updateCount" style="width: 80px;"
								   bookId="${entry.value.id}"
								   type="text" value="${entry.value.count}">
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteItem" href="CartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>

		</table>

		<%--如果购物车是非空才输出下面的内容--%>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a class="deleteAll" href="CartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="OrderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>

	
	</div>

	<!--静态包含页脚的代码-->
	<%@include file="/pages/common/footer.jsp" %>
</body>
</html>