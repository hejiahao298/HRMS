// 设置全局的请求拦截器
// 请求发生时将token携带过去
axios.interceptors.request.use(function (config){
    const token = localStorage.getItem("token");
    config.headers["token"]=token;
    return config;
})

// 响应拦截器，数据响应时，如果状态码不为200就跳转错误页面
axios.interceptors.response.use(config => {
    const token = localStorage.getItem("token");
    // 对响应数据做点什么
    if(config.data.code===500){
        if(token==null){
            location.href="/login.html"
        }else{
            location.href="/error.html";
        }
    }else{
        return config;
    }
},err=>{
    console.log(err)
    });