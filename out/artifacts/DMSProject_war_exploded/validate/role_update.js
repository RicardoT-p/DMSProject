$(function(){
    $("#insertForm").validate({
        debug:true,
        submitHandler:function(form){
            form.submit(); // 表示采用手工提交
        },
        rules:{
            "role.title":{
                required:true
            },
            "role.note" :{
                required:true,
                rangelength:[10,250]
            },
        }
    })
});