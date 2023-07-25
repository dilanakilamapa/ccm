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
                        <a href="https://www.javaguides.net" class="navbar-brand"> User Authentication </a>
                    </div>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                    	<form action="CheckLoginServlet" method="post">
                        <caption>
                            <h2> User Login</h2>
                        </caption>
                        
                        <fieldset class="form-group">
                            <label>User Name</label> <input type="text" value=""  class="form-control" name="name" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Password</label> <input type="password" value="" class="form-control" name="password">
                        </fieldset>
                        <button type="submit" class="btn btn-success">Login</button>
                        </form>
                        <c:if test="${not empty error}">
  							<p class="error">${error}</p>
						</c:if>
                    </div>
                </div>
            </div>
        </body>
        </html>