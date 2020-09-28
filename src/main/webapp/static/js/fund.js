/**
 * 根据基金名模糊查询基金信息
 */
function searchfund() {

  $('#dg').datagrid('load', {
    fundName: $('#s_name').val()
  });
}

var url;

/**
 * 打开新增基金窗口
 */
function openfundAddDialog() {
  $('#dlg').dialog({
    title: '添加基金',
    iconCls: 'add',
    closed: false,
    top: $(window).height() / 4,
    width: 500,
    height: 350,
    onClose: function () {
      $('#name').val('');
      $('#code').val('');
      $('#scope').val('');
      $('#buildDate').val('setValue', '2020-01-01');
    }
  });

  url = "/fund/save";
}

/**
 * 打开修改基金窗口
 */
function openfundModifyDialog() {
  var selections = $('#dg').datagrid('getSelections');
  if (selections.length < 1) {
    $.messager.alert({
      title: '系统提示',
      msg: '请选择一条您要修改的记录',
      icon: 'error',
      top: $(window).height() / 4
    });
    return;
  }
  //加载数据至表单
  $('#fm').form('load', selections[0]);
  $('#buildDate').val('setValue', selections[0].buildDate);
  //设置窗口相关属性，并打开
  $('#dlg').dialog({
    title: '修改基金',
    iconCls: 'update',
    closed: false,
    top: $(window).height() / 4,
    width: 500,
    height: 350,
    onClose: function () {
      $('#name').val('');
      $('#code').val('');
      $('#scope').val('');
      $('#buildDate').val('setValue', '2020-01-01');
    }
  });

  url = "/fund/save?id=" + selections[0].id;
}

/**
 * 关闭窗口
 */
function closeDlg() {
  $('#name').val('');
  $('#code').val('');
  $('#scope').val('');
  $('#buildDate').val('setValue', '2020-01-01');
  $('#dlg').dialog('close');
}

$(function () {
  //数据表格加载完毕后，绑定双击打开修改窗口事件
  $('#dg').datagrid({
    onDblClickRow: function (index, row) {
      //加载数据至表单
      $('#fm').form('load', row);
      $('#dlg').dialog({
        title: '修改基金',
        iconCls: 'update',
        closed: false,
        top: $(window).height() / 4,
        width: 500,
        height: 350,
        onClose: function () {
          $('#name').val('');
          $('#code').val('');
          $('#scope').val('');
          $('#buildDate').val('setValue', '2020-01-01');
        }
      });

      url = "/fund/save?fundId=" + row.fundId;
    }
  })
});

/**
 * 保存基金信息
 */
function saveData() {
  $('#fm').form('submit', {
    url: url,
    onSubmit: function () {
      if ($('#name').val() === null || $('#name').val() === '') {
        $.messager.alert({
          title: '系统提示',
          msg: '请输入基金名称',
          icon: 'error',
          top: $(window).height() / 4
        });

        return false;
      }
      if ($('#code').val() === null || $('#code').val() === '') {
        $.messager.alert({
          title: '系统提示',
          msg: '请输入基金代码',
          icon: 'error',
          top: $(window).height() / 4
        });

        return false;
      }
      if ($('#scope').val() === null || $('#scope').val() === '') {
        $.messager.alert({
          title: '系统提示',
          msg: '请输入基金规模',
          icon: 'error',
          top: $(window).height() / 4
        });

        return false;
      }
      if ($('#buildDate').val() === null || $('#buildDate').val() === '') {
        $.messager.alert({
          title: '系统提示',
          msg: '请输入基金成立时间',
          icon: 'error',
          top: $(window).height() / 4
        });

        return false;
      }

      return true;
    },
    success: function (result) {
      var resultJson = eval('(' + result + ')');
      if (resultJson.code === 100) {
        $.messager.alert({
          title: '系统提示',
          msg: '保存成功',
          icon: 'info',
          top: $(window).height() / 4
        });
        $('#dlg').dialog('close');
        $('#dg').datagrid('reload');
      } else {
        $.messager.alert({
          title: '系统提示',
          msg: resultJson.msg,
          icon: 'error',
          top: $(window).height() / 4
        });
      }
    }
  })
}

/**
 * 删除用户信息
 */
function deletefund() {
  var selections = $('#dg').datagrid('getSelections');
  if (selections.length < 1) {
    $.messager.alert({
      title: '系统提示',
      msg: '请选择您要删除的记录',
      icon: 'error',
      top: $(window).height() / 4
    });
    return;
  }
  $.messager.confirm({
    title: '系统提示',
    msg: '您确定要删除这' + selections.length + '条记录吗？',
    top: $(window).height() / 4,
    fn: function (r) {
      if (r) {
        var idsAr = [];
        for (var i = 0; i < selections.length; i++) {
          idsAr.push(selections[i].id);
        }
        var ids = idsAr.join(",");
        $.ajax({
          url: '/fund/delete',
          dataType: 'json',
          type: 'post',
          data: {
            'ids': ids
          },
          success: function (result) {
            if (result.code === 100) {
              $.messager.alert({
                title: '系统提示',
                msg: '删除成功',
                icon: 'info',
                top: $(window).height() / 4
              });
              $('#dg').datagrid('reload');
            } else {
              $.messager.alert({
                title: '系统提示',
                msg: result.msg,
                icon: 'error',
                top: $(window).height() / 4
              });
            }
          }
        });
      }
    }
  })
}