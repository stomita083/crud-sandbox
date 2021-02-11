package com.sora.data.crudsandbox.domain

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import java.io.Serializable
import javax.validation.constraints.NotNull

@Data
data class Member(

    @Id
    val memberId: Long? = null,

    val firstName: String,

    val lastName: String,

    val teamId: Long,

    @Version @NotNull val version: Int = 0

) : Serializable {
}