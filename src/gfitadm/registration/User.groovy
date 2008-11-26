/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gfitadm.registration

import java.io.Serializable
import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table
import groovy.beans.Bindable
/**
 *
 * @author alisson
 */

@Bindable
@Entity(name = "User")
@Table(name = "users")
@NamedQueries(value = [
        @NamedQuery(name = "User.findAll", query = "SELECT u.login,u.password FROM User u")
])
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
}
