<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<link href="./assets/css/loginForm.css" rel="stylesheet">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<!------ Include the above in your HEAD tag ---------->
		<title>Pagina di Accesso</title>
	</head>
	<body>
		<div class="wrapper fadeInDown">
  			<div id="formContent">
    		<!-- Warning -->
    		<div class="alert alert-danger  ${messaggio==null?'d-none':''}" role="alert">
	  			${messaggio}
			</div>

    		<!-- Login Form -->
    		<form class="form-signin" action="ExecuteLoginServlet" method="post">
    			<h1 class="h3 mb-3 font-weight-normal">Accedi al Sistema</h1>
      			<input type="text" id="inputUsername" class="fadeIn second" name="inputUsername" placeholder="login">
      			<input type="password" id="Inputpassword" class="fadeIn third" name="inputPassword" placeholder="password">
      			<input type="submit" class="fadeIn fourth" value="Log In">
    		</form>

    		<!-- Remind Passowrd -->
    		<div id="formFooter">
      			<a class="underlineHover" href="#">Forgot Password?</a>
    		</div>

  			</div>
		</div>
	</body>
</html>