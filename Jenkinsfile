
node {
    def linkProductRepo = true
    def repoBase = 'https://github.com/Guite/'
    def projectName = 'MostHelp'
    def repoUrl = repoBase + projectName + '/'
    def downstreamJobs = 'MOST-1_Prepare-9_Locales'

    try {
        stage 'Init'
        def builder, postprocessor
        fileLoader.withGit("${repoBase}MostProduct.git", 'master', 'c568f590-e3fe-4732-9e5c-68ebc55b849e') {
            builder = fileLoader.load('vars/builder');
            postprocessor = fileLoader.load('vars/postbuild');
        }

        stage 'Checkout'
        builder.init(projectName, repoUrl, linkProductRepo)

        stage 'Build'
        builder.startMaven()

        stage 'Post-build'
        postprocessor.finish(repoUrl, downstreamJobs);

    } catch (exception) {
        builder.handleError(repoUrl)

        throw exception
    } finally {
        postprocessor.finalise()
    }
}
