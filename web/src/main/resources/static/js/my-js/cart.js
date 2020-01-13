/**
 * Created by an.han on 13-12-17.
 */
window.onload = function () {
    alert(1111111);





    $.ajax({
        url: "http://localhost:8083/cart/getCartList",
        type:"get",
        dataType:"json",//规定返回值格式
        async:false,//同步上传
        success:function (data){//成功回调函数

            var html="";
            for(var i=0;i<data.dataList.length;i++){


                html+='<tr>'
                html+='<td class="checkbox"><input class="check-one check" type="checkbox"/></td>'
                html+='<td class="goods"><a href="#"><img src="'+data.dataList[i].productPic+'" width="100" height="100"/><span>'+data.dataList[i].productName+'<i>'+data.dataList[i].productSubTitle+'</i></span></a></td>'
                html+='<td class="price">'+data.dataList[i].price+'</td>'
                html+='<td class="count"><span class="reduce" onclick="reduceId('+data.dataList[i].id+')"></span><input id="getValue"class="count-input" type="text" value="'+data.dataList[i].quantity+'"/><span class="add" onclick="addId('+data.dataList[i].id+')">+</span></td>'
                html+=' <td class="subtotal">'+data.dataList[i].price+'</td>'
                html+=' <td class="operation"><span class="delete" onclick="deleteProductId('+data.dataList[i].id+')">X</span></td>'
                html+='</tr>'
            }
            $("#cartId").html(html);
        },
        error :function(){// 错误回调函数
            alert("展示错误,请联系管理员");
        }
    })


    if (!document.getElementsByClassName) {
        document.getElementsByClassName = function (cls) {
            var ret = [];
            var els = document.getElementsByTagName('*');
            for (var i = 0, len = els.length; i < len; i++) {

                if (els[i].className.indexOf(cls + ' ') >=0 || els[i].className.indexOf(' ' + cls + ' ') >=0 || els[i].className.indexOf(' ' + cls) >=0) {
                    ret.push(els[i]);
                }
            }
            return ret;
        }
    }

    var table = document.getElementById('cartTable'); // 购物车表格
    var selectInputs = document.getElementsByClassName('check'); // 所有勾选框
    var checkAllInputs = document.getElementsByClassName('check-all') // 全选框
    var tr = table.children[1].rows; //行
    var selectedTotal = document.getElementById('selectedTotal'); //已选商品数目容器
    var priceTotal = document.getElementById('priceTotal'); //总计
    var deleteAll = document.getElementById('deleteAll'); // 删除全部按钮
    //var selectedViewList = document.getElementById('selectedViewList'); //浮层已选商品列表容器
    var selected = document.getElementById('selected'); //已选商品
    var foot = document.getElementById('foot');


    // 更新总数和总价格，已选浮层
    function getTotal() {
		var seleted = 0;
		var price = 0;
		var HTMLstr = '';
		for (var i = 0, len = tr.length; i < len; i++) {
			if (tr[i].getElementsByTagName('input')[0].checked) {
				tr[i].className = 'on';
				seleted += parseInt(tr[i].getElementsByTagName('input')[1].value);
				price += parseFloat(tr[i].cells[4].innerHTML);
				HTMLstr += '<div><img src="' + tr[i].getElementsByTagName('img')[0].src + '"><span class="del" index="' + i + '">取消选择</span></div>'
			}
			else {
				tr[i].className = '';
			}
		}
	
		selectedTotal.innerHTML = seleted;
		priceTotal.innerHTML = price.toFixed(2);//方法将一个数字转换成一个小数点后2位的字符串
        console.log($('priceTotal').val())
		//selectedViewList.innerHTML = HTMLstr;
	
		if (seleted == 0) {
			foot.className = 'foot';
		}
	}

    // 计算单行价格
    function getSubtotal(tr) {
        var cells = tr.cells;
        var price = cells[2]; //单价
        var subtotal = cells[4]; //小计td
        var countInput = tr.getElementsByTagName('input')[1]; //数目input
        var span = tr.getElementsByTagName('span')[1]; //-号
        //写入HTML
        subtotal.innerHTML = (parseInt(countInput.value) * parseFloat(price.innerHTML)).toFixed(2);
        //如果数目只有一个，把-号去掉
        if (countInput.value == 1) {
            span.innerHTML = '';
        }else{
            span.innerHTML = '-';
        }
    }

    // 点击选择框
    for(var i = 0; i < selectInputs.length; i++ ){
        selectInputs[i].onclick = function () {
            if (this.className.indexOf('check-all') >= 0) { //如果是全选，则吧所有的选择框选中
                for (var j = 0; j < selectInputs.length; j++) {
                    selectInputs[j].checked = this.checked;
                }
            }
            if (!this.checked) { //只要有一个未勾选，则取消全选框的选中状态
                for (var i = 0; i < checkAllInputs.length; i++) {
                    checkAllInputs[i].checked = false;
                }
            }
            getTotal();//选完更新总计
        }
    }

    // 显示已选商品弹层
/*    selected.onclick = function () {
        if (selectedTotal.innerHTML != 0) {
            foot.className = (foot.className == 'foot' ? 'foot show' : 'foot');
        }
    }*/

    //已选商品弹层中的取消选择按钮
    /*selectedViewList.onclick = function (e) {
        var e = e || window.event;
        var el = e.srcElement;
        if (el.className=='del') {
            var input =  tr[el.getAttribute('index')].getElementsByTagName('input')[0]
            input.checked = false;
            input.onclick();
        }
    }*/

    //为每行元素添加事件
    for (var i = 0; i < tr.length; i++) {
        //将点击事件绑定到tr元素
        tr[i].onclick = function (e) {
            var e = e || window.event;
            var el = e.target || e.srcElement; //通过事件对象的target属性获取触发元素
            var cls = el.className; //触发元素的class
            var countInout = this.getElementsByTagName('input')[1]; // 数目input
            var value = parseInt(countInout.value); //数目
            //通过判断触发元素的class确定用户点击了哪个元素
            switch (cls) {
                case 'add': //点击了加号
                    countInout.value = value+1;
                    getSubtotal(this);
                    console.log($('#aa').val());
                    console.log($('#getValue').val())


                    $.ajax({
                        url: "http://localhost:8083/cart/addCartCount",
                        type:"post",
                        data:{
                            "id":$('#aa').val(),
                            "quantity":$('#getValue').val()
                        },
                        //dataType:"json",//规定返回值格式
                        async:false,//同步上传
                        success:function (){//成功回调函数

                            alert("增加了一件商品呦");
                            window.location.reload();

                        },
                        error :function(){// 错误回调函数
                            alert("增加失败,请联系管理员");
                        }
                    })

                    break;
                case 'reduce': //点击了减号
                    if (value > 1) {
                        countInout.value = value - 1;
                        getSubtotal(this);
                        console.log($('#aa').val());

                        $.ajax({
                            url: "http://localhost:8083/cart/addCartCount",
                            type:"post",
                            data:{
                                "id":$('#aa').val(),
                                "quantity":$('#getValue').val()
                            },
                            dataType:"json",//规定返回值格式
                            async:false,//同步上传
                            success:function (){//成功回调函数
                               /* if($('#getValue').val()==1){
                                    alert("真滴不能再减少啦");
                                }else {
                                    alert("真滴要减少吗");
                                    window.location.reload();
                                }*/
                                alert("真滴要减少吗");
                                window.location.reload();

                            },
                            error :function(){// 错误回调函数
                                alert("减少失败,请联系管理员");
                            }
                        })
                    }
                    break;
                case 'delete': //点击了删除
                    var conf = confirm('确定删除此商品吗？');
                    if (conf) {
                        this.parentNode.removeChild(this);
                      //console.log($('#aa').val());//拿到商品id
                        $.ajax({
                            url: "http://localhost:8083/cart/deleteCartList",
                            type:"post",
                            data:{
                                "id":$('#aa').val()
                            },
                            //dataType:"json",//规定返回值格式
                            async:false,//同步上传
                            success:function (){//成功回调函数

                                alert("删除成功");
                                window.location.reload();

                            },
                            error :function(){// 错误回调函数
                                alert("删除失败,请联系管理员");
                            }
                        })

                    }
                    break;
            }
            getTotal();
        }
        // 给数目输入框绑定keyup事件
        tr[i].getElementsByTagName('input')[1].onkeyup = function () {
            var val = parseInt(this.value);
            if (isNaN(val) || val <= 0) {
                val = 1;
            }
            if (this.value != val) {
                this.value = val;
            }
            getSubtotal(this.parentNode.parentNode); //更新小计
            getTotal(); //更新总数
        }
    }

    // 点击全部删除
    deleteAll.onclick = function () {
        if (selectedTotal.innerHTML != 0) {
            var con = confirm('确定删除所选商品吗？'); //弹出确认框
            if (con) {
                for (var i = 0; i < tr.length; i++) {
                    // 如果被选中，就删除相应的行
                    if (tr[i].getElementsByTagName('input')[0].checked) {
                        tr[i].parentNode.removeChild(tr[i]); // 删除相应节点
                        i--; //回退下标位置
                    }
                }
            }
        } else {
            alert('请选择商品！');
        }
        getTotal(); //更新总数
    }

    // 默认全选
    checkAllInputs[0].checked = true;
    checkAllInputs[0].onclick();
}
function deleteProductId(obj){

    $('#aa').val(obj);//赋值  将上面拼接的表里面循环的id赋值给 aa为id的input框
    return obj;
}

function reduceId(obj){

    $('#aa').val(obj);//赋值  将上面拼接的表里面循环的id赋值给 aa为id的input框
    return obj;
}

function addId(obj){

    $('#aa').val(obj);//赋值  将上面拼接的表里面循环的id赋值给 aa为id的input框
    return obj;
}
