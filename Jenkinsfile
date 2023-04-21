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
import groovyx.net.http.HTTPBuilder

pipeline {
    agent any

    stages {
        stage('Update JIRA Issue') {
            steps {
                script {
                    def jiraEndpoint = "https://kalyani0908.atlassian.net/rest/api/2/issue/CAL-13"
					def jiraUsername = "kalyanis.0908@gmail.com"
					def jiraPassword = "ATATT3xFfGF0LG8ecCK2xnUs9E7cxmNLDfkDhOs-yprnNePDWNHwmkbvkjss4fVinGIvG1ZlqfA6gOU-sNdxQIKhr2xlTPn645MI1UNYPXlNA5weVOutgA8TbIMhQRqX0rTmU0wYltkRxPC-PkMVbrjJut-j-kcwm1Yzdzam6iRyeWrHLLorQuk=56065233"

                    def updateData = new groovy.json.JsonBuilder([
                        fields: [
                            summary: "Updated issue summary",
                            description: "Updated issue description",
                            customfield_10038: "Updated custom field value"
                        ]
                    ]).toString()

                    def httpClient = new groovy.net.http.HTTPBuilder(jiraEndpoint)
                    httpClient.auth.basic(jiraUsername, jiraPassword)
                    httpClient.request(Method.PUT, ContentType.JSON) {
                        body = updateData
                        response.success = { resp, json ->
                            println("JIRA issue ${json.key} successfully updated.")
                        }
                        response.failure = { resp ->
                            println("Failed to update JIRA issue: ${resp.statusLine.statusCode} - ${resp.statusLine.reasonPhrase}")
                        }
                    }
                }
            }
        }
    }
}