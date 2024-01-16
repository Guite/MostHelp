# Changelog

## ModuleStudio 1.5.0 (unreleased)

### Product / Tooling changes

* Updated to Eclipse 2023-12 (4.30).
* Updated included Java version from 14.0.1 to 17.0.6
* Fixed problem preventing embedded textual editor to open properly.

### DSL / Modelling language changes

* Target version is now a Symfony version (currently: `SF70`, `SF63`).
* Removed obsolete application properties `generateMailzApi`, `generateNewsletterPlugin`, `generateTagSupport`.
* Removed obsolete email field properties `checkMX`, `checkHost`.
* Removed obsolete URL field property `checkDNS`.
* Removed hooks support entirely.
* Removed support for Zikula specific legacy content concepts (PageLock module, pending content, MultiHook needles, Scribite plugins, blocks, content types, search integration).
* Removed support for separate admin templates.
* Removed attributable behavior.
* Removed support for example data.
* Removed support for authentication method skeletons.
* Removed external controller and finder in favor of form-based relations.
* Removed array fields and object fields (deprecated in DBAL 3.4) - simple array and JSON array fields are still available.
* Replaced `displayType` and `visible` properties by dedicated flags `visibleOnIndex`, `visibleOnDetail`, `visibleOnNew`, `visibleOnEdit` and `visibleOnSort`.
* Added `role` attribute to larger text fields which allows to distinguish plain text from coding languages and WYSIWYG editing.
* Added `useAutoCompletion` flag for list fields.
* Added datetime component `DATE_TIME_TZ` for DateTime objects with timezone.
* Added new string roles for `CIDR`, `ISIN` and `ULID` validators.
* Added support for fulltext indexes.
* Removed `TABLE` identifier strategy and added `ULID` instead.
* Reduced `slugLength` default and max value from 255 to 190 for better `utf8mb4` compatibility.
* Removed support for `notify` change tracking policy which is deprecated and will be removed in Doctrine ORM 3.0.

### Generator changes

* Generated bundles require at least PHP 8.2 and Symfony 7 (Zikula 4.0).
* Generated bundles use and extend the concepts of EasyAdminBundle.
* Use property type hints; remove unrequired casts in setter methods.
* Use constructor property promotion.
* Use native PHP attributes for validation constraints, route definitions, setter injections and ORM mappings.
* Use other PHP 8 features (e.g. nullsafe operator, non-capturing catches, `::class` on objects).
* Introduce repository interfaces and utilize autowiring for them using `ServiceEntityRepository(Interface)` (#1253).
* Introduce application specific entity interfaces for easier separation of entities inside event listeners and subscribers.
* Variables are now processed as Symfony bundle configuration instead of having a config controller (no modvars anymore).
* Annotate Doctrine collection so PhpStorm can provide its generics support.
* Fixed regression regarding filtering user fields.
* Fixed exception when editing entities with allowed but unset specific creation date.
* Fixed paths to Leaflet assets for geographical entities (#1243).
* Use lazy-loaded Twig extensions.
* Provide default values for default coordinate fields to prevent invalid form state.
* Reset page number to 1 to avoid empty page if filters have been set.
* Add fluent setters and made add/remove methods for multi-valued associations more solid.
* Fixed usage of mapped superclasses.
* Updated structure for classes related to entities with inheritance relationships.
* Provide `getDescription` helper method in `EntityDisplayHelper`.
* Fixed an issue with `directParent` selection in tree relatives template.
* Use `NotCompromisedPassword` validator for password fields.
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

## Older versions

The following links point to the closed tickets on GitHub, as it makes not sense to pollute this changelog with such old things.

* [ModuleStudio 1.3.2](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.3.2) (Sep 20, 2018)
* [ModuleStudio 1.3.1](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.3.1) (May 30, 2018)
* [ModuleStudio 1.3.0](https://github.com/Guite/MostGenerator/issues?q=milestone%3A1.3.0) (Feb 1, 2018)
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

