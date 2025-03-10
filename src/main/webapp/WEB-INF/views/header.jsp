<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .error {
            color: red;
        }
        .message {
            color: green;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="<s:url action='listEmployees'/>">Employee Management System</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="<s:url action='listEmployees'/>">View Employees</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<s:url action='addEmployeeForm'/>">Add Employee</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-4">
<!-- Display action errors/messages -->
<s:if test="hasActionErrors()">
    <div class="alert alert-danger">
        <s:actionerror/>
    </div>
</s:if>
<s:if test="hasActionMessages()">
    <div class="alert alert-success">
        <s:actionmessage/>
    </div>
</s:if>