<%@page import="com.saini.service.ProductsService"%>
<%@page import="com.saini.model.Products"%>
<%@ include file="header.jsp"%>

<section class="container" data-ng-app="cartApp" style="height: 470px;">
	<div data-ng-controller="cartController"
		data-ng-init="initCartId('${cart.cartId}')">
		<div>
			<a class="btn btn-danger pull-left" data-ng-click="clearCart()">
				<span class="glyphicon glyphicon-remove-sign"></span> Clear Cart
			</a>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<a href="orderConfirmation?productId=${product.productId}"
					class="btn btn-success pull-right"> Check out </a>
			</c:if>
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<a href="login" class="btn btn-success pull-right"> Check out </a>
			</c:if>

		</div>

		<table class="table table-hover">
			<tr>
				<th>Product</th>
				<th>Quantity</th>
				<th>Unit Price</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
			<tr data-ng-repeat="item in product">
				<td>${product.productId}---${product.name}</td>
				<td>${1}</td>
				<td>${product.price}</td>
				<td>${product.price}</td>
				<td>
				<a href="<spring:url value="/deleteCart?productId=${product.productId }" />"
					class="btn btn-warning"> <span	class="glyphicon-info-sign glyphicon"> </span> Remove
				</a></td>
			</tr>
			<tr>
				<th></th>
				<th></th>
				<th>Grand Total</th>
				<th>${product.price}</th>
				<th></th>
			</tr>

		</table>
		<a href="<spring:url value="/products" />" class="btn btn-success">
			<span class="glyphicon-circle-arrow-left glyphicon"></span> continue
			shopping
		</a>
	</div>
</section>
<%@ include file="footer.jsp"%>