<%
	// se não existir um login na sessao, 
	// vai enviar para a página de login novamente
	} else {
%>
    <jsp:forward page="index.jsp?erro=-2"></jsp:forward>
<%
}
%>