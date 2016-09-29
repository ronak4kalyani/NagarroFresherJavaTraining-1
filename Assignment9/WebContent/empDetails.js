$(function(){
	var editSec = $("#editSec");
	var overlay = $("#overlay");
	var editBtn = $("#editBtn");
	var editLink = $(".editLink");
	var employeeCode = $("#employeeCode");
	var eCode = $("#eCode");
	var name = $("#name");
	var location = $("#location");
	var email = $("#email");
	var dob = $("#dob");
	
	
	editBtn.on("click",toggleView);
	overlay.on("click",toggleView);
	editLink.on("click",openUpdateEmpView);
	

	function openUpdateEmpView(){
		toggleView();
		var x = $(this).parent().parent() ;
		employeeCode.val(x.find('td[name="employeeCode"]').html());
		eCode.val(x.find('td[name="employeeCode"]').html());
		name.val(x.find('td[name="name"]').html());
		location.val(x.find('td[name="location"]').html());
		email.val(x.find('td[name="email"]').html());
		dob.val(x.find('td[name="dob"]').html());
	}

	function toggleView(){
		overlay.toggle();
		editSec.toggle();
	}
	
});