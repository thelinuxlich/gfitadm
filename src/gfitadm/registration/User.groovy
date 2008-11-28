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

@Bindable
@Entity(name = "User")
@Table(name = "users")
@NamedQueries(value = [
        @NamedQuery(
            name = "User.findAll",
            query = "SELECT u.login, u.password FROM User u"
        )]
)

class User implements Serializable {
    static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    Integer id;
    @Column(name = "login")
    String login;
    @Column(name = "password")
    String password;
    @Column(name = "person_id")
    Integer person_id;
    @Column(name = "level_id")
    Integer level_id;

    def save() {
        
        if (
            login != "" &
            login ==~ /[a-zA-Z]/ &
            login?.length() >= 4 &
            login?.length() <= 15 &
            password != "" &
            password ==~ /[a-zA-Z0-9]/ &
            password?.length() >= 6 &
            password?.length() <= 12 &
            person_id != null &
            person_id != 0 &
            level_id != null &
            level_id != 0
        ) {
            try {
                persist(this)
                return true
            } catch (Exception e) {
                return false
                pritnln "ERROR: " + e.toString() + "\nmessage: " + e.getMessage()
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
