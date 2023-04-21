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
					jiraPassword = "ATATT3xFfGF02ZpDkAJb-A9wy_YVd8nz6NS1-0pUp1bq9IGd4tB0sqn1fYnDHRwJOyXC9mbF8vPl0C1-Ckvw4N6JFlA6hx-1hGLf_E7JU0btNfrg5PkknmuCnewrX18jkixjZ2uDvo2hTPHHSzbE1-mDdIZ0o2dLX3GElb4DDtS2whdJqeSb2Lo=B418C67A"

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