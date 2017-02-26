/**
 * Validates the create user form using jQuery validation plugin.
 * 
 * @autor Eugenia Pérez Martínez
 */

$.validator.addMethod("loginFormat", function(value, element) {
	return this.optional(element) || /^[A-Za-z0-9]+$/.test(value);
}, "Must contain only chars and numbers");

var validator = $("#createUserForm").validate({
	// Define the rules of the form
	rules : {
		login : {
			required : true,
			minlength : 4,
			maxlength : 15,
			loginFormat : true 
		},
		password : {
			required : true,
			minlength : 6,
			maxlength : 15
		},
		description : {
			maxlength : 255
		}
	},
	// Define the messages for the rules
	messages : {
		login : {
			required : "Enter a login",
			minlength : $.validator.format("Enter at least {0} characters"),
			maxlength : $.validator.format("Enter less than {0} characters"),
		},
		password : {
			required : "Provide a password",
			minlength : $.validator.format("Enter at least {0} characters"),
			maxlength : $.validator.format("Enter less than {0} characters"),
		},
		description : {
			maxlength : $.validator.format("Enter less than {0} characters"),
		}
	},
	errorPlacement : function(error, element) {
		error.insertAfter(element);
	},
	submitHandler : function(form) {
		form.submit();
	}
});
