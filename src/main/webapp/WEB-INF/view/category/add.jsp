<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"/>

<!-- BEGIN PAGE CONTENT-->
<div class="row-fluid">
	  		<div class="widget blue">
			<div class="widget-title">
				<h4><i class="icon-reorder"></i> Add Category </h4>
				<span class="tools">
				<a href="javascript:;" class="icon-chevron-down"></a>
				<a href="javascript:;" class="icon-remove"></a>
				</span>
			</div>
			<div style="display: block;" class="widget-body">
				<!-- BEGIN FORM-->
	 		    <form:form method="POST" action = "/category/add.html" modelAttribute="categories">
				<div class="control-group">
					<label class="control-label">Category Name</label>
					<div class="controls">
						<form:input path="catName"/>
						<span class="help-inline"></span>
					</div>
				</div>
	
				<div class="form-actions">
					<button type="submit" class="btn btn-primary">Submit</button>
					<button type="button" class="btn">Cancel</button>
				</div>
				</form:form>
				<!-- END FORM-->
			</div>
		</div>
</div>

<jsp:include page="../footer.jsp"/>