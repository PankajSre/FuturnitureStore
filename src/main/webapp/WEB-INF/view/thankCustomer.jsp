<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/view/header.jsp" %>

        <section>
            
                <div class="container">
                    <p style="font-size: 50px;">Thank you</p> <br>
                    <p style="color: blue;font-size: 50px;">${cart.username} </p><br>
                    <p style="font-size: 30px;">for your business!</p>

                    <p>Your order with order Id <span class="label label-success"> ${cart.orderId}</span> will be shipped in <span class="label label-warning"> Five </span>  business days!</p>
                </div>
            
        </section>

        <section class="container">
            <p><a href="<spring:url value="/" />" class="btn btn-success">OK</a></p>
        </section>
<%@ include file="/WEB-INF/view/footer.jsp" %>