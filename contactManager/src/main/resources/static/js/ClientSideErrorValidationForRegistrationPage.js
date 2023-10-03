$(document).ready(function() {
	$("#clientSideErrorForFirstName").hide();
	$("#clientSideErrorForLastName").hide();
	$("#clientSideErrorForEmail").hide();
	$("#clientSideErrorForPassword").hide();
	$("#clientSideErrorForDescription").hide();

	$("#firstName").on('click', function(e) {
		$("#clientSideErrorForFirstName").hide();
	})

	$("#lastName").on('click', function(e) {
		$("#clientSideErrorForLastName").hide();
	})

	$("#email").on('click', function(e) {
		$("#clientSideErrorForEmail").hide();
	})

	$("#password").on('click', function(e) {
		$("#clientSideErrorForPassword").hide();
	})

	$("#description").on('click', function(e) {
		$("#clientSideErrorForDescription").hide();
	})

	$("form").on('submit', function(e) {
		var isThereAnyError = false;

		var firstName = $("#firstName").val()
		if (firstName.length === 0) {
			$("#clientSideErrorForFirstName").text("First name cannot be empty").show()
			isThereAnyError = true
		}
		else if (firstName.length > 255) {
			$("#clientSideErrorForFirstName").text("First name length should be within 255 characters").show()
			isThereAnyError = true
		}
		else if (!/^[a-zA-Z]+$/.test(firstName)) {
			$("#clientSideErrorForFirstName").text("First name can only have alphabets").show()
			isThereAnyError = true
		}

		var lastName = $("#lastName").val()
		if (lastName.length === 0) {
			$("#clientSideErrorForLastName").text("Last name cannot be empty").show()
			isThereAnyError = true
		}
		else if (lastName.length > 255) {
			$("#clientSideErrorForLastName").text("Last name length should be within 255 characters").show()
			isThereAnyError = true
		}
		else if (!/^[a-zA-Z]+$/.test(lastName)) {
			$("#clientSideErrorForLastName").text("Last name can only have alphabets").show()
			isThereAnyError = true
		}

		var email = $("#email").val()
		if (email.length === 0) {
			$("#clientSideErrorForEmail").text("Email cannot be empty").show()
			isThereAnyError = true
		}
		else if (email.length > 255) {
			$("#clientSideErrorForEmail").text("Email length should be within 255 characters").show()
			isThereAnyError = true
		}
		else if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
			$("#clientSideErrorForEmail").text("Invalid Email").show()
			isThereAnyError = true
		}

		var password = $("#password").val()
		if (password.length === 0) {
			$("#clientSideErrorForPassword").text("Password cannot be empty").show()
			isThereAnyError = true
		}
		else if (password.length > 50) {
			$("#clientSideErrorForPassword").text("Password length should be within 50 characters").show()
			isThereAnyError = true
		}
		else if (!/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/.test(password)) {
			$("#clientSideErrorForPassword").text("Password rules violated").show()
			isThereAnyError = true
		}

		var description = $("#description").val()
		if (description.length > 255) {
			$("#clientSideErrorForDescription").text("Description length should be within 255 characters").show()
			isThereAnyError = true
		}

		if (isThereAnyError)
			e.preventDefault()
	})
});