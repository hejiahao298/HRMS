// 动态加载welcome-box
loadWelcomeBox();

// 动态加载sidebar
loadSidebar();

const tbody = document.getElementById('departmentTable').getElementsByTagName('tbody')[0];
const arr = ["departmentId","departmentName","name","phone"];

sendRequestData('/dep/getAllDepVO','get',null)
    .then(res => {
    const data = res.data.data;
    data.forEach(dep =>{
        const tr = createTr(dep,arr);
        tbody.appendChild(tr);
    });
});