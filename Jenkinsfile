import groovy.json.JsonSlurper
@NonCPS
	def jiraCall(){
		issueKey = "CAL-13" // replace with the actual issue key
   	 	jiraUrl = "https://kalyani0908.atlassian.net/rest/api/2/issue/$issueKey"				
		auth = "kalyanis.0908@gmail.com:ATATT3xFfGF0LG8ecCK2xnUs9E7cxmNLDfkDhOs-yprnNePDWNHwmkbvkjss4fVinGIvG1ZlqfA6gOU-sNdxQIKhr2xlTPn645MI1UNYPXlNA5weVOutgA8TbIMhQRqX0rTmU0wYltkRxPC-PkMVbrjJut-j-kcwm1Yzdzam6iRyeWrHLLorQuk=56065233".bytes.encodeBase64() // replace with your Jira credentials
		headers = [
		    'Authorization': "Basic $auth",
		    'Content-Type': 'application/json'
		]
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
