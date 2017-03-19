<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
   <title>Login</title>
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <link href="../../../assets/plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
   <link href="../../../assets/plugin/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
   <link href="../../../assets/plugin/font-awesome/css/font-awesome.css" rel="stylesheet" />
   <link href="../../../assets/css/style.css" rel="stylesheet" />
   <link href="../../../assets/css/style-responsive.css" rel="stylesheet" />
   <link href="../../../assets/css/style-default.css" rel="stylesheet" id="style_color" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="lock">
    
    <div class="login-wrap" style="position: fixed;top: 50%;left: 51%;transform: translate(-50%,-50%)">
    <form:form method="POST" action = "/login.html" modelAttribute="login">
    	
    	
    	<div class="metro single-size red">
            <div class="locked">
                <i class="icon-lock"></i>
                <span>Login</span>
            </div>
        </div>
        <div class="metro double-size green">
  
			<div class="input-append lock-input">
				<form:input path="username"/>
			</div>
          
        </div>
        <div class="metro double-size yellow">
          
			<div class="input-append lock-input">
				<form:password path="password"/>
			</div>
            
        </div>
        <div class="metro single-size terques login">
            
			<button type="submit" class="btn login-btn">
				Login
				<i class=" icon-long-arrow-right"></i>
			</button>
        
        </div>

        <div class="login-footer">
            <div class="remember-hint pull-left">
                <input type="checkbox" id=""> Remember Me
            </div>
            <div class="forgot-hint pull-right">
                <a id="forget-password" class="" href="javascript:;">Forgot Password?</a>
            </div>
        </div>
    	
    </form:form>
    
    </div>
</body>
<!-- END BODY -->
</html>