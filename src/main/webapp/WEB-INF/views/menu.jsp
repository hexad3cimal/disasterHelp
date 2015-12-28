<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
   <div class="menu_section">
      <h3>Disasters</h3>
      <ul class="nav side-menu">

      				<c:forEach var="nextHeader" items="${menuList}">
      <li>
         <a href=" <c:out value="${nextHeader.link}" />"><i class="fa fa-home"></i>
         <c:out value="${nextHeader.title}" /> <span class="fa fa-chevron-down"></span></a>
      </li>
      					</c:forEach>

    </ul>
   </div>

<!-- /sidebar menu -->