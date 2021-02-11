package com.sora.data.crudsandbox.service

import com.sora.data.crudsandbox.controller.CreateTeamRequest
import com.sora.data.crudsandbox.domain.Team
import com.sora.data.crudsandbox.domain.TeamRepository
import org.springframework.stereotype.Service

@Service
class TeamService(private val teamRepository: TeamRepository) {

    companion object {
        private val log = org.slf4j.LoggerFactory.getLogger(this::class.java.enclosingClass)!!
    }

    fun list(
    ): List<Team> {
        return teamRepository.findAll()
    }

    fun get(teamId: Long): Team {
        log.info("add team with teamId: $teamId")
        //return teamRepository.findById(teamId).orElseThrow()
        // TODO
        return Team(null, "", "", 0)
    }
    
    fun exists(teamId: Long): Boolean {
        //return teamRepository.existsById(teamId)
        // TODO
        return true
    }

    fun create(request: CreateTeamRequest): Team {
        val team = Team(
            teamId = null,
            name = request.name,
            type = request.type
        )
        //return teamRepository.save(team)
        // TODO
        return Team(null, "", "", 0)
    }

    fun delete(teamId: Long) {
        //return teamRepository.deleteById(teamId)
        // TODO
    }
}