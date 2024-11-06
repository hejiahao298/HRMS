/*---------------------初始化更新页面-----------------*/
function loadHtml(){
    // 加载部门
    getAllDep()

    // 加载职位
    getAllPosition()

    // 获取employee传过来的员工Id
    const params = new URLSearchParams(window.location.search);
    const empId = params.get('empId');

    // 访问后端获取通过员工Id获取员工信息，渲染到input中
    axios({
        url:"http://localhost:8080/emp/getEmpById",
        method:"get",
        params:{
            "empId":empId
        }
    }).then(res => {
        const data = res.data.data;
        setEleVal("empId",data.employeeId);
        setEleVal("name",data.name);
        setEleVal("email",data.email);
        setEleVal("phone",data.phone);
        setEleVal("hireDate",data.hireDate);
        setEleVal("expiryDate",data.expiryDate);
        setEleVal("department",data.departmentId);
        setEleVal("position",data.positionId);
        setEleVal("salary",data.salary);
    })
}
/*---------------------初始化更新页面-----------------*/


/*---------------------更新员工--------------------*/
function UpdateEmp(){
    axios({
        url:"/emp/updateEmp",
        method:"put",

        data:{
            "employeeId":getEleVal("empId"),
            "name":getEleVal("name"),
            "email":getEleVal("email"),
            "phone":getEleVal("phone"),
            "hireDate":getEleVal("hireDate"),
            "expiryDate":getEleVal("expiryDate"),
            "departmentId":getEleVal("department"),
            "positionId": getEleVal("position"),
            "salary":getEleVal("salary")
        }
    }).then(res => {
        const i = res.data.data;
        if(i!=1){
            alert("修改失败！")
        }else{
            alert("修改成功！")
        }
    })
}
/*---------------------更新员工--------------------*/

// 加载页面
loadHtml();