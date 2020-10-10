/**
 * 根据基金名模糊查询基金信息
 */
function searchData() {

    $('#dg').datagrid('load', {
        name: $('#s_name').textbox('getValue'),
        date: $('#s_date').combobox('getValue')
    });
}

function formatPe(val, row) {
    return (val * 100) + '%';
}

var url;
$(function () {
    $('#s_date').combobox({
        mode: 'remote',
        url: '/data/getComboboxListDate',
        valueField: 'date',
        textField: 'date'
    });

    $('#dg').datagrid({
        fit: true,
        fitColumns: true,
        pagination: true,
        rownumbers: true,
        singleSelect: false,
        url: "/data/list",
        pageList: [30, 40, 50],
        pageSize: "30",
        toolbar: "#tb",
        striped: true,
        title: "指数管理",
        rowStyler: function (index, row) {
            if (row.pe != 0) {
                // 绿色：估值较低，适合开始定投的品种
                // 黄色：估值适中，可以观望
                // 红色：估值较高，谨慎投资
                if (row.ep > 0.10) {
                    return 'background-color:#63B239;';
                } else if (row.ep < 0.065) {
                    return 'background-color:#F9544D;';
                } else {
                    return 'background-color:#FEA043;';
                }
            }
        }
    })

});
