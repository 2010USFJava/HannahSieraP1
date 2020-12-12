/**
 * 
 */
let employees;
let today;
let i;


window.onload = function() {
	console.log("test onload");
	getEmployee();
}

	

function loadEmployee(employees) {
	//today = new Date();
	const table = document.getElementById("tableData");
	for (i = 0; i < employees.length; i++) {
		let row = table.insertRow();
		let fName = row.insertCell(0);
		fName.innerHTML = employees[i].empObj.firstName;
		let lName = row.insertCell(1);
		lName.innerHTML = employees[i].empObj.lastName;
		let uname = row.insertCell(2);
		fName.innerHTML = employees[i].empObj.username;
		let pword = row.insertCell(3);
		lName.innerHTML = employees[i].empObj.password;
		let eID = row.insertCell(4);
		eID.innerHTML = employees[i].empObj.empID;
		let balance = row.insertCell(5);
		balance.innerHTML = forms[i].empObj.balance;
		
		
		//let days = row.insertCell(5);
		//let day = new Date(forms[i].rObj.date);
		//let date = Math.round((today.getTime() - day.getTime()) / (1000 * 60 * 60 * 24));
		//if (date < 12) {
		//	days.innerHTML = date + " days URGENT";
		//}
		//else {
		//	days.innerHTML = date + " days";
		//}
	}
}



function getEmployee() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("cmon do the thing")
		console.log(xhttp.responseText);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			employee = JSON.parse(xhttp.responseText);
			console.log(employee);
			//console.log(employees[1].empObj.firstName);
			loadEmployee(employee);

		}

	}


	xhttp.open("GET", "/ProjectOne/viewemployees.json", false);

	xhttp.send();
}