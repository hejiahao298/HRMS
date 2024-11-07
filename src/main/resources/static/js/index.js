loadSidebar();

loadWelcomeBox()

sendRequestData('/emp/index','get',null)
    .then(res => {
    const data = res.data.data;
    getElement('empAll').textContent=data.empCount;
    getElement('expNum').textContent=data.expiryCount;
    getElement('positions').textContent=data.jobCount;
    getElement('openings').textContent = data.jobOpenings;
})
