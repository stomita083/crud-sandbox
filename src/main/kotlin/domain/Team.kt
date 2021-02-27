package com.sora.data.crudsandbox.domain

import lombok.Data
import java.io.Serializable
import javax.validation.constraints.NotNull

@Data
data class Team(
    
    val teamId: Long? = null,

    val name: String,

    val type: String,
    
    @NotNull val version: Int = 0

) : Serializable {
    
    var members: MutableList<Member> = mutableListOf()
}