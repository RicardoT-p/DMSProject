$(function(){
    $("#insertForm").validate({
        debug:true,
        submitHandler:function(form){
            form.submit(); // 表示采用手工提交
        },
        rules:{
            "action.title":{
                required:true
            },
            "action.url" :{
                required:true,
            },
            "action.icon":{
                required:true
            },
        }
    })
});