<%-- 
    Document   : student
    Created on : 29 Oct 2023, 12:06:16
    Author     : user
--%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="jumborton bg-white text-center">
            <h1>ADD STUDENT</h1>

        </div>
        <div class="mx-4 mb-5">
            <form class="row g-3" action="StudentProcess.jsp" method="post">
                <div class="col-12">
                    <label for="sName" class="form-label" >First Name</label>
                    <input type="text" class="form-control" id="sName" name="sName">
                </div>
                <div class="col-md-6">
                    <label for="email" class="form-label" >Email</label>
                    <input type="email" class="form-control" id="email" name="email">
                </div>

                <div class="col-md-6">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <div class="col-md-6">
                    <label for="gender" class="form-label">Gender</label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" value="Male" name="gender" id="gender">
                        <label class="form-check-label" for="Male">
                            Male
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gender" value="Female" id="gender" >
                        <label class="form-check-label" for="Female">
                            Female
                        </label>
                    </div>
                </div>

                <div class="col-12">
                    <label for="address" class="form-label">Address</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="1234 Main St">
                </div>
                
                <div class="col-md-6">
                    <label for="city" class="form-label">City</label>
                    <input type="text" class="form-control" id="city" name="city">
                </div>
                <div class="col-md-4">
                    <label for="state" class="form-label">State</label>
                    <select id="state" class="form-select" name="state">
                        <option selected>Open this select menu</option>
                        <option value="Dhaka">Dhaka</option>
                        <option value="Rajshahi">Rajshahi</option>
                        <option value="Khulna">Khulna</option>
                    </select>
                </div>
                <div class="col-md-2">
                    <label for="inputZip" class="form-label">Zip</label>
                    <input type="text" class="form-control" id="inputZip" name="zip">
                </div>
                <div class="col-12">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="gridCheck">
                        <label class="form-check-label" for="gridCheck">
                            Check me out
                        </label>
                    </div>
                </div>

                <div class="col-md-6">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
                <div class="col-md-6">
                    <button type="reset" class="btn btn-danger">Reset</button>


                </div>
            </form>

        </div>
    </body>
</html>
<%@include file="footer.jsp" %>
