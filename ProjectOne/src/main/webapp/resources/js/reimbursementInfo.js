/**
 * 
 */
window.onload = function() {
	console.log("pleae work, please.");
	getEmployee();
};

function getEmployee() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("in onreadystate change")
		console.log(xhttp.responseText);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let emp = JSON.parse(xhttp.responseText);
			console.log(emp);
			console.log(emp.employee.firstName);
			loadElements(emp);
		}

	}


	xhttp.open("GET", "/ProjectOne/getsession.json", false);

	xhttp.send();
}

function logout(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.open("GET", "/UpGrade/logout.json", false);
	xhttp.send();
}

function loadElements(emp){
	document.getElementById("empName").innerHTML=emp.employee.firstName;
	document.getElementById("amt").innerHTML=emp.employee.availableR;
}