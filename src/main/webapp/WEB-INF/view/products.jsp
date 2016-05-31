<%@ include file="header.jsp"%>
<a href='<c:url value="/cart" />' class="btn btn-default pull-right">
	<span class="glyphicon-shopping-cart glyphicon"></span> view cart
</a>
<style>
h1 {
	border-bottom: 3px solid #cc9900;
	color: #996600;
	font-size: 30px;
}

table, th, td {
	border: 1px solid grey;
	border-collapse: collapse;
	padding: 5px;
}

table tr:nth-child(odd) {
	background-color: #f1f1f1;
}

table tr:nth-child(even) {
	background-color: #ffffff;
}
</style>

<section data-ng-app="">
	<div class="table responsive">
		<div class="table">
			<div style="height: 50px; padding-left: 200px; width: 500px;">
				<label>Search Element <input type="text" id="search"
					data-ng-model="search" value="${param.item}"
					data-ng-init="search='${param.item}'"></label>
			</div>
			<br>

			<script>
				$(window).load(function() {
					searchTable($('#search').val());
				});

				$(document).ready(function() {
					$('#search').keyup(function() {
						searchTable($(this).val());
					});
				});

				function searchTable(inputVal) {
					var table = $('#myTable');
					table.find('tr').each(function(index, row) {
						var allCells = $(row).find('td');
						if (allCells.length > 0) {
							var found = false;
							allCells.each(function(index, td) {
								var regExp = new RegExp(inputVal, 'i');
								if (regExp.test($(td).text())) {
									found = true;
									return false;
								}
							});
							if (found == true)
								$(row).show();
							else
								$(row).hide();
						}
					});
				}
			</script>
			<center>
				<table id="myTable">
					<tr>
						<th>Product ID</th>
						<th>Group Name</th>
						<th>Product Name</th>
						<th>Product Price</th>
						<th>Quantity</th>
						<th>Description</th>
						<th>Image</th>
						<th>Operations</th>

					</tr>
					<c:if test="${not empty products}">

						<c:forEach var="my" items="${products}">
							<tr>
								<td><c:out value="${my.productId}"></c:out></td>
								<td><c:out value=" ${my.groupName}"></c:out></td>
								<td><c:out value=" ${my.name}"></c:out></td>
								<td><c:out value=" ${my.price}"></c:out></td>
								<td><c:out value=" ${my.quantity}"></c:out></td>
								<td><c:out value=" ${my.description}"></c:out></td>
								<td><img src="<c:url value='/resources/${product.productId }.jpg' />" height="50" width="50" /></td>
								<td><a
									href="<spring:url value="/viewProduct?productId=${my.productId }" />"
									class="btn btn-info"> <span
										class="glyphicon-info-sign glyphicon"> </span> Details
								</a> <c:if
										test="${pageContext.request.userPrincipal.name == 'Krishna'}">
										<a
											href="<spring:url value="/editProduct?productId=${my.productId }" />"
											class="btn btn-danger"> <span
											class="glyphicon-info-sign glyphicon"> </span> Edit
										</a>
										<a
											href="<spring:url value="/delete?productId=${my.productId }" />"
											class="btn btn-warning"> <span
											class="glyphicon-info-sign glyphicon"> </span> Delete
										</a>
									</c:if> <a href="#" class="btn btn-success"
									data-ng-click="addToCart('${product.productId}')"> <span
										class="glyphicon-shopping-cart glyphicon"> </span> Add
								</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
                 <c:if test="${pageContext.request.userPrincipal.name == 'Krishna'}">
				<a href="<spring:url value="/prodRegistration" />"
					class="btn btn-success"> <span
					class="glyphicon-info-sign glyphicon"> </span> Add New Product
				</a>
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name != 'Krishna'}">
				<a href="<spring:url value="products"  />" onclick="alert('You are not allowed to Enter a product')"
					class="btn btn-success"> <span 	class="glyphicon-info-sign glyphicon"> </span> Add New Product
				</a>
				</c:if>
			</center>
		</div>
	</div>

</section>

<%@ include file="footer.jsp"%>