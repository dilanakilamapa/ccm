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

            <div class="row">
                <div class="container">
                    <h3 class="text-center">List of Transaction</h3>
                    <hr>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Type</th>
                                <th>Item Id</th>
                                <th>Item Name</th>
                                <th>Employee Name</th>
                                <th>Date</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<!--   for (Todo todo: todos) {  -->
                            <c:forEach var="item" items="${listItem}">
                                <tr>
                                    <td>
                                        <c:out value="${item.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${item.type}" />
                                    </td>
                                    <td>
                                        <c:out value="${item.item_id}" />
                                    </td>
                                    <td>
                                        <c:out value="${item.item_name}" />
                                    </td>
                                    <td>
                                        <c:out value="${item.employee_name}" />
                                    </td>
                                    <td>
                                        <c:out value="${item.date}" />
                                    </td>
                                    <td>
                                        <c:out value="${item.price}" />
                                    </td>
                                    
                                  </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>