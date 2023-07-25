<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        </body>
        </html>