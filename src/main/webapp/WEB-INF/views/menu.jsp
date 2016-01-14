<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jovin
  Date: 9/1/16
  Time: 7:09 AM
  To change this template use File | Settings | File Templates.
--%>
<form role="search">
    <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
    </div>
</form>
<ul id = "sidebar" class="nav menu">
    <c:forEach var="nextHeader" items="${menuList}">
    <li><a class = "menuClass" href="<c:out value="${nextHeader.link}"/>"><svg class="glyph stroked male-user"><use xlink:href="#stroked-calendar"></use></svg>  <c:out value="${nextHeader.title}"/></a></li>
    </c:forEach>
    <%--<li role="presentation" class="divider"></li>--%>
    <%--<li><a href="login.html"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Login Page</a></li>--%>

</ul>