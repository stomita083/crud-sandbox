package com.sora.data.crudsandbox.domain

import java.io.Serializable
import javax.persistence.*

@Entity
data class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberId: Long,

    val firstName: String,

    val lastName: String,

    //@ManyToOne
    //@JoinColumn(name = "teamId", referencedColumnName = "teamId")
    //val team: Team,
    val teamId: Long,

    @Version
    val version: Int
) : Serializable {
}