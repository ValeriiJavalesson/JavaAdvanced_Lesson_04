$(document).ready(function () {
   checkValueOfBuckets();
});

$(".logout-button")
	.click(
		function() {
			$.get("logout", function(data) {
				if (data !== '') {
					var customUrl = '';
					var urlContent = window.location.href.split('/');
					for (var i = 0; i < urlContent.length - 1; i++) {
						customUrl += urlContent[i] + '/'
					}
					customUrl += data;
					window.location = customUrl;
				}
			});
		});	
var buckets = 0;
function checkValueOfBuckets() {
	$.get("bucket", function(data) {
		buckets = data.length;		
	}).done(function() {
		if (buckets == '0') {
				$('.shopping-cart-icon::after').removeAttr('display');
		}else{
			$('.shopping-cart-icon::after').attr('display', 'block');
			$("<style>.shopping-cart-icon::after { content: '" + buckets + "';}</style>").appendTo("head");
		}
		

	});
};		