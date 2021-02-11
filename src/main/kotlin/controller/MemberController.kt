package com.sora.data.crudsandbox.controller

import com.sora.data.crudsandbox.domain.Member
import com.sora.data.crudsandbox.domain.MemberRepository
import com.sora.data.crudsandbox.domain.Team
import com.sora.data.crudsandbox.domain.TeamRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class MemberController (private val memberRepository: MemberRepository) {

    companion object {
        private val log = org.slf4j.LoggerFactory.getLogger(this::class.java.enclosingClass)!!
    }

    @GetMapping
    fun list(
    ): List<Member> {
        return memberRepository.findAll()
    }

    @GetMapping("/{memberId}")
    fun get(
        @PathVariable memberId: Long
    ): Member {
        return memberRepository.findById(memberId).orElseThrow()
    }
}
