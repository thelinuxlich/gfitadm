/**
 *
 * @author redpill
 */
narrative "User's update", {
    as_a "Common user"
    i_want "To update a user's profile"
    so_that "I can update a user's profile"
}

scenario "User have access to update his profile", {
    given "I am logged"
    and "I have access to update my profile"
    and "I access the Users' profile screen in the Menu"
    when "I push the 'Update' button"
    and "I update some field"
    and "I push the 'Save' button"
    then "I should see ''User' updated with sucess!'"
}

scenario "User have no acsess to update his user's profile", {
    given "I am logged"
    when "I access the Users' profile screen in the Menu"
    then "I should not see the 'Update' button"
}

scenario "User have access to update another user's profile", {
    given "I am logged"
    and "I have access to update another user's profile"
    and "I access the Users' profile screen in the Menu"
    and "I push the 'Search' button"
    and "I search for the 'User' who I wanna update"
    and "I load the 'User' profile who I wanna update"
    when "I push the 'Update' button"
    and "I update some field"
    and "I push the 'Save' button"
    then "I should see ''User' updated with sucess!'"
}

scenario "User have no acsess to update another user's profile", {
    given "I am logged"
    and "I access the Users' profile screen in the Menu"
    and "I push the 'Search' button"
    and "I search for the 'User' who I wanna update"
    when "I load the 'User' profile who I wanna update"
    then "I should not see the 'Update' button"
}

scenario "User have access to delete his user's profile", {
    given "I am logged"
    and "I have access to delete my profile"
    and "I access the Users' profile screen in the Menu"
    when "I push the 'Delete' button"
    and "I push the 'Yes' button in the 'Have you sure?' prompt dialog"
    then "I should see ''User' has been removed from the system!'"
}

scenario "User have no access to delete his user's profile", {
    given "I am logged"
    when "I access the Users' profile screen in the Menu"
    then "I should not see the 'Delete' button"
}

scenario "User have access to delete another user's profile", {
    given "I am logged"
    and "I have access to delete another user's profile"
    and "I access the Users' profile screen in the Menu"
    and "I push the 'Search' button"
    and "I search for the 'User' who I wanna delete"
    and "I load the 'User' profile who I wanna delete"
    when "I push the 'Delete' button"
    and "I push the 'Yes' button in the 'Have you sure?' prompt dialog"
    then "I should see ''User' has been removed from the system!'"
}

scenario "User have no access to delete another user's profile", {
    given "I am logged"
    and "I access the Users' profile screen in the Menu"
    and "I push the 'Search' button"
    and "I search for the 'User' who I wanna delete"
    when "I load 'User' the profile who I wanna delete"
    then "I should not see the 'Delete' button"
}
