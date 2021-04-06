$(function(){
    $("#loginForm").validate({
        debug:true,
        submitHandler:function(form){
            form.submit(); // 表示采用手工提交
        },
        rules:{
            "admin.aid":{
                required:true
            },
            "admin.password" :{
                required:true,
                rangelength:[3,12]
            }
        }
    })
});