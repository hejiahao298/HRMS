function login(){
    const username = getEleVal("username");
    const password = getEleVal("password");
    const message = getElement('message');


    sendRequestParams('/user/login','post',{
        "username":username,
        "password":password
    }).then(res => {
        const data = res.data.data;
        if(data == null){
        message.innerHTML=`用户名或者密码错误`;
        }else{
            localStorage.setItem("token",data);
            location.href="index.html";
        }
    })
}
