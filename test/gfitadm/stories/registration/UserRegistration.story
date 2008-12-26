/**
 *
 * @author redpill
 */
narrative "User's registration", {
    as_a "Common user"
    i_want "To register a new user"
    so_that "I can register a new user"
}

scenario "User have access to register a new user", {
    given "I am logged"
    and "I have access to register a new user"
    and "I access the Users' registration in the Menu"
    when "I fill the 'Login' field with 'valid_new_unique_user'"
    and "I fill the 'Password' field with 'valid_new_pass'"
    and "I select a 'valid_unique_person' profile in 'Person' field"
    and "I select a 'valid_level' in 'Level' field"
    and "I push the 'Save' button"
    then "I should see ''valid_new_unique_user' saved with sucess!'"
}

scenario "User have no access to register a new user", {
    given "I am logged"
    when "I access the User's section from Menu"
    then "I should not see nothing about new users creation"
}
