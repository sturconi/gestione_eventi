function sendEmail() {
	Email.send({
	Host: "smtp.gmail.com",
	Username : "<mercoledisanto.kristhen@gmail.com>",
	Password : "<56675024>",
	To : '<k.mercoledisanto@itsrizzoli.it>',
	From : "<mercoledisanto.kristhen@gmail.com>",
	Subject : "<fff>",
	Body : "<fff>",
	}).then(
		message => alert("mail sent successfully")
	);
}