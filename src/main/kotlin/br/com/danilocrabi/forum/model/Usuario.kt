package br.com.danilocrabi.forum.model

import javax.persistence.*

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val email: String,
    val password: String,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_roles",
        joinColumns = [JoinColumn(name = "usuario_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "roles_id", referencedColumnName = "id")]
    )
    val roles: List<Roles>
)
