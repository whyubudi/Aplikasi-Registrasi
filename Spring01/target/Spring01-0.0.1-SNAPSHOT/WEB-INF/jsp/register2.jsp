<!DOCTYPE html>

<!-- header -->
<div xmlns:th="http//www.w3.org/1999/xhtml"
	th:replace="header::top_area">
</div>

<form xmlns:th="http//www.w3.org/1999/xhtml"
	th:action="@{/proses_register2}" method="post"
	th:object="${userLogin}">
	<div class="form-group">
		<label>Email</label>
		<input th:field="*{email}" type="text" class="form-control" autofocus/>
		
		<span class="text-danger" th:if="${#fields.hasErrors('email')}"
			th:errors="*{email}"></span>
	</div>
	<div class="form-group">
		<label>Name</label>
		<input th:field="*{name}" name="text" type="text" class="form-control"/>
		
		<span class="text-danger" th:if="${#fields.hasErrors('name')}"
			th:errors="*{name}"></span>
	</div>
	<div class="form-group">
		<label>Password</label>
		<input th:field="*{password}" name="password" type="password" class="form-control"/>
		
		<span class="text-danger" th:if="${#fields.hasErrors('password')}"
			th:errors="*{password}"></span>
	</div>
	<div class="form-group">
		<label>Gender</label>
		<Select th:field="*{gender}" name="gender" class="form-control">
			<option value="Pria">Male</option>
			<option value="Wanita">Female</option>
		</Select>
	</div>
	<div class="form-group">
		<label>Status</label>
		<input th:field="*{status}" checked type="radio" name="status" value="Single"/> Single
		<input th:field="*{status}" type="radio" name="status" value="Married"/> Married
		<br/>
		<span class="text-danger" th:if="${#fields.hasErrors('status')}"
			th:errors="*{status}"></span>
	</div>
	
	<button type="submit" onclick='return confirm("Are you sure?")' class="btn btn-primary">
		<span class="fas fa-check"></span> Submit
	</button>
</form>

<!-- footer -->
<div xmlns:th="http//www.w3.org/1999/xhtml"
	th:replace="footer::bottom_area">
</div>