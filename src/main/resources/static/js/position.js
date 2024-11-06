// 动态加载welcome-box
loadWelcomeBox();

// 动态加载sidebar
loadSidebar();

// 加载部门信息
getAllDep();

// 获取tbody元素
const tbody = document.getElementById('positionTable').getElementsByTagName('tbody')[0];

const arr = ["departmentName","positionTitle"];

function createRow(pos) {
    const tr = createTr(pos,arr);
    const td = document.createElement('td');
    td.innerHTML=`<button class="borrow-btn" type="button" onclick="deletePos(${pos.positionId})">删除</button>`
    tr.appendChild(td);
    tbody.appendChild(tr);
}

function loadPosition(){

    axios({
        url: "http://localhost:8080/pos/getAllVO",
        method: 'get',
    }).then(res => {
        const data = res.data.data;
        data.forEach(pos => createRow(pos));
    })
}

function searchPosition(){
    tbody.innerHTML=``;
    axios({
        url: "http://localhost:8080/pos/getPosByDep",
        method: 'get',

        params:{
            "departmentId":getEleVal("department")
        }
    }).then(res => {
        const data = res.data.data;
        data.forEach(pos => createRow(pos));
    })
}

/*---------------------删除职位信息-------------------*/
function deletePos(posId) {
    axios({
        url: "http://localhost:8080/pos/deletePosById",
        method: "delete",
        params: { "posId": posId }
    }).then(res => {
        const data = res.data.data;
        if (data !== 1) {
            alert("删除失败！");
        } else {
            alert("删除成功！");
            location.href="position.html"
        }
    })
}
/*---------------------删除职位信息-------------------*/

loadPosition()