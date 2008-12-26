package gfitadm.registration

/**
 *
 * @author thelinuxlich
 */
import java.io.Serializable
import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
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
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id
    @Column(name = "login", nullable = false)
    String login
    @Column(name = "password", nullable = false)
    String password
    @Column(name = "person_id", nullable = false)
    Integer person_id
    @Column(name = "level_id", nullable = false)
    Integer level_id

    def save() {
        if (
            login ==~ /[a-zA-Z]{4,15}/ &&
            password ==~ /[a-zA-Z0-9]{6,12}/ &&
            person_id && level_id
        ) {
            try {
                persist(this)
                return true
            } catch (Exception e) {
                println "ERROR: " + e.toString() + "\nmessage: " + e.getMessage()
                return false
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
