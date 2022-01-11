<!DOCTYPE html>

<!-- header -->
<div xmlns:th="http//www.w3.org/1999/xhtml"
	th:replace="header::top_area">
</div>


<table class="table table-bordered table-striped" xmlns:th="http//www.w3.org/1999/xhtml">
	<thead>
		<tr>
			<th>Nama</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Status</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<tr th:each="x:${data_user}">
			<td th:text="${x.name}"></td>
			<td th:text="${x.email}"></td>
			<td th:text="${x.gender}"></td>
			<td th:text="${x.status}"></td>
			<td>
				<a th:href="@{'/edit_user/' + ${x.id}}" class="btn btn-success">
					<span class="fa fa-pencil"></span> Edit
				</a>
			</td>
			<td>
				<form method="post" th:action="@{/delete_user}">
					<input type="hidden" name="id" th:value="${x.id}"/>
					<button type="submit" class="btm btn-danger">
						<span class="fa fa-trash"></span> Delete!
					</button>
				</form>
			</td>
		</tr>
	</tbody>

</table>

<!-- footer -->
<div xmlns:th="http//www.w3.org/1999/xhtml"
	th:replace="footer::bottom_area">
</div>