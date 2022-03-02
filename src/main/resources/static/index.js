let usernameInput = document.getElementById("username");
let passwordInput = document.getElementById("password");
let loginButton = document.getElementById("login");

loginButton.onclick = async function() {
    let username = usernameInput.value;
    let password = passwordInput.value;

    let response = await fetch("/api/login?" + new URLSearchParams({ username, password }));
    response = await response.json();

    if (response.validLogin) {
        document.body.style.backgroundColor = "green";
    } else {
        document.body.style.backgroundColor = "red";
    }
};
