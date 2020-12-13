/**
 * 
 */
//this displays current date in Current Date input and inputs request date into database 
let today = new Date().toISOString().substr(0, 10);
document.querySelector("#today").value = today;

var inputamount = document.getElementById('amount1').value;
var eventType = document.getElementById('eventType');
var changedamount = document.getElementById('amount');
console.log(inputamount);
console.log(eventType);

eventType.onchange = function(eventType){
	if (eventType == "University Courses"){
		var result = parseFloat(inputamount) * (0.80);
		console.log(result);
		changedamount.value = !isNaN(result) ? result : '';
	}
	if (eventType == "Seminars"){
		var result = parseFloat(inputamount) * (0.60);
		console.log(result);
		changedamount.value = !isNaN(result) ? result : '';
	}
	if (eventType == "Certification Preparation Classes"){
		var result = parseFloat(inputamount) * (0.75);
		console.log(result);
		changedamount.value = !isNaN(result) ? result : '';
	}
	if (eventType == "Certification"){
		var result = parseFloat(inputamount) * (1);
		console.log(result);
		changedamount.value = !isNaN(result) ? result : '';
	}
	if (eventType == "Technical Training"){
		var result = parseFloat(inputamount) * (0.90);
		console.log(result);
		changedamount.value = !isNaN(result) ? result : '';
	}
	if (eventType == "Other"){
		var result = parseFloat(inputamount) * (0.30);
		console.log(result);
		changedamount.value = !isNaN(result) ? result : '';
	}
}


