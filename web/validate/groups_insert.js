$(function(){
    $("#insertForm").validate({
        debug:true,
        submitHandler:function(form){
            form.submit(); // 表示采用手工提交
        },
        rules:{
            "groups.title":{
                required:true
            },
            "groups.note" :{
                required:true,
                rangelength:[10,250]
            },
            "groups.icon":{
                required:true
            },
        }
    })
});