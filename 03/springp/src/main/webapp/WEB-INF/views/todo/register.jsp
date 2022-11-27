<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!-- form 태그 라이브러리-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/todo/register" method="post">
        <div>
            Title : <input type="text" name="title">
        </div>
        <div>
            DueDate: <input type="date" name="dueDate" value="2022-12-05">
        </div>
        <div>
            Writer: <input type="text" name="writer">
        </div>
        <div>
            Finished: <input type="text" name="finished">
        </div>
        <div>
            <button type="submit">Register</button>
        </div>
    </form>

</body>
</html>
