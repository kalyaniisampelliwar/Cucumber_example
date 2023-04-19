import groovy.json.JsonSlurper
@NonCPS
	def jiraCall(){
		issueKey = "CAL-13" // replace with the actual issue key
   	 	jiraUrl = "https://kalyani0908.atlassian.net/rest/api/latest/issue/$issueKey"				
		headers = [
		    'Content-Type': 'application/json'
		]
		
		// Get the current issue data
 		currentIssueData = httpRequest(url: jiraUrl, acceptType: 'APPLICATION_JSON', validResponseCodes: '200:404')
		currentIssueJson = new JsonSlurper().parseText(currentIssueData.content)
		
		// Update the issue data
	 	newIssueData = currentIssueJson.clone()
		newIssueData.fields.customfield_10038 = "Pass=10 Fail=7" // replace with the appropriate custom field ID and value
		
		// Update the issue in Jira
		httpRequest(url: jiraUrl, httpMethod: 'PUT', headers: headers, acceptType: 'APPLICATION_JSON', requestBody: JsonOutput.toJson(newIssueData), validResponseCodes: '200:404')
	}
	pipeline {
	    agent any
	    stages {
	        stage('Hello') {
	            steps {
	                echo 'Hello World'
	            }
	        }
	        stage('JiraUpdate') {
	            steps {            	
	            	script{            
	               		jiraCall()
		            }
	            }
	        }
	    }
	}
