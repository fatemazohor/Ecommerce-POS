<%@page import="dao.Studentdao"%>
<jsp:useBean class="model.Student" id="s"/>
<jsp:setProperty name="s" property="*"/>
<%--* means all  --%>

<% 
    int result = Studentdao.deleteRecordsById(s);
    if (result>0) {
            response.sendRedirect("view.jsp");
        } else {
            response.sendRedirect("error.jsp");
    }
    System.out.println("result "+result);


%>