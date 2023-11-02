<%@include file="header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page  import="model.Student" %>
<%@page  import="dao.Studentdao" %>
<%@page  import="java.util.*" %>


<%
    List<Student> list = Studentdao.getAllRecords();
    request.setAttribute("list", list);
%>



<div class="container my-3 py-2">
    <div class="jumborton text-light bg-dark text-center my-2">
        <h1>Student Database</h1>
    </div>
    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Password</th>
                <th scope="col">Gender</th>
                <th scope="col">Address</th>
                <th scope="col">City</th>
                <th scope="col">State</th>
                <th scope="col">Zip</th>
                <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="s" >
                <tr>
                    <th>${s.getIdstudent()}</th>
                    <td>${s.getsName()}</td>
                    <td>${s.getEmail()}</td>
                    <td>${s.getPassword()}</td>
                    <td>${s.getGender()}</td>
                    <td>${s.getAddress()}</td>
                    <td>${s.getCity()}</td>
                    <td>${s.getState()}</td>
                    <td>${s.getZip()}</td>
                    <td>
                        <a href="editFrom.jsp?student=${s.getIdstudent()}" class="btn btn-primary">Edit</a>
                        <a href="delete.jsp?idstudent=${s.getIdstudent()}" class="btn btn-warning">Delete</a>
                        
                        <!-- for edit: student is any variable which has to be same
                           as editFrom.jsp getParameter('student'). -->
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</table>
</div>

<%@include file="footer.jsp" %>
