<%@page import="dao.Studentdao"%>
<jsp:useBean class="model.Student" id="s"/>
<jsp:setProperty name="s" property="*"/>
<%--* means all  --%>

<% 
    int result = Studentdao.saveStudent(s);
    if (result>0) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
    }
    System.out.println("result "+result);


%>
