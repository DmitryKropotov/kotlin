package kotlinn.application.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
@PropertySource("classpath:db.properties")
open class DataSourceConfig {

    @Value("\${url}")
    private val url: String? = null
    @Value("\${usernam}")
    private val username: String? = null
    @Value("\${password}")
    private val password: String? = null
    @Value("\${driverClassName}")
    private val driverClassName: String? = null

    @Bean
    open fun dataSource(): DataSource? {
        val dataSource = DriverManagerDataSource()

        dataSource.setDriverClassName(driverClassName)
        dataSource.username = username
        dataSource.password = password
        dataSource.url = url

        return dataSource
    }

}