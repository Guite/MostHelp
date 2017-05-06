# Changelog

## ModuleStudio 0.7.4 (unreleased)

### Product changes

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
* Reactivate automatic request processing by FilterUtil.
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
* Several other bugfixes.
* For more details see [closed tickets on GitHub](https://github.com/Guite/MostGenerator/issues?q=milestone%3A0.7.4).

## ModuleStudio 0.7.3 (Feb 18, 2017)

### Product changes

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

### Product changes

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

### Product changes

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
* Help search also includes results from zikula.org and zikula.de sites as well as documentation of Symfony, Doctrine and Twig. 
* Updated to Eclipse Neon.2 (4.6.2).
* ModuleStudio brings the required Java 8 environment along and can therewith also be used on systems without Java or with obsolete Java versions.
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
* Removed dsl properties for view layer, event listeners and transform objects.
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
* The geolocation functionality is commented out by default. If you need it, you can just activate it in the template by removing the comment (#853).
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

