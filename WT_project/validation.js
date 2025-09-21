function validateForm() {
    // Get input values
    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const firstName = document.getElementById('first_name').value;
    const lastName = document.getElementById('last_name').value;
    }
    // Clear any previous error messages
    clearErrorMessages();
  
    // Validation checks
    let isValid = true; // Flag to track overall validity
  
    if (!isValidUsername(username)) {
      isValid = false;
      showError('username-error', 'Username must be at least 3 characters long and contain only letters, numbers, and underscores.');
    }
  
    if (!isValidEmail(email)) {
      isValid = false;
      showError('email-error', 'Please enter a valid email address.');
    }
  
    if (!isValidPassword(password)) {
      isValid = false;
      showError('password-error', 'Password must be at least 8 characters long and contain a combination of letters, numbers, and symbols.');
    }
  
    if (!isValidName(firstName) || !isValidName(lastName)) {
      isValid = false;
      showError('first-name-error', 'Please enter a valid name')
    }