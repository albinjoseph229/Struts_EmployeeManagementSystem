<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="header.jsp" />

<div class="card">
    <div class="card-header d-flex justify-content-between align-items-center">
        <h3 class="card-title">Employees</h3>
        <a href="<s:url action='addEmployeeForm'/>" class="btn btn-primary">Add New Employee</a>
    </div>
    <div class="card-body">
        <s:if test="employees != null && !employees.isEmpty()">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Salary</th>
                    <th>Designation</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="employees">
                    <tr>
                        <td><s:property value="id" /></td>
                        <td><s:property value="name" /></td>
                        <td><s:property value="email" /></td>
                        <td>$<s:property value="salary" /></td>
                        <td><s:property value="designation" /></td>
                        <td>
                            <a href="<s:url action='editEmployeeForm'><s:param name='employeeId' value='%{id}'/></s:url>" class="btn btn-sm btn-info">Edit</a>
                            <a href="<s:url action='deleteEmployee'><s:param name='employeeId' value='%{id}'/></s:url>" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>
                        </td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </s:if>
        <s:else>
            <div class="alert alert-info">No employees found.</div>
        </s:else>
    </div>
</div>

<jsp:include page="footer.jsp" />