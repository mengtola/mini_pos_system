var SaleDetail = function () {
	
    return {

        //main function to initiate the module
        init: function () {
            function editRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML = '<input type="text" name="saleProduct['+ ($('#editable-sample tbody tr').length - 1) +'].proCode" class=" small" value="' + aData[0] + '">';
                jqTds[1].innerHTML = '<input type="text" name="saleProduct['+ ($('#editable-sample tbody tr').length - 1) +'].salePrice" class=" small" value="' + aData[1] + '">';
                jqTds[2].innerHTML = '<input type="text" name="saleProduct['+ ($('#editable-sample tbody tr').length - 1) +'].saleQty" class=" small" value="' + aData[2] + '">';
                jqTds[3].innerHTML = '<button class="btn btn-danger delete" type="button"><i class="icon-trash "></i></button>';
            }

            var oTable = $('#editable-sample').dataTable({
                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"] // change per page values here
                ],
                // set the initial value
                "iDisplayLength": 10,
                "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage": {
                    "sLengthMenu": "_MENU_",
                    "oPaginate": {
                        "sPrevious": "Prev",
                        "sNext": "Next"
                    }
                },
                "aoColumnDefs": [{
                        'bSortable': false,
                        'aTargets': [0,1,2,3]
                    }
                ]
            });
            

            jQuery('#editable-sample_wrapper .dataTables_filter input').addClass(" medium"); // modify table search input
            jQuery('#editable-sample_wrapper .dataTables_length select').addClass(" xsmall"); // modify table per page dropdown

            var nEditing = null;

            $('#editable-sample_new').click(function (e) {
                e.preventDefault();
                var aiNew = oTable.fnAddData(['', '', '', '',
                        '<a class="edit" href="">Edit</a>', '<a class="cancel" data-mode="new" href="">Cancel</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                nEditing = nRow;
          
            });

            $('#editable-sample .delete').live('click', function (e) {
                e.preventDefault();

                if (confirm("Are you sure to delete this row ?") == false) {
                    return;
                }

                var nRow = $(this).parents('tr')[0];
                oTable.fnDeleteRow(nRow);
                idx -= 1;
            });
        }

    };

}();