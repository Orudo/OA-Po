<%--
  Created by IntelliJ IDEA.
  User: martin
  Date: 5/11/17
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme--Login</title>

    <!-- Bootstrap Core CSS -->
    <link href="/startbootstrap-sb-admin-2-gh-pages/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/startbootstrap-sb-admin-2-gh-pages/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/startbootstrap-sb-admin-2-gh-pages/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/startbootstrap-sb-admin-2-gh-pages/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <form action="/servlet/loginprocess" method="get">
                        <fieldset>
                            <%if(request.getAttribute("username")!=null)
                            {%>
                                <div class="form-group has-error has-feedback">
                                    <input class="form-control" placeholder="Username" name="username" type="text" value=<%=request.getAttribute("username")%> autofocus>
                                    <span class="glyphicon glyphicon-remove form-control-feedback"></span>
                                </div>
                            <%}else{%>
                            <div class="form-group has-feedback">
                                <input class="form-control" placeholder="Username" name="username" type="text" autofocus>
                            </div><%}%>

                            <div class="form-group has-feedback">
                                <input class="form-control" placeholder="Password" name="password" type="password"                                >
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>

                            <c:if test="${MESSAGE=='incorrect_username_password'}">
                                Username or password is not correct
                            </c:if>
                            <%--<%=request.getAttribute("incorrect_username_password")%>--%>
                            <!-- Change this to a button or input when using this as a form -->
                            <!--<a href="/servlet/loginprocess" class="btn btn-lg btn-success btn-block">Login</a>-->
                            <input type="submit" class="btn btn-lg btn-success btn-block">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="/startbootstrap-sb-admin-2-gh-pages/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/startbootstrap-sb-admin-2-gh-pages/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/startbootstrap-sb-admin-2-gh-pages/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/startbootstrap-sb-admin-2-gh-pages/dist/js/sb-admin-2.js"></script>

</body>

</html>
