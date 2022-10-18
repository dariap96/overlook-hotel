$(function () {
    $('#login-submit').on("click", function() {
        let name = $('#login-name-field').val();
        let username = $('#login-username-field').val()
        let password = $('#login-password').val()

        if (name === "" || username === "" || password === "") {
            iziToast.show({
                title: "Enter ALL fields!"
            })
        }

        console.log(name, username, password)
    })
})
