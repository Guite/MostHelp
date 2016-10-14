# Getting started

This chapter explains the first steps required for starting creating applications with ModuleStudio.

For now we refer only to existing tutorials as they describe things still quite well.

## Installation

Simply download the archive for your operating system and extract it inside your home directory. After that you are ready to start the ModuleStudio executable.

Note ModuleStudio 0.6.2 requires Java in at least version 7. If no JRE (Java Runtime Environment) is found on your system path, a dialog appears and you are suggested to download and install the JRE before starting ModuleStudio.

### Additional notes for Windows 8 and later

If you enabled the SmartScreen protection starting ModuleStudio will open a blocking window showing the following error message: `Windows SmartScreen prevented an unrecognized program from starting. Running this program might put your PC at risk`.

This does not mean that ModuleStudio includes any kind of malware. Instead this message is only caused by the fact that the executable file is not digitally signed using a certificate yet. To start ModuleStudio nevertheless you should be able to use the right mouse button and choose `allow`. If this is not available click on the `More info` link and on the `Run anyway` button afterwards.

### Additional notes for MacOSX

If ModuleStudio does not start but fails with an error please check the created error log file. In case it contains lines like `!MESSAGE Missing required capability Require-Capability: osgi.ee; filter="(&(osgi.ee=JavaSE)(version=1.7))` then the system is not using Java (Standard Edition) 7. To verify this open a console and type: `java -version`. If Java 7 is used in your system by default the output should show something starting with 1.7.x.

According to feedback from our users it is also important to install the MacOS JDK instead of the JRE, since the JDK installer properly tells OSX to use 1.7 where the JRE does not.

### Note about ModuleStudio 0.7

ModuleStudio 0.7.0 requires Java 8, but it includes it already. So it should start also if you have an older version or no Java installed at all.

## First tour

First thing you may want to do after starting the ModuleStudio application is creating a new model. Therefore start the e[new application wizard] using the "File" main menu. It allows you to enter some basic information, like vendor and application name, in a simple form. After that it creates a new model and preinserts some common basic container elements so that you can directly proceed with describing your application in detail.

Please see [this tutorial](http://modulestudio.de/en/tutorial/the-first-zikula-application-in-10-minutes.html) for getting the overall idea.

### Samples

There are some sample models contained in the `examples` folder inside ModuleStudio.

You can also download them from [the examples project](https://github.com/Guite/MostExamples) on GitHub.

### Web resources

The following links may be helpful in addition.

* You can find further resources and information on the [ModuleStudio website](http://modulestudio.de/en).
* There are also some [video tutorials](http://modulestudio.de/en/documentation/) showing how to perform some common tasks.
* The [web generator](http://webgen.modulestudio.de/en) regenerates your applications using the latest Git revision of the generator.
* The [generator project](https://github.com/Guite/MostGenerator) on GitHub contains the issue tracker where you can lookup and report bugs and feature requests.
* There is also a [Google group](http://groups.google.de/group/most-dev) for communication between developers, testers and translators.
* Further support is available in the official [Zikula forums](http://zikula.org/forums/forum/56). If you speak German there is another one [here](http://support.zikula.de/module-CMS_Support_Forum-viewforum-forum-16.htm).
* Our [vendor site](http://guite.de/en) of Guite (Guckelsberger Information Technology) is where you can ask for professional support.

## Development process

Developing model-driven applications works well in combination with an iterative-incremental development process. In this approach you start with a small model which will then be enhanced in several steps whereby some short tests verify that the direction is correct.

Each cycle consists of the following steps:

1. Create or change model
2. Regenerate
3. Merge changes
4. Test intermediate results

Note ModuleStudio offers several *generator settings* to simplify the merging process.

## Migrating old models

To import a model from 0.6.2 just use the corresponding menu or dashboard action. The model will be migrated to the current modeling language and imported into a new project automatically.

## Migrating old modules

If you want create a model for an existing legacy module you can follow the following procedure.

1. First get the file *pntablesToXML.php* from [GitHub](https://github.com/zikula/core/tree/master/tools).
2. Use this script to migrate your old `pntables.php` file to an xml file.
3. Inside ModuleStudio use the menu entry *File > Import xml table definition* which will open a file selection dialog. Choose the xml file you just created. As a result you will get a new application model in the `MOST_output/yourmod.mostapp` file.
4. Now import this model using the corresponding menu or dashboard action.
5. In the data editor remove unrequired elements, like table prefixes and default identifier fields, that are primary and foreign keys.
6. Follow validation messages to get remaining stuff sorted properly.

Example import results:

![Admin module](images/import_admin.png "Admin module")

![News module](images/import_news.png "News module")

![Content module](images/import_content.png "Content module")

## Other hints

Here are some hints for getting into ModuleStudio smoothly.

* Each application is being represented by a model. A model consists of two files: a domain model (`*.mostapp`) and a diagram model (`*.mostdiagram`). The first one is the important thing containing all information relevant for further processing like model-to-model and model-to-code transformations. The diagram information is only cosmetical and not neccessary. So if you want to exchange models, only the domain model is needed from which a new diagram model can be initialised.
* Not all settings are directly embedded within the editor. To be able to set all fields refer to the *properties view* at the bottom right. There you can find an element named *domain* relating to a particular element with focus.
* At first start with simple goals. Think about an application needing only three to five database tables (entity objects in the model editor). Keeping your application-specific logic simple helps to understand the architectural concepts of ModuleStudio.
* You may have a look into some existing example models (see [Samples](#samples) chapter above).

