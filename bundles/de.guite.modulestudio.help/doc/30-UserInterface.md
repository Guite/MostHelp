# User interface

This section shows how to use ModuleStudio. Starting with a general demonstration of the user interface it goes step by step through all UI functions and explains their purpose. Note there is also a dedicated chapter showing a [list of keyboard shortcuts](82-KeyboardShortcuts.md) which are helpful not only, but especially for advanced users.

## Basic usage

An application project in ModuleStudio consists of two files: one `*.mostapp` file with the actual application model, and one representations file containing data for how the model is displayed in the different editors. The `mostapp` file is the primarily important one for storing and exchanging applications. It can imported into a new ModuleStudio project at any time, so you do not need to keep the representation file with it.

Besides the main menu, the environment can be split into two areas. On the left side there are the *dashboard* view and the *editor* windows. Editors contain the actual notation for changing the model. For the diagram editor this consists of a canvas as well as a *palette* with the available tools. This is where the actual modelling happens. The diagram editor's palette separates the available model elements into several groups, like *Relationships*, *Fields* or *Actions*. It is possible to have multiple elements at the same time in one model for each of these types. The visible groups and tools in the palette depends on which *layers* you have enabled in the diagram. More about these layers will be explained later.

On the right side is an arrangement of different *views*. For example there is an outline view with a miniature display of the editor window, a properties view used to edit properties of model elements.

![Editor with palette, several views](images/ui_basic.png "Editor with palette, several views")

## Main menu

*TBD*

### Troubleshooting if you can not save the model

If you get an error message when trying to save your model this means that it is not possible to serialise the object graph you have currently opened in the memory. The probable reason for this is that there exists a reference to an element without a name. Therefore the serialiser sees no way to persist this reference.

For example if you have two entities and a relationship between them then all both entities need a name. Otherwise the relationship can not store it's source or target references.

To fix this just ensure that all existing elements have a name. Since ModuleStudio version 0.7.0 this is actively supported by setting sensitive default values when adding new elements.

### Themes

*TBD*

### Preferences

*TBD*

## Help system

*TBD*

## Subchapters for UI components

* [Diagram editor](32-DiagramEditor.md)
* [Views](33-Views.md)
* [Table editors](35-TableEditors.md)
* [Textual editor](36-TextualEditor.md)

## Customisation

### Rearrange the UI

Most parts of the user interface can be customised, like one may expect from an Eclipse-based application. Views can be moved and replaced, e.g. you could have them at the left side, on the bottom or in the same tab bar as the editors.

![Views can be arbitrarily arranged](images/ui_view_arrangement.png "Views can be arbitrarily arranged")

It is even possible to use multiple editors in parallel by arranging them next to each other.

![Table editor and textual editor side by side](images/ui_multiple_editors.png "Table editor and textual editor side by side")

Experiment with these options and use them to meet your personal workflow.

One additional hint about editor synchronisation: If you changed a model, you need to save it to let ModuleStudio reflect the changes in other opened editors.
