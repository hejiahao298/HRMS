// 加载部门
getAllDep();

// 加载职位
getAllPosition()

function addEmp(){

    axios({
        url:"http://localhost:8080/emp/addEmp",
        method:"post",

        data:{
            "name":getEleVal("name"),
            "email":getEleVal("email"),
            "phone":getEleVal("phone"),
            "hireDate":getEleVal("hireDate"),
            "expiryDate":getEleVal("expiryDate"),
            "departmentId":getEleVal("department"),
            "positionId":getEleVal("position"),
            "salary":getEleVal("salary")
        }
    }).then(res => {
        const data = res.data.data;
        if(data==null){
            alert("添加失败！");
        }else{
            alert("添加成功！");
        }
    })
}