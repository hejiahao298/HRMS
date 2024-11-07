// 加载部门
getAllDep();

// 加载职位
getAllPosition();

function addJob(){

    sendRequestData("/job/addJob","post",{
        "positionId":getEleVal("position"),
        "departmentId":getEleVal("department"),
        "description":getEleVal("description"),
        "openings":getEleVal("num"),
        "status":getEleVal("status"),
        "postDate":getEleVal("postDate")
    }).then(res => {
        const data = res.data.data;
        console.log(data)
        if(data!=1){
            alert("添加失败！");
        }else{
            alert("添加成功！");
        }
    })
}