package com.sora.data.crudsandbox.domain

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.relational.core.mapping.MappedCollection
import java.io.Serializable
import javax.validation.constraints.NotNull

@Data
data class Team(

    @Id
    val teamId: Long? = null,

    val name: String,

    val type: String,

    @Version @NotNull val version: Int = 0

) : Serializable {
    
    @MappedCollection(idColumn="team_id", keyColumn="team_id")
    var members: MutableList<Member> = mutableListOf()
}