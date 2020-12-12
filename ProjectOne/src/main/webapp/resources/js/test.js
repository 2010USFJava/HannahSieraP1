let employees;
let today;
let i;


window.onload = function() {
    getEmployee();
}

    

function loadEmployee(employee) {
    //today = new Date();
    const table = document.getElementById("tableData");
    Array.prototype.forEach.call(employee.employee, employees => {
        let row = table.insertRow();

        let fName = row.insertCell(0);
        fName.innerHTML = employee.employee[0].firstName;

        let lName = row.insertCell(1);
        lName.innerHTML = employee.employee[0].lastName;

        let uname = row.insertCell(2);
        fName.innerHTML = employee.employee[0].username;

        let pword = row.insertCell(3);
        lName.innerHTML = employee.employee[0].password;

        let eID = row.insertCell(4);
        eID.innerHTML = employee.employee[0].empID;

        let balance = row.insertCell(5);
        balance.innerHTML = employee.employee[0].balance;
        
        });
        //let days = row.insertCell(5);
        //let day = new Date(forms[i].rObj.date);
        //let date = Math.round((today.getTime() - day.getTime()) / (1000 * 60 * 60 * 24));
        //if (date < 12) {
        //    days.innerHTML = date + " days URGENT";
        //}
        //else {
        //    days.innerHTML = date + " days";
		
        
    
}


function getEmployee() {
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        console.log("cmon do the thing")
        console.log(xhttp.responseText);
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            employee = JSON.parse(xhttp.responseText);
            console.log(employee);
            console.log(employee[0].firstName);
			console.log(employee[1].lastName);
			//console.log(employee[2].username);
			//console.log(employee[3].password);
			//console.log(employee[4].empID);
			//console.log(employee[5].balance);
            loadEmployee(employee);

        }

    }


    xhttp.open("GET", "/ProjectOne/viewemployees.json", false);

    xhttp.send();
}