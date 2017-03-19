<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../header.jsp"/>

<!-- BEGIN PAGE CONTENT-->
<div class="row-fluid">
	<div class="widget blue">
		<div class="widget-title">
			<h4><i class="icon-reorder"></i> All Brands</h4>
			<span class="tools">
			<a href="javascript:;" class="icon-chevron-down"></a>
			<a href="javascript:;" class="icon-remove"></a>
			</span>
		</div>
		<div style="display: block;" class="widget-body">
			<div>
			 <div class="clearfix">
				 <div class="btn-group">
					 <button id="editable_new" class="btn green">
						 Add New <i class="icon-plus"></i>
					 </button>
				 </div>
				 <div class="btn-group pull-right">
					 <button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i class="icon-angle-down"></i>
					 </button>
					 <ul class="dropdown-menu pull-right">
						 <li><a href="#">Print</a></li>
						 <li><a href="#">Save as PDF</a></li>
						 <li><a href="#">Export to Excel</a></li>
					 </ul>
				 </div>
			 </div>
			 <div class="space15"></div>
			 <table class="table table-striped table-hover table-bordered" id="editable-sample">
				 <thead>
				 <tr>
					 <th>No</th>
					 <th>Brand Name</th>
					 <th></th>
				 </tr>
				 </thead>
				 <tbody>
				 	<c:forEach var="item" items="${bra_list}" varStatus="key">
		  				<tr>
		  					<td>${key.index + 1}</td>
		  					<td>${item.getBraName()}</td>
		  					<td></td>
		  				</tr>
		  			</c:forEach>
               		
				 </tbody>
			 </table>
		 </div>
         <div class="dataTables_paginate paging_bootstrap pagination">
  			
         </div>
         <div style="clear:both;"></div>
		</div>
	</div>
</div>
<script>
	$(function(){
		$("#editable_new").click(function(){
			window.location="/brand/add.html";
		});
	});
</script>

<jsp:include page="../footer.jsp"/>