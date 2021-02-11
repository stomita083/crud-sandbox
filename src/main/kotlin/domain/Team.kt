package com.sora.data.crudsandbox.domain

import java.io.Serializable
import javax.persistence.*

@Entity
data class Team(
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val teamId: Long,

    val name: String,

    val type: String,

    @Version
    val version: Int = 0
        
) : Serializable {
    
    //@OneToMany(mappedBy = "team", cascade = [CascadeType.ALL])
    @OneToMany(mappedBy = "teamId", cascade = [CascadeType.ALL])
    var members: MutableList<Member> = mutableListOf()
}