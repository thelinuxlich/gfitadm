package gfitadm.unit_tests.registration

/**
 *
 * @author redpill
 */
import gfitadm.registration.User
import javax.persistence.NamedQuery
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

def test_user

before "create a test user for each spec", {
    test_user = new User(login:"user",password:"123456",person_id:1,level_id:1)
}

it "should save if all validations passed", {
    test_user.save().shouldBe true
    def manager = Persistence.createEntityManagerFactory("gfitadmpu").createEntityManager()
    def userQuery = manager.createNamedQuery("User.findByLogin").setParameter("login","user")
    def userList = userQuery.getResultList()
    userList.size().shouldBe 1
}

// Login specs
it "should require a login", {
    test_user.login = ""
    test_user.save().shouldBe false
}

it "should require a unique login", {
    test_user.save()
    test_user.save().shouldBe false
}

it "should require a login fill with letters (Upper and Lower cases) only", {
    test_user.login = "user12"
    test_user.save().shouldBe false

    test_user.login = "user@#@"
    test_user.save().shouldBe false
}

it "should require a login with 4 letters or more", {
    test_user.login = "us"
    test_user.save().shouldBe false
}

it "should require a login with 15 letters or less", {
    test_user.login = "areallybiguserlogin"
    test_user.save().shouldBe false
}

// Password specs
it "should require a password", {
    test_user.password = ""
    test_user.save().shouldBe false
}

it """should require a password fill with
    letters (Upper and Lower cases) and numbers only""",
{
    test_user.password = "pass@#@"
    test_user.save().shouldBe false
}

it "should require a password with 6 letters or more", {
    test_user.password = "pass"
    test_user.save().shouldBe false
}

it "should require a password with 12 letters or less", {
    test_user.login = "areallybigopassword"
    test_user.save().shouldBe false
}

// Person specs
it "should require a person_id", {
    test_user.person_id = null
    test_user.save().shouldBe false
}

it "should require a unique person_id", {
    test_user.save()
    test_user.save().shouldBe false
}

// Level specs
it "should require a level_id", {
    test_user.level_id = null
    test_user.save().shouldBe false
}
