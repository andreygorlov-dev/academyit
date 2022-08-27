<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ page session="false"%>
<html>
<head>
<title>Calculator</title>
<meta charset="UTF-8">
</head>
<body>
	<h1>Calculaton form</h1>

	<f:form method="POST" action="calc" commandName="MathematicalExpression">
		<fieldset>
			<f:input path="value1" />

			<f:select path="action">
				<option>+</option>
				<option>-</option>
				<option>*</option>
				<option>/</option>
			</f:select>
			<f:input path="value2" />
			<f:input path="result" />
		</fieldset>
		<br>
		<input type="submit" value="Calculate">
	</f:form>
</body>
</html>
