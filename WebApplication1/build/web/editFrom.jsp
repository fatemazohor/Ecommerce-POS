<%-- 
    Document   : student
    Created on : 29 Oct 2023, 12:06:16
    Author     : user
--%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.Studentdao"%>
<jsp:useBean class="model.Student" id="s"/>
<jsp:setProperty name="s" property="*"/>
<% 
    String id = request.getParameter("student");
    s=Studentdao.getStudentById(Integer.parseInt(id));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="jumborton bg-white text-center">
            <h1>Edit STUDENT</h1>

        </div>
        <div class="mx-4 mb-5">
            <form class="row g-3" action="edit.jsp" method="post">
                <input type="hidden" class="form-control" id="idstudent" name="idstudent" value="<%=s.getIdstudent()%>">
                
                <div class="col-12">
                    <label for="sName" class="form-label" >First Name</label>
                    <input type="text" class="form-control" id="sName" name="sName" value="<%=s.getsName()%>" >
                </div>
                <div class="col-md-6">
                    <label for="email" class="form-label" >Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%=s.getEmail()%>" >
                </div>

                <div class="col-md-6">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" value="<%=s.getPassword()%>">
                </div>
                
                <div class="col-md-6">
                    <label for="gender" class="form-label">Gender</label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" value="Male" name="gender" id="gender" <%= s.getGender().equals("Male") ? "checked" : "" %>>
                        <label class="form-check-label" for="Male">
                            Male
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gender" value="Female" id="gender" <%=s.getGender().equals("Female") ? "checked" : "" %>>
                        <label class="form-check-label" for="Female">
                            Female
                        </label>
                    </div>
                </div>

                <div class="col-12">
                    <label for="address" class="form-label">Address</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="1234 Main St" value="<%=s.getAddress()%>">
                </div>
                
                <div class="col-md-6">
                    <label for="city" class="form-label">City</label>
                    <input type="text" class="form-control" id="city" name="city" value="<%=s.getCity()%>">
                </div>
                <div class="col-md-4">
                    <label for="state" class="form-label">State</label>
                    <select id="state" class="form-select" name="state" value="<%=s.getState()%>">
                        <option selected> Select Anyone </option>
                        <option value="Dhaka" <%=s.getState().equals("Dhaka") ? "selected" : "" %>>Dhaka</option>
                        <option value="Rajshahi" <%=s.getState().equals("Rajshahi") ? "selected" : "" %>>Rajshahi</option>
                        <option value="Khulna" <%=s.getState().equals("Khulna") ? "selected": "" %>>Khulna</option>
                    </select>
                </div>
                <div class="col-md-2">
                    <label for="inputZip" class="form-label">Zip</label>
                    <input type="text" class="form-control" id="inputZip" name="zip" value="<%=s.getZip()%>">
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
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
                <div class="col-md-6">
                    <button type="reset" class="btn btn-danger">Reset</button>


                </div>
            </form>

        </div>
    </body>
</html>
<%@include file="footer.jsp" %>