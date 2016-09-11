# Component overview

## Introduction

This page gives you an overview of the main parts of ModuleStudio and how they work together.

## Modeling Language

The inner core of MOST is a domain-specific language (DSL) for Zikula extensions. This language allows a formalised description of applications which is a fundamental requirement to process models automatically with the help of transformations.

For convenience ModuleStudio uses general terms for modeling MVC applications. As you will see later an application model has different submodels for describing corresponding architectural layers (model, controller, view).

### Meta model

The meta model defines the essential concepts of the ModuleStudio language, that is which model elements may exist and how they are allowed to work with each other. This allows reusing the basic domain concepts at several places, like validation, editors, generators and so on.

### Constraints

In addition to the meta model there are [many validation rules](40-Validation.md#validation) to enrich the modeling language with more precise knowledge. These constraints ensure that the generator can only be started for valid models.

## Modeling Editors

The user interface consists of different types of editors which may include event different kinds of how information is described.

### Graphical

Graphical notations are convenient for modeling edges between different nodes. They are not that well suited for creating huge lists of similar elements for instance.

ModuleStudio offers graphical editors for creating and changing models for describing different applications. See the [user interface chapter](30-UserInterface.md#user-interface) for more information.

### Textual

A textual syntax is very nice for rapid creation of structures. It becomes less handy for relationships.

At the moment there is no textual editor included in ModuleStudio. This is going to change soon though.

### Structural

Structural views, for example trees or tables, are another possible viewpoint for describing a model.

At the moment there is no structural editor included in ModuleStudio. This will change in version 0.7.0 which includes table editors for entity fields and variables.

### Hybrid

In future of ModuleStudio is heading towards some kind of hybrid modeling where you can combine textual and graphical editors for describing applications.

## Generators

The generators add technical details depending on the target system. Their task is creating source code or other artifacts from application models.

The primary generator cartridge creates a Zikula extension. You can read more about this in the [generator chapter](50-Generator.md#generator). Also important is another chapter about [customisation and maintenance](60-Customisation.md) of generated applications.
