$("button.addProduct-button")
	.click(
		function() {
			var name = $("form.addProduct-form input.productName").val();
			var description = $("form.addProduct-form input.productDescription").val();
			var price = $("form.addProduct-form input.productPrice").val();

			if (name != '' || description != '' || price != '') {

				var newProduct = {
					name: name,
					description: description,
					price: price
				};

				$.post("product", newProduct, function(data) {
					if (data == "Success")
						alert("Успішно");
					$("form.addProduct-form")[0].reset();
				});
			}
		});	