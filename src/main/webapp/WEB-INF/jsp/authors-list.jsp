<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authors with Books</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Authors with Their Books</h1>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/">Back to Home</a>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Author Name</th>
                    <th>Email</th>
                    <th>Books Count</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="author" items="${authors}">
                    <tr>
                        <td>${author.name}</td>
                        <td>${author.email}</td>
                        <td>${fn:length(author.books)}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
