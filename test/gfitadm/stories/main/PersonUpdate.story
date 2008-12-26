/**
 *
 * @author redpill
 */
narrative "Person's update", {
    as_a "Common user"
    i_want "To update a person's profile"
    so_that "I can update a person's profile"
}

scenario "User have access to update his person's profile", {
    given "I am logged"
    and "I have access to update my person's profile"
    and "I access the People's profile screen in the Menu"
    when "I push the 'Update' button"
    and "I update some field"
    and "I push the 'Save' button"
    then "I should see ''Person' updated with sucess!'"
}

scenario "User have no acsess to update his person's profile", {
    given "I am logged"
    when "I access the People's profile screen in the Menu"
    then "I should not see the 'Update' button"
}

scenario "User have access to update another person's profile", {
    given "I am logged"
    and "I have access to update another person's profile"
    and "I access the People's profile screen in the Menu"
    and "I push the 'Search' button"
    and "I search for the 'Person' who I wanna update"
    and "I load the 'Person' profile who I wanna update"
    when "I push the 'Update' button"
    and "I update some field"
    and "I push the 'Save' button"
    then "I should see ''Person' updated with sucess!'"
}

scenario "User have no acsess to update another person's profile", {
    given "I am logged"
    and "I access the People's profile screen in the Menu"
    and "I push the 'Search' button"
    and "I search for the 'Person' who I wanna update"
    when "I load the 'Person' profile who I wanna update"
    then "I should not see the 'Update' button"
}

scenario "User have access to delete his person's profile", {
    given "I am logged"
    and "I have access to delete my person's profile"
    and "I access the People's profile screen in the Menu"
    when "I push the 'Delete' button"
    and "I push the 'Yes' button in the 'Have you sure?' prompt dialog"
    then "I should see ''Person' has been removed from the system!'"
}

scenario "User have no access to delete his person's profile", {
    given "I am logged"
    when "I access the People's profile screen in the Menu"
    then "I should not see the 'Delete' button"
}

scenario "User have access to delete another person's profile", {
    given "I am logged"
    and "I have access to delete another person's profile"
    and "I access the People's profile screen in the Menu"
    and "I push the 'Search' button"
    and "I search for the 'Person' who I wanna delete"
    and "I load the 'Person' profile who I wanna delete"
    when "I push the 'Delete' button"
    and "I push the 'Yes' button in the 'Have you sure?' prompt dialog"
    then "I should see ''Person' has been removed from the system!'"
}

scenario "User have no access to delete another person's profile", {
    given "I am logged"
    and "I access the People's profile screen in the Menu"
    and "I push the 'Search' button"
    and "I search for the 'Person' who I wanna delete"
    when "I load the 'Person' profile who I wanna delete"
    then "I should not see the 'Delete' button"
}
