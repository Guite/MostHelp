# User interface

This section shows how to use ModuleStudio. Starting with a general demonstration of the user interface it goes step by step through all UI functions and explains their purpose. Note there is also a dedicated chapter showing a [list of keyboard shortcuts](82-KeyboardShortcuts.md] which are helpful not only, but especially for advanced users.

## Basic usage

An application project in ModuleStudio consists of two files: one `*.mostapp` file with the actual application model, and one representations file containing data for how the model is displayed in the different editors. The `mostapp` file is the primarily important one for storing and exchanging applications. It can imported into a new ModuleStudio project at any time, so you do not need to keep the representation file with it.

Besides the main menu, the environment can be split into two areas. On the left side there are the *dashboard* view and the *editor* windows. Editors contain the actual notation for changing the model. For the diagram editor this consists of a canvas as well as a *palette* with the available tools. This is where the actual modeling happens. The diagram editor's palette separates the available model elements into several groups, like *Relationships*, *Fields* or *Actions*. It is possible to have multiple elements at the same time in one model for each of these types. The visible groups and tools in the palette depends on which *layers* you have enabled in the diagram. More about these layers will be explained later.

On the right side is an arrangement of different *views*. For example there is an outline view with a miniature display of the editor window, a properties view used to edit properties of model elements.

![Editor with palette, several views](images/ui_basic.png "Editor with palette, several views")

Most parts of the user interface can be customised, like one may expect from an Eclipse-based application. Views can be moved and replaced, e.g. you could have them at the left side, on the bottom or in the same tab bar as the editors. Also you can, for example, customise the palette (see [below](#palette). It is even possible to use multiple editors in parallel by arranging them next to each other.

![Table editor and textual editor side by side](images/ui_multiple_editors.png "Table editor and textual editor side by side")

## Diagram editor

The diagram editor offers different convenience functions to manage the model view and to aid in the modeling process. For example there is an infinitely variable zoom function which can be controlled by several ways. There are icons for this in the palette, a dropdown list at the top right in the toolbar as well as an entry in the Diagram item on the main menu. The zoom function can also be accessed by using the `Ctrl` key in combination with the mouse wheel - as is used in many browsers, which makes it an intuitive option.

Another important function is *Arrange*. We can, for example, select all elements and use this function to automatically arrange them. Also practical is the export of diagrams as an image file, which supports a number of image formats.

### Tabbar

*TBD*

### Palette

* [Customise palette](http://modulestudio.de/en/tutorial/customise-palette.html)

*TBD*

### Layers

Layers allow to hide or show different concerns of the model which helps to keep focus on what is relevant for the moment. For example if you are currently not working on entity indexes, you can hide them by disabling the index layer. When disabling a layer both corresponding diagram elements and palette entries are hidden.

#### Base layer

The base layer is always enabled. Beside the application itself it contains entities, relationships and maybe generator settings.

##### Application properties

The diagram canvas corresponds to the application described by the model. Some basic settings should be defined here which are available in the properties view.

The most important fields should be already set because the new application wizard gathered the required information. This includes the application name, the database table prefix, the project home page (url) as well as the name and the email address of the developer.

The *version* field defines the version number of the application in the form `x.y.z`. The *license* field specifies under which license the application is developed. Here LGPL is the default, but you are free to change this.

A more advanced field is *capabilities*: it allows you to specify capability names which are used in Zikula to express certain functions a module is offering. This allows for a loose coupling between modules. For example you can let `MyProductsModule` depend on `MyCustomerModule`, but this is a very tight coupling. With capabilities you could instead let the products module query Zikula for `any module which is able to handle customers`. You can read more about this in the [CapabilityApi description](https://github.com/zikula/core/blob/1.4/src/docs/Core-2.0/Api/CapabilityApi.md).

*TBD*

##### Entities and relationships

Entities and relationships define the data layer for an application. This represents the managed database tables as well as how the objects behave within the working application.

When a new entity is created, the editor needs to know three things: the name for the entity in singular, and in plural, and a field specifying whether the entity is leading. In every application there must be one entity marked as leading. This is used as the default object type.

The modeling of entities is the most important step in defining the data layer, but this process is incomplete without defining the relationships between them. To add a relationship choose the connection type in the palette and activate the tool with a mouse click. Next click on the source entity and (without releasing the mouse button) drag the mouse to the target entity, where the button is released. The editor cleverly determines the names for both sides of the relationship from the singular or plural names of the connected entities. If you want to create a self-relationship, a simple click on the corresponding entity is enough.

*TBD*

##### Settings

*TBD*

#### Fields layer

Inside a new entity you can create a first string field named for example `name`. Additional fields are easily created with the popup bar that appears when the mouse hovers over the fields container within the entity. This is significantly faster than moving the mouse to the palette and back all the time. There are several different field types available. You should experiment with them to get to know them better.

*TBD*

#### Controller layer

Controllers define the interaction between the user and a Zikula module - what the user sees, and what he can do. We define, therefore, which user functions should exist at this place in the model.

If you enable the controller layer you see two additional palette groups, that are *controllers* and *actions*. The controllers represent different areas of an application. For example, there is a controller for the admin area, and another for the user area. Every controller contains one or more actions. Each action represents a callable function.

Let's look at the controller elements first. With admin and user controllers we can create the administrative and user-oriented areas of the Zikula application. These two are also the most commonly required areas, but others are possible. The ajax controller represents a special controller type containing ajax functionality. (Strictly seen admin, user and ajax controllers are legacy concepts, because Symfony allows any functions in every controller. In a future version controllers this will be considered also in the DSL (see [this issue](https://github.com/Guite/MostGenerator/issues/715)). With the individual controllers arbitrary additional controller elements with their own names can be added.

Note that each entity implicitly acts as a controller, too. So if you created a `person` entity, this represents also a person controller. For this reason both controllers and entities contain actions.

The available action elements are self-explanatory. It should be mentioned, however, that delete is only there for backwards compatibility. Every form generated from an edit action contains a delete button already. From older modules, one might be used to having the delete confirmation question on a separate page. Also here, there is an element for additional entries that one can use to model method stubs for additional actions in the controller classes.

*TBD*

#### Index layer

An index tells the database to optimise a table for searches by specific fields. Every index gets a name and has a certain type. The index can contain different entries which must be named exactly like an existing field from the same entity.

*TBD*

#### Variables layer

Variables are generated as basic settings in the application. You can create one or more container elements for variables on the canvas. These containers can hold the definition of several variables. Variables can be created for boolean values, integers, text fields, file paths and lists.

*TBD*

#### Workflow layer

The workflow layer is not implemented yet (planned for version 0.8). This section is just a dummy for future. You can still configure a bunch of different workflows for your entities (see [generator reference](87-GeneratorReference.md#entity-workflow-type)).

### Context menus

*TBD*

### Direct editing

*TBD*

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

The textual editor offers several advanced features, like for example syntax highlighting, code templates, auto completion, quick fixes and much more. It even allows you to create relationships between entities of different applications which is not possible using the diagram editor yet.

*TBD: features, screenshots and examples*

#### Textual grammar

Here is a railroad chart showing the textual grammar elements:

![Textual grammar](images/mostdsl_grammar.png "Textual grammar")
