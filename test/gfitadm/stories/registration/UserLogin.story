/**
 *
 * @author Leandro Pincini
 */

narrative "User's login" {
    as_a "Common user"
    i_want "To login"
    so_that "I can use the system"
}

scenario "User is not registred yet", {
    given "I am in the login's prompt dialog", {}
    and "given I fill the "Login" field with "fakeuser", {}
    and "given I fill the "Password" field with "123546", {}
    when "I push the "Log Me In" button, {}
    then "I should see "Could not log you in as 'fakeuser'.", {}
}

scenario "User is alredy registred", {
    given "I am in the login's prompt dialog", {}
    and "given I alredy registred the login "user" with the password "1234"
    when "I fill the "Login" field with "user", {}
    and "when I fill the "Password" field with "1234", {}
    then "I should see "Welcome, 'user'!",{}
}

scenario "Registred user log out", {
    given "I am alredy logged in", {}
    when "I push the "Log Out" button, {}
    then "I should see "You have been logged out!", {}
    and "then the session should be terminated", {}
}
