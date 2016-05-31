<%@ include file="header.jsp"%>
<section class="container" data-ng-app="cartApp" style="height: 430px;">

	<div class="row" data-ng-app="myApp" data-ng-controller="myCtrl">

		<div class="col-md-6">
			<form:form method="POST" action="editProducts/${product.productId}" commandName="products" class="form-horizontal">

				<table>
					<tr>
						<td>Product Id:</td>
						<td><form:input path="productId" value="${product.productId}"
							disabled="true" /></td>
					</tr>
					<tr>
						<td>Product Name:</td>
						<td><form:input path="name" value="${product.name}" /></td>
					</tr>
					<tr>
						<td>Product Group:</td>
						<td><form:input path="groupName" value="${product.groupName}"
						 /></td>
					</tr>
					<tr>
						<td>Product Quantity:</td>
						<td><form:input path="quantity" value="${product.quantity}" /></td>
					</tr>
					<tr>
						<td>Product Price:</td>
						<td><form:input path="price" value="${product.price}" /></td>
					</tr>
					<tr>
						<td>Product Description:</td>
						<td><form:input path="description" value="${product.description}"
							 /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Edit Product"
							class="btn btn-success" /></td>
					</tr>
				</table>

			</form:form>
		</div>
	</div>
</section>
<%@ include file="footer.jsp"%>