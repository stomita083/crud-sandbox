package com.sora.data.crudsandbox.domain

import com.sora.data.crudsandbox.domain.generated.tables.Member
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import com.sora.data.crudsandbox.domain.generated.tables.Team as TeamDb
import com.sora.data.crudsandbox.domain.generated.tables.pojos.Team as TeamVo

@Repository
@Transactional
class TeamRepository(private val dslContext: DSLContext) {

    val teamDb: TeamDb = TeamDb.TEAM
    val memberDb: Member = Member.MEMBER

    fun findAll(): List<Team> {
        val selected: List<TeamVo> = dslContext
            .select(teamDb.TEAM_ID, teamDb.NAME, teamDb.TYPE, teamDb.VERSION)
            .from(teamDb)
            .join(memberDb).on(memberDb.TEAM_ID.eq(teamDb.TEAM_ID))
            .fetchInto(TeamVo::class.java)

        return selected
            .map { teamVo: TeamVo ->
                Team(
                    teamVo.teamId,
                    teamVo.name,
                    teamVo.type,
                    teamVo.version
                )
            }
            .toList()
    }
}