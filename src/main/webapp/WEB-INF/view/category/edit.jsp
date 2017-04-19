<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"/>

<!-- BEGIN PAGE CONTENT-->
<div class="row-fluid">
	  		<div class="widget blue">
			<div class="widget-title">
				<h4><i class="icon-reorder"></i> Add Category </h4>
				<div class="tools">
                   <a class="collapse" href="javascript:;"></a>
                   <a class="config" href="#portlet-config" data-toggle="modal"></a>
                   <a class="reload" href="javascript:;"></a>
                   <a class="remove" href="javascript:;"></a>
               </div>
			</div>
			<div style="display: block;" class="widget-body">
				<!-- BEGIN FORM-->
	 		    <form:form method="POST" action = "" modelAttribute="categories"  class="cmxform form-horizontal">
				<div class="control-group">
					<label class="control-label">Category Name</label>
					<div class="controls">
						<form:input path="catName"  class="span4"/>
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