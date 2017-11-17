<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="mensagens" required="true" rtexprvalue="true"
	type="java.util.List"%>
<c:forEach var="msg" items="${mensagens}">
	 ${msg} <br>
</c:forEach>