<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container" style="max-width: 600px;">
        <h1>Add New Book</h1>
        
        <c:if test="${not empty error}">
            <div class="error-message">${error}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/save-book" method="post">
            <div class="form-group">
                <label>Title</label>
                <input type="text" name="title" required placeholder="Enter book title">
            </div>
            <div class="form-group">
                <label>ISBN</label>
                <input type="text" name="isbn" required placeholder="Enter ISBN">
            </div>
            <div class="form-group">
                <label>Author</label>
                <select name="author.id" required>
                    <c:forEach var="author" items="${authors}">
                        <option value="${author.id}">${author.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div style="display: flex; gap: 10px;">
                <button type="submit">Save Book</button>
                <a href="${pageContext.request.contextPath}/" style="text-decoration: none;">
                    <button type="button" style="background: #334155; color: white;">Cancel</button>
                </a>
            </div>
        </form>
    </div>
</body>
</html>
