# sonar-slack-pusher
Jenkins plugin for pushing Sonar quality gate statuses to a given Slack channel.

The plugin runs as a post build action and runs no matter the outcome of the job. The plugin makes an API request to
a Sonar server instance to get all the metrics for a given job. If the sonar job has a quality gate defined and
linked to the project all the check given checks will be reported back if they 'fail'.

For a failed code coverage check it looks like this:

**Sonar job**

**Job:** _My project_

**Branch:** _master_

**DANGER**

**Quality gate:** _coverage_

**Reason:** _Coverage < 60_

**Value:** _29.0%_


### Configuration

Parameter | Usage | Examples
--------------- | -------------------------- | --------
Slack hook|This is the hook into a given channel and it is generated by the Slack incoming Webhook extension. Just paste the full URL here.|https://hooks.slack.com/services/12/34/56
Sonar root URL|This is the root of the remote Sonar installation. The URL is the base for the metrics query and linkage to jobs.|sonar.mycompany.com:9000
Sonar job name|The name the project has in Sonar, usually project name followed by the branch name, '<job name> <branch'.|'super-awesome-service bugfixBranch'

### Supported metrics

The following metrics are supported in the notification.

* qi-quality-index
* coverage
* test_success_density
* blocker_violations
* critical_violations