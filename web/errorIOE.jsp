<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erro - HomeBanking</title>
</head>
   <body><div align="center">
           <jsp:include page="/publico/cab.xhtml">
                <jsp:param value="Sistema Biblioteca" name="cabecalho" />
            </jsp:include>
        </div><div class="corpo" style="background: #E7EBF2">
	<h3>Exceção Java: java.io.IOException</h3>
	<p>Ooops! Ao tentar gravar a tarefa, foi lanÃ§ada a seguinte exceção
            Java:</p></div>
	<p><%=exception.getMessage()%></p>
	 <jsp:include page="/publico/footer.xhtml" />
</body>
</html>