/**
 * 
 */
window.onload = function(){
	getManagers();
}

function getManagers(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			let manager = JSON.parse(xhttp.responseText);
			loadManagers(manager); 
			console.log(manager);
		}
	}
	xhttp.open("GET", "/ProjectOne/viewMan.json", false);
	xhttp.send();
}

function loadManagers(manager) {
	const table = document.getElementById("detailTable");
	Array.prototype.forEach.call(manager.manager, managers => {
		let row = table.insertRow();
		let fName = row.insertCell(0);
		reqID.innerHTML = manager.manager[0].firstName;
		let lName = row.insertCell(1);
		empID.innerHTML = manager.manager[0].lastName;
		let use = row.insertCell(2);
		event.innerHTML = manager.manager[0].username;
		let pass = row.insertCell(3);
		date.innerHTML = manager.manager[0].password;
		let id = row.insertCell(4);
		time.innerHTML = manager.manager[0].manID;
		let s1 = row.insertCell(5);
		location.innerHTML = manager.manager[0].status;
		let s2 = row.insertCell(6);
		description.innerHTML = manager.manager[0].statusdepthead;
		let s3 = row.insertCell(7);
		cost.innerHTML = manager.manager[0].statusbenco;
	});
}