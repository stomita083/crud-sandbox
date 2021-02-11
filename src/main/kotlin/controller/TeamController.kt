package com.sora.data.crudsandbox.controller

import com.sora.data.crudsandbox.config.SwaggerConfig
import com.sora.data.crudsandbox.domain.Team
import com.sora.data.crudsandbox.service.TeamService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/teams")
@Api(tags = [SwaggerConfig.TAG_TEAM])
class TeamController(private val teamService: TeamService) {

    companion object {
        private val log = org.slf4j.LoggerFactory.getLogger(this::class.java.enclosingClass)!!
    }

    @GetMapping
    fun list(
    ): List<Team> {
        return teamService.list()
    }

    @GetMapping("/{teamId}")
    fun get(
        @PathVariable teamId: Long
    ): Team {
        log.info("add team with teamId: $teamId")
        return teamService.get(teamId)
    }

    @PostMapping
    fun create(@RequestBody request: CreateTeamRequest): Team {
        log.info("crate team request: $request")
        return teamService.create(request)
    }

    @DeleteMapping("/{teamId}")
    fun delete(@PathVariable teamId: Long) {
        log.info("delete team by teamId: $teamId")
        return teamService.delete(teamId)
    }
}

@ApiModel(description = "チーム作成リクエスト")
data class CreateTeamRequest(

    @ApiModelProperty(position = 1, value = "チーム名", required = true)
    @get:NotBlank
    @get:Size(max = 50)
    val name: String,

    @ApiModelProperty(position = 2, value = "チームタイプ", required = true)
    @get:NotNull
    @get:Size(max = 20)
    val type: String,
)