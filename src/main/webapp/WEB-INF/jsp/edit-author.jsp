<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Author</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container" style="max-width: 600px;">
        <h1>Edit Author</h1>
        
        <c:if test="${not empty error}">
            <div class="error-message">${error}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/update-author/${author.id}" method="post">
            <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" value="${author.name}" required>
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" value="${author.email}" required>
            </div>
            <div style="display: flex; gap: 10px;">
                <button type="submit">Update Author</button>
                <a href="${pageContext.request.contextPath}/" style="text-decoration: none;">
                    <button type="button" style="background: #334155; color: white;">Cancel</button>
                </a>
            </div>
        </form>
    </div>
</body>
</html>
