<%@include file="common/header.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="jumbotron">
<div class="container">
<%@include file="common/navigation.jspf"%>
<h2>Add your To-Dos</h2>

<form:form class="form-inline" method="post"  commandName="todo">
	<form:hidden path="id"/>
<%-- 	<form:hidden path="user"/> --%>
	<fieldset>
    <form:input type="text" path="desc" class="form-control" placeholder="Description" required="true"></form:input>
    </fieldset><hr>
    <fieldset>
    <form:input type="text" path="targetDate" class="form-control" placeholder="Target Date" required="true"></form:input>
    </fieldset>
    <hr>
    <form:button type="submit" class="btn btn-primary">Submit</form:button>
</form:form>

</div>

</body>
</html>