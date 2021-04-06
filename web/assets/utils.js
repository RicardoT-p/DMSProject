$("#checkAll").click(
    function () {
        if (this.checked) {
            $("input[type='checkbox']").prop("checked", true);
        } else {
            $("input[type='checkbox']").prop("checked", false);
        }
    }
);

// 批量删除功能
function deleteAll(url, paraName, eleName) {
    var data = "";// 保存所有要删除的数据
    var item = document.all(eleName);
    var count = 0; // 统计要删除数据量
    // 判断要删除的数据是一个还是多个
    if (item.length == undefined) {
        if ($(eleName).checked == true) {
            data += $(eleName).value + ".";
            count++;
        }
    } else {
        for (var x = 0; x < item.length; x++) {
            if (item[x].checked == true) {
                count++;
                data += item[x].value + ".";
            }
        }
    }
    if (count > 0) {
        if (window.confirm("确定要删除吗？")) {
           window.location = url + "&" + paraName + "=" + data
        }
    } else {
        alert("你还没有选中任何需要删除的数据！")
    }
}