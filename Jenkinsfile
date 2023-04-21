import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPut
import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils

pipeline {
    agent any

    stages {
        stage('Update JIRA Issue') {
            steps {
                script {
                    jiraEndpoint = "https://kalyani0908.atlassian.net/rest/api/2/issue/CAL-13"
					jiraUsername = "kalyanis.0908@gmail.com"
					jiraPassword = "ATATT3xFfGF0oEqY7UiljCHdCt4RX_fmft5Nbb6FROTiQ7SmldGNA_3gbm5btrbumsOjDrND-AlRR1fpCuduL0W4RaDFQN4o0lmlIwosErfbyCbW5_sgreUmkXDw6R8flO3PffHGWne2AFmItFwb4BY-bc5asv_FVA6tJNZ35dWXxbTg5Tw_RK8=53201FFE"

                    updateData = new groovy.json.JsonBuilder([
                        fields: [
                            summary: "Updated issue summary",
                            description: "Updated issue description",
                            customfield_10000: "Updated custom field value"
                        ]
                    ]).toString()

                    response = httpRequest(
                        url: jiraEndpoint,
                        authentication: "${jiraUsername}:${jiraPassword}",
                        contentType: 'APPLICATION_JSON',
                        customHeaders: [[name: 'Authorization', value: 'Basic ' + "${jiraUsername}:${jiraPassword}".bytes.encodeBase64().toString()]],
                        requestBody: updateData,
                        httpMode: 'PUT'
                    ).trustAllCertificates()

                    if (response.status == 204) {
                        println("JIRA issue ${response.contentAsString} successfully updated.")
                    } else {
                        println("Failed to update JIRA issue: ${response.status} - ${response.contentAsString}")
                    }
                }
            }
        }
    }
}