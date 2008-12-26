/**
 *
 * @author redpill
 */
narrative "Person's registration", {
    as_a "Common user"
    i_want "To register a new person"
    so_that "I can register a new person"
}

scenario "User have access to register a new person", {
    given "I am logged"
    and "I have access to register a new person"
    and "I access the People's registration in the Menu"
    when "I fill the 'Name' field with 'valid_new_name'"
    and "I fill the 'LastName' field with 'valid_new_last_name'"
    and "I fill the 'BornDate' field with 'valid_new_born_date'"
    and "I push the 'Save' button"
    then "I should see ''valid_new_unique_user' saved with sucess!'"
}

scenario "User have no access to register a new person", {
    given "I am logged"
    when "I access the People's section from Menu"
    then "I should see nothing about new people creation"
}
