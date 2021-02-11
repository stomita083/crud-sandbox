package com.sora.data.crudsandbox.domain

import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import com.sora.data.crudsandbox.domain.generated.tables.Member as MemberDb
import com.sora.data.crudsandbox.domain.generated.tables.pojos.Member as MemberVo

@Repository
@Transactional
class MemberRepository(private val dslContext: DSLContext) {

    val memberDb: MemberDb = MemberDb.MEMBER

    fun findAll(): List<Member> {
        val selected: List<MemberVo> = dslContext
            .select()
            .from(memberDb)
            .fetchInto(MemberVo::class.java)

        return selected
            .map { memberVo: MemberVo ->
                Member(
                    memberVo.memberId,
                    memberVo.firstName,
                    memberVo.lastName,
                    memberVo.teamId,
                    memberVo.version
                )
            }
            .toList()
    }
}