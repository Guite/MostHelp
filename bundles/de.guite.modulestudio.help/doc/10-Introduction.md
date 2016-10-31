# Introduction

## About ModuleStudio

ModuleStudio (MOST) is a generative architecture for the Zikula Application Framework. Based on principles of Model-Driven Software Development (MDSD) the creation of modules is being abstracted to a new level.

Thus, ModuleStudio is a development environment with which one can quickly, simply and efficiently describe and generate web applications. Software developers can create complex Zikula extensions in a few steps and meet individual project requirements with them.

ModuleStudio rapidly simplifies the creation, maintenance and customisation of applications for Zikula. It speeds up this process and ensures quality of those applications at the same time. Applications can be designed or customised in a graphical editor and repeatedly generate their source code. In this way, the process is automated speeding up development time and quality many hundred fold. Maintenance and customisation also benefit from this process via graphical modeling and code generation. 

Read more at this page: [What is ModuleStudio](http://modulestudio.de/en/product/what-is-modulestudio.html).

*Replace coding by modeling and simplify your development!*

## How does it work ?

Developing and maintaining model-driven applications works well in combination with an iterative-incremental development process. In this approach you start with a small model which will then be enhanced in several steps whereby some short tests verify that the direction is correct.

Each development cycle in ModuleStudio consists of the following steps:

1. Create or change the model.
2. Let ModuleStudio validate it and fix problems.
3. Generate (or regenerate) the application source code.
4. Merge changes
5. Test intermediate results
6. Customise the application.

Note ModuleStudio offers several *generator settings* to simplify the merging process. More about that later.

## Benefits

* **Development time/costs:** avoid wasting weeks for schematical and architecturally motivated code parts (so-called boilerplate code)!
* **Maintainability:** your software is a model - easily changeable and cheaply maintainable! No more efforts for getting your modules up to date for new versions, just regenerate and merge the code!
* **Code quality:** take profit from best practices and established patterns!
* **Architectural compliance:** take most usage from powerful core frameworks and interfaces! Generated applications follow all APIs and guidelines automatically. This is a big step for avoiding unsecure and legacy extensions when the framework itself evolves!
* **Reusability:** share and modify your models! Do not make the same work twice!
* **Understandibility:** avoid having to cope with programming rules and framework details! Develop with general MVC (Model View Controller) terminology independent from technical stuff!

More information can be found in these articles:

* [Advantages of ModuleStudio](http://modulestudio.de/en/product/advantages-of-modulestudio.html)
* [How MDSD reduces costs for long-term maintenance of comprehensive software system families](http://modulestudio.de/en/tutorial/how-mdsd-reduces-costs-for-long-term-maintenance-of-comprehensive-software-system-families.html)
* [From scaffolding and UML to MDSD and DSL](http://modulestudio.de/en/tutorial/from-scaffolding-and-uml-to-mdsd-and-dsl.html)

## About this manual

This user manual is going to provide all required information to work with ModuleStudio. Furthermore it serves as a reference for all details of the generator. This document should be available in several formats:

* help within ModuleStudio
* online help on our website
* pdf print version

## What is Zikula ?

The Zikula Application Framework is a powerful solution for realising web applications and websites with the help of *modules* and *themes*. It essentially uses the following libraries:

* **Symfony:** a very popular set of reusable PHP components which offers many useful abstractions, like very powerful solutions for validation and web forms.
* **Doctrine:** a set of libraries focused on database storage and object mapping.
* **Twig:** a flexible, fast and secure template engine.
* **jQuery, Bootstrap, Font Awesome:** well-known components for rapid realisation of responsive and interactive frontends.

Since Zikula already provides many basic functions for running web projects, like management for users, groups and permissions as well as means for content management, custom modules can typically focus on implementing additional data structures and behaviour. And this is where ModuleStudio can help you.

A module is basically very similarly structured as a Symfony bundle. Under the hood Zikula modules and themes are nothing else than special bundle types. The main difference here is that they can be installed, enabled, disabled and uninstalled on runtime using the extension and theme management modules in the Zikula administration area. Also modules can utilise some additional functionality provided by Zikula which are expressed by capabilities. For example modules can work with each other using a flexible hook system.

## Component overview

This section gives you an overview of the main parts of ModuleStudio and how they work together.

### DSL

The inner core of MOST is a domain-specific language (DSL) for Zikula extensions. This language allows a formalised description of applications which is a fundamental requirement to process models automatically with the help of transformations. The DSL consists of the following parts:

* **Meta model:** defines the essential concepts of the ModuleStudio language, that is which model elements may exist and how they are allowed to work with each other. This allows reusing the basic domain concepts at several places, like validation, editors, generators and so on. The meta model is not visible for the user, but used by other components in the background.
* **Constraints:** there are [many validation rules](40-Validation.md#validation) to enrich the modeling language with more precise knowledge. These constraints ensure that the generator can only be started for valid models. For many common problems there are quick fixes offered proposing possible solutions to solve a certain error.

### Editors

The user interface consists of different types of editors which may include event different kinds of how information is described. The following list gives an impression about what is possible as well as the pros and cons. See the [user interface chapter](30-UserInterface.md#user-interface) for more detailed information about the ModuleStudio UI components.

* **Graphical** notations are convenient for modeling edges between different nodes. They are not that well suited for creating huge lists of similar elements for instance. ModuleStudio offers a graphical editor for creating and changing models for describing different applications. This editor consists of different layers and is the primary editor of ModuleStudio.
* **Textual** syntax is very nice for rapid creation of structures. It becomes less handy for relationships. While there exists a textual editor in ModuleStudio, it is not visible yet. This is going to change soon though (see below).
* **Structural** views, for example trees, forms or tables, are another possible viewpoint for describing a model. ModuleStudio includes two table editors for entity fields and variables. These can be used as alternatives for the graphical editor, but are less matured at the moment. It can be useful to print a table view or export table data as a csv file though.
* **Hybrid** modeling is where ModuleStudio is heading to in future. This combines different kinds of editors in the same UI. One concrete use case is an embedded textual editor inside the graphical editor allowing to specify details on entity level.

### Generator

The generator creates source code for a Zikula extension from a given application model. You can read more about this in the [generator chapter](50-Generator.md#generator). Also important is another chapter about [customisation and maintenance](60-Customisation.md) of generated applications.

### Overview

This chart shows how the main components of ModuleStudio are working together.

![Component overview](images/component_overview.png "Component overview")
