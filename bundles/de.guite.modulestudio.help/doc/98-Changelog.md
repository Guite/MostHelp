# Changelog

## ModuleStudio 0.7.0

### Product changes

* New implementation for the main program, overhauled UI contributions. Hence, the ModuleStudio UI is now more slim and limits itself to the relevant control elements.
* There are two different designs available: light and dark.
* There are new powerful editors: a primary graphical diagram editor and two tabular editors for entities and variables.
* All editors are automatically synchronised with each other, so that changes are immediately reflected everywhere.
* The graphical editor has no sub editors anymore, but works with different layers which can be displayed and hidden.
* Available views: dashboard (quick links), error log, model outline, properties, current problems.
* Double-clicking an error or warning in the problem view selects the affected element in the diagram.
* Fields and variables can be resorted using the context menu (top, up, down, bottom).
* Double-clicking a list field or list variable opens a dialog window for managing their entries.
* A dedicated preference page allows storing ModuleStudio-specific basic settings. Some of these basic preferences allow central setting of commonly required data (like vendor, author, etc.) for avoiding repeated work.
* The wizard for creating new models uses the basic settings avoiding repeated input of recurring data.
* Existing models can be easily imported. Old models from version 0.6.2 are automatically migrated.
* When opening a model it is automatically validated.
* When saving a model it is automatically validated and the model file is formatted for readability.
* Using the context menu of a problem in the problem view you can call and execute quick fixes.
* Special and only rarely required properties are hidden by default and can be displayed and hidden using a button (expert settings).
* Added menu item for toggling full screen display.
* Added auto save functionality.
* Added new property view (experimental) in addition to the traditional one.
* Relationships visualise whether they are unidirectional or bidirectional.
* When creating relationships the source and target descriptions are automatically preset to the appropriate singular or plural names of corresponding entities.
* Documentation is now based on Markdown.
* ModuleStudio automatically searches for updates on startup. You can control in preferences whether only stable releases are included or also continuously incoming updates are considered, too.
* Help search also includes results from zikula.org and zikula.de sites. 
* Updated to Eclipse 4.6.0 (Neon).
* ModuleStudio brings the required Java 8 environment along and can therewith also be used on systems without Java or with obsolete Java versions.

### DSL / Modeling language changes

