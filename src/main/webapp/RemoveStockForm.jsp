<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
        <html>

        <head>
            <title>Inventory Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
                        <form action="GetStockServlet" method="post">
                        <caption>
                            <h2>  Add Stock </h2>
                        </caption>
                        
                        <fieldset class="form-group">
                            <label>Item ID</label> <input type="text" value="" class="form-control" name="item_id" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Employee Name</label> <input type="text" value="" class="form-control" name="employee_name" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Quantity</label> <input type="text" value="" pattern="[1-9][0-9]*" title="Please enter a number greater than zero" class="form-control" name="quantity" required="required">
                        </fieldset>
                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
        </html>