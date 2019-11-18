# Changelog

## ModuleStudio 1.4.0 (unreleased)

### Product / Tooling changes

* Updated to Eclipse 2019-09 (4.13).
* Use SVG icons in included help web app.
* Dropped support for 32 bit platforms.
* Requires Java 11 now.

### DSL / Modelling language changes

* Fixed validation problems of image constraints.
* Added target core versions for Zikula Core 3.0.x.
* Added warning about target core versions 1.5.x becoming deprecated.
* Fixed problems in quick fixes for validation constraints regarding duplicates.

### Generator changes

* Added support for autowiring and autoconfiguration (Zikula 3 only) (#1188).
* Use scalar typehints for Zikula 3.
* Added support for map views showing a list of markers for multiple geographical entities (#1212).
* Added generated configuration option for private mode extending `ownerPermission` setting for viewing data. 
* Form types automatically derive allowed upload file extensions from upload helper.
* Fixed empty list settings for revision handling if an application contains multiple loggable entities.
* Prevent log entry creation from other modules.
* Fixed categories related problem in list content type (does not affect Zikula 1.x).
* Added import for `Response` class used in docblocks (#1205).
* Populate `accept` attribute for upload fields with allowed file extensions.
* Fixed wrong upload field reference in external finder (#1204).
* Fixed hardcoded specific directory structure for Scribite integration (#1202).
* Generate JavaScript edit functions also for just a config page.
* Fixed deletion of replaced upload file (#1206).
* Use title as fallback for description in finder.
* Fixed undefined variable in UI hook provider views (#1207).
* Fixed pagination for categorisable and translatable entities (#1211).
* Allow empty value for list entry validation.
* Fixed creation redirect exception for sluggable entities.
* Added missing min/max attributes for number input fields.
* Fixed wrong fallback value for array fields.
* Fixed logical mix-up of relation sides for embedded editing.
* Inform submitter about pending content approvals.
* Fixed possibly wrong default values for non-nullable integer and user fields.
* Prevent wrong translation domain when resolving list entries in Twig templates.
* Fixed Leaflet inclusion in raw templates.
* Truncate string using whole words in auto completion handler.
* Removed all artifacts which are entirely related to release engineering (Travis and StyleCI configuration files, composer dev requirements).
* Trigger email notifications after workflow transition has been completed.
* Apply workflow not before entity change for proper create notifications.
* Use `*` value for allowing all file extensions in an upload field.
* Use `*` value for allowing all mime types in an upload field.
* Fixed several problems in search helper.
* Fixed several problems in example data helper.
* Improved dynamic activation of loggable listeners in multiple modules.
* Fixed possible wrong quick search results caused by numeric fields.
* Minor cosmetical improvement for auto completion based relation editing.
* Skip client-side past and future validation for empty date values.
* Fixed processing of request-based relation presets in edit forms.
* Ensure multiple join tables between same entities get unique names.
* Restrict custom loggable listener action to entities from same bundle.
* Fixed YAML problems in authentication method service definition.
* Fixed several minor issues in generated technical documentation.
* Fixed possible invalid states for boolean filter in quick navigation.
* Improved handling of entities without view or index actions in moderation panel and moderation block.
* Hide link for creating related items in quick view.
* Overhauled and improved asset handling on raw pages (e.g. for inline editing).
* Properly consider doctrine proxies in listeners.
* Fixed handling of plural forms in translations.
* Avoid date range validation class on other datetime fields in same entity.
* Reselect sluggable entity before redirect after reverting to old revision.
* Fixed typo in UI hooks provider.
* Call filter hooks for text fields on display pages.
* Upgraded MultiHook needle support for MultiHook 6.0.0.
* Added support for Doctrine types `json`, `datetime_immutable`, `date_immutable`, `time_immutable` and `dateinterval` (Zikula 3 only).
* Lowered required permission level for creating entities with moderation.
* Item actions on display pages are not shown inside quick view windows.
* Introduced permission helper method for quick navigation forms; require only view permissions instead of edit (#1218).
* Add support for new `group.pre_delete` event in Zikula Core 3.x targets.
* Added missing `{{ moduleFooter() }}` call to base template (#1219).
* Hide link to own entries for users without edit access (#1220).
* Added reset button to quick navigation forms (#1221).
* Delay automatic filter submission for 5 seconds for improved usability.
* Several fixes for form-aware hook provider dummy implementation.
* Select collections without joins by default.
* Fixed creator filter in admin area.
* Fixed regression in workflow state exclusion filter.
* Fixed wrong fallback value for editing optional multi list fields.
* Moved permission inheritance functionality and category permission checks into permission helper to apply them for search and other integration areas (#1223).
* Fixed tree selection form type with duplicate labels.
* Disable CSRF protection for quick navigation forms, fixing redirects after editing.
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.4.0).

## ModuleStudio 1.3.2 (September 20, 2018)

### Product / Tooling changes

* Updated to Eclipse 2018-09 (4.9).
* Added generic connection creation tool. Read more about that [here](32-DiagramEditor.md#palette-standard-tools).
* Ensure all diagram layers are correctly displayed for newly added entities (#1199).

### DSL / Modelling language changes

* none

### Generator changes

* Added permission helper to support implementations of custom permission layers (#1187).
* Re-enabled support for Content types in Zikula 2.x by migrating them to Content 5.
* Fixed design problem with upload files handling (file names and file objects are stored in different fields now).
* Allow normal creation of tree entities by selecting a parent.
* Added item action for creating tree sub nodes.
* Improved and fixed different possible drag n drop behaviours of tree nodes (including multi tree support).
* Fixed behaviour of multiple trees on same page (searching, expanding/collapsing, etc.).
* Reuse item actions also for tree context menus.
* Updated check to avoid dragging tree root nodes.
* Minor cosmetic improvements for tree pages.
* Minor cleanup in ajax tree handler.
* Enabled reuse functionality for entities with trees.
* Fixed several issues in entity tree form type.
* Fixed undefined variable in tree relatives macro.
* Allow undeletion of loggable entities also without display action.
* Refactored usage of deprecated service in item actions menu for loggable entities.
* Call `postLoad` event handler for freshly initialised undeleted objects.
* Improved permission checks for loggable history actions.
* Added possibility to limit loggable history by amount of log entries or date intervals.
* Fixed typo in `loggableHistoryActionInternal` signature.
* Show latest loggable version as part of meta data during editing.
* Introduced loggable helper class for reusing common logic and taking load from controllers.
* Enhanced history and diff views showing array field details.
* Added additional field for log entries for storing an extended description of the executed action which produced a log entry. This is shown in both the normal history view as well as the list of deleted items (which helps to identify a specific one).
* Show user profile link and avatar for creator and last editor in history and diff views.
* Made `parent` relation versionable for loggable entities with a tree in order to improve their undeletion.
* Removed version annotation from root, lft, right and lvl properties to improve revert process.
* Removed version annotation from translatable locale to avoid unrequired log entries.
* Dynamically disable and reenable loggable listener when persisting translations to avoid unrequired log entries.
* Added revision handling for translations (combining loggable with translatable).
* Enhanced history and diff views showing changes per language for translatable entities.
* Translatable performance fix.
* Fallback fix for empty translation data.
* Corrected route requirement for tree slugs containing slashes.
* Improved behaviour or tree slug handlers and relative slug handlers.
* Fixed unique slug handling in tree actions.
* Improved form redirect behaviour, e.g. with regards to translatable slugs.
* Provide unique slug in item actions and display sections for creating related items.
* Fixed wrong arguments for ajax-based slug unique check.
* Fixed handling of unique slugs for relation form presets.
* Added support for `preFlush`, `onFlush` and `postFlush` Doctrine events in entity lifecycle listener.
* Proper service injection into menu builder.
* Added pre and post configuration events for amending or extending item actions menu (#1193).
* Updated logic for title and description field name determination.
* Applied default filters from `CollectionFilterHelper` also to selections of single entities by default.
* Removed usages of param converters.
* Prevent Imagine usage during SWF file handling.
* Added configuration settings to control usage of moderation fields in edit forms of entities with standard fields.
* Added configuration setting for whether only own entries should be shown on view pages by default or not.
* Automatically preset language/locale fields in entity initialiser.
* Added more differentiated subjects for workflow notification mails.
* Improved image handling for PDF output.
* Improved visualisation of boolean field states using bootstrap text classes.
* Always show boolean fields on display pages.
* Added custom messages for date related validation constraints.
* Fixed dependency syntax in composer file.
* Show a warning instead of an error during installation if category registries could not be created.
* Added `raw` filter to JSON output.
* Minor improvements for CSV and XML output.
* Avoid confusing placeholder text for expanded relationship representations.
* Improved handling of unidirectional one to one relationships.
* Excluded fields used as custom join columns from edit forms.
* Removed loading of unrequired bootstrap-jqueryui assets.
* Logical fix in list entry validator.
* Moved default sorting determination in controller helper into own method.
* Added missing check in entity initialiser.
* Fixed count queries with join conditions.
* Improved dynamic checks for hook enablements.
* Added sorting by updated date to list block, list content type, mailz and newsletter plugins.
* Fixed slightly wrong help messages about minimum and maximum values.
* Do not assume that table column exists for current sorting field.
* Fixed and improved client-side date range validation.
* Fixed several minor issues with relationship auto completion.
* Avoid invalid item actions and display page sections for unidirectional many-to-many relationships.
* Fixed wrong check if one-to-one relation already exists in item action menu (#1200).
* Added a check for whether view action exists in templates for moderation block and moderation panel.
* Fixed wrong handling of `enabledFinderTypes` setting in external controller (#1191).
* Properly consider `mandatory` flag in relation editing inclusion templates.
* Added missing remarks for text fields, email fields, url fields and object fields to technical docs.
* Fixed client-side date and datetime resetting functionality.
* Fixed detection of geolocation enablement.
* Consider collection filtering and translation walker in search helper.
* Trim leading and trailing regex slashes for client-side validation.
* Avoid assigning invalid routes to processing hooks.
* Fixed wrong method call for creating thumbnail images within auto completion.
* Readded missing recover action for trashed data in 2.x targets.
* Fixed wrong formatting of time fields in entity display helper (#1194).
* Removed updated date from RSS item title.
* Fixed wrong call to webmaster email address in RSS templates (#1197).
* Avoid exception in archive helper when module has just been uninstalled.
* Improved detection of whether magnific popup is available.
* Cleanup for request access (use request stack as late as possible).
* Fixed categories handling in list blocks.
* Explicitly set translation domain for block form types.
* Some fixes for example data creation.
* Fixed typos related to example row handling (#1185).
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.3.2).

## ModuleStudio 1.3.1 (May 30, 2018)

### Product / Tooling changes

* Updated to Eclipse Oxygen.3 (4.7.3).
* Force refresh after context menu actions for repositioning fields in diagram editor.
* Build improvements for Mac OS - the product archive now contains a proper app bundle with a `ModuleStudio.app` directory.

### DSL / Modelling language changes

* Fixed wrong validation of minimum value constraint if no maximum value constraint is set.
* Default value for `sourceEditing` property of many to one relationships is now `CHOOSE` instead of `NONE`.
* The finder is now also supported for entities containing image upload fields but no display action (#1182).

### Generator changes

* Exclude many to one relationships from outgoing edit relations.
* Updated some deprecated SPDX license identifiers in composer file.
* Fixed typo in pending content listener.
* Generate inline usage redirect in form handler only if needed.
* Properly initialise image thumbnail options for display hooks template.
* Logical fix for removing old upload files.
* Added fallback check to list field transformer.
* Fixed typo in tree slug handler annotation.
* Avoid index column size too large on MySQL < 5.7 for log entries and translations (see [this issue](https://github.com/Atlantic18/DoctrineExtensions/issues/1904) and [this patch](https://github.com/Atlantic18/DoctrineExtensions/pull/1905) for the details).
* Ensure custom view sorting is properly reflected in the pager.
* The finder is now also supported for entities containing image upload fields but no display action (#1182).
* Fixed workflow definition syntax for 2.x targets (#1184).
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.3.1).

## ModuleStudio 1.3.0 (Feb 1, 2018)

### Product / Tooling changes

* Updated to Eclipse Oxygen.2 (4.7.2).
* Avoid broken diagram if problems with parsing textual model occur. Read more about that [here](32-DiagramEditor.md#visualisation-of-parsing-issues).
* Fixed double palette entries after synchronising diagram after saving model changes in textual editors.

### DSL / Modelling language changes

* All non-UI parts of the DSL (like model parser, validation constraints, formatter) are now automatically tested (#1170).
* Removed obsolete DSL elements (#1173).
* Several fixes for relations from/to mapped super classes.
* Fixed wrong validation logic regarding item actions settings.
* Improved several relation-oriented validation constraints considering inheritance hierarchies.
* Fixed non-working validation constraint to verify an entity has only one outgoing inheritance relationship.
* Overhauled validation constraints for reserved slug field.
* Added validation constraints with quick fixes for required minimum length of ISBN and ISSN fields.
* Added validation constraint with quick fixes for minimum and maximum image pixels.
* Added validation constraint for unique values of list items.
* Several further fixes and improvements for the validation layer.
* Allow dots, commas, slashes and brackets in text of list items.
* Removed some unneeded validation constraints.

### Generator changes

* The generator is now automatically tested (#1170).
* Added image EXIF data to upload field meta data (#1175).
* Added auto-rotation of incorrectly oriented images (#1176).
* Added missing separator for inheritance discriminator map.
* Added generation of a `custom.css` file for easier addition of custom styles.
* Fixed model to model transformation issue with mapped super classes.
* Fixed several filter queries for variables in multiple containers.
* Fixed regular expression for detecting Twig variables in documentation fields.
* Consider query arguments in URI for repeated creations.
* Reenabled `trashed` workflow state (#1177).
* Minor fix for undeletion check during persisting log entries.
* Define weight for loading magnific popup to ensure proper load order.
* Avoid processing search value as normal collection filter.
* Skip feature activation helper in quick navigation to prevent pager issues.
* Added links to switch between only own and all entries on view pages.
* Updated implementation of pending content listener.
* Explicitly set translation domain in UI hook template.
* Use default selection for sorting related items in quick navigation.
* Fixed typo in ICS template.
* Reactivated possibility to manually specify a slug value.
* Show delete actions and delete submit button in edit forms with edit permissions if `ownerPermission` is enabled.
* Simplified customisability of category-based permission checks behaviour.
* Skip `handleCommand` action in form handler when cancel action is clicked.
* Added missing readonly attribute to field form type options (#1179).
* Prevent form validation when `cancel` button is used (#1180).
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.3.0).

## ModuleStudio 1.2.0 (Dec 16, 2017)

### Product / Tooling changes

* Added icons to all quick fixes which did not have one yet.

### DSL / Modelling language changes

* Removed obsolete DSL elements (#139).
* Improved validation with regards of detecting missing names and other mandatory settings.
* The formatter now adds a new line after the last closing bracket.
* Generator settings are now defined at the application element directly; settings containers are not used anymore (#1172). A quick fix is provided for simple migration.
* The `nospace` property has been deprecated and will be removed in ModuleStudio 1.4.0 (#1174). A quick fix is provided for simple migration.
* Added `minPixels` and `maxPixels` constraints to upload fields for Zikula 2 (#1171).
* Added `immutable` flag for datetime, date and time fields (#1171).
* Added new string field role `PHONE_NUMBER` for telephone numbers (#1171). 

### Generator changes

* Re-added CSS class for image shrinking enablement.
* Increase memory limit for shrinking large original images.
* Fixed logical problem in list field default settings in `EntityInitializer`.
* Fixed placement of reset button on configuration pages.
* Check if magnific popup is loaded before using it.
* Added missing JavaScript inclusion for UI hooks provider.
* Fixed idPrefix for initialising UI hook provider auto completion.
* Support legacy subscriber URLs in UI hooks provider.
* Fixed declaration in legacy item selector form type.
* Fixed constructor arguments for `IntlDateFormatter` in `EntityDisplayHelper`.
* Fixed inline editing redirect if no auto completion is used.
* Introduced `getFormOptions` method in form handlers for easier customisation.
* Added some new features of Symfony 3.4 for Zikula 2 (#1171).
* Workflows may contain multiple transitions with the same name again in Zikula 2.x (#1171). Thus, instead of `updatewaiting`, `updateapproved` and so on simply `update` is used again.
* Applications for Zikula 2 support an additional workflow event (`completed`) introduced in Symfony 3.4 (#1171).
* For Zikula 2 the colour form type is not generated anymore, since it is provided by Symfony 3.4 (#1171).
* A form field for telephone numbers is used for the new string field role `PHONE_NUMBER`. For Zikula 2 it is used from Symfony 3.4, for earlier versions it is generated (#1171). 
* Avoid selecting deletion log entries for undeleted entries.
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.2.0).

## ModuleStudio 1.1.0 (Nov 26, 2017)

### Product / Tooling changes

* Removed redundant filter panel.
* Removed unused table editors.
* Added possibility to open textual editor from dashboard view or main menu.
* Hide `defaultValue` property for some field types (list, upload, array, object).
* Hide `fixedLength`, `nospace` and `minLength` properties for list and upload fields.
* Hide `sluggablePosition` property for some field types (email, url, list, upload).
* Hide `sortableGroup` property for upload, array and object fields.
* Hide `translatable` property for some field types (list, upload, array, object).
* Reduced font size for splash screen (#100).

### DSL / Modelling language changes

* Variable elements have been deprecated. Variable containers include normal fields now instead. There are [quick fixes](33-Views.md#quick-fixes-for-problems) available for migrating variables in existing models (#97). So you can now use many more options and field types for configuration pages, e.g. colours, countries, locales, timezones, email addresses, uploads, date intervals, expanded lists, and so on.
* Datetime, date and time fields have been unified. Thus, date and time fields have been deprecated. You can use datetime fields and configure the `components` property instead (#1154).
* The `version` property for date time fields has been removed. Better use integer fields for versions, as datetimes could potentially lead to conflicts for high traffic sites depending on the timestamp resolution in the database. As the Doctrine 2 manual points out integers are more robust against race conditions in high traffic environments where timestamp comparisons are limited due to how precise the used database does it.
* A new number field type supersedes decimal and float fields which have been deprecated. A `numberType` property allows to specify whether a decimal or a floating number is desired (#1155).
* Added new upload naming scheme for user defined file names (#862).
* Allowed dashes in list item names (whitespace and underscores were already allowed before).
* Added new relationship properties for permission inheritance to control whether and how the source visibility should affect the target visibility in view and display pages (#1125).
* The `editType` property of join relationships has been deprecated in favour of two new properties `sourceEditing` and `targetEditing`. Beside inline editing now also embedded editing is supported (but limited to single-valued sides for now) (#3).
* Added new generator setting `generateTechnicalDocumentation` for creating stand-alone HTML files with technical documentation (#1166).
* Added new generator settings to configure different placements and styles for item actions (#1169).

### Generator changes

* Fixed potential form redirect problem for edit and display pages of entities without unique slugs.
* Slug support has been extended to utilise tree slug handlers and relative slug handlers (#305). Relative slugs will only be used for now if both entities (connected by the corresponding relationship) have sluggable fields.
* Avoid putting thumb runtime options into query to prevent pager problem.
* Use named argument for `notifyDisplayHooks` calls.
* Fixed problems in RSS and Atom templates.
* Fixed usage of `getChildrenQueryBuilder` in list content type.
* Fixed edge case in `CategoryHelper`.
* Fixed some Font Awesome icon usages.
* Fixed potentially missing generation of `ThirdPartyListener` for 2.x targets (#1145).
* Fixed potentially missing generation of detail block form type for 2.x targets (#1146).
* Properly consider incoming relationships acting as primary key.
* Reload view page after drag n drop resorting.
* Improved formatting of list field item text.
* Fixed formatting of relation alias parameters for relation presets in edit forms.
* Fixed potentially missing generation of inline editing JavaScript file.
* Added fallback for non-existing moderation group modvars.
* Disabled `@Cache` annotations to prevent confusion.
* Introduced a container element for fields with inline editing to improve JavaScript reliability.
* Fixed Symfony 3 incompatibility in translation listener.
* Minor adjustments for security schema collection in composer file.
* Added missing raw filter for display hook inclusion.
* Explicitly specify translation domain for item action menu definitions.
* Keep own items filter during view page navigation (#1149).
* Ensure filters are not applied for backend pages (#1150).
* Fixed undefined isCategorisable variable in list block editing (#1151).
* Apply start and end date filters also for related items (#1152).
* Module variables are handled in a dedicated `AppSettings` class (#97). This also allows for easy addition of custom behaviour, like for example clearing the cache after a specific setting has been changed.
* Prevent user access to detail pages of waiting entities.
* Utilise new category selector option `showRegistryLabels` (#1147).
* Moderation fields in edit forms are now limited to admin permissions.
* Added permission based filtering for view pages.
* Added relation-based permission filtering for view and display pages (#1125).
* Fixed multi list filters in quick navigation.
* Added missing argument assignments in detail block form type (#1158).
* Fixed wrong container reference in detail block class (#1159).
* Fixed wrong route parameter default in external controller.
* Added missing parameter in parent call in external controller (#1159).
* Added support for embedded editing of related objects (#3).
* Avoid item actions for preview of deleted items.
* Added generation of technical documentation reports (#1166).
* Improved identifier and version handling during undeletion of loggable entities.
* Several other improvements for loggable entities.
* Changed private visibility of several member variables to protected (#1168).
* Removed fixed columns from view actions (crude and problematic).
* Avoid image distortion when shrinking too large dimensions.
* Use configured thumbnail mode also for shrinking original images.
* Added support for different placements and styles for item actions (#1169).
* Fixed logical error in category related quick nav parameter handling.
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.1.0).

## ModuleStudio 1.0.2 (Oct 3, 2017)

### Product / Tooling changes

* Updated to Eclipse Oxygen.1 (4.7.1).
* Avoid skipping some relationship validation constraints in wrong cases.
* Ensure that only one settings container can be added to a model.
* Initially assigned names for new data objects now contain an incrementing counter.
* Double-clicking several model elements opens an embedded textual editor inside the diagram editor. Read more about that in [this section](32-DiagramEditor.md#embedded-textual-editor).

### DSL / Modelling language changes

* The `sourceAlias` and `targetAlias` attributes moved from `JoinRelationship` to `Relationship`, so also inheritance relationships have these now.
* Made textual grammar more flexible with regards to relation sources and targets in order to improve support for mapped super classes.

### Generator changes

* Use fine-grained processing of display hooks again (#1132).
* Fixed form type option `inline_usage` missing in some cases (#1130).
* Reactivated Scribite support for Zikula 2.x (#1133).
* Added support for Scribite 6.0 providing additional plugins for new Quill and Summernote editors (#1133).
* Updated TinyMCE plugin (#1133).
* Fixed issues in Scribite plugins if Zikula is installed in a sub directory (#1133).
* Fixed ignored amount of items quick navigation setting.
* Properly consider `nullable` flag for user fields.
* Fixed potential exception in archive helper (#1140).
* Cleaner UI for repeated item creation (#1138).
* Fixed wrong reference in JavaScript handling of tree operations.
* Improved performance for ajax-based tree operations.
* Fixed missing search results (#1117).
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.0.2).

## ModuleStudio 1.0.1 (Sep 2, 2017)

### Product / Tooling changes

* Fixed copying of diagram image and model files to docs folder if no generator settings element has been created.
* Overhauled example models for showing a wider range of functionality (#1098).
* Simplified and improved wizard for creating new projects.
* Disable _Delete project_ action if no project is opened.
* Disable _Validate diagram_, _Generate application_ and _Print preview_ actions if no editor is opened.
* Added _Copy project_ action to duplicate the current project using a new name (#802).
* Fixed some wrong mnemonics for main menu actions.

### DSL / Modelling language changes

* Added new generator setting for a block providing a detail view for one specific entity (#883).
* Added new generator setting for configuring generation of support for PDF export (#798).

### Generator changes

* Removed `composer.lock` and `phpunit.xml` from `.gitignore`.
* Added `require-dev` section to `composer.json` containing PHPUnit, analysis tools and phpDox.
* Fixed several errors regarding hook providers (#1095 - #1097, #1100 - #1102, #1105 - #1111, #1121, #1122).
* Added missing relationship editing templates if `generateSeparateAdminTemplates` is activated (#1099).
* Updated sorting classes for Zikula 2.0.1.
* Fixed route parameters for history and diff views of entities with unique slugs.
* Updated forgotten target version fallback from `ZK15` to `ZK20`.
* Use central parent service for form handler service definitions.
* Fixed deprecated usage of isbn constraints (#1114).
* Added generation of StyleCI configuration file.
* Migrated obsolete `OptionsResolver` method call (#1116).
* Fixed logical issue in `SearchHelper` (#1117).
* Fixed invalid redirect after mass operation if no index action is available (#1118).
* Fixed UI hooks inclusion in subscriber templates.
* Fixed empty submission and display for optional and nullable date/datetime fields.
* Fixed updating hook assignment URL information of updated subscriber data objects.
* Fixed logical issue in quick navigation form for disabled categories enablement.
* Fixed typo in Newsletter plug-in (#1123).
* Fixed date filter argument in RSS templates (#1124).
* Fixed processing of translatable slugs (#1094).
* Separated inline editing from auto completion (#1084).
* Added option for custom display template in single object content type (#965).
* Added unarchive action to republish archived items (#225).
* Moved `ParamConverter` and `Cache` annotations from base controllers into child controllers.
* Fixed `Cache` annotation for edit actions (#1126).
* Added fallback for list block templates if no content types are generated.
* Added support for a block providing a detail view for one specific entity (#883).
* Inline editing is now not only possible for auto completion, but also for list-based relationship sides (selects, check-boxes, radio buttons) (#982).
* Properly consider `NONE` as passive edit type for the target side of a relationship.
* Minor improvements for multiple relationships between same entities.
* Skip return control and additional moderation fields (custom creator, custom creation date) for inline editing.
* Introduced the Leaflet library for geographical functionality replacing Mapstraction (#340).
* Improved support for exporting PDF files (#798).
* Fixed deletion of optional upload files when no new file was provided.
* Fixed permission level for submission of new entries with workflows with approval (#1129).
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.0.1).

## ModuleStudio 1.0.0 (July 31, 2017)

### Product / Tooling changes

* None

### DSL / Modelling language changes

* The default target version is now `ZK20` (#1080).
* Support for Zikula 1.4.x has been removed (#1080).

### Generator changes

* None
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.0.0).

## ModuleStudio 0.7.5 (July 31, 2017)

### Product / Tooling changes

* Updated to Eclipse Oxygen (4.7).
* Removed packages for Linux PPC.
* Added error tracking functionality and a setting to disable it.
* Corrected missing icons for quick fixes.
* Removed some unrequired preference pages.
* Enumerations with many entries are now rendered as select widgets instead of radio widgets in properties view.
* Overhauled form-based properties view, organising the properties into multiple tabs and sections.
* Readded missing `minValue`/`maxValue` properties for integer fields to properties view.
* Removed the old tabular properties view entirely.
* Prevent potential NPE during editor initialisation (#1092).

### DSL / Modelling language changes

* The default target version is now `ZK15`. In the same step `ZK14` and `ZK14DEV` have been marked as deprecated and will be removed after the release of ModuleStudio 1.4.0 (#1081).
* Added target version `ZK2DEV` to separate stable and development versions of Zikula 2.x. 
* Minor improvements for validation of inheritance hierarchies (e.g. duplicate fields and actions, display pattern field references, no additional fields or actions).
* Added support for hook providers (filter hooks, form aware hooks, UI hooks) (#15).
* Several boolean flags of string fields (like `bic`, `country`, `locale`, and so on) are replaced by a single `role` property represented by a select widget. Note while your old models can still be opened these properties are **not migrated automatically**. This means you will have to set the `role` property to the desired semantics for your existing fields.

### Generator changes

* Fixed some issues with auto completion based relationship handling (#1054, #1056).
* Fixed generation of applications containing inheritance relationships (#1055).
* Fixed typos in `DiscriminatorMap` annotation (#1057, #1058).
* Fixed wrong import statement for inheriting entities (#1062).
* Fixed form field options for list block if only one entity exists (#1063).
* Fixed categories related typo in list block editing template (#1065).
* Fixed resizing of too huge original images.
* Fixed cosmetic issue in categories filter in quick navigation forms in XS viewport (#1074).
* Fixed potentially wrong routes in RouteUrl objects.
* Applications for Zikula 1.5+ support form aware hooks and non-persisted hooks (#1072).
* Properly consider inheritance in `ListEntriesHelper`.
* Fixed workflow state field related issue for child entities (#1064).
* Several other fixes regarding entity inheritance (#46).
* Fixed resorting of view pages using table column headers or quick navigation.
* Auto completion fields for related items are automatically triggered after having created a new one (#1060). Additionally, if only one result is found this is automatically selected.
* Applications for Zikula 2.0 support additional workflow events (`entered` and `announce`) introduced in Symfony 3.
* Image field constraints are now shown as hints in edit forms.
* Skipping third party integrations for Zikula 2.0 applications whose modules are not migrated yet (#1075).
* More robust handling of invalid filters in blocks, content types as well as Newsletter and Mailz plugins (#1082).
* Properly set default values for editing new blocks in Zikula 1.5+.
* Example data insertion has moved from the installer to a post installation event handler to have own services available.
* Relocated Scribite plugins to prevent confusion with gitignore (#1086).
* Fixed wrong query expression in finder if only images are selected (#1088).
* Replace German umlauts in application name/author/vendor to prevent invalid composer files.
* Fixed wrong entity access during adding/releasing page locks in edit form handlers.
* Strip tags when showing truncated text fields on view pages.
* Properly detect item action titles if Bootstrap tooltips are used, too.
* Properly handle finder pop-up if primary object type is forbidden.
* Fixed ajax-based duplicate check.
* Fixed processing of upload field of entity being edited in display pattern resolver.
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.7.5).

## ModuleStudio 0.7.4 (May 19, 2017)

### Product / Tooling changes

* Updated to Eclipse Neon.3 (4.6.3).
* Made preference fields optional (#1001).
* Fixed non-critical but ugly startup error on Mac OS.
* ModuleStudio features and updates are now signed using a purchased certificate (#801).
* The Windows executables (exe files) are additionally signed to satisfy Windows SmartScreen (#801).

### DSL / Modelling language changes

* Removed the `softDeleteable` property which had been deprecated before (#970).
* Added target versions for Zikula 1.5.x.
* The generator settings `generateMailzApi`, `generateNewsletterPlugin`, `generateTagSupport` and `generateMultiHookNeedles` are now `false` by default instead of `true` (#994).
* Added new generator setting `separateAdminTemplates` to allow generating independent templates for admin and user areas (#685).
* Removed support for composite primary keys. Each entity may only have max. one field marked as `primaryKey` (#1035). Using multiple foreign keys in a relationship is still supported though.
* Added new generator setting `authenticationMethod` to control whether a skeleton for an authentication method should be generated or not (default value is `NONE`) (#361).
* Added possibility to mark a string field as `dateInterval` (#229). Only applicable for Zikula 2.0.
* A variable container can now act as `composite` (#390). More details can be found in the [generator reference](87-GeneratorReference.md#variables).
* Added `ACTIVE_CHOOSE_PASSIVE_CHOOSE` edit type, removed restrictions of some other edit types (#330).
* Added `sortableGroup` flag to `ManyToOne` relationships (#29).
* The default value of `bidirectional` is `false` again to prevent serialisation problems.

### Generator changes

* Fixed handling of `DateTime` values in history view of loggable entities.
* Use new general deletion form type for delete actions for Zikula 1.5.0+ instead of generating a custom form type class.
* Use `PermissionApiInterface` for Zikula 1.5.0+.
* Added a simple implementation for array field on display and edit pages.
* Refactored search integration form options for Zikula 1.5.0+ (#972).
* Avoid `Image` validation constraint for upload fields supporting also other file types.
* Made check for slug parameter in selection helper more robust.
* Fixed logging of upload fields.
* Fixed broken redirect for entities with only edit actions.
* Made form fields for nullable relationships unrequired.
* Removed listener generation for some deprecated events (related to `user.gettheme`, `pageutil.addvar_filter`, `system.outputfilter`, old module dispatching, legacy APIs, legacy core, Smarty theme templates, Smarty module templates).
* Set translation domain explicitly in link container.
* Provide entity change set to filter event classes in `preUpdate` events.
* Use new workflow system based on Symfony workflow component for Zikula 1.5.0+ (#973).
* Category-related fixes for when using multiple registries.
* Use form type class constants for Zikula 1.5.0+.
* Fixed problem with `datetime-local` input field and the validator.
* Generate a configuration setting for controlling which object types should be used in Scribite plug-ins / Finder component (#894).
* Minor fix for `localizedcurrency` filter usage.
* Excluded user fields from sorting because it would require joining the user table for each user field in almost all queries.
* Several tree handling fixes.
* Minor fix for sorting behaviour (route argument was not evaluated correctly anymore).
* Updated category integration for Zikula 1.5.
* Refactored list entry validation callbacks as custom validation constraint.
* Fixed datetime input problems with webshim.
* Removed selection helper in favour of entity factory (#975).
* Quick navigation is now hidden by default. There is a filter button added which can be used to show it again.
* DateTime fields are now persisted in UTC for Zikula 1.5.0+.
* Eliminated custom loggable listener (#984).
* For Zikula 1.5.0+ new API interfaces are used for type hinting service arguments.
* For multiple groups tabs are now used instead of collapse sections on display and edit pages (#974).
* Use truncate filter for text fields on view pages (#990).
* Added entity initialiser for dynamic application of default values (#995).
* Support `detectCorrupted` constraint for image upload fields in Zikula 2.x (#799).
* Prevent marking unchanged numeric values as dirty causing loggable picking them up from the entity changeset.
* Replaced `getTitleFromDisplayPattern()` entity method by an `EntityDisplayHelper` class and a corresponding Twig filter (#979).
* Removed more usages of legacy util classes (#979).
* Cleanups for repository classes (#1002).
* Avoid deletion of parent objects if related children exist for a relation without delete cascade (#11).
* Added more configuration settings for geographical options (defaults for latitude, longitude, map type and zoom level) (#1000).
* For applications containing language or locale fields a configuration setting is generated allowing to activate locale-based filtering in the frontend (#998).
* Added custom sluggable transliterator for proper handling of umlauts and accents during permalink generation (#241).
* Reviewed and overhauled help texts about field constraints in edit forms (#847).
* Utilised some features of Symfony 3 for the `ZK20` target (#797). This includes new stuff from Symfony 3.1 and 3.2. News from Symfony 3.3 are approached later (after Zikula 2.0 has been updated to it).
* AutoCompletion is now based on jQuery UI instead of typeahead (#1045).
* Added possibility to reorder sortable entities on view pages using drag n drop (#29).
* Added a reset link for unsetting a non-mandatory user field (#1047).
* Several other bugfixes.
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.4.0).

## ModuleStudio 0.7.3 (Feb 18, 2017)

### Product / Tooling changes

* Now there is a stand-alone generator available (#967). Read more about that [here](60-GeneratingApplications.md#stand-alone-generator).
* Hide some unrequired `MostDsl` preference sub pages (`Compiler`, `Refactoring` and `Task Tags`).
* Removed model migration from 0.6.x.

### DSL / Modelling language changes

* Fixed problem in meta class operation preventing some validation constraints from being executed correctly.
* Fixed non-working validation constraint for ensuring a display pattern.
* Fixed problem in formatter to avoid new lines between closing brackets and commas.
* The `softDeleteable` extension has been deprecated. Consider using `loggable` instead.

### Generator changes

* Fixed access to entity property in constraint expression for date range validation.
* Fixed categories selection in detail content type.
* Assign created date instead of creating user in search results.
* Support pasting relative links as well as absolute urls in Finder selection dialog used by Scribite plug-ins (#966).
* Avoid fixed columns for tables without item rows.
* Fixed missing closing curly bracket in item actions menu for entities with multiple related item types.
* Added missing `endif` tag for private message links displayed next to user fields.
* Fixed wrong markup for map container in edit form of geographical entities.
* Fixed initialisation of geographical editing.
* Put page navigation links on view pages in a paragraph.
* Exclude version fields from editing (#30).
* Fixed entity manager reference for edit locking.
* Use AbstractLogEntry as base class for log entry entities (#30).
* Added change history page for loggable entities (#30).
* Allow displaying previous versions of loggable entities (#30).
* Allow reverting loggable entities to previous versions (#30).
* Avoid deleting upload files for loggable entities (#30).
* Added a trash section for viewing deleted loggable entities (#30).
* Allow viewing deleted loggable entities (#30).
* Allow undeletion of deleted loggable entities (#30).
* Provide diff view for comparing different versions of loggable entities (#30).
* Avoid `scale` option for range form type.
* Improved editing translatable fields (#177).
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.7.3).

## ModuleStudio 0.7.2 (Feb 12, 2017)

### Product / Tooling changes

* When creating many-to-many relationships a default value for the `refClass` attribute is set automatically (#943).
* Fixed some missing German translations (#944).
* Minor vendor updates.

### DSL / Modelling language changes

* Multiple order by fields and custom sorting directions are allowed for `OneToManyRelationship` and `ManyToManyRelationship` elements. See the [generator reference](87-GeneratorReference.md#ordering-many-valued-relationship-sides) for examples.
* Foreign keys are allowed to be referenced by index items.
* Changed errors about non-existing source/target fields (other than `id`) to warnings (as foreign keys are automatically created by Doctrine).
* The `bidirectional` property has been removed for `ManyToOneRelationship` and `InheritanceRelationship` (#943).
* The default value of `bidirectional` has been changed to `true` (#943).
* The default value of `editType` has been changed to `ACTIVE_CHOOSE_PASSIVE_NONE` for `ManyToManyRelationship` and `ACTIVE_NONE_PASSIVE_CHOOSE` for other join relationships (#943).
* Removed some obsolete DSL elements (#914).

### Generator changes

* Fixed typo in creation methods of entity factory class.
* Several fixes for user fields handling.
* Fixed typos in hook subscriber bundle initialisation.
* Avoid unwanted output in unique entity constraint for unique index annotations.
* Create boolean modvars for account page controls only if `generateAccountApi` setting is `true`.
* Initialise polyfills also for config pages (#949).
* Reactivated loading jQuery UI for related item quick view windows.
* Provide `radio-inline` and `checkbox-inline` classes for expanded relation choice fields.
* Removed generation of obsolete doc files (#948).
* Added missing comma in route annotation parameter requirements for non-unique slugs.
* Fixed syntax problems in param converter parameter options.
* Use new `LocaleApi` for Zikula 1.4.6+.
* Implemented `SearchableInterface` for Zikula 1.4.6+ (#956).
* Added links for sending private messages to users in Zikula 1.4.6+. 
* Fixed problem with url-encoded upload file pathes.
* Fixed tree usage combined with translatable (#226).
* Fixed wrong variable names for moderation groups in notification helper (#954).
* Fixed incorrect loop over group members in notification helper.
* Improved usage of tree verification and recovery.
* Improved referencing the base path in templates (#953).
* Added tree node actions for moving to top and bottom.
* Several fixes for content types (#952).
* Support new image script in Zikula 1.4.6+ (#958).
* Removed `NotBlank` constraint for slug fields.
* Select entity by slug only if slug is unique (#959).
* Automatically provide settings related to geographical features (#960).
* Corrected `maxlength` attribute for time form types.
* Allow realising email notifications using designated entity fields (#955).
* Prevent error if default value for an `IntVar` is not numeric.
* Added support for dynamic Twig variables used in documentation fields (for variable containers and entities) (#889).
* Moved item actions into first column of view actions, also made them fixed (#964).
* Updated permission levels for item actions to create related items (#963).
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.7.2).

## ModuleStudio 0.7.1 (Jan 18, 2017)

### Product / Tooling changes

* Generator workflow exports the diagram only as JPG and only if `writeToModelDocs` is `true`. The JPEG file is placed in the same directory as the model file itself (#903).
* Prevent potential null pointer exception on model import.
* Fixed editor tab display which did not always show correct titles.
* Improved dynamic filtering of visible property sheet tabs.
* Fixed wrong title of problems view in English version (#902).
* Fixed broken marker images in problems view (#902).

### DSL / Modelling language changes

* Removed support for Zikula 1.3.x (#260).
* The `writeModelToDocs` setting is now `true` by default.
* The `nospace` constraint is not required to be activated for string fields for bic, countries, currencies, languages, locales, ip addresses, colours and uuids anymore. It is added automatically as part of the generator workflow instead (#12).
* Support for controller elements has been removed in favour of entity controller actions (#715).
* The `IpTraceable` extension is now supported (#452).
* The `Blameable` extension is now supported (#910).

### Generator changes

* Added missing arguments for category helper in installer class (#904).
* Use PlainResponse for external finder action.
* More reasonable naming of user referencing standard fields. Creating and last updating users are now joins referencing the `UserEntity`.
* User fields are now generated as joins referencing the `UserEntity` (#910).
* Use more readable YAML syntax for argument lists (#900).
* Introduced `GeographicalTrait` and `EntityWorkflowTrait` removing redundancies in entity classes (#890).
* Moved automatic archiving from bootstrap file into helper class (#909).
* Show no placeholder option for mandatory list fields.
* Improved base directory structure for easier understandability (#866).
* Fixed wrong call of `createdBy` user object if a new entity with enhanced workflow is created (#913).
* Fixed wrong initialisation of user fields in entity constructor.
* Allow empty value in choice constraint callback for non-mandatory single-valued list fields.
* Simplified some JS methods and moved almost all inline JavaScript code into dedicated JS files (#891).
* Create dedicated helper template for moderation panel.
* Allow managing related child items when editing parent objects (#10).
* Fixed editing entities with relations which define a custom source or target field (#906).
* Store referers for form redirects in session for each module independently.
* Added missing import for user fields validation.
* Fixed wrong reset value for upload fields when cloning an entity.
* Fixed initialisation of relationships preset as url arguments (#916).
* Improved support for custom template sets and block template overrides.
* Skip truncate for tree and softdeletable entities during installation (#794).
* Added supportsSlugInputFields method and hide slug inputs for now (#788).
* Updated form fields option for nullable incoming relationships (#917).
* Use Bootstrap list groups for related items in display pages.
* Check if entity exists before further processing it in mass handling (#679).
* Cleanup for controller classes and actions (#880).
* Use plain response instead of printer theme for quick view modals (#912).
* Refactored common action handling parts out of controllers into controller helper (#618).
* Use dropdown menu in config page tabs for grouping image settings for multiple upload fields (#920).
* Only one central entity factory is used for all entity and repository types (#886).
* Avoid injecting the service container (#886).
* Removed almost all usages of legacy util classes (#886).
* Updated usage of `max_length` constraint in form type classes (#927).
* Support redirecting to own items or own related items.
* If edited entry can not be found redirect back with flash message instead of throwing an error.
* Fixed missing generation of timestampable annotations.
* Improved `ownerPermission` implementation, including filtered selection during editing related items (#922).
* Added optional form fields for moderators to override creator and creation date (#857).
* Added custom datetime form type for datetime-local input fields with better polyfill support.
* For all entities with view actions and standard fields there are additional settings generated to control whether a link to own entries should be added to the account page or not.
* Added raw base template for finder and quick view actions.
* Added links for sending private messages in Zikula 1.4.6+ if a message module is installed and configured.
* Added `urlencode()` call to upload URLs to avoid problems with Symfony's URL validator.
* Added support for setting entity editing form field values using request parameters.
* Allow sorting by user names of creator and updater.
* The finder component (and therewith Scribite plugins) support inserting images including switching between multiple image fields (#938).
* Fixed option selection in locale form type (#940).
* Improved UI feedback after ajax-based tree operations.
* Several minor cleanups and simplifications.
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.7.1).

## ModuleStudio 0.7.0 (Jan 1, 2017)

### Product / Tooling changes

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
* Help search also includes results from documentation of Symfony, Doctrine and Twig. 
* Updated to Eclipse Neon.2 (4.6.2).
* Removed import of xml files created from old old pntables files (#829).

### DSL / Modelling language changes

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
* Two new properties allow controlling field visibility and css classes for editing.
* Removed action handlers, action events and transitions from controller layer.
* Removed DSL properties for view layer, event listeners and transform objects.
* Added `expandedSource` and `expandedTarget` properties to relationships for controlling their editing display type in Symfony Forms terminology. The `useChecks` property of list fields has been renamed to `expanded` accordingly.
* The `metaData` extension is deprecated and does not have any effect anymore in the generator. If you need meta data create a normal entity for them instead (#854).
* It is now possible to define for each field whether it should be visible on view pages, visible on display pages and whether it may be used for sorting or not (#858). 

### Generator changes

* Twig is used instead of Smarty for 1.4 (#571).
* In 1.4 Symfony forms are used instead of the old forms framework (#416).
* With 1.4 the `LinkContainer` service is used now instead of user-/admin apis for header links.
* 1.4 applications utilise capabilities for exposing categories usage.
* The generator displays descriptions for field names containing numbers more readable.
* 1.4 applications use webshims polyfill for forms to provide better support for HTML5 validation in old browsers (#673).
* Editing time fields is now supported by a dedicated form plug-in. Also for date fields there is a new selector (#87).
* In 1.4 applications annotations are used to distinguish between admin and user areas in entity controllers (#633).
* The `postInstall` event newly introduced in Zikula 1.4 is supported.
* Custom admin images are dynamically generated (#458).
* The primary variable name for search terms has been changed to `q` for improved integration with analytics software.
* For the generated templates YAML example files with example overrides are pregenerated for easy copy n paste (#460).
* In 1.4 applications `RouteUrl` and `UrlInterface` are now used instead of the `ModUrl` class.
* The `maxLength` property of text fields are now reflected in the generated form field properly.
* Generation of MultiHook needles has been added (together with a new generator setting for that) (#13).
* For upload fields with images additional settings are generated allowing to enable automatic downscaling of too large images down to configurable maximum dimensions (#800).
* Further additional settings are generated for making thumbnail parameters configurable (#864).
* For all view actions there are additional settings generated to control the amount of items per page.
* Form handlers redirect back to the referer if no `returnTo` parameter is specified (#844).
* For 1.4 applications a `FeatureActivationHelper` class is created which can be used to disable/enable certain features (categories, attributes, translations, tree relatives) during runtime (#841). This is for example useful if you would like to make these features depending on some conditions, like a module variable.
* Generated applications support category-based permissions now (#842).
* The geolocation functionality is disabled by default (#853).
* Many minor bugfixes.
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.7.0).

## Older versions

The following links point to the closed tickets on GitHub, as it makes not sense to pollute this changelog with such old things.

* [ModuleStudio 0.6.2](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.6.2) (Aug 7, 2014)
* [ModuleStudio 0.6.1](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.6.1) (Mar 13, 2014)
* [ModuleStudio 0.6.0](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.6.0) (Mar 8, 2013)
* [ModuleStudio 0.5.4](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.5.4) (Nov 29, 2011)
* [ModuleStudio 0.5.3](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.5.3) (Oct 10, 2011)
* [ModuleStudio 0.5.2](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.5.2) (Sep 8, 2011)
* ModuleStudio 0.5.1 (Sep 20, 2010)
* ModuleStudio 0.5.0 (Aug 21, 2010)
* ModuleStudio 0.4.9 (Apr 29, 2008)
* ModuleStudio 0.4.3 (Dec 21, 2007)

