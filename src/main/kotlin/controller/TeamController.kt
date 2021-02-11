package com.sora.data.crudsandbox.controller

import com.sora.data.crudsandbox.domain.Team
import com.sora.data.crudsandbox.domain.TeamRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/teams")
class TeamController(private val teamRepository: TeamRepository) {

    companion object {
        private val log = org.slf4j.LoggerFactory.getLogger(this::class.java.enclosingClass)!!
    }

    @GetMapping
    fun list(
    ): List<Team> {
        return teamRepository.findAll()
    }

    @GetMapping("/{teamId}")
    fun get(
        @PathVariable teamId: Long
    ): Team {
        return teamRepository.findById(teamId).orElseThrow()
    }
}