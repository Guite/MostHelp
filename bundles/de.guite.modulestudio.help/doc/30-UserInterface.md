# User interface

## Introduction

This section shows how to use ModuleStudio. Starting with a general demonstration of the user interface it goes step by step through all single editors required for creating a complete model.

At the moment this page consists only of a few links to corresponding tutorials. It will be enhanced at a later stage after the actual modeling language has matured enough to spend work on completing the user interface.

## Basic usage

Please see [this tutorial](http://modulestudio.de/en/tutorial/basic-usage.html).

## Graphical editors

### Main editor

Please see [this tutorial](http://modulestudio.de/en/tutorial/basic-settings-in-main-editor.html).

![Main model](images/main_model.png "Main model")

### Model editor

Please see [this tutorial](http://modulestudio.de/en/tutorial/describing-the-model.html).

![Model model](images/model_model.png "Model model")

### Controller editor

Please see [this tutorial](http://modulestudio.de/en/tutorial/modeling-the-controllers.html).

![Controller model](images/controller_model.png "Controller model")

### Workflow editor

The workflow layer is not implemented yet (planned for version 0.8). This section is just a dummy for future.

## Textual editors

Beginning with ModuleStudio 0.6.0 there is also a textual syntax notation available. Not visible
at once, it will be integrated into the UI step by step.

## Useful hints

Here are some tutorial showing special abilities for certain use cases:

* [Customise palette](http://modulestudio.de/en/tutorial/customise-palette.html)
* [Multiple container elements](http://modulestudio.de/en/tutorial/multiple-container-elements.html)
* [Moving fields with drag n drop](http://modulestudio.de/en/tutorial/moving-fields-with-drag-n-drop.html)
* [Creating multiple elements quickly](http://modulestudio.de/en/tutorial/creating-multiple-elements-quickly.html)
* [Working with multiple windows](http://modulestudio.de/en/tutorial/working-with-multiple-windows.html)

### General keyboard shortcuts

* **F1** - Opens the help system.

### Keyboard shortcuts in graphical editors

There are some very handy shortcuts hidden in ModuleStudio. For example it can be worth to experiment with the Ctrl (Alt on Mac) and/or Shift keys when moving or resizing an object.

Here is a [list of all editor shortcuts](http://help.eclipse.org/helios/topic/org.eclipse.gmf.doc/prog-guide/runtime/Developer%20Guide%20to%20Keyboard%20Accessibility.html).

If one has selected a palette tool and creates an object in the diagram it is usually required to select the tool again in order to create another object. If one presses the Ctrl (Alt on Mac) key one can create multiple elements of the same type in one step.

### Keyboard shortcuts in textual editors

The following list shows some basic commands which might be helpful when using the textual editors.

* **Alt-Up / Alt-Down** - Move current line or selection one line up / down.
* **Alt-Left / Alt-Right** - Go back / forward in the history of editors.
* **Alt-Shift-Up / Alt-Shift-Down** - Expand selection to containing element.
* **Alt-Shift-R** - Rename current element as well as all other occurences.
* **F3 or Ctrl-MouseClick** - Follow reference under cursor.
* **Ctrl-Up / Ctrl-Down** - Scroll one line up / down.
* **Ctrl-PgUp / Ctrl-PgDown** - Activate previous / next editor tab.
* **Ctrl-0** - Pop up outline for easy navigation and filtering.
* **Ctrl-1** - Quick fix of errors.
* **Ctrl-/** - Toggle comment for line or selection.
* **Ctrl-Space** - Start content assist suggesting possible values.
* **Ctrl-D** - Delete current line.
* **Ctrl-L** - Go to a certain line.
* **Ctrl-M** - Maximize current editor window.
* **Ctrl-W** - Close current editor tab.
* **Ctrl-Q** - Go to last edit location.
* **Ctrl-Shift-F** - Start the source code formatter.
* **Ctrl-Shift-G** - Find references to current element.
* **Ctrl-Shift-F3** - Locate a certain element.

## Textual Grammar

Here is a railroad chart showing the textual grammar elements:

![Textual grammar](images/mostdsl_grammar.png "Textual grammar")
