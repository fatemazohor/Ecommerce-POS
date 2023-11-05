<%@page import="dao.Userdao" %>
<jsp:useBean class="model.User" id="u"/>
<jsp:setProperty name="u" property="*"/>

<% 
    int result=Userdao.userLogin(u);
    if (result > 0) {
            response.sendRedirect("viewUser.jsp");
        } else {
            response.sendRedirect("errorUser.jsp");
    }
    System.out.println("result "+result);

%>