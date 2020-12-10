window.onload = function() {
	console.log("window");
	getEmployee();
}

function getEmployee() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("the ready state has changed");
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let emp = JSON.parse(xhttp.responseText);
			console.log(emp);
			loadEmployee(emp);
		
		}
	}
	xhttp.open("GET", "http://localhost:8080/ProjectOne/getsession.json");

	xhttp.send();
}
function loadEmployee(emp) {
	document.getElementById("empName").innerHTML.emp.employee.firstName;
}