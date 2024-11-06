// 设置全局的请求拦截器
// 请求发生时将token携带过去
axios.interceptors.request.use(function (config){
    const token = localStorage.getItem("token");
    config.headers["token"]=token;
    return config;
})

// 响应拦截器，数据响应时，如果状态码不为200就跳转错误页面
axios.interceptors.response.use(
    function (response) {
        // 任何2xx范围的状态码都会触发此函数
        return response;
    },
    function (error) {
        // 任何超出2xx范围的状态码都会触发此函数
        if (error.response) {
            // 后端返回了状态码，但状态码不在2xx的范围内
            if (error.response.code === 500) {
                // 状态码为500，跳转到错误页面
                location.href = "error.html";
            } else {
                // 其他非2xx状态码的处理
                console.log('Error Status:', error.response.status);
            }
        } else if (error.request) {
            // 请求已经发出，但没有收到响应
            console.log(error.request);
        } else {
            // 在设置请求时发生了一些事情，触发了一个错误
            console.log('Error', error.message);
        }
        return Promise.reject(error);
    }
);