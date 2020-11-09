/**
 * 根据基金名模糊查询基金信息
 */
function searchData() {

    $('#dg').datagrid('load', {
        name: $('#name').textbox('getValue'),
        code: $('#code').textbox('getValue'),
        industry: $('#industry').combobox('getValue'),
        profit: $('#profit').checkbox('options').checked,
        st: $('#st').checkbox('options').checked
    });
}

function formatProfit(val, row) {
    var data = unitConvert(val);
    return data.num + data.unit;
}

function unitConvert(num) {
    var moneyUnits = ["元", "万元", "亿元", "万亿"]
    var dividend = 10000;
    var curentNum = num;
    //转换数字
    var curentUnit = moneyUnits[0];
    //转换单位
    for (var i = 0; i < 4; i++) {
        curentUnit = moneyUnits[i]
        if (strNumSize(curentNum) < 5) {
            break;
        }
        curentNum = curentNum / dividend
    }
    var m = {num: 0, unit: ""}
    m.num = curentNum.toFixed(2)
    m.unit = curentUnit;
    return m;
}

function strNumSize(tempNum) {
    var stringNum = tempNum.toString()
    var index = stringNum.indexOf(".")
    var newNum = stringNum;
    if (index != -1) {
        newNum = stringNum.substring(0, index)
    }
    return newNum.length
}

var url;
$(function () {
    $('#industry').combobox({
        mode: 'remote',
        url: '/stock/getComboboxList',
        valueField: 'name',
        textField: 'name'
    });

    $('#dg').datagrid({
        columns: [[
            {field: 'name', title: '股票名称', width: 100},
            {
                field: 'code',
                title: '股票代码',
                width: 100,
                formatter: function (val, row) {
                    if(val.startsWith("SH")){
                        return val + '<span style="color: green">[沪]</span>';
                    }
                    if(val.startsWith("SZ")){
                        return val + '<span style="color: red">[深]</span>';
                    }
                    return val;
                }
            },
            {field: 'industryName', title: '行业名称', width: 100},
            {field: 'peTtm', title: '市盈率(TTM)', sortable: true, width: 100},
            {field: 'peLyr', title: '市盈率(静)', sortable: true, width: 100},
            {field: 'pb', title: '市净率', sortable: true, width: 100},
            {
                field: 'netprofit',
                title: '盈利',
                width: 100,
                formatter: formatProfit, width: 100
            }
        ]],
        fit: true,
        fitColumns: true,
        pagination: true,
        rownumbers: true,
        singleSelect: false,
        url: "/stock/list",
        pageList: [30, 40, 50],
        pageSize: "30",
        toolbar: "#tb",
        striped: true,
        rowStyler: function (index, row) {
            // if (row.pe != 0) {
            //     // 绿色：估值较低，适合开始定投的品种
            //     // 黄色：估值适中，可以观望
            //     // 红色：估值较高，谨慎投资
            //     if (row.ep > 0.10) {
            //         return 'background-color:#63B239;';
            //     } else if (row.ep < 0.065) {
            //         return 'background-color:#F9544D;';
            //     } else {
            //         return 'background-color:#FEA043;';
            //     }
            // }
        }
    })

});
