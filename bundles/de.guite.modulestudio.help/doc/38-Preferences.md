# Preferences

In the preferences section you can adjust several base settings of ModuleStudio. This chapters explains what these settings do.

## AutoSave

Here you can enable automatic save for the editors. You can specify an interval in seconds. This is especially interesting as a save operation triggers [validation](50-Validation.md#triggering-validation), too. So if you for example save the model every 30 seconds you can just work and the [problems view](33-Views.md#problems-view) keeps you updated about possible errors automatically.

![AutoSave preferences](images/ui_preferences_autosave.png "AutoSave preferences")

## ModuleStudio base preferences

* *Default theme*: choose whether you like to have the light or dark [theme](30-UserInterface.md#themes) per default.
* *Vendor, Author, Email address, Url*: you can input your default values at this place. The wizard for [creating a new model project](20-GettingStarted.md#create-your-first-application-in-10-minutes) will reuse these values, so you do not have to enter them repeatedly.
* *Ignore model warnings during generation*: enable this option to avoid that a message box appears if your model contains warnings.
* *Override existing files*: if you enable this option the generator will not abort if files exist in the selected output directory. *Use with caution!*
* *Use staging updates*: if that option is activated the auto update function will include unstable releases. Each time you start ModuleStudio it looks for whether updates are available. Per default it searches only for stable releases. With the staging channel you get also updates from every single build which earlier brings you new features, but also includes the risk of breaking things.
* *Ignore updates*: enable this option if you do not want ModuleStudio searching for updates.

![ModuleStudio base preferences](images/ui_preferences_modulestudio.png "ModuleStudio base preferences")

## Advanced sections

The following preference pages are mainly intended for advanced users and are usually not required to be changed.

### MostDsl

The *MostDsl* tab is related to the [textual editor](36-TextualEditor.md#textual-editor).

#### Syntax colouring

Here you can change styles for the syntax highlighting. For example you could have keywords in red instead of purple. Or you could have strings in bold style using another font.

![Syntax colouring preferences](images/ui_preferences_syntax_colouring.png "Syntax colouring preferences")

#### Template settings

This shows the available [template proposals](36-TextualEditor.md#template-proposals) defined for the textual editor.

![Template proposals preferences](images/ui_preferences_template_proposals.png "Template proposals preferences")

You can change them and add new ones if you like.

![Add or edit template proposals](images/ui_preferences_template_proposals_edit.png "Add or edit template proposals")

Inside the input field you can use [content assist](36-TextualEditor.md#content-assist) like in the textual editor, too.
