<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../header.jsp"/>

<!-- BEGIN PAGE CONTENT-->
<div class="row-fluid">
	<div class="widget blue">
		<div class="widget-title">
			<h4><i class="icon-reorder"></i> All Customers</h4>
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
					 <th>Customer Name</th>
					 <th>Customer Phone</th>
					 <th></th>
				 </tr>
				 </thead>
				 <tbody>
				 	<c:forEach var="item" items="${cus_list}" varStatus="key">
		  				<tr>
		  					<td>${offset + key.index +1 }</td>
		  					<td>${item.getCusName()}</td>
		  					<td>${item.getCusPhone()}</td>
		  					<td style="text-align:center;width:8%;"><a href="/customer/edit/${item.getCusId()}.html"><i class="icon-edit" style="font-size:18px;color:#e74955;"></i></a></td>
		  				</tr>
		  			</c:forEach>
               		
				 </tbody>
			 </table>
		 </div>
         <div class="dataTables_paginate paging_bootstrap pagination">
  			<tag:paginate max="15" offset="${offset}" count="${count}" uri="/customer.html" next="&raquo;" previous="&laquo;" />
         </div>
         <div style="clear:both;"></div>
		</div>
	</div>
</div>
<script>
	$(function(){
		$("#editable_new").click(function(){
			window.location="/customer/add.html";
		});
	});
</script>

<jsp:include page="../footer.jsp"/>