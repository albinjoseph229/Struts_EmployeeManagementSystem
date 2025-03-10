<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="header.jsp" />

<div class="card">
    <div class="card-header">
        <h3 class="card-title">Edit Employee</h3>
    </div>
    <div class="card-body">
        <s:form action="updateEmployee" method="post" theme="simple" cssClass="needs-validation">
            <s:hidden name="employee.id" />

            <div class="form-group">
                <label for="name">Name <span class="text-danger">*</span></label>
                <s:textfield name="employee.name" cssClass="form-control" id="name" />
                <s:fielderror fieldName="employee.name" cssClass="error" />
            </div>

            <div class="form-group">
                <label for="email">Email <span class="text-danger">*</span></label>
                <s:textfield name="employee.email" cssClass="form-control" id="email" />
                <s:fielderror fieldName="employee.email" cssClass="error" />
            </div>

            <div class="form-group">
                <label for="salary">Salary <span class="text-danger">*</span></label>
                <s:textfield name="employee.salary" cssClass="form-control" id="salary" type="number" step="0.01" />
                <s:fielderror fieldName="employee.salary" cssClass="error" />
            </div>

            <div class="form-group">
                <label for="designation">Designation</label>
                <s:textfield name="employee.designation" cssClass="form-control" id="designation" />
            </div>

            <div class="form-group">
                <s:submit value="Update Employee" cssClass="btn btn-primary" />
                <a href="<s:url action='listEmployees'/>" class="btn btn-secondary">Cancel</a>
            </div>
        </s:form>
    </div>
</div>

<jsp:include page="footer.jsp" />