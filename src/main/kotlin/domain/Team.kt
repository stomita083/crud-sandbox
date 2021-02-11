package com.sora.data.crudsandbox.domain

import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class Team(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val teamId: Long? = null,

    val name: String,

    val type: String,

    @Version @NotNull val version: Int = 0

) : Serializable {

    @OneToMany(mappedBy = "teamId", cascade = [CascadeType.ALL])
    var members: MutableList<Member> = mutableListOf()
}