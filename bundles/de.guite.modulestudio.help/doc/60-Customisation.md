# Customisation and maintenance

## Introduction

This section gives a few hints for changing arbitrary things in your generated applications while keeping in sync with upcoming releases of Zikula and ModuleStudio.

## Long-term maintenance

To prevent losing the [benefits of ModuleStudio](10-Introduction.md#benefits) in future you have to follow a few simple basic rules in your development process.

### Keep consistent

When using ModuleStudio then your model is not only some sort of bootstrapping or documentation artifact. The model describes or better is the real application. Therefore you should do all important changes (like adding or moving table columns, renaming an entity or other amendments, introducing a new controller action, etc.) on model level although it might look a bit inconvenient first. Do not let your model become obsolete, as this would mean losing lots of advantages. You will thank yourself when generating again with a newer version.

### Document your changes

Document your changes to simplify the merging process you will have to do after regeneration. For example after you added some fields later on, or you got a new generator version fixing some bugs, and so on you will want to know again where you did which changes for which reason.

Best practice is to add a [generator settings container](55-GeneratorReference.md#settings-container) to your model. It contains two properties called *skipFiles* and *markFiles* (follow link to get more information) allowing you to specify your amendments inside the model. The generator will then either not generate these files (skip) or create them with a custom file name containing `.generated`. There is also an additional setting named *generateOnlyBaseClasses* which can be helpful sometimes, too.

### Use overriding

All cosmetic enhancements can be done by template overriding in Zikula. For example you can place custom templates in `/config/templates/YourMod/...` during development. *Note* that if legacy mode is turned off, template overriding will not work automatically. In the past Zikula performed a file system scan several directories for each template which was very convenient, but also bad for performance. Now you have to describe overrides in the file `template_overrides.yml` explicitely instead.

So when custom templates are placed in the `/config/templates/YourMod/...` folder this is fine for development. It is even recommended for the module developer to keep things separated during development (and in Git, see below) so that he can always distinguish (and compare) between generated and customised templates, since this makes things easier if the module is regenerated again in future.

When using a module in production things are a bit different. A site owner may want to further customise some templates, so the `/config/` directory should not be used by the module itself out of the box. This is not really a technical problem, but just a question of how the deployment process should be. You can for example move the overridden templates into the module before a release.

If you need additional display-oriented logic, simply create a view plugin (Smarty in 1.3.x and Twig in 1.4.x) encapsulating your efforts in a file which is not affected by the generator at all.

### Code additions

Perform logical enhancements in the generated implementation classes. These extend from abstract base classes containing the actual generator implementation code. So almost all concrete classes are empty waiting for your custom extension.

There is a helper class (`ControllerUtil` in 1.3.x, `ControllerHelper` in 1.4.x) which can be used to enable/disable specific controller actions (like view, display, ...) and additional functionality (like blocks, mailz api, content type, etc.) for particular entity types within custom conditions.

When using edit forms you can easily customise the redirect behaviour by appending a `returnTo` parameter to the edit url. For example let's imagine a customer entity having a bidirectional relationship to many addresses. In this case the default behaviour of the address editing functionality redirects back to the detail view of the created/updated entity if it exists in the model. If there is no display action it redirects to the list view if existing else it jumps to the index page. Using the `returnTo` parameter you can assign certain pages like `display`, `view` and even related items like `customerDisplay`.

### Use versioning

Using a version control system, like git or svn, gives you another additional level of rollback safety and is a good idea anyway.

## Additional notes

Please see also [this tutorial](http://modulestudio.de/en/tutorial/structure-and-customisation-of-generated-applications.html). Some parts are a little outdated due to the migration from Doctrine 1.3 to Doctrine 2, but this shouldn't be a problem for the understandability of the overall messages shown there.
