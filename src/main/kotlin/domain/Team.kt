package com.sora.data.crudsandbox.domain

import lombok.Data
import java.io.Serializable
import javax.validation.constraints.NotNull

@Data
data class Team(

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val teamId: Long? = null,

    val name: String,

    val type: String,

    //@Version 
    @NotNull val version: Int = 0

) : Serializable {

    //@OneToMany(mappedBy = "teamId", cascade = [CascadeType.ALL])
    var members: MutableList<Member> = mutableListOf()
}