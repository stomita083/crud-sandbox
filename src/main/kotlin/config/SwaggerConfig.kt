package com.sora.data.crudsandbox.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.Tag
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.DocExpansion
import springfox.documentation.swagger.web.UiConfiguration
import springfox.documentation.swagger.web.UiConfigurationBuilder
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@Configuration
class SwaggerConfig {

    companion object {
        const val TAG_TEAM = "Team"
        const val TAG_MEMBER = "Member"
    }

    /**
     * SpringFox の設定
     *
     * @return Docket
     */
    @Bean
    fun docket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(
                ApiInfoBuilder()
                    .title("CRUD sandbox")
                    .description("sandbox of CRUD API")
                    .version("1.0")
                    .build()
            )
            .consumes(setOf("application/json"))
            .produces(setOf("application/json"))
            .tags(
                Tag(TAG_TEAM, "チーム", 1),
                Tag(TAG_MEMBER, "メンバー", 2),
            )
            .useDefaultResponseMessages(false)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.sora.data.crudsandbox.controller"))
            .build()
    }

    /**
     * SpringFoxの Swagger UI の設定
     *
     * @return UiConfiguration
     */
    @Bean
    fun uiConfig(): UiConfiguration =
        UiConfigurationBuilder.builder().deepLinking(true)
            .docExpansion(DocExpansion.LIST)
            .build()

//    /**
//     * 重複したクラス名をSwaggerで別々の名称に分ける。
//     *
//     *
//     * 例：settlement.user => settlementUser,contract.user => contractUser
//     */
//    @Bean
//    fun userModelNameProvider(): UserModelNameProvider? = UserModelNameProvider()
}