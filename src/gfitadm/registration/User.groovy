package gfitadm.registration

/**
 *
 * @author thelinuxlich
 */
import java.io.Serializable
import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table
import groovy.beans.Bindable
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence


@Entity(name = "User")
@Table(name = "users")
@NamedQueries(value = [
        @NamedQuery(
            name = "User.findAll",
            query = "SELECT u.id, u.login, u.password, u.level_id, u.person_id FROM User u"
        ),
        @NamedQuery(
            name = "User.findByLogin",
            query = "SELECT u.id, u.login, u.password, u.level_id, u.person_id, u.level_id FROM User u WHERE u.login = :login"
        )]
)

class User implements Serializable {
    //static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    Integer id
    @Column(name = "login")
    String login
    @Column(name = "password")
    String password
    @Column(name = "person_id")
    Integer person_id
    @Column(name = "level_id")
    Integer level_id

    def save() {
        if (
            login != "" &&
            login ==~ /\w+/ &&
            (4..15).contains(login?.length()) &&
            password != "" &&
            password ==~ /\w+\d+/ &&
            (6..12).contains(password?.length()) &&
            person_id != null &&
            level_id != null
        ) {
            try {
                persist(this)
                return true
            } catch (Exception e) {
                return false
                println "ERROR: " + e.toString() + "\nmessage: " + e.getMessage()
            }
        } else {
            return false
        }
    }

    def private persist(object) {
        def emf = Persistence.createEntityManagerFactory("gfitadmpu")
        def em = emf.createEntityManager()
        em.getTransaction().begin()
        try {
            em.persist(object)
            em.getTransaction().commit()
        } catch (Exception e) {
            e.printStackTrace()
            em.getTransaction().rollback()
        } finally {
            em.close()
        }
    }
}
