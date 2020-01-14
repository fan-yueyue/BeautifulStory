$(function(){

})
function sumbuert(){
    $.ajax({
        url:"http://localhost:8086/comment/addCom",
        data:$('#loginForm').serialize(),
        type:"post",
        dataType:"json",
        success:function (data) {
            alert("评价成功");
            location.href="http://localhost:8089/orderController/order";
        },error:function (){
            alert("失败");
        }
    })
}
