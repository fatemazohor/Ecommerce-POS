<%@include file="navbar.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.Userdao" %>
<jsp:useBean class="model.User" id="u"></jsp:useBean>
<jsp:setProperty name="u" property="*"/>
<% 
    String id=request.getParameter("myid");
    u=Userdao.getUserById(id);
    
// getUserById()method set user class propertity. then jsp.setproperty will use this to setproperty agani.Then getMthod() use thie value to response the wev server request.
%>

<div class="jumborton bg-primary text-center my-2">
    <h1>Update User</h1>
</div>
<div class="container row-8 align-middle px-2 ">

    <form action="editUser.jsp" method="post">
        <div class="mb-3">
            <input type="hidden" class="form-control" id="uid" name="uid" value="<%=u.getUid()%>">
            <label for="fullName" class="form-label">Full Name</label>
            
            <input type="text" class="form-control" id="fullName" name="fullName" value="<%=u.getFullName()%>">
        </div>
        <div class="mb-3">
            <label for="userName" class="form-label">User Name</label>
            <input type="text" class="form-control" id="userName" name="userName" value="<%=u.getUserName()%>">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" name="password" value="<%=u.getPassword()%>">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" name="email" placeholder="example@ex.com" value="<%=u.getEmail()%>" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        
        <button type="submit" class="btn btn-primary">Update</button>
        <button type="reset" class="btn btn-danger">Reset</button>
    </form>
</div>
