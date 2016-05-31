<%@ include file="header.jsp" %>
	<section>
	 <div align="center">
        <form:form action="${pageContext.request.contextPath}/admin/prodRegistration" method="POST"  commandName="products" enctype="multipart/form-data">
           
           <div class="table-responsive">
            <table>
                <tr>
                    <td colspan="2" align="center"><h2>Product Registration</h2></td>
                </tr>
               
                <tr>
                    <td>Group Name:</td>
                    <td><form:input path="groupName" /></td>
                </tr>
                <tr>
                    <td>Product Name:</td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><form:input path="description" /></td>
                </tr>
                <tr>
                    <td>Product Quantity:</td>
                    <td><form:input path="quantity" /></td>
                </tr>
                <tr>
                    <td>Product Price:</td>
                    <td><form:input path="price" /></td>
                </tr>
                <tr>
                    <td>Product Image:</td>
                   <td><form:input type="file" path="imagePath" class="btn btn-warning" /></td>


                </tr>
                
                
            </table>
            
            <br>
            <div style="display: table-footer-group;">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit"  value="Add Product" class="btn btn-info">
                     
            </div>
            </div>
        </form:form>
        
    </div>
	</section>
	<%@ include file="footer.jsp" %>