
node {
    def linkProductRepo = true
    def projectName = 'MostHelp'
    def repoUrl = "https://github.com/Guite/${projectName}/"
    def downstreamJobs = 'MOST-1_Prepare-9_Locales'

    // Set properties
    properties [
        pipelineTriggers([]),
        disableConcurrentBuilds(),
        [$class: 'GithubProjectProperty', displayName: projectName, projectUrlStr: repoUrl]
    ]

    try {
        stage 'Checkout'
        start(repoUrl, linkProductRepo)

        stage 'Build'
        startMaven()

        stage 'Post-build'
        postBuildProcessing(repoUrl, downstreamJobs);

    } catch (exception) {
        handleError(repoUrl)

        throw exception
    } finally {
        finalise()
    }
}
