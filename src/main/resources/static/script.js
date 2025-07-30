document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("userForm");
  const message = document.getElementById("message");
  const messageBox = document.getElementById("messageBox");
  const successImage = document.getElementById("successImage");

  form.addEventListener("submit", function (event) {
    event.preventDefault(); // Stop default form submit

    const formData = new FormData(form);

    fetch('/save', {
      method: 'POST',
      body: new URLSearchParams(formData),
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      }
    })
    .then(response => {
      if (response.ok) {
        // ✅ Hide the form
        form.style.display = "none";

        // ✅ Show message and image
        message.textContent = "Submitted successfully Bro 👌😍!";
        messageBox.style.display = "block";
        successImage.style.display = "inline";
      } else {
        message.textContent = "Error: " + response.statusText;
        messageBox.style.display = "block";
        successImage.style.display = "none";
      }
    })
    .catch(error => {
      message.textContent = "Request failed: " + error;
      messageBox.style.display = "block";
      successImage.style.display = "none";
    });
  });
});
