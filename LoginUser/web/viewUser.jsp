<%@include file="navbar.jsp" %>
<%@page import="dao.Userdao" %>
<%@page import="model.User" %>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
    List<User> ulist=Userdao.getAllUser();
    request.setAttribute("ulist", ulist);
    int index=1;
    for(User u:ulist){
        u.setIndex(index++);
    }
%>

<div class="jumborton bg-success text-center my-2">
    <h1>All User Data</h1>
</div>
<div class="container my-3 py-2">
    

<table class="table table-striped table-hover">
    <thead>
        <tr>
        <th>Index</th>
        <th>Id</th>
        <th>Full Name</th>
        <th>User Name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ulist}" var="u">
            <tr>
                <td>${u.getIndex()}</td>
                <td>${u.getUid()}</td>
                <td>${u.getFullName()}</td>
                <td>${u.getUserName()}</td>
                <td>${u.getPassword()}</td>
                <td>${u.getEmail()}</td>
                <td>
                    <a href="editFrom.jsp?myid=${u.getUserName()}" class="btn btn-primary">Edit</a>
                    <a href="deleteUser.jsp" class="btn btn-warning">Delete</a>
                </td>
            </tr>   
        </c:forEach>
        
    </tbody>
</table>
</div>

