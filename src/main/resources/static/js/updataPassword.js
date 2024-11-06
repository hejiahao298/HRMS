function restPassword(){
    const username = getEleVal("username");
    const newPassword = getEleVal("new-password");
    const confirmPassword = getEleVal("confirm-new-password");
    if(newPassword===confirmPassword){
        axios({
            url:'http://localhost:8080/user/findUsername',
            method:'get',
            params:{
                "username":username
            }
        }).then(res => {
            const data = res.data.data;
            if(data==null){
                alert("用户名不存在");
            }else{
                return axios({
                    url:"http://localhost:8080/user/resetPassword",
                    method:"post",
                    params:{
                        "newPassword":newPassword,
                        "username":username,
                    }
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