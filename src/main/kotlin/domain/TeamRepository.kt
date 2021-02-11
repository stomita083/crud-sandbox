package com.sora.data.crudsandbox.domain

import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import com.sora.data.crudsandbox.domain.generated.tables.Team as TeamDb
import com.sora.data.crudsandbox.domain.generated.tables.pojos.Team as TeamVo

@Repository
@Transactional
class TeamRepository(private val dslContext: DSLContext) {

    val teamDb: TeamDb = TeamDb.TEAM

    fun findAll(): List<Team> {
        val selected: List<TeamVo> = dslContext
            .select()
            .from(teamDb)
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