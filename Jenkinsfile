import groovy.json.JsonSlurper

pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('JiraUpdate') {
           	def issueKey = "CAL-13" // replace with the actual issue key
			def jiraUrl = "https://kalyani0908.atlassian.net/rest/api/latest/issue/$issueKey"
			
			def auth = "kalyanis.0908@gmail.com:ATATT3xFfGF0CM0BORP6gV4mdQ83KeAI63iwjH9AGAmUHOTjQTAVM_k0CvkV6vE945KtX7eYCVbsL9uKS9CwqWnEoqkqfvjkvsQlj_KGQwS7VCff4A6Yv_UIsphOEi7H1GTEIabB47Aar3dtsSte7rdI-wGHW7q6FljguYWGI6eTSpiTH1SkSfM=9DF9191A".bytes.encodeBase64() // replace with your Jira credentials
			def headers = [
			    'Authorization': "Basic $auth",
			    'Content-Type': 'application/json'
			]
			
			// Get the current issue data
			def currentIssueData = httpRequest(url: jiraUrl, headers: headers, acceptType: 'APPLICATION_JSON')
			def currentIssueJson = new JsonSlurper().parseText(currentIssueData.content)
			
			// Update the issue data
			def newIssueData = currentIssueJson.clone()
			newIssueData.fields.customfield_10038 = "Pass=10 Fail=7" // replace with the appropriate custom field ID and value
			
			// Update the issue in Jira
			httpRequest(url: jiraUrl, httpMode: 'PUT', headers: headers, acceptType: 'APPLICATION_JSON', requestBody: JsonOutput.toJson(newIssueData))
            
        }
    }
}
