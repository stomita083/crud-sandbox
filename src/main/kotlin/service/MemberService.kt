package com.sora.data.crudsandbox.service

import com.sora.data.crudsandbox.controller.CreateMemberRequest
import com.sora.data.crudsandbox.domain.Member
import com.sora.data.crudsandbox.domain.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val teamService: TeamService
) {

    companion object {
        private val log = org.slf4j.LoggerFactory.getLogger(this::class.java.enclosingClass)!!
    }

    fun list(
    ): List<Member> {
        return memberRepository.findAll()
    }

    fun get(memberId: Long): Member {
        //return memberRepository.findById(memberId).orElseThrow()
        // TODO
        return Member(null, "", "", 1, 0)
    }

    fun create(request: CreateMemberRequest): Member {

        if (!teamService.exists(request.teamId)) {
            log.error("target team is not exists. teamId: ${request.teamId}")
            throw RuntimeException("target team is not exists")
        }

        val member = Member(
            memberId = null,
            firstName = request.firstName,
            lastName = request.lastName,
            teamId = request.teamId
        )
        //return memberRepository.save(member)
        // TODO
        return Member(null, "", "", 1, 0)
    }

    fun delete(memberId: Long) {
        //memberRepository.deleteById(memberId)
        // TODO
    }
}