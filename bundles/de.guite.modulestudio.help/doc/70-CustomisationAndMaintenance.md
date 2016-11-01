# Customisation and maintenance

This section gives a few hints for changing arbitrary things in your generated applications while keeping in sync with upcoming releases of Zikula and ModuleStudio.

## How to ensure long-term maintainability

To prevent losing the [benefits of ModuleStudio](10-Introduction.md#benefits) in future you have to follow a few simple basic rules in your development process.

### Keep consistent

When using ModuleStudio then your model is not only some sort of bootstrapping or documentation artifact. The model describes or better **is** the real application. Thus it is important for the sustainable maintenance of an application that the model does not become obsolete. It should always represent the current functionality of the project, otherwise one has to do extra work, later, to return it to a consistent state. This is especially important when one wants to regenerate the code at some later date, for example, when a new generator version introduces bug-fixes, or supports a new Zikula version with improved functionality.

To avoid losing the abstraction of model-driven development all changes to functional project requirements should be applied to the model first. Therefore you should do all important changes (like renaming an entity or other amendments, adding or moving fields, introducing new configuration settings, etc.) on model level although it might look a bit inconvenient first. Do not let your model become obsolete, as this would mean losing lots of advantages. You will thank yourself when generating again with a newer version, because manually migrating applications to a new platform version can be tedious and error-prone.

### Iterative-incremental approach

Developing and maintaining model-driven applications works well in combination with an iterative-incremental development process. In this approach you start with a small model which will then be enhanced in several steps whereby some short tests verify that the direction is correct.

Each development cycle in ModuleStudio consists of the following steps:

1. Create or change the model.
2. Let ModuleStudio validate it and fix problems.
3. Generate (or regenerate) the application source code.
4. Merge changes
5. Test intermediate results
6. Customise the application.

Note ModuleStudio offers several *generator settings* to simplify the merging process. More about that below.

### Use versioning

Using a version control system, like git or svn, gives you another additional level of rollback safety and is a good idea anyway. It also simplifies process for performing tests and doing an automatical deployment (e.g. to a test server). If you are interesting in automating such things, look at CI systems like [Jenkins](https://jenkins.io) or [Travis](https://travis-ci.org/) (there are many more).

## How to handle custom code

### Document your changes

Document your changes to simplify the merging process you will have to do after regeneration. For example after you added some fields later on, or you got a new generator version fixing some bugs, and so on you will want to know again where you did which changes for which reason.

Best practice is to add a [generator settings container](87-GeneratorReference.md#settings-container) to your model. It contains two properties called `skipFiles` and `markFiles` (follow link to get more information) allowing you to specify your amendments inside the model. The generator will then either not generate these files (skip) or create them with a custom file name containing `.generated`.

If you just implemented a child class which was generated empty anyway, you can use `skipFiles`. Personally I use `markFiles` for almost everything, but that's a matter of taste. There is also an additional setting named `generateOnlyBaseClasses` which can be helpful sometimes, too.

### How to merge re-generated files

How this is done best, depends primarily on your personal workflow. But it is more simple than it looks like.

If you documented your changes like shown above you could just copy the new files into your working directory. Afterwards you can search for all marked files (`*.generated.*`) and compare them with the original ones, ensuring that you miss no change.

Before committing the new version you can show the differences using `git diff`. This allows you doing a review before you push the changes into the main repository.

## Where to inject customisation

### Understand the module structure

If you do not know yet how a Zikula module is structured look at the [SpecModule](https://github.com/zikula/SpecModule) which acts as an example module demonstrating the main parts and what they are used for. Remember a Zikula module is a special kind of Symfony bundle, so you might check out [further web resources](89-WebResources.md) to learn more about it.

### Use overriding

All cosmetic enhancements can be done by template overriding in Zikula. The Zikula theme system allows for both theme and system overrides. More information can be found in the [SpecTheme docs](https://github.com/zikula/SpecTheme/#resource-overrides).

So when custom templates are placed outside the module this is fine for development. It is even recommended for the module developer to keep things separated during development (and in Git) so that he can always distinguish (and compare) generated and customised templates, since this makes things easier if the module is regenerated again in future.

When using a module in production things are a bit different. A site owner may want to further customise some templates, so the system-wide resources directory should not be used by the module itself out of the box. This is not really a technical problem, but just a question of how the deployment process should be. You can for example move the overridden templates into the module before a release.

If you need additional display-oriented logic, simply create a Twig extension (Smarty view plugin in Zikula 1.3.x) encapsulating your efforts in a file which is not affected by the generator at all.

### Code additions

Perform logical enhancements in the generated implementation classes. These extend from abstract base classes containing the actual generator implementation code. So almost all concrete classes are empty waiting for your custom extension.

If you need to add complex behaviour put this into dedicated helper classes outside of generated files. Using the dependency injection from Symfony's service container you can use this helper class where you need it, keeping the additional code for children of generated classes small.

There is a helper class (`ControllerHelper` in 1.4+, `ControllerUtil` in 1.3.x) which can be used to enable/disable specific controller actions (like view, display, ...) and additional functionality (like blocks, content types, mailz api, etc.) for particular entity types within custom conditions.

When using edit forms you can easily customise the redirect behaviour by appending a `returnTo` parameter to the edit url. For example let's imagine a customer entity having a bidirectional relationship to many addresses. In this case the default behaviour of the address editing functionality redirects back to the detail view of the created/updated entity if it exists in the model. If there is no display action it redirects to the list view if existing else it jumps to the index page. Using the `returnTo` parameter you can assign certain pages like `display`, `view` and even related items like `customerDisplay`.