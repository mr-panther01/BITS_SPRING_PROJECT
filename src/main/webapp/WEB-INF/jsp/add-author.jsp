<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Author</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container" style="max-width: 600px;">
        <h1>Add New Author</h1>
        
        <c:if test="${not empty error}">
            <div class="error-message">${error}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/save-author" method="post">
            <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" required placeholder="Enter author name">
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" required placeholder="Enter author email">
            </div>
            <div style="display: flex; gap: 10px;">
                <button type="submit">Save Author</button>
                <a href="${pageContext.request.contextPath}/" style="text-decoration: none;">
                    <button type="button" style="background: #334155; color: white;">Cancel</button>
                </a>
            </div>
        </form>
    </div>
</body>
</html>
