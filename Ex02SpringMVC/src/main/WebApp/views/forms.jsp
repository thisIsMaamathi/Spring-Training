<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/hello/form" method="POST" modelAttribute="forms">
	StudentID:<form:input path="studentId"/><br>
	StudentName:<form:input path="studentName"/><br>
	StudentAge:<form:input path="studentAge"/><br>
	
	<input type="submit" value="submit">
	
</form:form>