package com.sora.data.crudsandbox.controller

import com.sora.data.crudsandbox.config.SwaggerConfig
import com.sora.data.crudsandbox.domain.Member
import com.sora.data.crudsandbox.domain.MemberRepository
import com.sora.data.crudsandbox.service.MemberService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/members")
@Api(tags = [SwaggerConfig.TAG_MEMBER])
class MemberController(private val memberService: MemberService) {

    companion object {
        private val log = org.slf4j.LoggerFactory.getLogger(this::class.java.enclosingClass)!!
    }

    @GetMapping
    fun list(
    ): List<Member> {
        return memberService.list()
    }

    @GetMapping("/{memberId}")
    fun get(
        @PathVariable memberId: Long
    ): Member {
        return memberService.get(memberId)
    }

    @PostMapping
    fun create(@Valid @RequestBody request: CreateMemberRequest): Member {
        log.info("member create request: $request")
        return memberService.create(request)
    }

    @DeleteMapping("/{memberId}")
    fun delete(@PathVariable memberId: Long) {
        log.info("delete member by memberId: $memberId")
        return memberService.delete(memberId)
    }
}

@ApiModel(description = "メンバー作成リクエスト")
data class CreateMemberRequest(

    @ApiModelProperty(position = 1, value = "姓", required = true)
    @get:NotBlank
    @get:Size(max = 50)
    val firstName: String,

    @ApiModelProperty(position = 2, value = "名", required = true)
    @get:NotBlank
    @get:Size(max = 50)
    val lastName: String,

    @ApiModelProperty(position = 3, value = "チームID", required = true)
    @get:NotNull
    val teamId: Long,
)

