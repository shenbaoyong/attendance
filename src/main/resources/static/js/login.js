
function check() {
    var account = $.trim($('#u').attr('value'));
    var password= $.trim($('#p').attr('value'));
    var userType= $.trim($('#mySelect').attr('id'));
    if ("" == account || "" == password) {
        alert('用户名或者密码不能为空');
    } else {
        $.ajax({
            type : 'post',
            url : 'account/login?user_id=' + name + '&user_id=' + pwd + '&user_type=' + userType
        });
         
    }
}
