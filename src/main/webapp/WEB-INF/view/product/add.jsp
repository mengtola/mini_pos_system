<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"/>

<!-- BEGIN PAGE CONTENT-->
<div class="row-fluid">
	  		<div class="widget blue">
			<div class="widget-title">
				<h4><i class="icon-reorder"></i> Add Product </h4>
				<span class="tools">
				<a href="javascript:;" class="icon-chevron-down"></a>
				<a href="javascript:;" class="icon-remove"></a>
				</span>
			</div>
			<div style="display: block;" class="widget-body">
				<!-- BEGIN FORM-->
	 		    <form:form method="POST" action = "/product/add.html" modelAttribute="products">
				<div class="control-group">
					<label class="control-label">Category</label>
					<div class="controls">
						<sf:select path="category">
							<sf:options items="${category_list}" itemValue="catId" itemLabel="catName"></sf:options>
						</sf:select>
						<span class="help-inline"></span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Brand</label>
					<div class="controls">
						<sf:select path="brand">
							<sf:options items="${brand_list}" itemValue="braId" itemLabel="braName"></sf:options>
						</sf:select>
						<span class="help-inline"></span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Product Name</label>
					<div class="controls">
						<form:input path="proName"/>
						<span class="help-inline"></span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Qty</label>
					<div class="controls">
						<form:input path="qty"/>
						<span class="help-inline"></span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Unit Price</label>
					<div class="controls">
						<form:input path="unitPrice"/>
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