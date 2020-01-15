$(function(){
    loadList();
})

function loadList(){
    $.ajax({
        url:"http://localhost:8085/productAttributeValue/selectList",
        dataType:"json",
        type:"GET",
        success:function(data) {
            console.log(data)
            html1 = '';
            for(var i = 0;i<data.dataList.length;i++){
            html1 +='<div class="one_good">\n'+
                '<a class="fp_good_a" target="_blank" href="/web/toSelectDetail?id='+data.dataList[i].productId+'">\n' +
                '<img class="fp_good_img" src="'+data.dataList[i].pic+'"></a>'+
                '<span class="delete_footprint" data-twitter-id="481640549"> <em class="white-trash-can"></em> </span> ' +
                '<span class="fp_good_price">'+data.dataList[i].price+'</span>' +
                ' <a class="fp_good_title" href="/web/toSelectDetail?id='+data.dataList[i].productId+'" target="_blank">'+data.dataList[i].subTitle+'</a> </div> '
            }
        $("#footprint_goods").html(html1);
        },error:function(){
                alert("报错")
            }
    })
}