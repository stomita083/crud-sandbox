package com.sora.data.crudsandbox.domain

import lombok.Data
import java.io.Serializable
import javax.validation.constraints.NotNull

@Data
data class Member(
    
    val memberId: Long? = null,

    val firstName: String,

    val lastName: String,

    val teamId: Long,
    
    @NotNull val version: Int = 0

) : Serializable {
}