/**
 * 根据基金名模糊查询基金信息
 */
function searchdata() {

  $('#dg').datagrid('load', {
    dataName: $('#s_name').val()
  });
}

var url;
$(function () {

});
