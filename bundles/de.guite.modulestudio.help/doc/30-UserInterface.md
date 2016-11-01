# User interface

This section shows how to use ModuleStudio. Starting with a general demonstration of the user interface it goes step by step through all UI functions and explains their purpose.

## Basic usage

Please see [this tutorial](http://modulestudio.de/en/tutorial/basic-usage.html).

### Editors

*TBD*

### Views

*TBD*

## Graphical editor

### Application settings

Please see [this tutorial](http://modulestudio.de/en/tutorial/basic-settings-in-main-editor.html).

*TBD*

### Entity and field layer

Please see [this tutorial](http://modulestudio.de/en/tutorial/describing-the-model.html).

*TBD*

### Controller layer

Please see [this tutorial](http://modulestudio.de/en/tutorial/modeling-the-controllers.html).

*TBD*

### Index layer

*TBD*

### Variables layer

*TBD*

### Settings layer

*TBD*

### Workflow layer

The workflow layer is not implemented yet (planned for version 0.8). This section is just a dummy for future. You can still configure a bunch of different workflows for your entities (see [generator reference](87-GeneratorReference.md#entity-workflow-type)).

## Views

### Dashboard view

*TBD*

### Problems view

*TBD*

### Error log view

*TBD*

### Properties view

*TBD*

#### Quick fixes for problems

*TBD*

### Outline view

*TBD*

### Help view

*TBD*

## Main menu

*TBD*

### Troubleshooting if you can not save the model

If you get an error message when trying to save your model this means that it is not possible to serialise the object graph you have currently opened in the memory. The probable reason for this is that there exists a reference to an element without a name. Therefore the serialiser sees no way to persist this reference.

For example if you have two entities and a relationship between them then all both entities need a name. Otherwise the relationship can not store it's source or target references.

To fix this just ensure that all existing elements have a name. Since ModuleStudio version 0.7.0 this is actively supported by setting sensitive default values when adding new elements.

## Themes

*TBD*

## Preferences

*TBD*

## Help system

*TBD*

## Useful hints

Here are some tutorial showing special abilities for certain use cases:

* [Customise palette](http://modulestudio.de/en/tutorial/customise-palette.html)
* [Multiple container elements](http://modulestudio.de/en/tutorial/multiple-container-elements.html)
* [Moving fields with drag n drop](http://modulestudio.de/en/tutorial/moving-fields-with-drag-n-drop.html)
* [Creating multiple elements quickly](http://modulestudio.de/en/tutorial/creating-multiple-elements-quickly.html)
* [Working with multiple windows](http://modulestudio.de/en/tutorial/working-with-multiple-windows.html)
* [List of keyboard shortcuts](82-KeyboardShortcuts.md]

## Enhanced UI components

### Table editors

*TBD*

### Entity table editor

*TBD*

### Variables table editor

*TBD*

### Textual editor

Beginning with ModuleStudio 0.6.0 there is also a textual syntax notation available. Not visible at once, it will be integrated into the UI step by step. ModuleStudio is going to move towards hybrid modeling, combining different kinds of editors in the same UI. One concrete use case is an embedded textual editor inside the graphical editor allowing to specify details on entity level.

*Expert tip:* you can use the textual editor already if you like: open the *Open resource* dialog using **Ctrl + Shift + R**, type `*.mostapp` into the filter field and click on the *Open* button.

#### Textual grammar

Here is a railroad chart showing the textual grammar elements:

![Textual grammar](images/mostdsl_grammar.png "Textual grammar")
