<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
        <html>

        <head>
            <title>Inventory Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
        </head>

        <body>
         

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Inventory Management Application </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/ShowListServlet" class="nav-link">USER</a></li>
                        <li><a href="<%=request.getContextPath()%>/ShowListItemServlet" class="nav-link">ITEMS</a></li>
                        <li><a href="<%=request.getContextPath()%>/ShowTransactionFromServlet" class="nav-link">ADD STOCKS</a></li>
                        <li><a href="<%=request.getContextPath()%>/ShowGetFromStockForm" class="nav-link">GET FROM STOCK</a></li>
                        
                        <li><a href="<%=request.getContextPath()%>/InventryReportListServlet" class="nav-link">INVENTORY REPORT</a></li>
                        <li><a href="<%=request.getContextPath()%>/FinancialReportServlet" class="nav-link">FINANCIAL REPORT</a></li>
                        <li><a href="<%=request.getContextPath()%>/ShowPersonalUsageReportFormServelet" class="nav-link">PERSONAL USAGE REPORT</a></li>
                        
                        <li><a href="<%=request.getContextPath()%>/ShowTarnsactionListServelet" class="nav-link">TRANSACTION LOG</a></li>
                        
                        <li><a href="<%=request.getContextPath()%>/LogoutServlet" class="nav-link">Log Out</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${Item != null}">
                            <form action="UpdateItemServlet" method="post">
                        </c:if>
                        <c:if test="${Item == null}">
                            <form action="InsertItemServlet" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${Item != null}">
                                    Edit Item
                                </c:if>
                                <c:if test="${Item == null}">
                                    Add New Item
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${Item != null}">
                            <input type="hidden" name="id" value="<c:out value='${Item.id}' />" />
                        </c:if>
                        
                        <fieldset class="form-group">
                            <label>Item ID</label> <input type="text" value="<c:out value='${Item.item_id}' />" class="form-control" name="Item_id" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Item Name</label> <input type="text" value="<c:out value='${Item.name}' />" class="form-control" name="name" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Quantity</label> <input type="text" pattern="[1-9][0-9]*" title="Please enter a number greater than zero" value="<c:out value='${Item.quantity}' />" class="form-control" name="quantity">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Price</label> <input type="text" pattern="[1-9][0-9]*" title="Please enter a number greater than zero" value="<c:out value='${Item.price}' />" class="form-control" name="price">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Employee Name</label> <input type="text" value="<c:out value='${Item.employee}' />" class="form-control" name="employee">
                        </fieldset>
                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
        </html>