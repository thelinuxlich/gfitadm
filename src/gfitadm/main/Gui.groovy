package gfitadm.main

/**
 *
 * @author thelinuxlich
 */
import net.miginfocom.swing.MigLayout
import groovy.swing.SwingBuilder
import javax.swing.WindowConstants as WC
import javax.persistence.NamedQuery
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence
import gfitadm.registration.User

class Gui {

    static void main(args) {
        def manager = Persistence.createEntityManagerFactory("gfitadmpu").createEntityManager()
        def userQuery = manager.createNamedQuery("User.findAll")
        def userlist = []

        userQuery.getResultList().each { userlist << [login:it[1],password:it[2]]}

        SwingBuilder.build {
            frame(
                title: "Teste com o modelo User",
                pack: true,
                show: true,
                defaultCloseOperation:WC.EXIT_ON_CLOSE) 
            {
                panel(layout: new MigLayout('fill')) {
                    label(text:'Listando usuários...')
                    scrollPane {
                        table() {
                            tableModel(list: userlist) {
                                propertyColumn(header:'Login', propertyName:'login')
                                propertyColumn(header:'Senha', propertyName:'password')
                            }
                        }
                    }
                }
            }
        }
    }
}
