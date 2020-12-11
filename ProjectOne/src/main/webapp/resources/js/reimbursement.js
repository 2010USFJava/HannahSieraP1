window.onload = funtion() {
	console.log("in window.onload");
	getReimbursement();
}
funciton getReimbursement() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("ready state change");
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let reims = JSON.parse(xhttp.responseText);
			loadReim(reims);
			console.log(reims);
		}
	}
	xhttp.open("GET", "/UpGrade/getreimbursementbystatus.json", false);
	xhttp.send();
}
function loadReim(reims) {
	const table = document.getElementById("reimTable");
	Array.prototype.forEach.call(reims.reims, reim => {
		let row = table.insertRow();
		let reimID = row.insertCell(0);
		reimID.innerHTML = reims.reims[0].reimID
		let empid = row.insertCell[1].empid
		empid.innerHTML = empid.empid[1].empid
	}
	);
}
