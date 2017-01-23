<%@ include file="common/header.jspf"%>
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

<%@ include file="common/navigation.jspf" %>

<div class="row">
<div class="col-md-12">
<h2>Welcome ${name}</h2>
</div>
</div>

<div class="row">
<div class="col-md-12">
                    
 <table class="table table-striped table-inverse">
  <thead>
    <tr>
      <th>ID</th>
      <th>USER</th>
      <th>DESC</th>
      <th>TARGET DATE</th>
      <th>IS DONE</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${Todo}" var="todo">
    <tr>
      <th>${todo.id}</th>
      <td>${todo.user}</td>
      <td>${todo.desc}</td>
      <td><fmt:formatDate pattern="dd/MM/yyyy"
                                    value="${todo.targetDate}" />
      </td>
      <td>${todo.done}</td>
      <td>
         <a type="button" class="btn btn-danger" 
         href="delete-todo?id=${todo.id}">Delete</a>
      </td>
      <td>
      	 <a type="button" class="btn btn-success" 
         href="update-todo?id=${todo.id}">Update</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</div>
</div>
                    

<a href="add-todos"><button type="button" class="btn btn-primary">Add</button></a>


</div>
</body>
</html>