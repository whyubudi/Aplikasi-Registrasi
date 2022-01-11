<!DOCTYPE html>

<!-- header -->
<div xmlns:th="http//www.w3.org/1999/xhtml"
	th:replace="header::top_area">
</div>

<p xmlns:th="http//www.w3.org/1999/xhtml" th:text="${data.email1}">
</p>
<p xmlns:th="http//www.w3.org/1999/xhtml" th:text="${data.text1}">
</p>
<p xmlns:th="http//www.w3.org/1999/xhtml" th:text="${data.password1}">
</p>
<p xmlns:th="http//www.w3.org/1999/xhtml" th:text="${data.gender1}">
</p>
<p xmlns:th="http//www.w3.org/1999/xhtml" th:text="${data.status1}">
</p>

<!-- footer -->
<div xmlns:th="http//www.w3.org/1999/xhtml"
	th:replace="footer::bottom_area">
</div>