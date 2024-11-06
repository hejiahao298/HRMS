loadSidebar();

loadWelcomeBox()

axios({
    url:"http://localhost:8080/emp/index",
    method:"get"
}).then(res => {
    const data = res.data.data;
    const empAll = document.getElementById("empAll");
    empAll.textContent=data.empCount;

    const expNum = document.getElementById("expNum");
    expNum.textContent=data.expiryCount;

    const positions = document.getElementById("positions");
    positions.textContent =data.jobCount;

    const openings = document.getElementById("openings");
    openings.innerHTML = data.jobOpenings;
})
