<%@include file="navbar.jsp" %>
<div class="text-center row-8 py-4 text-lg fs-1 fw-bold">Sign In</div>
<div class="container col-6 align-middle px-3 py-4 text-dark bg-light bg-gradient shadow p-3 mb-5  rounded">
    <form action="loginAction.jsp" method="post">
        <div class="mb-3">
            <label for="userName" class="form-label">User Name</label>
            <input type="text" class="form-control" id="userName" name="userName" placeholder="User Name" aria-describedby="emailHelp">
            
        </div> 
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-danger">Reset</button>
    </form>
    <div id="emailHelp" class="form-text ">New User? Sign up <a href="addNew.jsp">here</a></div>
</div>
