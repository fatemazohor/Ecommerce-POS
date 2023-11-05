<%@page import="dao.Userdao" %>
<jsp:useBean class="model.User" id="u"/>
<jsp:setProperty name="u" property="*"/>

<% 
    int result= Userdao.saveUser(u);
   if (result>0) {
            response.sendRedirect("sucessUser.jsp");
        } else {
            response.sendRedirect("errorUser.jsp");
    }
    System.out.println("result "+result);

%>