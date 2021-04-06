$(function(){
    $("#insertForm").validate({
        debug:true,
        submitHandler:function(form){
            form.submit(); // 表示采用手工提交
        },
        rules:{
            "dept.title":{
                required:true
            },
            "dept.note" :{
                required:true,
                rangelength:[10,250]
            },
            "document.title":{
                required:true
            },

        }
    })
});