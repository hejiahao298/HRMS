function restPassword(){
    const username = getEleVal("username");
    const newPassword = getEleVal("new-password");
    const confirmPassword = getEleVal("confirm-new-password");
    if(newPassword===confirmPassword){
        sendRequestParams('/user/findUsernam','get',{
            "username":username
        }).then(res => {
            const data = res.data.data;
            if(data==null){
                alert("用户名不存在");
            }else{
            return sendRequestParams('/user/resetPassword','post',{
                    "newPassword":newPassword,
                    "username":username,
                }).then(res => {
                    alert("重置成功！");
                    location.href="login.html";
                })
            }
        })
    }else{
        alert("两次密码不一致");
    }
}