
node {
    def linkProductRepo = true
    def repoBase = 'https://github.com/Guite/'
    def projectName = 'MostHelp'
    def repoUrl = repoBase + projectName + '/'
    def downstreamJobs = 'MOST-1_Prepare-9_Locales'

    def builder, postProcessor
    stage 'Init'
    fileLoader.withGit("${repoBase}MostProduct.git", 'master', 'c568f590-e3fe-4732-9e5c-68ebc55b849e') {
        builder = fileLoader.load('vars/builder')
        postProcessor = fileLoader.load('vars/postBuild')
    }

    try {
        stage 'Checkout'
        builder.init(projectName, repoUrl, linkProductRepo)

        stage 'Build'
        builder.startMaven()

        stage 'Post-build'
        postProcessor.finish(repoUrl, downstreamJobs);

    } catch (exception) {
        builder.handleError(repoUrl)

        throw exception
    } finally {
        postProcessor.finalise()
    }
}
