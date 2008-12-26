/**
 *
 * @author redpill
 */
narrative "User's login", {
    as_a "Common user"
    i_want "To login"
    so_that "I can use the system"
}

scenario "User is not registered yet", {
    given "I am in the login's prompt dialog"
    when "I fill the 'Login field with 'fake_user'"
    and "I fill the 'Password field with 'fake_pass'"
    and "I push the 'Log Me In' button"
    then "I should see 'Could not log you in as fakeuser.'"
}

scenario "User is alredy registered", {
    given "I am in the login's prompt dialog"
    and "I alredy registred the login 'valid_user' with the password 'valid_pass'"
    when "I fill the 'Login' field with 'valid_user'"
    and "I fill the 'Password' field with 'valid_pass'"
    then "I should see 'Welcome, 'valid_user'!'"
}

scenario "Registred user log out", {
    given "I am alredy logged in"
    when "I push the 'Log Out' button"
    then "I should see 'You have been logged out!'"
    and "then the session should be terminated"
}
