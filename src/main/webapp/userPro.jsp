<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- http://localhost:8080/ssm/users --%>
<!doctype html> <%--添加--%>
<html lang="en">
<head>
    <!-- 必须的 meta 标签 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<body>

<!-- jQuery 和 Bootstrap 集成包（集成了 Popper） -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-7ymO4nGrkm372HoSbq1OY2DP4pEZnMiA+E0F3zPr+JQQtQ82gQ1HPY3QIVtztVua" crossorigin="anonymous"></script>
<%-- 通过 http://localhost:8080/ssm/users 访问 --%>
<table class="table table-striped table-bordered">
    <thead class="thead-dark">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        <th>gender</th>
        <th>registerTime</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.data.list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.gender}</td>
            <td>
                <fmt:formatDate value="${user.registerTime}" pattern="yyyy-MM-dda"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <c:if test="${requestScope.data.hasPreviousPage}">
            <li class="page-ite">
                <a class="page-link" href="${pageContext.request.contextPath}/users?pageNum=${requestScope.data.prePage}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${!requestScope.data.hasPreviousPage}">
            <li class="page-ite">
                <a class="page-link disabled" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${requestScope.data.pages}" var="pageNum">
            <c:if test="${pageNum==requestScope.data.pageNum}">
                <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/users?pageNum=${pageNum}">${pageNum}</a></li>
            </c:if>
            <c:if test="${pageNum!=requestScope.data.pageNum}">
                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/users?pageNum=${pageNum}">${pageNum}</a></li>
            </c:if>
        </c:forEach>

        <c:if test="${!requestScope.data.hasNextPage}">
            <li class="page-item">
                <a class="page-link disabled" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${requestScope.data.hasNextPage}">
            <li class="page-item">
                <a class="page-link" href="${pageContext.request.contextPath}/users?pageNum=${requestScope.data.nextPage}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</nav>

</body>
</html>
