<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="header.jsp" />

<div class="card border-danger">
    <div class="card-header bg-danger text-white">
        <h3 class="card-title">Error</h3>
    </div>
    <div class="card-body">
        <h5>An error occurred:</h5>
        <s:if test="hasActionErrors()">
            <div class="alert alert-danger">
                <s:actionerror/>
            </div>
        </s:if>
        <s:else>
            <div class="alert alert-danger">
                Unknown error occurred. Please try again or contact administrator.
            </div>
        </s:else>
        <a href="<s:url action='listEmployees'/>" class="btn btn-primary">Return to Employee List</a>
    </div>
</div>

<jsp:include page="footer.jsp" />