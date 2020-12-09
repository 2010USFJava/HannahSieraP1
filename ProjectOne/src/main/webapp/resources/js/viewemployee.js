function loadEmployee(employee) {
document.getElementById("id").innerHTML=employee.id;


}

function getEmployee(){
    console.log("in get employee");
    let employee_id= document.getElementById("empID").value;

    //step 1 
    var xhr= new XMLHttpRequest();
    //step 2 on ready state change
    xhr.onreadystatechange=function () {
        console.log("in orsc");
        if(xhr.readyState==4&&xhr.status==200){
            console.log(xhr.responseText);
            var employee = JSON.parse(xhr.responseText); //taking json text and turning into js object to pass into function to take out name and print it in h3 tag

            loadEmployee(employee);

        }
    }
    //step 3 open request (method, url, synchronis) 
    xhr.open("GET","http://localhost:8080/ProjectOne/profile.change"+employee_id,true);

    //step 4 send request
    xhr.send();

}
window.onload= function() {
    console.log("in on load");
    document.getElementById("submit").addEventListener("click",getEmployee, false);
}