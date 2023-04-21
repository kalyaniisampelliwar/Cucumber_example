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
					jiraPassword = "ATATT3xFfGF0PX25SoY4YQpEBJy7kBOxJKtcjf07DygQYirRbDY0sO5fK8OK1KoKKK1rztql5vv4uv-xbKyLP8MoZpnYW6hxnhhWopcIuV_IkibT1ciyDWMPJpzcMrMartm4Bn_kEb_4xZIbIO7_Ml6OQA9kQR7qaDgiGKN8TWzaRq0ndylS9tc=D884BE3B"

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