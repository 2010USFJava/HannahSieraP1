function loadReimbursement(reimbursement) {
document.getReimbursementByEmpId("employee_id").innerHTML=reimbursement.employee_id;


}

function getReimbursement(){
    console.log("in get reimbursement");
    let employeeID= document.getReimbursementByEmpId("employee_id").value;

    //step 1 
    var xhr= new XMLHttpRequest();
    //step 2 on ready state change
    xhr.onreadystatechange=function () {
        console.log("in orsc");
        if(xhr.readyState==4&&xhr.status==200){
            console.log(xhr.responseText);
            var reimbursement = JSON.parse(xhr.responseText); //taking json text ans turning into js object to pass into function to take out name and print it in h3 tag

            loadReimbursement(reimbursement);

        }
    }
    //step 3 open request (method, url, synchronis) 
    xhr.open("GET","http://localhost:8080/ProjectOne/reimbursement.change"+employeeID,true);

    //step 4 send request
    xhr.send();

}
window.onload= function() {
    console.log("in on load");
    document.getReimbursementByEmpId("submit").addEventListener("click",getReimbursement, false);
}

