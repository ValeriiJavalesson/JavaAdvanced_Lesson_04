$(document).ready(function() {
	$('#student_list').onchange(getUser);	
});

function getUser() {
	var student_id = $('#student_list').find(":selected").val();
	let url = `/student?student_id=${student_id}`;
	window.location = url;
};

