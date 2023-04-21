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
					jiraPassword = "ATATT3xFfGF0MA9Qvtdyr6sl9t-K9Me_vV-xUJXF6oK_7lhGoWfQ2b-0dUMdstou9rdQLx8xbAwzJXHWGJfSkq6zzoSQHBBydX4PFZCYyuipjgkFiUB05YJ9TgybNg0tPFPmVnig42fE5mjisuEtgtNsT9Pp5glGrxTxrfK7Cy-e5UQbTysFJ2c=27CAB760"

                    updateData = new groovy.json.JsonBuilder([
                        fields: [
                            summary: "Updated issue summary",
                            description: "Updated issue description",
                            customfield_10000: "Updated custom field value"
                        ]
                    ]).toString()

                    response = httpRequest(
                        url: jiraEndpoint,
                        authentication: 'Jenkins-jira',
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