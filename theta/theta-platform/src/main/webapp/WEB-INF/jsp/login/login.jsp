<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%-- <c:set var="ctx" value="${pageContext.request.contextPath}"/> --%>
<!DOCTYPE html>
<html>
<head>
<!-- refer css files-->
<link rel="stylesheet" type="text/css" href="plugins/bootstrap-3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="plugins/bootstrap-3.3.7/css/bootstrap-theme.min.css"/>
<link rel="stylesheet" type="text/css" href="css/login/login.css"/>

<!-- refer js files-->
<script type="text/javascript" src="plugins/jquery1.11/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/common/utils.js"></script>
<script type="text/javascript" src="js/login/login.js"></script>

<title>user login</title>
</head>
<body class="content-center">
<div class="navbar-fixed-top"><!-- navbar navbar-inverse -->
</div>
<div class="masthead">
    <div class="container mid-content">
    	<div class="content-center">
    		<img style="width:50px;height:50px;" src="images/logotypes/loginLogo.png" alt=""/>
    	</div>
        <div class="auth-form-body mt-3">
        	<div class="content-left">
            	<label for="">Sign in to Theta</label>
        	</div>
            <input class="form-control input-block" id="login_field_account" name="login" tabindex="1" type="text" placeholder="input your account here..."/>
            <input id="ctx" name="login" tabindex="1" type="hidden" value="${pageContext.request.contextPath}"/>
            <div class="content-left">
            	<label for="password">Password</label>
            	<a href="" class="label-link">Forgot password?</a>
            </div>
            <input id="ctx" type="hidden" value="${pageContext.request.contextPath}">
            <input class="form-control input-block" id="login_field_passwd" name="login" tabindex="1" type="text" placeholder="input your password here..."/>
           
            <input class="btn btn-primary btn-block" name="commit" tabindex="3" value="Sign in" type="submit" onclick="login.signIn()">
        </div>
        <p class="create-account-callout mt-3 mid-font-family">
            New to Theta?
            <a href="" >Create an account</a>.
        </p>
    </div>
</div>
</body>
</html>