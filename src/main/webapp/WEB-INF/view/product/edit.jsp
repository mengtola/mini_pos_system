<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"/>

<!-- BEGIN PAGE CONTENT-->
<div class="row-fluid">
	  		<div class="widget blue">
			<div class="widget-title">
				<h4><i class="icon-reorder"></i> Add Product </h4>
				<div class="tools">
                   <a class="collapse" href="javascript:;"></a>
                   <a class="config" href="#portlet-config" data-toggle="modal"></a>
                   <a class="reload" href="javascript:;"></a>
                   <a class="remove" href="javascript:;"></a>
               </div>
			</div>
			<div style="display: block;" class="widget-body">
				<!-- BEGIN FORM-->
	 		    <form:form method="POST" action = "" modelAttribute="products"  class="cmxform form-horizontal">
	 		    
					<div class="control-group">
						<label class="control-label">Category</label>
						<div class="controls">
							<sf:select path="catId"  class="span4">
								<sf:options items="${category_list}" itemValue="catId" itemLabel="catName"></sf:options>
							</sf:select>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Brand</label>
						<div class="controls">
							<sf:select path="braId"  class="span4">
								<sf:options items="${brand_list}" itemValue="braId" itemLabel="braName"></sf:options>
							</sf:select>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Product Name</label>
						<div class="controls">
							<form:input path="proName"  class="span4"/>
						</div>
					</div>	
			
					<div class="control-group">
						<label class="control-label">Qty</label>
						<div class="controls">
							<form:input path="qty"  class="span4"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Stock Price</label>
						<div class="controls">
							<form:input path="stockPrice"  class="span4"/>
						</div>
					</div>
					
				
	
					<div class="control-group">
						<label class="control-label">Sale Price</label>
						<div class="controls">
							<form:input path="salePrice"  class="span4"/>
	
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Status</label>
						<div class="controls">
							<sf:select path="proStatus"  class="span4">
								<sf:options items="${prostatuslist}"></sf:options>
							</sf:select>
						</div>
					</div>		
				
					<div class="form-actions" style="clear:both;">
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="button" class="btn">Cancel</button>
						</div>
					<div style="clear:both;"></div>
				</form:form>
				<!-- END FORM-->
			</div>
		</div>
</div>

<jsp:include page="../footer.jsp"/>