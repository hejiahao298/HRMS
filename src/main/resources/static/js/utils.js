
// 根据响应的数据和属性数组生成tr
function createTr(data,arr){
    const tr = document.createElement('tr');
    for (let i=0;i<arr.length;i++){
        const td = document.createElement('td');
        td.textContent=data[arr[i]];
        tr.appendChild(td);
    }
    return tr;
}

// 获取所有部门信息
function getAllDep(){
    // 获取部门信息
    const selectElement  = document.getElementById('department');

    axios({
        url:"http://localhost:8080/dep/getAll",
        method:"get",
    }).then(res => {
        const data = res.data.data;
        data.forEach(dep => {
            const option = document.createElement('option');
            option.value = dep.departmentId; // 设置option的值
            option.text = dep.departmentName; // 设置option的显示文本
            selectElement.appendChild(option); // 将option添加到select中
        })
    })
}



// 获取所有职位信息
function getAllPosition(){
    // 获取部门信息
    const ss  = document.getElementById('position');

    axios({
        url:"http://localhost:8080/pos/getAll",
        method:"get",
    }).then(res => {
        const data = res.data.data;
        data.forEach(pos => {
            const option = document.createElement('option');
            option.value = pos.positionId; // 设置option的值
            option.text = pos.positionTitle; // 设置option的显示文本
            ss.appendChild(option); // 将option添加到select中
        })
    })
}

// 设置input框中的值
function setEleVal(eleId,value1){
    document.getElementById(eleId).value=value1;
}

// 获取input框中的值
function getEleVal(eleId){
    const val = document.getElementById(eleId).value;
    return val;
}

// 动态加载welCome-box div
function loadWelcomeBox(){
    // 创建一个新的 XMLHttpRequest 对象
    var xhr = new XMLHttpRequest();
    // 配置请求类型（GET），URL，以及是否异步
    xhr.open('GET', 'welcome-box.html', true);
    // 设置请求完成的回调函数
    xhr.onload = function () {
        if (xhr.status === 200) {
            // 获取请求返回的HTML内容
            const welcomeBoxHTML = xhr.responseText;
            // 获取header中的元素，用于插入welcome-box
            const header = document.querySelector('.header');
            // 使用insertAdjacentHTML方法将welcome-box插入到header中
            header.insertAdjacentHTML('beforeend', welcomeBoxHTML);
        } else {
            console.error('Failed to load welcome-box.html');
        }
    };
    // 发送请求
    xhr.send();
}


// 动态加载sidebar.html
function loadSidebar(){

    // 创建一个新的 XMLHttpRequest 对象
    var xhr = new XMLHttpRequest();
    // 配置请求类型（GET），URL，以及是否异步
    xhr.open('GET', 'sidebar.html', true);

    // 设置请求完成的回调函数
    xhr.onload = function () {
        if (xhr.status === 200) {
            // 获取请求返回的HTML内容
            const sidebarHTML = xhr.responseText;
            // 获取header中的元素，用于插入welcome-box
            const container = document.getElementById("container")
            // 使用insertAdjacentHTML方法将welcome-box插入到header中
            container.insertAdjacentHTML('afterbegin', sidebarHTML);
        } else {
            console.error('Failed to load sidebar.html');
        }
    };
    // 发送请求
    xhr.send();
}
