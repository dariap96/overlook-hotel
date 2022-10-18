$(function () {
    $('#login-submit').on("click", function () {
        let username = $('#login-username-field').val()?.trim()
        let password = $('#login-password').val().trim()

        if (username === "" || password === "") { wrongParamsToast() }

        console.log(username, password)
    })
})

function wrongParamsToast() {
    iziToast.show({
        title: "Wrong email or password!"
    })
}
