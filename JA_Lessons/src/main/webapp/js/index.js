$("button.login")
	.click(
		function() {
			var email = $("form.login-form input.email").val();
			var password = $("form.login-form input.password").val();

			if (email == '' || password == '') {
				$("form.login-form .alert").removeClass("d-none");
				$("form.login-form .alert span").text("Заповніть всі поля для реєстрації!");
			} else if ((password.length) < 8) {
				$("form.login-form .alert").removeClass("d-none");
				$("form.login-form .alert span").text("Пароль має містити щонайменше 8 символів!");
			} else {
				$("form.login-form .alert").addClass("d-none");

				var userLogin  = {
					email: email,
					password: password
				};

				$.post("login", userLogin, function(data) {
					console.log(data);
					if (data == 'Success') {
						/*$("form")[0].reset();
						console.log(data);*/
					}
				});
			}
		});