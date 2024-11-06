// 动态加载welcome-box
loadWelcomeBox();

// 动态加载sidebar
loadSidebar();

/*----------------所有员工信息渲染------------------*/
const tbody = document.getElementById('employeeTable').getElementsByTagName('tbody')[0];
const arr=["employeeId","name","email","phone","hireDate","expiryDate","departmentName","positionTitle","salary"];

function createRow(emp) {
    const tr = createTr(emp, arr);

    // 创建编辑按钮的td
    const tdUpdate = document.createElement('td');
    tdUpdate.innerHTML = `<button id="empUpdate" class="borrow-btn" type="button" onclick="empUpdate(${emp.employeeId})">编辑</button>`;
    tr.appendChild(tdUpdate); // 将编辑按钮的td添加到tr

    // 创建删除按钮的td
    const tdDelete = document.createElement('td');
    tdDelete.innerHTML = `<button id="empDelete" class="borrow-btn" type="button" onclick="empDelete(${emp.employeeId})">删除</button>`;
    tr.appendChild(tdDelete); // 将删除按钮的td添加到tr

    tbody.appendChild(tr); // 将tr添加到tbody
}

function loadAllEmp(){
    axios({
        url: "http://localhost:8080/emp/getAll",
        method: 'get'
    }).then(res => {
        const data = res.data.data;
        data.forEach(emp => createRow(emp));
    });
}

/*----------------------------------------所有员工信息渲染------------------------------------------*/

/*--------------------------------------查询员工渲染-----------------------------------------*/
function searchEmployee() {
    const search = document.getElementById("search").value;
    tbody.innerHTML = "";

    axios({
        url: "http://localhost:8080/emp/getEmpByName",
        method: "get",
        params: { "name": search }
    }).then(res => {
        const data = res.data.data;
        data.forEach(emp => createRow(emp));
    });
}
/*--------------------------------------查询员工渲染-----------------------------------------*/

/*--------------------------------------删除员工-----------------------------------------*/
function empDelete(empId) {
    axios({
        url: "http://localhost:8080/emp/deleteEmpById",
        method: "delete",
        params: { "empId": empId }
    }).then(res => {
        const data = res.data.data;
        if (data == null) {
            alert("删除失败！");
        } else {
            alert("删除成功！");
            searchEmployee(); // 重新加载员工列表
        }
    });
}
/*--------------------------------------删除员工-----------------------------------------*/

/*--------------------------------------编辑员工-----------------------------------------*/
function empUpdate(empId) {
    location.href = `/updateEmployee.html?empId=${empId}`;
}
/*--------------------------------------编辑员工-----------------------------------------*/

loadAllEmp()