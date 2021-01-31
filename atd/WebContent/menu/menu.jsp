<%@page pageEncoding="UTF-8" %>

<a href ="../menu/index.jsp">ホーム</a>
<a href ="../attendance/attendance-in.jsp">勤怠登録</a>

<%if(session.getAttribute("customer") == null) {%>
	<a href="../login/login-in.jsp">ログイン</a>
<%}else{ %>
	<a href="../login/logout-in.jsp">ログアウト</a>
<%} %>

<hr>