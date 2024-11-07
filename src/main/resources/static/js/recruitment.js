// 动态加载welcome-box
loadWelcomeBox();

// 动态加载sidebar
loadSidebar();

/*---------------------渲染所有招聘信息-------------------*/
// 获取tbody元素
const tbody = document.getElementById('recruitmentTable').getElementsByTagName('tbody')[0];

const arr = ["positionTitle","departmentName","description","openings","status","postDate"];

function createRow(job) {
    const tr = createTr(job,arr);
    const td = document.createElement('td');
    td.innerHTML=`<button class="borrow-btn" type="button" onclick="deleteJob(${job.jobId})">删除</button>`
    tr.appendChild(td);
    tbody.appendChild(tr);
}

function loadAllJobs() {

    sendRequestParams('/job/getAll','get',null)
        .then(res => {
        const data = res.data.data;
        data.forEach(job => createRow(job));
    })
}
/*---------------------渲染所有招聘信息-------------------*/


/*---------------------删除招聘信息-------------------*/
function deleteJob(jobId) {
    sendRequestParams('/job/deleteJobById','delete',{
        "jobId": jobId
    }).then(res => {
        const data = res.data.data;
        if (data !== 1) {
            alert("删除失败！");
        } else {
            alert("删除成功！");
            location.href="recruitment.html"
        }
    })
}
/*---------------------删除招聘信息-------------------*/


/*---------------------查询招聘信息-------------------*/
function searchJob() {
    const jobName = getEleVal("jobName");
    tbody.innerHTML = "";

    sendRequestParams('/job/getJobByNam','get',{
        "jobName": jobName
    }).then(res => {
        const data = res.data.data;
        data.forEach(job => createRow(job));
    })
}
/*---------------------查询招聘信息-------------------*/

// 初始化页面
loadAllJobs();