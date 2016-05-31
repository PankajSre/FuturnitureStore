<%@ include file="header.jsp" %>
	<section class="container" data-ng-app="cartApp" style="height: 430px;">

		<div class="row"  data-ng-app="myApp" data-ng-controller="myCtrl">
			<div class="col-md-6">
		<img src="<c:url value='/resources/${product.productId }.jpg' />" height="200" width="200" />

			</div>
			<div class="col-md-6">
                <h2 style="color: blue;">Product Information</h2>
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>Item Code : </strong><span class="label label-warning">${product.productId}</span>
				</p>
				<p>
					<strong>Product Group :</strong> : ${product.groupName}
				</p>
				<p>
					<strong>Quantity</strong> : ${product.quantity}
				</p>
				
				<h4>Rs &nbsp;${product.price}  &nbsp;INR</h4>
			
				<p data-ng-controller="cartController">
					<a href="<spring:url value="/products" />" class="btn btn-success">Back
						
					</a> 
					<a href="<spring:url value="/cart?productId=${product.productId }"/>" class="btn btn-warning btn-large" data-ng-click="addToCart('${product.productId}')">
					<span class="glyphicon glyphicon-shopping-cart"></span> Order Now</a>
				</p>
			
			</div>
		</div>
	</section>
	
	<%@ include file="footer.jsp" %>