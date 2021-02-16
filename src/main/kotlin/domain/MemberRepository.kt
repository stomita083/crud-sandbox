package com.sora.data.crudsandbox.domain

import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import com.sora.data.crudsandbox.domain.generated.tables.Member as MemberDb

@Repository
@Transactional
class MemberRepository(private val dslContext: DSLContext) {

    val memberDb: MemberDb = MemberDb.MEMBER

    fun findAll(): List<Member> {
        return dslContext
            .select()
            .from(memberDb)
            .fetchInto(Member::class.java)
    }
}