// 加载部门
getAllDep();


function addJob(){
    axios({
        url:"http://localhost:8080/pos/addPos",
        method:"post",

        data:{
            "positionTitle":getEleVal("position"),
            "departmentId":getEleVal("department"),
        }
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