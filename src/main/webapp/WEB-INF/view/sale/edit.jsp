<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"/>

<!-- BEGIN PAGE CONTENT-->
<div class="row-fluid">
	  		<div class="widget blue">
			<div class="widget-title">
				<h4><i class="icon-reorder"></i> Add Sale </h4>
				<div class="tools">
                   <a class="collapse" href="javascript:;"></a>
                   <a class="config" href="#portlet-config" data-toggle="modal"></a>
                   <a class="reload" href="javascript:;"></a>
                   <a class="remove" href="javascript:;"></a>
               </div>
			</div>
			<div style="display: block;" class="widget-body form">
				<!-- BEGIN FORM-->
	 		    <form:form method="POST" action = "" modelAttribute="saleadd" class="cmxform form-horizontal">
		 		 
						
				<div class="control-group">
					<label class="control-label">Customer</label>
					<div class="controls">
						<sf:select path="cusId" class="span4">
							<sf:options items="${customer_list}" itemValue="cusId" itemLabel="cusName"></sf:options>
						</sf:select>
					</div>
				</div>
				<div>
                    <div class="clearfix">
                        <div class="btn-group">
                            <button id="editable-sample_new" class="btn green" type="button">
                                Add Product <i class="icon-plus"></i>
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
                            <th>Product Code</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="item" items="${saleProduct}" varStatus="key">
                        	<tr>
                        		<td><input type="text" name="saleProduct[${key.index}].proCode" class=" small" value="${item.getProCode()}"></td>
                        		<td><input type="text" name="saleProduct[${key.index}].salePrice" class=" small" value="${item.getSalePrice()}"></td>
                        		<td><input type="text" name="saleProduct[${key.index}].saleQty" class=" small" value="${item.getSaleQty()}"></td>
                        		<td><button class="btn btn-danger delete" type="button"><i class="icon-trash "></i></button></td>
                        	</tr>
                        	</c:forEach>
                        </tbody>
                    </table>
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

   <!-- script for datatable -->
   <script type="text/javascript" src="../../../assets/plugin/data-tables/jquery.dataTables.js"></script>
   <script src="../../../assets/plugin/data-tables/DT_bootstrap.js" type="text/javascript"></script>
   <script src="../../../assets/js/editable-table.js"></script>
   
    <!-- END JAVASCRIPTS -->
  <script>
      jQuery(document).ready(function() {
    	  SaleDetail.init();
      });
  </script>

<jsp:include page="../footer.jsp"/>