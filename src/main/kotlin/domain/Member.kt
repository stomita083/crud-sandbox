package com.sora.data.crudsandbox.domain

import lombok.Data
import java.io.Serializable
import javax.validation.constraints.NotNull

@Data
//@Entity
data class Member(

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberId: Long? = null,

    val firstName: String,

    val lastName: String,

    val teamId: Long,

    //@Version
    @NotNull val version: Int = 0

) : Serializable {
}