package br.com.danilocrabi.forum.service

import br.com.danilocrabi.forum.model.Usuario
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.transaction.annotation.Transactional

@Transactional
class UserDetail(
    private val usuario: Usuario,
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {

        val authorities = ArrayList<SimpleGrantedAuthority>()

        val listAuthorities = usuario.roles;

        System.out.println(listAuthorities);

        for (role in listAuthorities) {
            authorities.add(SimpleGrantedAuthority(role.name))
        }
        return authorities
    }

    override fun getPassword() = usuario.password

    override fun getUsername() = usuario.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

}