* Applications can now define `capabilities` they provide (#667).
* String fields can be marked as `bic` or `timezone` (analogous to `currency`, `country`, `language`, `locale`, `colour`, `ip address`, `iban number`, etc.).
* Integer, decimal and float fields can be marked as `percentage`.
* Integer fields with minimum and maximum can be marked as `range`.
* The DSL uses a new formatter for the model format.
* With the `skipHookSubscribers` property you can take influence on whether an entity should support display and filter hooks or not. In some cases it can make sense to disable that for improving performance (#702).
* Added string property for additional date validators (#640).
* Url fields have a new `checkDNS` property to check whether the associated host exists (#674).
* The relation attributes `orderBy` and `orderByReverse` are checked for valid fields.
* Constraints for `min` and `max` items can be used independently from each other for array fields and multi-values relations (like it is possible for multiple list fields, too).
* Text variables have a new `multiline` property to separate single-lined text fields and text areas (#722).
* A new generator setting allows control over whether the ModuleStudio version should be part of the top docblock for all generated files or only for the Version class (#627).
* Entities contain controller actions now, like any other controller elements. Therewith you can control for each entity which use cases apply.
* The `allowedFileSize` property of upload fields has been deprecated. Please use `maxSize` instead (#541).
* Upload fields can now specify allowed `maxSize` and `mimeTypes` (#541).
* Upload fields can now be set to `multiple` to allow multiple files at once (#541, #123). 
* Upload fields for images can now specify many image-specific constraints in addition (`minWidth`, `maxWidth`, `minHeight`, `maxHeight`, `minRatio`, `maxRatio`, `allowSquare`, `allowLandscape`, `allowPortrait`, `detectCorrupted`) (#541).
* Replaced entity property `mappedSuperClass` by a dedicated language element.
* Application property `applicationType` has been removed.
* Moved data layer elements into main editor.
* Moved property for amount of example rows into generator settings.
* Moved remaining elements from controller layer into main editor.
* Two new properties allow controlling field visibility and css classes.
* Removed action handlers, action events and transitions from controller layer.
* Removed dsl properties for view layer, event listeners and transform objects.
* Added `expandedSource` and `expandedTarget` properties to relationships for controlling their editing display type in Symfony Forms terminology. The `useChecks` property of list fields has been renamed to `expanded` accordingly.

### Generator changes

* Twig is used instead of Smarty for 1.4 (#571).
* In 1.4 Symfony forms are used instead of the old forms framework (#416).
* With 1.4 the `LinkContainer` service is used now instead of user-/admin apis for header links.
* 1.4 applications utilise capabilities for exposing categories usage.
* The generator displays descriptions for field names containing numbers more readable.
* 1.4 applications use webshims polyfill for forms to provide better support for HTML5 validation in old browsers (#673).
* Editing time fields is now supported by a dedicated form plugin. Also for date fields there is a new selector (#87).
* In 1.4 applications annotations are used to distinguish between admin and user areas in entity controllers (#633).
* The `postInstall` event newly introduced in Zikula 1.4 is supported.
* Custom admin image and Scribite editor plugin images are dynamically generated (#458).
* The primary variable name for search terms has been changed to `q` for improved integration with analytics software.
* For the generated templates YAML example files with example overrides are pregenerated for easy copy n paste (#460).
* In 1.4 applications `RouteUrl` and `UrlInterface` are now used instead of the `ModUrl` class.
* The `maxLength` property of text fields are now reflected in the generated form field properly.
* Generation of MultiHook needles has been added (together with a new generator setting for that) (#13).
* For upload fields with images additional settings are generated allowing to enable automatic shrinking of too large images down to configurable maximum dimensions (#800).
* Many minor bugfixes.
* For more details see [closed tickets on Github](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.7.0).

## ModuleStudio 0.6.2 (Aug 7, 2014)

### Product changes

* Updated to Eclipse 4.4 (Luna).

### DSL / Modeling language changes

* A new generator setting allows defining a model as system module (#596).
* Added new options in the model editor allowing specifying additional validation constraints available in Symfony 2.4.x and 2.5.0 (#516, #606).
* Added new DSL property `onAccountDeletion` to entities and user fields to allow control over how an app should react when users are deleted (#284).
* A new `dbName` property for entity fields allows different naming for field and database column (#489).
* Array fields can be configured as array, simple array and json array for 1.4.0 (#488).
* Added new generator setting for marking generating files with special file names (`*.generated.*`) (#497).
* The following obsolete properties have been removed from the DSL: `Application#modelPath`, `Application#targetCoreVersion`, `DerivedField#leading`.

### Generator changes

* All frontend functions have been converted from Prototype to jQuery and Bootstrap for Zikula 1.4.0 (#238).
* Applications for Zikula 1.4.0 dispatch custom Symfony2 events, see generated FooEvents class (#568).
* Added basic support for cache annotations for 1.4.0 apps (#567).
* Structure of entity classes has been refactored for 1.4.0 to allow easier overriding from outside of the module using service parameters (#565).
* Display and delete actions use the `ParamConverter` annotation for object selection in 1.4.0 (#563).
* If no filters are set the current page of paginated views is remembered from session (#548).
* Applications for 1.4.0 support `Monolog` logger as well as Symfony components `Filesystem` and `Finder` (#546).
* Changed generated event subscribers for 1.4.0. Removed support for obsolete events, added support for Symfony kernel events (#544).
* Applications for Zikula 1.4.0 use Symfony's dependency injection container now (#535).
* The routing in 1.4.0 modules has been converted to Symfony using annotations. This replaces the url route classes and encodeurl/decodeurl methods generated before (#465, #604).
* Controller structure has been reorganised: now there exists one controller for each entity. This has been done for preparing migration to Symfony routing, but also makes controller methods more precise and easier to customise by overriding (#465).
* In 1.4.0 the Symfony validator component is used with annotations instead of self-written validation methods (#516).
* Added ics (iCalendar) templates for entities with start and end dates (#509).
* Migrated search integration to new helper class in 1.4.0 (#503).
* User avatars are displayed at appropriate places (#607).
* Entities with another workflow than `NONE` allow selecting user groups for moderation in the generated configuration page. Email notifications are sent between creator and moderators on state changes (#570).
* In 1.4.0 status messages are not with `LogUtil` realised anymore, but using Symfony FlashBags (#512).
* Client-side geocoding now uses a callback function to make customisation easier inside edit templates (#507).
* Lots of generator updates and bugfixes (for details on most changes see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.6.2).

## ModuleStudio 0.6.1 (Mar 13, 2014)

### Product changes

* This release is the first which has been built completely by our CI server. The build infrastructure has matured and allows for reproducable builds with measuring quality metrics and testing. There are also some new platforms added to the list of supported versions. But most important it has become much easier to create and publish new releases now.
* The MacOS versions behave like native MacOS apps.
* One unrequired and confusing main menu entry (`File > Open File...`) has been hidden.
* Updated to Eclipse 4.3.2 (Kepler SR2).

### DSL / Modeling language changes

* Introduced a new model element containing generator settings. Therewith you can control which features should be generated and take influence on some behavioural aspects of the generator (read more about this [here](87-GeneratorReference.md#settings-container)).
* Added new target core version `pre14` for the new Symfony-based module structure. This replaces the 1.3.6 version which behaves now exactly like 1.3.5.
* Brief entity display can now be freely controlled by a display pattern in the model (read more about [here](87-GeneratorReference.md#entity)).
* Added a language property for controlling sorting also for the incoming source side of many-to-many relationships, from the target side view.
* Only string field types can be used as permalink parts (sluggable position) now.
* The default value for the amount of example rows to be generated for a certain model container has been changed to `0`.
* Also view actions are now allowed for ajax controllers.
* Fixed wrong length calculation during table size validation.
* Added missing validation for ensuring one-to-one relations targeting a soft-deleteable entity have a remove cascade.
* Added missing validation for sortable group needing also a sortable position.

### Generator changes

* Upload folders are now created on demand if they do not exist yet (required if a module is used without having installed it, like for example when using Multisites site templates).
* Added an option for bypassing entity validation (required for example when archiving objects automatically).
* The generator creates also a plugin for the Newsletter module (beside the Mailz plugin which has been supported before already).
* Lists with related objects in quick navigation forms are sorted now by default.
* Added support for new event handlers in 1.4.0 to recognise a module being activated or deactivated.
* In 1.4.0 event handlers are not managed in the database anymore, but by means of dependency injection.
* Names of database tables include the vendor as prefix in 1.4.0.
* The frontend for 1.4.0 applications has been converted to Bootstrap.
* Lots of generator updates and bugfixes (for details on most changes see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.6.1).

## ModuleStudio 0.6.0 (Mar 8, 2013)

### Product changes

* A textual syntax defines a new and more readable model file format. Also there is a migration function for converting your existing models to this new notation automatically.
* Reimplemented generator templates in new language. The generator has a much better performance now.
* Errors and warnings can be translated into other languages now (German is supported already).
* Validation is no longer performed automatically every few seconds, but on certain events (each model save in the main editor, after opening existing models, when starting generation) and when calling validation manually using the main menu.
* Updated to Eclipse 4.2.2 (Juno SR2) and corresponding versions of third-party components. Mac OS X builds support only cocoa now, there are no launchers available for carbon anymore.
* The example models from the `MostExamples` repository are now shipped in a folder named `examples` within MOST.
* Removed custom beautifier component as it caused more problems than benefits.
* Reimplemented validation constraints, errors and warnings now also with German translation.

### DSL / Modeling language changes

* A new property stores the `vendor` of an application. Usually this is the name of a company or institution. This is a preparation for future versions of Zikula as it is intended to name extensions combining vendor and name of a Module. Then it becomes possible to install for example multiple News modules by different vendors concurrently.
* Another new property allows you to define the desired target core version. The default is 1.3.6 which includes the new forward compatibility layer for Zikula 1.4.0. Another current possible option is 1.3.5 for backwards compatibility and more stability.
* Basic workflow support. For each entity one of three predefined workflows can be selected and further customised by means of several options. Totally you can describe a huge number of different workflows. More information can be found in the user manual.
* Introduced support for different types of application dependencies (requirement, recommendation, conflict).
* Float and decimal fields now have a `currency` flag property.
* There are two properties for relationship cascade settings now, one for each relation side.
* Whitespaces and 0 values are now allowed for list field entries.
* Upload fields can optionally have also a maximum size.
* The function for orphan removal is now also available for many-to-many relationships (beside one-to-one and one-to-many).
* A new `categorisableMultiSelection` option allows for defining whether multiple categories can be selected for the corresponding entity or not.
* Datetime and date fields can now be declared as start or end.
* Variables reserved in Zikula are now checked not only for field names, but also for entity names.
* Fixed validation of string fields with regular expressions.

### Generator changes

* Implementation and usage of the DSL changes described above, for example a lot of workflows-related stuff.
* Entities with Geographical extension show a map in display and edit pages now (based on mapstraction which is included as a system plugin in the core, so it is easily possible to use different map vendors).
* KML export functionality for entities with Geographical extension.
* When editing entities with Geographical extension a map for selecting coordinates is provided.
* Handling of relations has been reimplemented with form plugins.
* Relationship handling is now done with dropdown lists by default. Using auto completion instead is still possible. Inline creation and editing of related items is only possible when using the auto completion approach.
* Integration for search API and your account panel.
* Support for pending content listener, moderation block and moderation panel.
* Mass handling of objects on admin view pages.
* Support for meta data for the Tag module.
* Automatic archiving if archive and end date are available.
* Using Zikula.UI.Panels in display and edit pages if they become huge.
* Actions in view and display pages are now presented with context menus (similar like in tree management pages).
* Added a quick navigation form for view pages allowing for filtering, searching and sorting the list.
* A new content type allows displaying one certain single object.
* Optional category filters for generic block and both content types.
* Possibility for entering custom templates in list block and list content type.
* For categories multiple registries/trees/properties are now considered everywhere.
* Basic Scribite integration, at the moment there are plugins generated for Xinha, TinyMCE and CKEditor.
* Fixed validation of upload file extensions; this check is now performed on the client-side, too.
* Default implementation for user delete event listener.
* Display and edit actions have been implemented also for ajax controllers.
* Improved permission check instances so that permissions are considered also for single entries now.
* Entities with tree extension (nested set, closure) show relatives on display pages (parents, children, siblings, etc.).
* Fixed problems with creating root nodes in nested sets if length of title or description fields are too small.
* Use text data type for text fields again.
* Fixed definition and handling of many-to-many relations.
* AutoComplete bugfixes for many-to-many and one-to-many relations.
* Further fixes for relation handling during edit.
* Removed obsolete generation of entity classes for m:n reference tables.
* Bugfix for deleting entities with optional upload fields.
* Significant performance optimisations for the shorturl support.
* Fixed storage of attributes, outsourced attribute field names into own method for easier customisation.
* Fixed installation of list vars by using array serialisation only for multiple lists.
* Fixed wrong case keyword for status message determination in edit forms.
* Various bugfixes related with version fields and optimistic locking in the form handlers and validators.
* Added missing tooltip declaration in config templates.
* Fixed id field list retrieval in delete action.
* Fixed repeated object creation.
* Fixed modifier for displaying list field entries.
* Fixed logical error in validation method isStringNotContaining.
* Fixed usage of Gettext in JavaScript.
* Fixed obsolete condition for display hooks output in edit templates.
* Fixed list field handling in form handlers as well as in the output modifier.
* Fixed values for precision and scale of coordinate fields.
* Fixed query for retrieving related objects during editing.
* Removed wrong application of client-side validation to input buttons.
* Also for form plugins there are base classes generated now, for easier extensibility and customisability.
* Usage of prepared statements in repository classes.
* Many minor bugfixes und refactorings (e.g. request object usage).
* For all details see [closed tickets on Github](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.6.0).

## ModuleStudio 0.5.4 (Nov 29, 2011)

* A new selection api simplifies data selection in controller layers.
* Entity actions are now centrally collected for easier extendability and reusability.
* Bugfixes for user fields in combination with tree root nodes and edit forms.
* Validation hooks in form handlers have been armed now (errors cause abortion).
* Form handlers were refactored for outsourcing common code parts into a generic parent class.
* Added generation of templates for custom controller actions.
* Using getOneOrNullResult method for single entity selections.
* Improved formatting of action icons in list views.
* Moved form handler base class location.
* Added standard fields to list of allowed sorting criteria.
* Parameter in image creation util class to be able to crop thumbnails individually, too.
* Bugfixes for error handling and post processing in form handlers.
* Make sort links in view templates consider the parameter for showing all items instead of paginated list properly.
* Improved language detection in bootstrap file when using translatable fields.
* Object actions in admin view templates contain now a preview icon if a user display action exists in the controller model.
* Fixed errors in Content type, generic block and Mailz plugin.
* Added forgotten string field validation calls.
* Fixed JavaScript problems for inline editing of related objects linked by many-to-many relationships.
* Fixed missing generation of view modifier for displaying country names.
* Updated Imagine pathes for thumbnail generation due to vendor changes.
* For more details see [closed tickets on Github](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.5.4).

## ModuleStudio 0.5.3 (Oct 10, 2011)

* A new selection api simplifies data selection in controller layers.
* Entity actions are now centrally collected for easier extendability and reusability.
* Bugfixes for user fields in combination with tree root nodes and edit forms.
* Validation hooks in form handlers have been armed now (errors cause abortion).
* Form handler refactoring outsourcing common code parts into generic parent class.
* Added generation of templates for custom controller actions.
* Using getOneOrNullResult method for single entity selections.
* Improved formatting of action icons in list views.
* Moved form handler base class location.
* Added standard fields to list of allowed sorting criteria.
* Parameter in image creation util class to be able to crop thumbnails individually, too.
* Bugfixes for error handling and post processing in form handlers.
* Make sort links in view templates consider the parameter for showing all items instead of paginated list properly.
* Improved language detection in bootstrap file when using translatable fields.
* Object actions in admin view templates contain now a preview icon if a user display action exists in the controller model.
* Fixed errors in Content type, generic block and Mailz plugin.
* Added forgotten string field validation calls.
* Fixed JavaScript problems for inline editing of related objects linked by many-to-many relationships.
* Fixed missing generation of view modifier for displaying country names.
* Updated Imagine pathes for thumbnail generation due to vendor changes.
* For more details see [closed tickets on Github](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.5.3).

## ModuleStudio 0.5.2 (Sep 8, 2011)

* For most details see [closed tickets on Github](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.5.2).

## ModuleStudio 0.5.1 (Sep 20, 2010)

Too old to be still documented here.

## ModuleStudio 0.5.0 (Aug 21, 2010)

Too old to be still documented here.

## ModuleStudio 0.4.9 (Apr 29, 2008)

Too old to be still documented here.

## ModuleStudio 0.4.3 (Dec 21, 2007)

Too old to be still documented here.