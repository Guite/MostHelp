# Changelog

## ModuleStudio 1.5.0 (unreleased)

### Product / Tooling changes

* Updated to Eclipse 2022-06 (4.24).
* Updated included Java version from 14.0.1 to 15.0.2
* Fixed problem preventing embedded textual editor to open properly.

### DSL / Modelling language changes

* Reduced `slugLength` default and max value from 255 to 190 for better `utf8mb4` compatibility.
* Removed support for older target core versions 1.5.x and 2.x.
* Added support for newer target core versions (now supporting: `ZK30`, `ZK31`, `ZK40`). 
* Removed obsolete application properties `generateMailzApi`, `generateNewsletterPlugin`, `generateTagSupport`.
* Removed obsolete email field properties `checkMX`, `checkHost`.
* Removed obsolete URL field property `checkDNS`.
* Removed hooks support entirely.
* Removed support for Zikula specific legacy content concepts (`PageLock` module, pending content, MultiHook needles, Scribite plugins, blocks, content types, search integration).
* Removed support for separate admin templates.
* Removed attributable behavior.
* Removed support for example data.
* Removed support for authentication method skeletons.

### Generator changes

* Generated bundles require at least PHP 8.1 and Zikula 4.0 (Symfony 5.4+).
* Use property type hints; remove unrequired casts in setter methods.
* Use constructor property promotion.
* Annotate Doctrine collection so PhpStorm can provide its generics support.
* Use native PHP attributes for validation constraints, route definitions, setter injections and ORM mappings.
* Use other PHP 8 features (e.g. nullsafe operator, non-capturing catches, `::class` on objects).
* Introduce repository interfaces and utilise autowiring for them using `ServiceEntityRepository(Interface)` (#1253).
* Introduce application specific entity interfaces for easier separation of entities inside event listeners and subscribers.
* Fixed display hook processing on edit and delete pages.
* Fixed regression regarding filtering user fields.
* Fixed wrong import in `ConnectionsMenuListener`.
* Fixed exception when editing entities with allowed but unset specific creation date.
* Fixed paths to Leaflet assets for geographical entities in Zikula 3 (#1243).
* Provide object identifier to form aware hook in Zikula 3.
* Fixed regressions in auto completion functionality in Zikula 3.
* Use lazy-loaded Twig extensions.
* Provide default values for default coordinate fields to prevent invalid form state.
* Reset page number to 1 to avoid empty page if filters have been set.
* Add fluent setters and made add/remove methods for multi-valued associations more solid.
* Fixed usage of mapped superclasses.
* Updated structure for classes related to entities with inheritance relationships.
* Provide `getDescription` helper method in `EntityDisplayHelper`.
* Fixed an issue with `directParent` selection in tree relatives template.
* Skip sending creator-related notification if creator has approval permissions (#1249).
* Fixes for ICS templates (#1254).
* Add missing cast to getter for decimal fields (#1257).
* Removed colons from form labels.
* Update changed user names in log entries (#1251).
* Allow deletion of entities that are not valid.
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.5.0).

## ModuleStudio 1.4.0 (June 26, 2020)

### Product / Tooling changes

* Updated to Eclipse 2020-06 (4.16).
* Includes Java 14.0.1 now.
* Dropped support for 32 bit platforms.
* Use SVG icons in included help web app.
* Fixed project switcher issue in some Windows environments (#1209).

### DSL / Modelling language changes

* Fixed validation problems of image constraints.
* Added target core versions for Zikula Core 3.0.x.
* Added warning about target core versions 1.5.x becoming deprecated.
* Fixed problems in quick fixes for validation constraints regarding duplicates.
* Added possibility to configure validation mode for email fields (used in Zikula 3 only). More details can be found in the [generator reference](87-GeneratorReference.md#email-validation-mode).
* Added possibility to define arbitrary field units for integer, number and string fields (#1201).
* Added `counter` flag to integer fields to provide view counter functionality (#1226).
* Added `deleteExpired` flag for automatic deletion of obsolete data (#1232).
* Added new string role for week fields (used in Zikula 3 only). More details can be found in the [generator reference](87-GeneratorReference.md#string-role).
* Added new string role for icon fields (used in Zikula 3 only). More details can be found in the [generator reference](87-GeneratorReference.md#string-role).
* Added new string role for hostname fields (used in Zikula 3 only). More details can be found in the [generator reference](87-GeneratorReference.md#string-role).

### Generator changes

* Added support for all changes in Zikula Core 3.
* Added support for map views showing a list of markers for multiple geographical entities (#1212).
* Coordinate input fields are shown below map when editing geographical entities.
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
* More unobtrusive display for item actions dropdown menu.
* Added missing min/max attributes for number input fields.
* Fixed wrong fallback value for array fields.
* Fixed logical mix-up of relation sides for embedded editing.
* Inform submitter about pending content approvals.
* Fixed possibly wrong default values for non-nullable integer and user fields.
* Fallback to guest user if an optional user field is not nullable.
* Prevent wrong translation domain when resolving list entries in Twig templates.
* Disable collection filter helper when determining moderation items.
* Fixed Leaflet inclusion in raw templates.
* Truncate string using whole words in auto completion handler.
* Removed all artifacts which are entirely related to release engineering (Travis and StyleCI configuration files, composer dev requirements).
* Trigger email notifications after workflow transition has been completed.
* Apply workflow not before entity change for proper create notifications.
* The finder component can now dynamically switch languages to insert links in another language into editors (#1214).
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
* Removed usage of deprecated jQuery ajax callbacks.
* Show information about last editor in workflow notification emails (of entities with standard fields) for moderators.
* Several improvements for CSV and XML output (e.g. array fields and relationship data).
* Hide link for creating related items in quick view.
* Overhauled and improved asset handling on raw pages (e.g. for inline editing).
* Properly consider doctrine proxies in listeners.
* Fixed handling of plural forms in translations.
* Avoid date range validation class on other datetime fields in same entity.
* Reselect sluggable entity before redirect after reverting to old revision.
* Fixed typo in UI hooks provider.
* Call filter hooks for text fields on display pages.
* Upgraded MultiHook needle support for MultiHook 6.0.0.
* Lowered required permission level for creating entities with moderation.
* Item actions on display pages are not shown inside quick view windows.
* Introduced permission helper method for accessing quick navigation forms; require only view permissions instead of edit (#1218).
* Related entities in quick navigation forms are filtered by permissions (#1230).
* Added dropdown fields for target sides of one2one and many2one relationships to quick navigation (#1217).
* Added dropdown fields for many-valued relationship sides to quick navigation (#1217).
* Add support for new `group.pre_delete` event in Zikula Core 3.x targets.
* Added missing `{{ moduleFooter() }}` call to base template (#1219).
* Hide link to own entries for users without edit access (#1220).
* Added reset button to quick navigation forms (#1221).
* Delay automatic filter submission for 5 seconds for improved usability.
* Several fixes for form-aware hook provider dummy implementation.
* Select collections without joins by default.
* Properly provide entity changeset in pre update events.
* Fixed creator filter in admin area.
* Fixed regression in workflow state exclusion filter.
* Fixed wrong fallback value for editing optional multi list fields.
* Moved permission inheritance functionality and category permission checks into permission helper to apply them for search and other integration areas (#1223).
* Fixed tree selection form type with duplicate labels.
* Disable CSRF protection for quick navigation forms, fixing redirects after editing.
* View page actions / navigation links are now handled by MenuBuilder using KnpMenu (#1213).
* Fixed sorting items in view pages by related entities (#1229).
* Fixed handling of ID insertion into Summernote editor.
* Fixed searching in / filtering by translatable fields (#1234).
* Zikula 3 only: added support for autowiring and autoconfiguration (#1188).
* Zikula 3 only: use scalar typehints.
* Zikula 3 only: added support for form fields with immutable dates. 
* Zikula 3 only: support localisation of countries, currencies, languages, locales and timezones in both forms and display.
* Zikula 3 only: added support for Doctrine types `json`, `datetime_immutable`, `date_immutable`, `time_immutable` and `dateinterval`.
* Zikula 3 only: provide workflow transition blockers with reasons for unallowed deletion actions.
* Zikula 3 only: ability to validate BIC and IBAN codes together.
* Zikula 3 only: extended credit card validation to include "UATP" cards.
* Zikula 3 only: added validation of timezone fields.
* Zikula 3 only: added support for different validation modes for email fields.
* Zikula 3 only: added ability for auto-creation of imagine cache directory.
* Zikula 3 only: use Symfony Mailer component instead of old SwiftMailer-based Mailer API.
* Zikula 3 only: added listener for `FormTypeChoiceEvent`.
* Zikula 3 only: custom application events are now represented by dedicated event classes.
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

## Older versions

The following links point to the closed tickets on GitHub, as it makes not sense to pollute this changelog with such old things.

* [ModuleStudio 1.2.0](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.2.0) (Dec 16, 2017)
* [ModuleStudio 1.1.0](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.1.0) (Nov 26, 2017)
* [ModuleStudio 1.0.2](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.0.2) (Oct 3, 2017)
* [ModuleStudio 1.0.1](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.0.1) (Sep 2, 2017)
* [ModuleStudio 1.0.0](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.0.0) (Jul 31, 2017)
* [ModuleStudio 0.7.5](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.7.5) (Jul 31, 2017)
* [ModuleStudio 0.7.4](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.7.4) (May 19, 2017)
* [ModuleStudio 0.7.3](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.7.3) (Feb 18, 2017)
* [ModuleStudio 0.7.2](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.7.2) (Feb 12, 2017)
* [ModuleStudio 0.7.1](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.7.1) (Jan 18, 2017)
* [ModuleStudio 0.7.0](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.7.0) (Jan 1, 2017)
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

