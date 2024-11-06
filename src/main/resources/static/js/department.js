// 动态加载welcome-box
loadWelcomeBox();

// 动态加载sidebar
loadSidebar();

const tbody = document.getElementById('departmentTable').getElementsByTagName('tbody')[0];
const arr = ["departmentId","departmentName","name","phone"];
axios({
    url: "http://localhost:8080/dep/getAllDepVO",
    method: 'get',
}).then(res => {
    const data = res.data.data;
    data.forEach(dep =>{
        const tr = createTr(dep,arr);
        tbody.appendChild(tr);
    });
});