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
                    def jiraEndpoint = "https://kalyani0908.atlassian.net/rest/api/2/issue/CAL-13"
					def jiraUsername = "kalyanis.0908@gmail.com"
					def jiraPassword = "ATATT3xFfGF0LG8ecCK2xnUs9E7cxmNLDfkDhOs-yprnNePDWNHwmkbvkjss4fVinGIvG1ZlqfA6gOU-sNdxQIKhr2xlTPn645MI1UNYPXlNA5weVOutgA8TbIMhQRqX0rTmU0wYltkRxPC-PkMVbrjJut-j-kcwm1Yzdzam6iRyeWrHLLorQuk=56065233"

                    def updateData = new groovy.json.JsonBuilder([
                        fields: [
                            summary: "Updated issue summary",
                            description: "Updated issue description",
                            customfield_10000: "Updated custom field value"
                        ]
                    ]).toString()

                    def response = httpRequest(
                        url: jiraEndpoint,
                        authentication: "${jiraUsername}:${jiraPassword}",
                        contentType: 'APPLICATION_JSON',
                        customHeaders: [[name: 'Authorization', value: 'Basic ' + "${jiraUsername}:${jiraPassword}".bytes.encodeBase64().toString()]],
                        requestBody: updateData,
                        httpMode: 'PUT'
                    )

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